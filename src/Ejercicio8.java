public class Ejercicio8 {
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "¿Cuánto mide la base del rectángulo?",
                "¿Cuánto mide la altura del rectángulo?"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        app.getRespuestasTexto()[indice] = texto;
        String[] etiquetas = {
                "Base",
                "Altura"
        };

        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);
        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            mostrarResultadoFinal(app);
        }
    }
    public static void mostrarResultadoFinal(App app) {
        String[] respuestas = app.getRespuestasTexto();
        //Crea una referencia local del array de respuestas para ser tratado.
        try {
            double base = Double.parseDouble(respuestas[0]);
            double altura = Double.parseDouble(respuestas[1]);
            double area = base * altura;
            //Convierte las respuestas a números para operar
            app.appendConsola("\nÁrea del rectángulo: " + area + "\n");
        } catch (NumberFormatException e) {
            app.appendConsola("\nError: las entradas no son números válidos.\n");
            //Salta el error si la respuesta introducida no es un dígito.
        }
    }
}
