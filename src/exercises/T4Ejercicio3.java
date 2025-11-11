package exercises;
import main.App;

public class T4Ejercicio3 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 38 - Calculadora con switch");
        app.setPreguntas(new String[]{
                "Introduce un número",
                "Introduce otro número",
                "Introduce la operación(+, -, *, /)"
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
                "Segundo número",
                "Operación"

        };
        String[] unidades = {
                "",
                "",
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
                int num2 = Integer.parseInt(respuestas[1]);
                char operando = respuestas[2].charAt(0);
                double resultado = 0;
                switch(operando) {
                    case '+' -> {resultado = num1 + num2;}
                    case '-' -> {resultado = num1 - num2;}
                    case '*' -> {resultado = num1 * num2;}
                    case '/' -> {resultado = (double)num1/num2;}
                    default -> {app.appendConsola("Operación no esperada o inválida");}
                }
                app.appendConsola(String.format("%d %s %d = %.1f", num1, operando, num2, resultado));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
