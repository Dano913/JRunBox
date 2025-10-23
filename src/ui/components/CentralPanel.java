// ui/components/CentralPanel.java
package ui.components;

import ui.RoundedPanel;
import javax.swing.*;
import java.awt.*;

public class CentralPanel extends RoundedPanel {

    public CentralPanel(
            JLabel tituloEjercicioLabel,
            JPanel inputPanel,
            JLabel preguntaLabel,
            JTextField respuestaField,
            JButton siguienteButton,
            Color fgLight
    ) {
        super(20, new Color(50, 50, 50));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Título del ejercicio ---
        tituloEjercicioLabel.setFont(new Font("Arial", Font.BOLD, 18));
        tituloEjercicioLabel.setForeground(fgLight);
        tituloEjercicioLabel.setHorizontalAlignment(JLabel.CENTER);
        add(tituloEjercicioLabel, BorderLayout.NORTH);

        // --- Panel de input ---
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(50, 50, 50));
        inputPanel.setVisible(false);

        preguntaLabel.setFont(new Font("Arial", Font.BOLD, 16));
        preguntaLabel.setForeground(fgLight);
        preguntaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        respuestaField.setFont(new Font("Arial", Font.PLAIN, 16));
        respuestaField.setMaximumSize(new Dimension(400, 40));
        respuestaField.setBackground(new Color(64, 64, 64));
        respuestaField.setForeground(fgLight);
        respuestaField.setAlignmentX(Component.CENTER_ALIGNMENT);

        siguienteButton.setBackground(new Color(64, 64, 64));
        siguienteButton.setForeground(fgLight);
        siguienteButton.setFocusPainted(false);
        siguienteButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --- Añadir elementos ---
        inputPanel.add(preguntaLabel);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(respuestaField);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(siguienteButton);

        add(inputPanel, BorderLayout.CENTER);
    }
}
