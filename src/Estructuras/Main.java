package Estructuras;

import Vistas.Principal;

import javax.swing.*;

public class Main {
    public static void main (String [] args){
        JFrame home = new JFrame("Sistema Gestión Torneo de Ajedrez");
        AdministradorTorneo administrar=new AdministradorTorneo();
        Principal principal = new Principal(administrar);
        home.setContentPane(principal.home);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setSize(600, 600);
        home.setVisible(true);
    }
}

