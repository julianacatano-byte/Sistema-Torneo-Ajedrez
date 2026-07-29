package Vistas;


import Estructuras.AdministradorTorneo;
import Modelos.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class RegistrarJugador {
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JButton btnRegistrar;
    private JButton regresarButton;
    private JFrame frame;
    private Window parent;
    private AdministradorTorneo administrador;

    public RegistrarJugador(Window parent,AdministradorTorneo administrador) {
        this.administrador=administrador;
        this.parent=parent;
        frame = new JFrame("Registrar Jugador");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnRegistrar.addActionListener((ActionEvent e) -> registrarJugador());
        regresarButton.addActionListener((ActionEvent e) -> regresar());
    }


    private void registrarJugador() {

        String nombre = txtNombre.getText().trim();
        String cedula = txtCedula.getText().trim();

        if (nombre.isEmpty() || cedula.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Debe completar todos los campos.");
            return;
        }

        if (!validarNumero(cedula)) {
            return;
        }

        if (administrador.buscarJugador(cedula) != null) {
            JOptionPane.showMessageDialog(frame, "Ya existe un jugador con esa cédula.");
            return;
        }

        Jugador jugador = new Jugador(nombre, cedula);

        administrador.inscribirJugador(jugador);

        JOptionPane.showMessageDialog(frame, "Jugador registrado correctamente.");

        txtNombre.setText("");
        txtCedula.setText("");
        txtNombre.requestFocus();
    }

    private void regresar() {
        frame.dispose();
        if (parent != null) {

            parent.setVisible(true);
            parent.requestFocus();

        }

    }

    private boolean validarNumero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "La cédula debe ser solo números y sin puntos, ni comas");
            return false;

        }

    }
}
