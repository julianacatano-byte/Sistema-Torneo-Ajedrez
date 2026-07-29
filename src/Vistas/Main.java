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
                new RegistrarJugador().mostrar();
            }
        });

        btnCrearPartida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CrearPartida().mostrar();
            }
        });

        btnRegistrarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrarResultados().mostrar();
            }
        });
        btnHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HistorialPartidas();
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);
                if (ventana != null) ventana.dispose();
            }
        });
    }
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Sistema Gestión Torneo de Ajedrez");
        ventana.setContentPane(new Main().panelPrincipal);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
