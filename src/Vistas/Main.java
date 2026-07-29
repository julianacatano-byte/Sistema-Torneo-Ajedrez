package Vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JButton btnRegistrarJugador;
    private JButton btnCrearPartida;
    private JButton btnRegistrarResultado;
    private JButton btnHistorial;
    private JButton btnVerRanking;
    private JButton btnBuscarJugadorPorCedula;
    private JButton btnRetirarJugador;
    private JButton btnMostrarJugadoresPorNiveles;
    private JButton btnSalir;

    public Main() {
        btnRegistrarJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnCrearPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        btnRegistrarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
