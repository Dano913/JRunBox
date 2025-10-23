package ui.components;

import ui.RoundedPanel;
import javax.swing.*;
import java.awt.*;

public class TopPanel extends RoundedPanel {

    public TopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar,
                    Color fgLight, Color botonColor, Color bordeColor, Color textoBotonColor) {
        super(20, new Color(38, 38, 38));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Panel principal superior
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(38, 38, 38));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // Título
        JLabel tituloLabel = new JLabel("Ejercicios de Programación");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(fgLight);
        panelTop.add(tituloLabel, BorderLayout.WEST);

        // -----------------------------
        // ComboEjercicios con estilo personalizado completo
        // -----------------------------
        comboEjercicios.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {

            @Override
            protected void installDefaults() {
                super.installDefaults();
                comboBox.setOpaque(false);
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Pintar todo el fondo del ComboBox incluyendo el área del botón
                g2.setColor(botonColor);
                g2.fillRoundRect(0, 0, comboBox.getWidth(), comboBox.getHeight(), 20, 20);

                // Pintar el borde
                g2.setColor(bordeColor);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, comboBox.getWidth() - 1, comboBox.getHeight() - 1, 20, 20);

                g2.dispose();
            }

            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton() {
                    @Override
                    public void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // No pintamos fondo aquí, ya se pinta en paintCurrentValueBackground

                        // Dibujar la flecha
                        int w = getWidth();
                        int h = getHeight();
                        int arrowWidth = 8;
                        int arrowHeight = 5;

                        // Centrar la flecha
                        int x = (w - arrowWidth) / 2;
                        int y = (h - arrowHeight) / 2;

                        // Crear polígono de flecha hacia abajo
                        int[] xPoints = {x, x + arrowWidth, x + arrowWidth / 2};
                        int[] yPoints = {y, y, y + arrowHeight};

                        g2.setColor(textoBotonColor);
                        g2.fillPolygon(xPoints, yPoints, 3);

                        g2.dispose();
                    }
                };

                button.setContentAreaFilled(false);
                button.setBorderPainted(false);
                button.setFocusPainted(false);
                button.setPreferredSize(new Dimension(35, 40));
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                button.setOpaque(false);

                return button;
            }

            @Override
            public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus) {
                // Pintar el valor seleccionado
                ListCellRenderer<Object> renderer = comboBox.getRenderer();
                Component c = renderer.getListCellRendererComponent(
                        listBox, comboBox.getSelectedItem(), -1, false, false);

                c.setFont(comboBox.getFont());
                c.setForeground(comboBox.getForeground());


                currentValuePane.paintComponent(g, c, comboBox, bounds.x, bounds.y,
                        bounds.width, bounds.height, false);
            }
        });

        // Borde vacío para dar espacio
        comboEjercicios.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 5));

        comboEjercicios.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setForeground(textoBotonColor);
                label.setBackground(isSelected ? bordeColor : botonColor);
                label.setFont(new Font("Arial", Font.PLAIN, 14));
                label.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
                return label;
            }
        });

        comboEjercicios.setBackground(botonColor);
        comboEjercicios.setForeground(textoBotonColor);
        comboEjercicios.setPreferredSize(new Dimension(210, 40));
        comboEjercicios.setFocusable(false);
        comboEjercicios.setFont(new Font("Arial", Font.PLAIN, 14));

        // Panel de controles (combo + botón)
        JPanel controlesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        controlesPanel.setBackground(new Color(38, 38, 38));
        controlesPanel.add(comboEjercicios);


        // -----------------------------
        // Botón Ejecutar con estilo
        // -----------------------------
        botonEjecutar.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(botonColor);
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
                g2.setColor(bordeColor);
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 20, 20);
                g2.dispose();
                super.paint(g, c);
            }
        });

        botonEjecutar.setContentAreaFilled(false);
        botonEjecutar.setFocusPainted(false);
        botonEjecutar.setForeground(textoBotonColor);
        botonEjecutar.setPreferredSize(new Dimension(100, 40));
        botonEjecutar.setBorderPainted(false);

        controlesPanel.add(botonEjecutar);
        panelTop.add(controlesPanel, BorderLayout.EAST);
        add(panelTop, BorderLayout.CENTER);
    }

    // Sobrecarga para 4 parámetros
    public TopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar,
                    Color fgLight, Color botonColor) {
        this(comboEjercicios, botonEjecutar, fgLight, botonColor, Color.DARK_GRAY, Color.WHITE);
    }
}