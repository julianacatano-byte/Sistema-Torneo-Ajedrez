package Vistas;

import Estructuras.AdministradorTorneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class Ranking extends JDialog {
    private JPanel contentPane;
    private JButton regresarButton;
    private JPanel mostrarLista;
    private JLabel lblRanking;
    private JTextArea textLista;
    private AdministradorTorneo administrador;
    private Window parent;



    public Ranking(Window parent ,AdministradorTorneo administradorTorneo) {
        this.parent = parent;
        this.administrador = administradorTorneo;
        setContentPane(contentPane);
        setModal(true);
        textLista.setEditable(false);
        mostrarHistorial();
        regresarButton.addActionListener((ActionEvent e) -> regresar());

        pack(); // Ajusta el tamaño según los componentes
        setLocationRelativeTo(null); // Lo centra respecto a la ventana padre

    }


    public void mostrarHistorial(){
        String ranking = administrador.mostrarRanking();
        if(ranking.isEmpty()){
            textLista.setText("No existen jugadores registrados.");
        }else{
            textLista.setText(ranking);

        }
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
