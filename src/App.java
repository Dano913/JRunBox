

import javax.swing.*;
import java.awt.*;
import ui.builders.UIBuilder;
import ui.RoundedPanel;


public class App extends JFrame {

    private JLabel tituloEjercicioLabel;
    private JTextArea consola;
    private JPanel inputPanel;
    private JLabel preguntaLabel;
    private JTextField respuestaField;
    private JButton siguienteButton;

    private RoundedPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelCentral;
    private JPanel panelDerecho;
    private JScrollPane scroll;
    private JComboBox<String> comboEjercicios;
    private JButton botonEjecutar;

    private String[] preguntas;
    private String[] respuestasTexto;
    private int indicePregunta;
    private int puntuacion;

    private String ejercicioActual; // ← guardamos el ejercicio seleccionado por botón

    public App() {
        initUI();
    }

    private void initUI() {
        setTitle("Mini Aplicación de Ejercicios");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // ventana centrada
        setLocationRelativeTo(null); // centrado en pantalla

        Color bgDark = new Color(28, 28, 28);
        getContentPane().setBackground(bgDark);
        Color fgLight = new Color(230, 230, 230);
        Color botonColor = new Color(64, 64, 64);

// --- CREAR LOS CONTROLES PRIMERO ---
        String[] nombresEjercicios = {
                "Ejercicio 1","Ejercicio 2","Ejercicio 3","Ejercicio 4","Ejercicio 5",
                "Ejercicio 6","Ejercicio 7","Ejercicio 8","Ejercicio 9","Ejercicio 10",
                "Ejercicio 11","Ejercicio 12","Ejercicio 13","Ejercicio 14","Ejercicio 15",
                "Ejercicio 16","Ejercicio 17","Ejercicio 18","Ejercicio 19","Ejercicio 20"
        };
        comboEjercicios = new JComboBox<>(nombresEjercicios);
        botonEjecutar = new JButton("Ejecutar");

// --- CREAR PANEL PRINCIPAL ---
        UIBuilder builder = new UIBuilder();
        mainPanel = builder.buildMainPanel();

// --- CREAR PANEL SUPERIOR REDONDEADO ---
        RoundedPanel topPanel = builder.buildTopPanel(comboEjercicios, botonEjecutar, fgLight, botonColor);
        mainPanel.add(topPanel, BorderLayout.NORTH);


        // --- PANEL CENTRAL REDONDEADO ---
        tituloEjercicioLabel = new JLabel();
        inputPanel = new JPanel();
        preguntaLabel = new JLabel();
        respuestaField = new JTextField();
        siguienteButton = new JButton("Siguiente");

        RoundedPanel centralPanel = builder.buildCentralPanel(
                tituloEjercicioLabel,
                inputPanel,
                preguntaLabel,
                respuestaField,
                siguienteButton,
                fgLight
        );

        mainPanel.add(centralPanel, BorderLayout.CENTER);

        // --- CONSOLA INFERIOR ---
        consola = new JTextArea();
        scroll = new JScrollPane();
        RoundedPanel consolaPanel = builder.buildConsolaPanel(consola, scroll, fgLight);
        mainPanel.add(consolaPanel, BorderLayout.SOUTH);

        // --- AÑADIR mainPanel A LA VENTANA CON PESOS ---
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;   // ancho 100%
        gbc.weighty = 1.0;   // alto 100%
        gbc.fill = GridBagConstraints.BOTH;
        add(mainPanel, gbc);

        // --- ACCIONES ---
        botonEjecutar.addActionListener(e -> {
            String ejercicioSeleccionado = (String) comboEjercicios.getSelectedItem();
            if (ejercicioSeleccionado != null) {
                ejercicioActual = ejercicioSeleccionado;
                iniciarEjercicio(ejercicioActual);
            }
        });
        siguienteButton.addActionListener(e -> procesarRespuesta());
        respuestaField.addActionListener(e -> procesarRespuesta());
    }

