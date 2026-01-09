package ui.components;

import ui.RoundedPanel;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;

public class CentralPanel extends RoundedPanel {

    public CentralPanel(
            JLabel tituloEjercicioLabel,
            JPanel inputPanel,
            JTextArea preguntaArea,
            JTextField respuestaField,
            JButton siguienteButton,
            Color fgLight
    ) {
        super(20, new Color(50, 50, 50));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // --- Título del ejercicio ---
        tituloEjercicioLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tituloEjercicioLabel.setForeground(fgLight);
        tituloEjercicioLabel.setHorizontalAlignment(JLabel.CENTER);
        tituloEjercicioLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        add(tituloEjercicioLabel, BorderLayout.NORTH);

        // --- Panel de input ---
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(50, 50, 50));
        inputPanel.setVisible(false);

        // --- Pregunta Label ---
        preguntaArea.setFont(new Font("Arial", Font.BOLD, 20));
        preguntaArea.setForeground(fgLight);
        preguntaArea.setBackground(new Color(50, 50, 50));
        preguntaArea.setLineWrap(true);        // wrap automático
        preguntaArea.setWrapStyleWord(true);   // wrap por palabras
        preguntaArea.setEditable(false);       // solo lectura
        preguntaArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        preguntaArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        inputPanel.add(preguntaArea);

        // --- Panel para respuestaField + siguienteButton ---
        JPanel respuestaButtonPanel = new JPanel();
        respuestaButtonPanel.setLayout(new BoxLayout(respuestaButtonPanel, BoxLayout.X_AXIS));
        respuestaButtonPanel.setBackground(new Color(50, 50, 50));
        respuestaButtonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Configuración del campo de texto
        respuestaField.setFont(new Font("Arial", Font.PLAIN, 18));
        respuestaField.setPreferredSize(new Dimension(400, 40));
        respuestaField.setMaximumSize(new Dimension(700, 40));
        respuestaField.setBackground(new Color(64, 64, 64));
        respuestaField.setForeground(fgLight);

        // Configuración del botón
        siguienteButton.setFont(new Font("Arial", Font.BOLD, 18));
        siguienteButton.setPreferredSize(new Dimension(150, 40));
        siguienteButton.setMaximumSize(new Dimension(150, 40));
        siguienteButton.setBackground(new Color(64, 64, 64));
        siguienteButton.setForeground(fgLight);
        siguienteButton.setFocusPainted(false);

        // Separación entre campo y botón
        respuestaButtonPanel.add(respuestaField);
        respuestaButtonPanel.add(Box.createHorizontalStrut(10));
        respuestaButtonPanel.add(siguienteButton);

        // Añadir al inputPanel
        inputPanel.add(respuestaButtonPanel);
        inputPanel.add(Box.createVerticalStrut(10)); // espacio debajo

        add(inputPanel, BorderLayout.CENTER);
    }
}
