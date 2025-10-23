public class Ejercicio5 {
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "¿Cómo se llama tu aplicación?",
                "¿Cuál es la versión?",
                "El valor de pi es ", // se mostrará inmediatamente
                "¿Cuál es tu usuario?",
                "¿Cuál es tu nivel?",
                "¿Qué puntuación tienes?",
                "Actualiza tu usuario si lo deseas",
                "Actualiza tu nivel",
                "Actualiza tu puntuación"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        if (indice != 2) {
            respuestas[indice] = texto;
            String[] etiquetas = {
                    "Nombre",
                    "Versión",
                    "Pi",
                    "Usuario",
                    "Nivel",
                    "Puntuación",
                    "Usuario actualizado",
                    "Nivel actualizado",
                    "Puntuación actualizado"

            };
            app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
            //Indica que este bloque se ejecuta siempre y cuando no estemos en el indice 2.
        }
        if (indice == 1) {
            //Si se llegara a la respuesta de ese Indice la siguiente la responde automaticamente porque es constante.
            respuestas[2] = String.valueOf(Math.PI);
            app.appendConsola("Pi: " + respuestas[2] + "\n");
            app.setIndicePregunta(3);
            //Salta la pregunta 2 porque se ha respondido automaticamente
            app.setPreguntaLabel(app.getPreguntas()[3]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
            //Termina el flujo normal porque ya se salto el índice 2
        }

        app.setIndicePregunta(indice + 1);
        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("¡Datos Actualizados!\n");
        }
    }
}
