package Vistas;

import Estructuras.AdministradorTorneo;
import Modelos.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RetirarJugador extends JDialog {
    private JPanel contentPane;
    private JButton buttonRetirar;
    private JButton regresarButton;
    private JTextField textCedula;
    private JButton buscarButton;
    private JTextArea textInformacion;
    private JLabel txtTitulo;
    private AdministradorTorneo administrador;
    private Jugador jugadorEncontrado;
    private Window parent;

    public RetirarJugador(Window parent,AdministradorTorneo administrador) {
        this.administrador=administrador;
        this.parent=parent;
        setContentPane(contentPane);
        setModal(true);
        textInformacion.setEditable(false);
        buscarButton.addActionListener((ActionEvent e) -> buscarJugador());
        buttonRetirar.addActionListener((ActionEvent e) -> retirarJugador());
        regresarButton.addActionListener((ActionEvent e) -> regresar());

        pack(); // Ajusta el tamaño según los componentes
        setLocationRelativeTo(null); // Lo centra respecto a la ventana padre

    }

    private void buscarJugador() {

        String cedula = textCedula.getText().trim();

        if(cedula.isEmpty()){
            JOptionPane.showMessageDialog(this, "Ingrese una cédula.");
            return;
        }

        jugadorEncontrado = administrador.buscarJugador(cedula);

        if(jugadorEncontrado == null){
            textInformacion.setText("Jugador no encontrado.");
            return;
        }
        textInformacion.setText("Nombre : " + jugadorEncontrado.getNombre() + "\n\nCédula : " + jugadorEncontrado.getCedula() + "\n\nPuntaje : " + jugadorEncontrado.getPuntaje());

    }

    private void retirarJugador(){
        if(jugadorEncontrado == null){JOptionPane.showMessageDialog(this, "Primero busque un jugador.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea retirar este jugador?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if(opcion == JOptionPane.YES_OPTION){
            administrador.retirarJugador(jugadorEncontrado);
            JOptionPane.showMessageDialog(this, "Jugador retirado correctamente.");
            limpiar();
        }
    }

    private void limpiar(){
        textCedula.setText("");
        textInformacion.setText("");
        jugadorEncontrado = null;
        textCedula.requestFocus();
    }

    public void regresar() {
            this.dispose();
            if (parent != null) {
                parent.requestFocus();
                parent.revalidate();
                parent.setVisible(true);

            }
    }


}
