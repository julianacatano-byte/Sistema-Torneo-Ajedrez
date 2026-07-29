package Vistas;

import Estructuras.AdministradorTorneo;
import Modelos.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class BuscarCedula extends JDialog {
    private JPanel contentPane;

    private JLabel txtTitulo;
    private JTextField textCedula;
    private JButton buscarButton;
    private JTextArea txtInformacion;
    private JButton regresarButton;
    private AdministradorTorneo administrador;
    private Window parent;

    public BuscarCedula(Window parent, AdministradorTorneo administrador) {
        this.administrador = administrador;
        this.parent = parent;
        setContentPane(contentPane);
        setModal(true);
        txtInformacion.setEditable(false);
        buscarButton.addActionListener((ActionEvent e) -> buscarJugador());
        regresarButton.addActionListener((ActionEvent e) -> regresar());

    }

    private void buscarJugador() {
        String cedula = textCedula.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cédula del jugador.");
            return;
        }

        Jugador jugador = administrador.buscarJugador(cedula);
        if (jugador == null) {
            txtInformacion.setText("Jugador no encontrado.");
            return;
        }

        String informacion = "Nombre : " + jugador.getNombre() + "\n\nCédula : " + jugador.getCedula() + "\n\nPuntaje : " + jugador.getPuntaje();
        txtInformacion.setText(informacion);

    }

    public void regresar() {
        regresarButton.addActionListener(e -> {
            this.dispose();
            if (parent != null) {
                parent.requestFocus();
                parent.revalidate();
                parent.setVisible(true);

            }
        });
    }

}
