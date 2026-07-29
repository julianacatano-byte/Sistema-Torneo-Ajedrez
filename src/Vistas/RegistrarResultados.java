package Vistas;

import Estructuras.ListaPartidas;

import javax.swing.*;
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

    private ListaPartidas listaPartidas;

    public RegistrarResultados() {

        btnRegistrarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(textIDPartida.getText());

                String resultado = "";

                if (rbBlancas.isSelected()) {
                    resultado = "Ganaron blancas";
                } else if (rbNegras.isSelected()) {
                    resultado = "Ganaron negras";
                } else if (rbEmpate.isSelected()) {
                    resultado = "Empate";
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un resultado");
                    return;
                }

                JOptionPane.showMessageDialog(null,
                        "Partida: " + id + "\nResultado: " + resultado);
            }
        });


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
}