    // --- Métodos para delegar a los ejercicios ---
    private void iniciarEjercicio(String ejercicio) {
        switch (ejercicio) {
            case "Ejercicio 1" -> Ejercicio1.iniciarEjercicio(this);
            case "Ejercicio 2" -> Ejercicio2.iniciarEjercicio(this);
            case "Ejercicio 3" -> Ejercicio3.iniciarEjercicio(this);
            case "Ejercicio 4" -> Ejercicio4.iniciarEjercicio(this);
            case "Ejercicio 5" -> Ejercicio5.iniciarEjercicio(this);
            case "Ejercicio 6" -> Ejercicio6.iniciarEjercicio(this);
            case "Ejercicio 7" -> Ejercicio7.iniciarEjercicio(this);
            case "Ejercicio 8" -> Ejercicio8.iniciarEjercicio(this);
            case "Ejercicio 9" -> Ejercicio9.iniciarEjercicio(this);
            case "Ejercicio 10" -> Ejercicio10.iniciarEjercicio(this);
            case "Ejercicio 11" -> Ejercicio11.iniciarEjercicio(this);
            case "Ejercicio 12" -> Ejercicio12.iniciarEjercicio(this);
            case "Ejercicio 13" -> Ejercicio13.iniciarEjercicio(this);
            case "Ejercicio 14" -> Ejercicio14.iniciarEjercicio(this);
            case "Ejercicio 15" -> Ejercicio15.iniciarEjercicio(this);
            case "Ejercicio 16" -> Ejercicio16.iniciarEjercicio(this);
            case "Ejercicio 17" -> Ejercicio17.iniciarEjercicio(this);
            case "Ejercicio 18" -> Ejercicio18.iniciarEjercicio(this);
            case "Ejercicio 19" -> Ejercicio19.iniciarEjercicio(this);
            case "Ejercicio 20" -> Ejercicio20.iniciarEjercicio(this);
        }
    }

    private void procesarRespuesta() {
        if (ejercicioActual == null) return; // seguridad
        String texto = respuestaField.getText().trim();

        switch (ejercicioActual) {
            case "Ejercicio 1" -> Ejercicio1.procesarRespuesta(this, texto);
            case "Ejercicio 2" -> Ejercicio2.procesarRespuesta(this, texto);
            case "Ejercicio 3" -> Ejercicio3.procesarRespuesta(this, texto);
            case "Ejercicio 4" -> Ejercicio4.procesarRespuesta(this, texto);
            case "Ejercicio 5" -> Ejercicio5.procesarRespuesta(this, texto);
            case "Ejercicio 6" -> Ejercicio6.procesarRespuesta(this, texto);
            case "Ejercicio 7" -> Ejercicio7.procesarRespuesta(this, texto);
            case "Ejercicio 8" -> Ejercicio8.procesarRespuesta(this, texto);
            case "Ejercicio 9" -> Ejercicio9.procesarRespuesta(this, texto);
            case "Ejercicio 10" -> Ejercicio10.procesarRespuesta(this, texto);
            case "Ejercicio 11" -> Ejercicio11.procesarRespuesta(this, texto);
            case "Ejercicio 12" -> Ejercicio12.procesarRespuesta(this, texto);
            case "Ejercicio 13" -> Ejercicio13.procesarRespuesta(this, texto);
            case "Ejercicio 14" -> Ejercicio14.procesarRespuesta(this, texto);
            case "Ejercicio 15" -> Ejercicio15.procesarRespuesta(this, texto);
            case "Ejercicio 16" -> Ejercicio16.procesarRespuesta(this, texto);
            case "Ejercicio 17" -> Ejercicio17.procesarRespuesta(this, texto);
            case "Ejercicio 18" -> Ejercicio18.procesarRespuesta(this, texto);
            case "Ejercicio 19" -> Ejercicio19.procesarRespuesta(this, texto);
            case "Ejercicio 20" -> Ejercicio20.procesarRespuesta(this, texto);
        }
    }

    // --- Getters y setters para ejercicios ---
    public String[] getPreguntas() { return preguntas; }
    public void setPreguntas(String[] preguntas) { this.preguntas = preguntas; }
    public String[] getRespuestasTexto() { return respuestasTexto; }
    public void setRespuestasTexto(String[] respuestasTexto) { this.respuestasTexto = respuestasTexto; }
    public int getIndicePregunta() { return indicePregunta; }
    public void setIndicePregunta(int indicePregunta) { this.indicePregunta = indicePregunta; }
    public int getPuntuacion() { return puntuacion; }
    public void setPuntuacion(int puntuacion) { this.puntuacion = puntuacion; }

    public void setPreguntaLabel(String texto) { preguntaLabel.setText(texto); }
    public void limpiarRespuestaField() { respuestaField.setText(""); }
    public void setInputPanelVisible(boolean visible) { inputPanel.setVisible(visible); }
    public void limpiarConsola() { consola.setText(""); }
    public void requestFocusRespuesta() { respuestaField.requestFocus(); }
    public void appendConsola(String texto) { consola.append(texto); }
    public void setTituloEjercicio(String titulo) {
        if (tituloEjercicioLabel != null) {
            tituloEjercicioLabel.setText("▶ " + titulo);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
