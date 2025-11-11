// ui/components/ConsolaPanel.java
package ui.components;

import ui.RoundedPanel;
import javax.swing.*;
import java.awt.*;

public class ConsolaPanel extends RoundedPanel {

    public ConsolaPanel(JTextArea consola, JScrollPane scroll, Color fgLight) {
        super(20, new Color(20, 20, 20));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Configurar JTextArea ---
        consola.setEditable(false);
        consola.setFont(new Font("Monospaced", Font.PLAIN, 16));
        consola.setBackground(new Color(20, 20, 20));
        consola.setForeground(fgLight);
        consola.setCaretColor(fgLight);

        // --- Configurar JScrollPane ---
        scroll.setViewportView(consola);
        scroll.setPreferredSize(new Dimension(780, 250));
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);

        scroll.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scroll.getHorizontalScrollBar().setUI(new CustomScrollBarUI());

        ((CustomScrollBarUI) scroll.getVerticalScrollBar().getUI()).setThinScrollbar(scroll.getVerticalScrollBar());
        ((CustomScrollBarUI) scroll.getHorizontalScrollBar().getUI()).setThinScrollbar(scroll.getHorizontalScrollBar());

        add(scroll, BorderLayout.CENTER);
    }
}
