package Vistas;

import Estructuras.AdministradorTorneo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    public JPanel home;
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
    private AdministradorTorneo administrador;


    public Principal(AdministradorTorneo administrador) {
        this.administrador=administrador;
        registrarJugador();
        crearPartida();
        historial();
        registrarResultado();

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(home);
                if (ventana != null) ventana.dispose();
            }
        });
    }

    public void registrarJugador(){
        btnRegistrarJugador.addActionListener(e->{
            Window currentWindow = SwingUtilities.getWindowAncestor(home);
            RegistrarJugador registrarJugador = new RegistrarJugador(currentWindow,administrador);
            currentWindow.setVisible(false);

            registrarJugador.mostrar();
        });
    }

    public void crearPartida(){
        btnCrearPartida.addActionListener(e->{
            Window currentWindow = SwingUtilities.getWindowAncestor(home,administrador);
            CrearPartida crearPartida = new CrearPartida(currentWindow);
            currentWindow.setVisible(false);

        });
    }

    public void historial(){
        btnHistorial.addActionListener(e->{
            Window currentWindow = SwingUtilities.getWindowAncestor(home);
            HistorialPartidas historialPartida = new HistorialPartidas(currentWindow,administrador);
            currentWindow.setVisible(false);

        });
    }
    public void registrarResultado(){
        btnRegistrarResultado.addActionListener(e->{
            Window currentWindow = SwingUtilities.getWindowAncestor(home);
            RegistrarResultados registrarResultado = new RegistrarResultados(currentWindow,administrador);
            currentWindow.setVisible(false);
        });
    }
}
