package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio2 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 2 - Números comparados");
        app.setPreguntas(new String[]{
                "Introduce el primer número",
                "Introduce el segundo número"
        });
        // Inicializa entradas usando EjercicioUtils para no repetir código
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Primer número", "Segundo número" };

        // Guardar la respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no hay más preguntas, realizar comparaciones
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            compararNumeros(app);
        }
    }

    private static void compararNumeros(App app) {

        String[] respuestas = app.getRespuestasTexto();

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
