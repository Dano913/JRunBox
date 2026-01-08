package main;

import javax.swing.*;
import java.awt.*;

import controller.ExerciseHandler;
import ui.builders.UIBuilder;
import ui.RoundedPanel;

import utils.ExecutionUtils;

import ui.components.TopPanel;


public class App extends JFrame {

    private JLabel tituloEjercicioLabel;
    private JTextArea consola;
    private JPanel inputPanel;
    private JLabel preguntaLabel;
    private JTextField respuestaField;
    private JButton siguienteButton;

    private RoundedPanel mainPanel;
    private TopPanel topPanel;
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
        setTitle("JRunBox");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout()); // ventana centrada
        setLocationRelativeTo(null); // centrado en pantalla

        Color bgDark = new Color(28, 28, 28);
        getContentPane().setBackground(bgDark);
        Color fgLight = new Color(230, 230, 230);
        Color botonColor = new Color(64, 64, 64);

// --- CREAR LOS CONTROLES PRIMERO ---
        comboEjercicios = new JComboBox<>(ExerciseHandler.NOMBRES_EJERCICIOS);
        botonEjecutar = new JButton("Ejecutar");

// --- CREAR PANEL PRINCIPAL ---
        UIBuilder builder = new UIBuilder();
        mainPanel = builder.buildMainPanel();

// --- CREAR PANEL SUPERIOR REDONDEADO ---
        topPanel = builder.buildTopPanel(comboEjercicios, botonEjecutar, fgLight, botonColor);
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

                long duration = ExecutionUtils.medirTiempo(() -> {
                    ExerciseHandler.iniciarEjercicio(this, ejercicioActual);
                });

                topPanel.setTiempoEjecucion(duration);
            }
        });


        siguienteButton.addActionListener(e ->
                ExerciseHandler.procesarRespuesta(this, ejercicioActual, respuestaField.getText().trim())
        );

        respuestaField.addActionListener(e ->
                ExerciseHandler.procesarRespuesta(this, ejercicioActual, respuestaField.getText().trim())
        );
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
    public void appendConsola(String texto) {
        SwingUtilities.invokeLater(() -> {
            consola.append(texto);
            consola.setCaretPosition(consola.getDocument().getLength()); // auto-scroll al final
        });
    }
    public void setTituloEjercicio(String titulo) {
        if (tituloEjercicioLabel != null) {
            tituloEjercicioLabel.setText(titulo);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
