package exercises;
import main.App;

public class T3Ejercicio7 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 27 - Claificacion con letra");
        app.setPreguntas(new String[]{
                "Introduce tu nota"
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
                "Nota"
        };
        try {
            double valor = Double.parseDouble(texto);

            if (valor <= 0 || valor >= 10) {
                app.appendConsola("❌ Error: la nota debe estar entre 1 y 10.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
            respuestas[indice] = texto;
            app.appendConsola("Nota " + (indice + 1) + ": " + valor + "\n");
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            double nota = Double.parseDouble(respuestas[0]);
            if(0<=nota && nota<5) {
                app.appendConsola("Tu calificacion es Suspenso");
            } else if(5<=nota && nota<7){
                app.appendConsola("Tu calificacion es Aprobado");
            } else if(7<=nota && nota<9){
                app.appendConsola("Tu calificacion es Notable");
            } else if(9<=nota && nota<=10){
                app.appendConsola("Tu calificacion es Sobresaliente");
            }
        }
    }
}
