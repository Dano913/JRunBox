package exercises;
import main.App;
public class Ejercicio12 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 12 - Números comparados");
        app.setPreguntas(new String[]{
                "Introudce el primer número",
                "Introduce el segundo número"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto){
        int indice = app.getIndicePregunta();
        String [] respuestas = app.getRespuestasTexto();
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
                 app.appendConsola("\nCOMPARACIONES\n");
                app.appendConsola(num1 + " > " + num2 + " ? " + (num1 > num2) + "\n");
                app.appendConsola(num1 + " < " + num2 + " ? " + (num1 < num2) + "\n");
                app.appendConsola(num1 + " == " + num2 + " ? " + (num1 == num2) + "\n");
                app.appendConsola(num1 + " >= " + num2 + " ? " + (num1 >= num2) + "\n");
                app.appendConsola(num1 + " <= " + num2 + " ? " + (num1 <= num2) + "\n");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
