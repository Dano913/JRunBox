// ui/builders/UIBuilder.java
package ui.builders;
import ui.RoundedPanel;
import ui.components.TopPanel;
import ui.components.CentralPanel;
import ui.components.ConsolaPanel;
import javax.swing.*;
import java.awt.*;

public class UIBuilder {

    private final Color cardColor = new Color(45, 45, 45);

    public RoundedPanel buildMainPanel() {
        RoundedPanel mainPanel = new RoundedPanel(20, cardColor);
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return mainPanel;
    }

    public TopPanel buildTopPanel(JComboBox<String> comboEjercicios, JButton botonEjecutar,
                                  Color fgLight, Color botonColor) {
        return new TopPanel(comboEjercicios, botonEjecutar, fgLight, botonColor);
    }


    public RoundedPanel buildCentralPanel(
            JLabel tituloEjercicioLabel,
            JPanel inputPanel,
            JLabel preguntaLabel,
            JTextField respuestaField,
            JButton siguienteButton,
            Color fgLight
    ) {
        return new CentralPanel(
                tituloEjercicioLabel,
                inputPanel,
                preguntaLabel,
                respuestaField,
                siguienteButton,
                fgLight
        );
    }

    public RoundedPanel buildConsolaPanel(JTextArea consola, JScrollPane scroll, Color fgLight) {
        return new ConsolaPanel(consola, scroll, fgLight);
    }
}
