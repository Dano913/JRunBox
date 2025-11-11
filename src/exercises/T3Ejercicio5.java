package exercises;
import main.App;

public class T3Ejercicio5 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 25 - Compra con descuento");
        app.setPreguntas(new String[]{
                "Introduce un número"
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
                "Número",
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
                int numero = Integer.parseInt(respuestas[0]);
                int resto = numero % 2;
                String parImpar;
                if(resto==0) {
                    parImpar = "par";
                } else {
                    parImpar = "impar";
                }
                app.appendConsola("El número "+numero+" es "+parImpar+".");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
