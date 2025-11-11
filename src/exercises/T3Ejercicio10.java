package exercises;
import main.App;

public class T3Ejercicio10 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 30 - Entrada de parque de atracciones");
        app.setPreguntas(new String[]{
                "Introduce tu altura"
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
                "Altura"
        };
        String[] unidades = {
                "cm"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + " " + unidades[indice] + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                double altMin = 120;
                double altMax = 200;
                double altura = Double.parseDouble(respuestas[0]);
                if(altMin<=altura && altura<=altMax) {
                    app.appendConsola("Puedes subir a la atracción");
                } else if(altura<altMin){
                    app.appendConsola("No puedes subir a la atracción. Altura mínima"+altMin+" cm.");
                } else if(altura>altMax){
                    app.appendConsola("No puedes subir a la atracción. Altura máxima"+altMax+" cm.");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
