package exercises;

import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 1 – Operaciones aritméticas");
        app.setPreguntas(new String[]{
                "Introduce un número",
                "Introduce otro número"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Primer número", "Segundo número" };

        // Guardar respuesta y mostrar etiqueta
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si se han completado las respuestas, hacer operaciones aritméticas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double num1 = Double.parseDouble(respuestas[0]);
                double num2 = Double.parseDouble(respuestas[1]);

                app.appendConsola("\nOperaciones aritméticas:\n");
                app.appendConsola("Suma: " + num1 + " + " + num2 + " = " + (num1 + num2) + "\n");
                app.appendConsola("Resta: " + num1 + " - " + num2 + " = " + (num1 - num2) + "\n");
                app.appendConsola("Multiplicación: " + num1 + " * " + num2 + " = " + (num1 * num2) + "\n");
                app.appendConsola((num2 != 0)
                        ? "División: " + num1 + " / " + num2 + " = " + (num1 / num2) + "\n"
                        : "División entre 0 no permitida\n");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }

            app.appendConsola("¡Operaciones aritméticas resueltas!\n");
        }
    }
}
