package exercises;
import main.App;
public class T3Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 21 - Mayoria de edad");
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
                "Edad",
        };
        app.appendConsola(etiquetas[indice] + ": " + texto+"\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                int edad = Integer.parseInt(respuestas[0]);
                int edadLegal = 18;
                boolean mayoria = edad >= edadLegal;
                if(mayoria){
                    app.appendConsola("Tienes "+edad+". Aunque no sirva para nada, puedes votar.");
                }else{
                    app.appendConsola("Tienes "+edad+". No puedes votar, pero no te preocupes no tiene ninguna utilidad.");
                }

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
