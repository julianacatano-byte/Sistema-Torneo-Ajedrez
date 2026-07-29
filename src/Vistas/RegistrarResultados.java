package Vistas;

import Estructuras.AdministradorTorneo;
import Estructuras.ListaPartidas;
import Modelos.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarResultados {
    private JLabel lblTitulo;
    private JLabel lblIdPartida;
    private JRadioButton rbBlancas;
    private JRadioButton rbNegras;
    private JRadioButton rbEmpate;
    private JLabel lblCalidadBlancas;
    private JLabel lblCalidadNegras;
    private JTextField textCalidadBlancas;
    private JTextField textCalidadNegras;
    private JButton btnRegistrarResultado;
    private JButton btnLimpiar;
    private JTextField textIDPartida;
    private JPanel panelPrincipal;
    private JButton regresarButton;
    private JFrame frame;
    private Window parent;
    private ListaPartidas listaPartidas;
    private AdministradorTorneo administrador;

    public RegistrarResultados(Window parent, AdministradorTorneo administrador) {
        this.administrador = administrador;
        this.parent = parent;

        frame = new JFrame("Registrar Resultados");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbBlancas);
        grupo.add(rbNegras);
        grupo.add(rbEmpate);

        regresarButton.addActionListener((ActionEvent e) -> regresar());
        btnRegistrarResultado.addActionListener((ActionEvent e) -> registrarResultado());

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textIDPartida.setText("");
                textCalidadBlancas.setText("");
                textCalidadNegras.setText("");

                rbBlancas.setSelected(false);
                rbNegras.setSelected(false);
                rbEmpate.setSelected(false);
            }
        });
    }

    private void regresar() {
        frame.dispose();
        if (parent != null) {
            parent.setVisible(true);
            parent.requestFocus();
        }
    }

    private void registrarResultado() {

        if (!validarNumero(textIDPartida.getText(), "ID de la partida")) {
            return;
        }
        if (!validarNumero(textCalidadBlancas.getText(), "Calidad Blancas")) {
            return;
        }
        if (!validarNumero(textCalidadNegras.getText(), "Calidad Negras")) {
            return;
        }

        int id = Integer.parseInt(textIDPartida.getText());
        Partida partida = administrador.buscarPartida(id);
        if (partida == null) {
            JOptionPane.showMessageDialog(frame, "La partida no existe.");
            return;
        }

        String resultado = "";

        if (rbBlancas.isSelected()) {
            resultado = "Blancas";

        } else if (rbNegras.isSelected()) {
            resultado = "Negras";
        } else if (rbEmpate.isSelected()) {
            resultado = "Empate";
        } else {
            JOptionPane.showMessageDialog(frame, "Seleccione un resultado.");
            return;
        }

        int calidadBlancas = Integer.parseInt(textCalidadBlancas.getText());

        int calidadNegras = Integer.parseInt(textCalidadNegras.getText());

        administrador.registrarResultado(partida, resultado, calidadBlancas, calidadNegras);

        JOptionPane.showMessageDialog(frame, "Resultado registrado correctamente.");

    }

    private boolean validarNumero(String valor, String nombreCampo) {

        if (valor.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "El campo " + nombreCampo + " es obligatorio.");
            return false;

        }

        try {
            Integer.parseInt(valor);
            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "El campo " + nombreCampo + " debe contener solamente números.");
            return false;

        }

    }
}