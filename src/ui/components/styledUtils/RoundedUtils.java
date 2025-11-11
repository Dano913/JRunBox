package ui.components.styledUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Clase utilitaria para aplicar bordes redondeados y estilos consistentes
 * a botones y combo boxes.
 */
public class RoundedUtils {

    /**
     * Dibuja un fondo redondeado con borde en un componente.
     *
     * @param g Graphics
     * @param c Componente sobre el que pintar
     * @param fondoColor Color de fondo
     * @param bordeColor Color del borde
     * @param radio Radio de las esquinas
     * @param grosor Grosor del borde
     */
    public static void pintarFondoRedondeado(Graphics g, JComponent c,
                                             Color fondoColor, Color bordeColor,
                                             int radio, float grosor) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo
        g2.setColor(fondoColor);
        g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), radio, radio);

        // Borde
        g2.setColor(bordeColor);
        g2.setStroke(new BasicStroke(grosor));
        g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, radio, radio);

        g2.dispose();
    }

    /**
     * Configura un botón con estilo redondeado.
     */
    public static void aplicarEstiloRedondeado(JButton boton, Color fondo, Color borde,
                                               Color texto, int radio, float grosor) {
        boton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                pintarFondoRedondeado(g, c, fondo, borde, radio, grosor);
                super.paint(g, c);
            }
        });
        boton.setContentAreaFilled(false);
        boton.setFocusPainted(false);
        boton.setForeground(texto);
        boton.setBorderPainted(false);
    }

    /**
     * Configura un ComboBox con estilo redondeado y flecha personalizada.
     */
    public static void aplicarEstiloRedondeado(JComboBox<String> comboBox,
                                               Color fondo, Color borde, Color texto,
                                               int radio, float grosor) {
        comboBox.setBackground(fondo);
        comboBox.setForeground(texto);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 14));
        comboBox.setFocusable(false);
        comboBox.setBorder(BorderFactory.createEmptyBorder(0, 12, 0, 5));
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setForeground(texto);
                label.setBackground(isSelected ? borde : fondo);
                label.setFont(new Font("Arial", Font.PLAIN, 14));
                label.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
                return label;
            }
        });

        comboBox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton button = new JButton() {
                    @Override
                    public void paintComponent(Graphics g) {
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                        // Dibujar flecha hacia abajo
                        int w = getWidth();
                        int h = getHeight();
                        int arrowWidth = 8;
                        int arrowHeight = 5;
                        int x = (w - arrowWidth) / 2;
                        int y = (h - arrowHeight) / 2;

                        int[] xPoints = {x, x + arrowWidth, x + arrowWidth / 2};
                        int[] yPoints = {y, y, y + arrowHeight};

                        g2.setColor(texto);
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
            protected void installDefaults() {
                super.installDefaults();
                comboBox.setOpaque(false);
            }

            @Override
            public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
                pintarFondoRedondeado(g, comboBox, fondo, borde, radio, grosor);
            }
        });
    }
}
