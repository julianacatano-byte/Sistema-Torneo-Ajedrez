package Vistas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RegistrarJugador {
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtCedula;
    private JButton btnRegistrar;
    private JButton btnLimpiar;

    public RegistrarJugador() {
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
}
