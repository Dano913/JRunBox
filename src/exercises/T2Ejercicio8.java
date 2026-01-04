package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 2 - Operaciones combinadas");
        app.setPreguntas(new String[]{
                "Introduce el primer número",
                "Introduce el segundo número",
                "Introduce el tercer número"
        });

        // Inicializa entradas y panel de manera genérica
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Primer número", "Segundo número", "Tercer número" };

        // Guardar respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, realizar operaciones
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            realizarOperaciones(app);
        }
    }

    private static void realizarOperaciones(App app) {
        String[] respuestas = app.getRespuestasTexto();

        try {
            double num1 = Double.parseDouble(respuestas[0]);
            double num2 = Double.parseDouble(respuestas[1]);
            double num3 = Double.parseDouble(respuestas[2]);

            double suma = num1 + num2 + num3;
            double promedio = suma / 3;
            double calculo = num3 != 0 ? (num1 * num2) / num3 : Double.NaN;

            app.appendConsola("La suma de los 3 números es: " + suma + "\n");
            app.appendConsola("El promedio de los 3 números es: " + promedio + "\n");
            app.appendConsola(num3 != 0
                    ? "El resultado del cálculo (num1*num2)/num3 es: " + calculo + "\n"
                    : "Error: división por 0 en el cálculo final\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores no es un número válido.\n");
        }
    }
}
