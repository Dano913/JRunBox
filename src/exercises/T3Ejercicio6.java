package exercises;
import main.App;

public class T3Ejercicio6 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 26 - Acceso a contenido");
        app.setPreguntas(new String[]{
                "Introduce tu edad"
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
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Edad"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                int ead = Integer.parseInt(respuestas[0]);
                int edadMin = 16;
                boolean acceso = ead >= edadMin;
                if(acceso) {
                    app.appendConsola("Acceso concedido");
                } else {
                    app.appendConsola("Acceso denegado. Debes tener al menos 16 años");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
