public class Ejercicio4 {

    // 🔹 Inicia el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "Ingresa el título del libro:",
                "Ingresa el autor del libro:",
                "Ingresa el año de publicación:",
                "Ingresa el número de páginas:",
                "¿Disponible en biblioteca? (true/false):"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }

    // 🔹 Procesa cada respuesta parcial
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;

        String[] etiquetas = {
                "Título",
                "Autor",
                "Año de publicación",
                "Número de páginas",
                "Disponible en biblioteca"
        };

        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");

        // Avanzar a siguiente pregunta
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("\n¡Datos del libro completados!\n");
        }
    }
}
