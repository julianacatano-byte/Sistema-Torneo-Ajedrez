package Vistas;

import Estructuras.ListaPartidas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPartida {
    private JTextField txtJugadoresEspera;
    private JButton btnCrearPartida;
    private JButton btnCerrar;
    private JTextPane txtResultado;
    private JPanel panelPrincipal;
    private Window parent;
    private boolean visible;
    public CrearPartida(Window parent) {
        this.parent=parent;
        JFrame frame = new JFrame("Crear Partida");
        frame.setContentPane((JPanel) btnCrearPartida.getParent());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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
