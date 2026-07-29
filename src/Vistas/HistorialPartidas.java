package Vistas;

import Estructuras.AdministradorTorneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HistorialPartidas {

    private JLabel lblTitulo;
    private JTextArea AreaHistorial;
    private JButton btnActualizar;
    private JButton regresarButton;
    private JPanel principal;
    private JPanel panelPrincipal;
    private JFrame ventana;
    private Window parent;
    private AdministradorTorneo administrador;

    public HistorialPartidas(Window parent,AdministradorTorneo administrador) {
        this.administrador=administrador;
        this.parent=parent;

        ventana = new JFrame("Historial de Partidas");
        ventana.setContentPane(principal);
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        AreaHistorial.setEditable(false);

        btnActualizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Historial actualizado");
            actualizarHistorial();
        });

        regresarButton.addActionListener((ActionEvent e) -> regresar());
        ventana.setVisible(true);
    }
    private void actualizarHistorial(){
        String historial = administrador.mostrarHistorial();
        AreaHistorial.setText(historial);

    }

    private void regresar() {
        ventana.dispose();
        if (parent != null) {
            parent.setVisible(true);
            parent.requestFocus();

        }

    }
}
