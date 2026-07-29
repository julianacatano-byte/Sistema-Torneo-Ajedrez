package Vistas;

import Estructuras.AdministradorTorneo;

import javax.swing.*;
import java.awt.*;


public class Ranking extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
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
    }


    public void mostrarHistorial(){
        String ranking = administrador.mostrarRanking();
        if(ranking.isEmpty()){
            textLista.setText("No existen jugadores registrados.");
        }else{
            textLista.setText(ranking);

        }
    }


}
