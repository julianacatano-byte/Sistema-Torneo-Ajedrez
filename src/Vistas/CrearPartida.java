package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPartida {
    private JTextField txtJugadoresEspera;
    private JButton btnCrearPartida;
    private JButton btnCerrar;
    private JTextPane txtResultado;
    private JPanel panelPrincipal;

    public CrearPartida() {
        btnCrearPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("Crear Partida");
        frame.setContentPane((JPanel) btnCrearPartida.getParent());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
