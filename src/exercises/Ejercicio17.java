package exercises;
import main.App;
public class Ejercicio17 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 17 - Condiciones compuestas");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "¿Eres estudiante?",
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
                "Estudiante",
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
                int edad26 = 26;
                int edad = Integer.parseInt(respuestas[0]);
                boolean estudiante = Boolean.parseBoolean(respuestas[1]);
                boolean joven = edad < edad26;
                if(joven && estudiante) {
                    app.appendConsola("Tienes menos de "+edad26+" años y eres estudiante, por tanto optas al descuento especial.\n");
                } else if(joven && !estudiante){
                    app.appendConsola("Tienes menos de "+edad26+" años pero no eres estudiante, por tanto sólo optas al descuento joven.\n");
                } else if (!joven && estudiante) {
                    app.appendConsola("Eres estudiante pero tienes "+edad26+" años o más, por tanto sólo optas al descuento estudiante.\n");
                } else if(!joven && !estudiante) {
                    app.appendConsola("No eres estudiante y tienes "+edad26+" o más, por tanto no optas a ningún descuento.\n");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
