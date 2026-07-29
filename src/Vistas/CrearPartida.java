package Vistas;

import Estructuras.AdministradorTorneo;
import Modelos.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CrearPartida {
    private JTextField txtJugadoresEspera;
    private JButton btnCrearPartida;
    private JButton regresarButton;
    private JTextPane txtResultado;
    private JPanel panelPrincipal;
    private JFrame frame;
    private Window parent;
    private AdministradorTorneo administrador;

    public CrearPartida(Window parent, AdministradorTorneo administrador) {
        this.administrador=administrador;
        this.parent=parent;

        frame = new JFrame("Crear Partida");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        txtJugadoresEspera.setEditable(false);

        btnCrearPartida.addActionListener((ActionEvent e) -> crearPartida());
        regresarButton.addActionListener((ActionEvent e) -> regresar());

    }

    private void crearPartida() {

        Partida partida = administrador.crearPartida();

        if (partida == null) {
            JOptionPane.showMessageDialog(frame, "No hay suficientes jugadores para crear una partida.");
            actualizarJugadoresEnEspera();
            return;
        }
        txtResultado.setText("Partida creada correctamente\n\n" + "ID: " + partida.getidPartida() + "\n\nJugador Blancas: " + partida.getJugadorConPiezasBlancas().getNombre() +
                            "\n\nJugador Negras: " + partida.getJugadorConPiezasNegras().getNombre() + "\n\nEstado: " + partida.getResultado());
        actualizarJugadoresEnEspera();
    }

    private void actualizarJugadoresEnEspera() {
        txtJugadoresEspera.setText(String.valueOf(administrador.jugadoresEnEspera()));
    }


    private void regresar() {
        frame.dispose();
        if (parent != null) {
            parent.setVisible(true);
            parent.requestFocus();

        }

    }
}
