package Vistas;

import javax.swing.*;

public class HistorialPartidas {

    private JLabel lblTitulo;
    private JTextArea AreaHistorial;
    private JButton btnActualizar;
    private JButton btnSalir;
    private JPanel panelPrincipal;

    public HistorialPartidas() {

        JFrame ventana = new JFrame("Historial de Partidas");
        ventana.setContentPane(panelPrincipal);
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
}
