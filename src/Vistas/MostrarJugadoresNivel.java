package Vistas;

import Estructuras.AdministradorTorneo;

import javax.swing.*;
import java.awt.*;


public class MostrarJugadoresNivel extends JDialog {
    private JPanel contentPane;
    private JButton buttonMostrar;
    private JButton regresarButton;
    private JLabel textTitle;
    private JTextArea textInformacion;
    private AdministradorTorneo administrador;
    private Window parent;

    public MostrarJugadoresNivel(Window parent, AdministradorTorneo administrador) {
        this.parent=parent;
        this.administrador=administrador;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonMostrar);

    }
    private void mostrar(){

        String recorrido = administrador.mostrarJugadoresPorNiveles();

        if(recorrido.isEmpty()){
            textInformacion.setText("No existen jugadores registrados.");
        }else{
            textInformacion.setText(recorrido);
        }
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
