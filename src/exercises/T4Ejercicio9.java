package exercises;
import main.App;

public class T4Ejercicio9 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 44 - Factorial con for");
        app.setPreguntas(new String[]{
                "Introduce un número entero positivo"
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
                "Número"

        };
        String[] unidades = {
                ""
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
                int num1 = Integer.parseInt(respuestas[0]);
                long factorial = 1;
                for (int i = 1; i <= num1; i++) {
                    factorial *= i;
                }

                app.appendConsola(String.format("Factorial de %d es %d%n", num1, factorial));

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
