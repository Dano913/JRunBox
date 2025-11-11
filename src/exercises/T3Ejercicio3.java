package exercises;
import main.App;

public class T3Ejercicio3 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 23 - Aprobado o suspenso");
        app.setPreguntas(new String[]{
                "Introduce una nota"
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
                "Nota",
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
                int nota = Integer.parseInt(respuestas[0]);
                if(nota>=5){
                    app.appendConsola("Has sacado un "+nota+". Has aprobado");
                }else{
                    app.appendConsola("Has sacado un "+nota+". Has suspendido");
                }

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
