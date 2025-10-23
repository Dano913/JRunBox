package ui.components;

import ui.RoundedPanel;
import javax.swing.*;
import java.awt.*;

public class TopPanel extends RoundedPanel {
    public TopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar, Color fgLight, Color botonColor) {
        super(20, new Color(38, 38, 38));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(38, 38, 38));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel tituloLabel = new JLabel("Ejercicios de Programación");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(fgLight);
        panelTop.add(tituloLabel, BorderLayout.WEST);

        comboEjercicios.setFont(new Font("Arial", Font.PLAIN, 14));
        comboEjercicios.setBackground(Color.WHITE);
        comboEjercicios.setForeground(Color.DARK_GRAY);
        comboEjercicios.setPreferredSize(new Dimension(160, 35));
        comboEjercicios.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));

        JPanel controlesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        controlesPanel.setBackground(new Color(38, 38, 38));
        controlesPanel.add(comboEjercicios);

        botonEjecutar.setBackground(new Color(64, 64, 64));
        botonEjecutar.setForeground(Color.WHITE);
        botonEjecutar.setFocusPainted(false);
        botonEjecutar.setPreferredSize(new Dimension(100, 35)); // tamaño fijo
        botonEjecutar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)); // bordes redondeados

        controlesPanel.add(botonEjecutar);

        panelTop.add(controlesPanel, BorderLayout.EAST);
        add(panelTop, BorderLayout.CENTER);
    }
}
