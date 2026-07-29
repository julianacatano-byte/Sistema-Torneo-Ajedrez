package Vistas;

import javax.swing.*;
import java.awt.*;

public class HistorialPartidas {

    private JLabel lblTitulo;
    private JTextArea AreaHistorial;
    private JButton btnActualizar;
    private JButton btnSalir;
    private JPanel principal;
    private JPanel panelPrincipal;
    private Window parent;
    private boolean visible;

    public HistorialPartidas(Window parent) {
        this.parent=parent;

        JFrame ventana = new JFrame("Historial de Partidas");
        ventana.setContentPane(principal);
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        btnActualizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Historial actualizado");
        });

        btnSalir.addActionListener(e -> {
            ventana.dispose();
        });

        ventana.setVisible(true);
    }




    public void regresarButton() {
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
