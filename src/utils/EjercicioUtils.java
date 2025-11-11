package utils;

import main.App;

public class EjercicioUtils {

    // Inicializa el panel de entrada para un nuevo ejercicio
    public static void inicializarEntrada(App app) {
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        // Crea un array vacío para guardar tantas respuestas como preguntas hay
        app.setIndicePregunta(0);
        // Empieza en la primera pregunta
        app.setPreguntaLabel(app.getPreguntas()[0]);
        // Muestra la primera pregunta
        app.limpiarRespuestaField();
        // Limpia el campo de texto
        app.setInputPanelVisible(true);
        // Hace visible el panel de entrada
        app.limpiarConsola();
        // Limpia la consola
        app.requestFocusRespuesta();
        // Pone el cursor en el campo de texto
    }

    // Metodo genérico para avanzar a la siguiente pregunta
    public static void avanzarPregunta(App app) {
        int indice = app.getIndicePregunta();
        app.setIndicePregunta(indice + 1);
        // Incrementa el índice para pasar a la siguiente pregunta

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            // Muestra la siguiente pregunta
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            // Coloca el cursor en el campo de entrada
        } else {
            app.setInputPanelVisible(false);
            // Oculta el panel si no quedan preguntas
        }
    }

    // Metodo genérico para procesar respuestas de texto y guardarlas
    public static void procesarRespuesta(App app, String texto, String[] etiquetas, String[] unidades) {
        int indice = app.getIndicePregunta();
        app.getRespuestasTexto()[indice] = texto;
        // Guarda la respuesta en el array
        String unidad = (unidades != null && indice < unidades.length) ? " " + unidades[indice] : "";
        // Obtiene la unidad correspondiente si existe
        app.appendConsola(etiquetas[indice] + ": " + texto + unidad + "\n");
        // Muestra la respuesta con etiqueta y unidad
    }
}
