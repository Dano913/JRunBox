package ui.components;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Scrollbar personalizada para consola.
 * - Thumb y track con colores oscuros
 * - Hover con color más claro
 * - Bordes redondeados
 * - Sin botones visibles
 */
public class CustomScrollBarUI extends BasicScrollBarUI {

    // Colores de la scrollbar
    private final Color thumbColor = new Color(80, 80, 80);
    private final Color thumbHoverColor = new Color(120, 120, 120);
    private final Color trackColor = new Color(30, 30, 30);

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Color según si el mouse está encima
        g2.setColor(isThumbRollover() ? thumbHoverColor : thumbColor);

        // Dibujar rectángulo redondeado
        g2.fillRoundRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height, 10, 10);
        g2.dispose();
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
        g.setColor(trackColor);
        g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
    }

    // Eliminamos los botones de incremento/decremento
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton();
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton();
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0));
        button.setVisible(false);
        button.setOpaque(false);
        button.setFocusable(false);
        return button;
    }

    // Opcional: barra más delgada
    public void setThinScrollbar(JScrollBar scrollBar) {
        if (scrollBar.getOrientation() == JScrollBar.VERTICAL) {
            scrollBar.setPreferredSize(new Dimension(8, 0));
        } else {
            scrollBar.setPreferredSize(new Dimension(0, 8));
        }
    }
}
