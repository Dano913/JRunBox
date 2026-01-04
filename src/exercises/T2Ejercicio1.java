package exercises;
import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 2 - División con resto");
        app.setPreguntas(new String[]{
            "Introduce el primer número",
            "Introduce el segundo número"
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Primer número",
                "Segundo número"
        };
        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar de pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no hay más preguntas, realizar operaciones
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularOperaciones(app);
        }
    }

    private static void calcularOperaciones(App app) {

        String[] respuestas = app.getRespuestasTexto();

        try {
            double num1 = Double.parseDouble(respuestas[0]);
            double num2 = Double.parseDouble(respuestas[1]);

            app.appendConsola("\nOperaciones aritméticas:\n");
            app.appendConsola("Suma: " + num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
            app.appendConsola("Resta: " + num1 + " - " + num2 + " = " + (num1 - num2) + "\n");
            app.appendConsola("Multiplicación: " + num1 + " * " + num2 + " = " + (num1 * num2) + "\n");

            if (num2 != 0) {
                app.appendConsola("División: " + num1 + " / " + num2 + " = " + (num1 / num2) + "\n");
                app.appendConsola("Módulo (resto): " + num1 + " % " + num2 + " = " + (num1 % num2) + "\n");
            } else {
                app.appendConsola("División entre 0 no permitida\n");
            }

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores no es un número válido.\n");
        }
    }
}
