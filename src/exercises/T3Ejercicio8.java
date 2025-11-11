package exercises;
import main.App;

public class T3Ejercicio8 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 28 - Comparación de números");
        app.setPreguntas(new String[]{
                "Introduce el primer número",
                "Introduce el segundo número"
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
                "Primer número",
                "Segundo número"
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
                double num1 = Double.parseDouble(respuestas[0]);
                double num2 = Double.parseDouble(respuestas[1]);
                if(num1>num2) {
                    app.appendConsola(num1+" es mayor que "+num2);
                } else {
                    app.appendConsola(num1+" es menor que "+num2);
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
