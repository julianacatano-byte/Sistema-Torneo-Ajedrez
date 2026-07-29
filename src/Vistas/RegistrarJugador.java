package Vistas;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistrarJugador {
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JButton btnRegistrar;
    private JButton btnLimpiar;
    private Window parent;
    private boolean visible;

    public RegistrarJugador(Window parent) {
        this.parent=parent;
        JFrame frame = new JFrame("Registrar Jugador");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void mostrar() {

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
