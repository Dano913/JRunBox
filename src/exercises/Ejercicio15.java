package exercises;
import main.App;
public class Ejercicio15 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 15 - Operadores lógicos");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "¿Tienes carnet de conducir?",
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
                "Edad",
                "Carnet de conducir",
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try{
                int edadMin = 21;
                int edad = Integer.parseInt(respuestas[0]);
                boolean carnet = Boolean.parseBoolean(respuestas[1]);
                boolean mayoria = edad >= edadMin;
                if (mayoria) {
                    app.appendConsola("Eres mayor de edad.\n");
                } else {
                    app.appendConsola("No eres mayor de edad.\n");
                }
                if (carnet) {
                    app.appendConsola("Tienes carnet de conducir.\n");
                } else {
                    app.appendConsola("No tienes carnet de conducir.\n");
                }
                if (mayoria && carnet) {
                    app.appendConsola("Puedes conducir legalmente.\n");
                } else {
                    app.appendConsola("No puedes conducir todavía.\n");
                }

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
