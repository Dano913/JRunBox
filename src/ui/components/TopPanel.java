package ui.components;

import ui.RoundedPanel;
import ui.components.styledUtils.RoundedUtils;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class TopPanel extends RoundedPanel {

    private JLabel tiempoLabel;

    public TopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar,
                    Color fgLight, Color botonColor, Color bordeColor, Color textoBotonColor) {
        super(20, new Color(38, 38, 38));
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // Panel superior
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(38, 38, 38));
        panelTop.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel tituloLabel = new JLabel("Ejercicios de Programación");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));
        tituloLabel.setForeground(fgLight);
        panelTop.add(tituloLabel, BorderLayout.WEST);

        // Panel controles
        JPanel controlesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        controlesPanel.setBackground(new Color(38, 38, 38));
        controlesPanel.add(comboEjercicios);
        controlesPanel.add(botonEjecutar);

        tiempoLabel = new JLabel("Tiempo: 0 ms");
        tiempoLabel.setForeground(fgLight);
        controlesPanel.add(tiempoLabel);

        panelTop.add(controlesPanel, BorderLayout.EAST);
        add(panelTop, BorderLayout.CENTER);

        comboEjercicios.setPreferredSize(new Dimension(210, 35));
        botonEjecutar.setPreferredSize(new Dimension(90, 35));

        // --- Estilos oscuros y redondeados ---
        RoundedUtils.aplicarEstiloRedondeado(botonEjecutar, botonColor, bordeColor, textoBotonColor, 20, 1.5f);
        RoundedUtils.aplicarEstiloRedondeado(comboEjercicios, botonColor, bordeColor, textoBotonColor, 20, 1.5f);

        // --- Custom Scrollbar redondeada para el combo ---
        customizeComboScrollBar(comboEjercicios);
    }

    private void customizeComboScrollBar(JComboBox<String> combo) {
        combo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e) {
                SwingUtilities.invokeLater(() -> {
                    JScrollPane scrollPane = findScrollPane(combo);
                    if (scrollPane != null) {
                        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                            @Override
                            protected void configureScrollBarColors() {
                                this.thumbColor = new Color(80, 80, 80);
                                this.trackColor = new Color(30, 30, 30);
                            }

                            @Override
                            protected JButton createDecreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            @Override
                            protected JButton createIncreaseButton(int orientation) {
                                return createZeroButton();
                            }

                            private JButton createZeroButton() {
                                JButton jbutton = new JButton();
                                jbutton.setPreferredSize(new Dimension(0, 0));
                                jbutton.setMinimumSize(new Dimension(0, 0));
                                jbutton.setMaximumSize(new Dimension(0, 0));
                                return jbutton;
                            }
                        });
                        scrollPane.setBorder(BorderFactory.createEmptyBorder());
                    }
                });
            }

            @Override public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e) {}
            @Override public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {}
        });
    }

    private JScrollPane findScrollPane(JComboBox<?> combo) {
        Object comp = combo.getUI().getAccessibleChild(combo, 0);
        if (comp instanceof JPopupMenu popup) {
            for (Component c : popup.getComponents()) {
                if (c instanceof JScrollPane scroll) {
                    return scroll;
                }
            }
        }
        return null;
    }

    public TopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar,
                    Color fgLight, Color botonColor) {
        this(comboEjercicios, botonEjecutar, fgLight, botonColor, Color.DARK_GRAY, Color.WHITE);
    }

    public void setTiempoEjecucion(long ms) {
        tiempoLabel.setText("Tiempo: " + ms + " ms");
    }
}
