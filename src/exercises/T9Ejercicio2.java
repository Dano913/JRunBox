package exercises;

import main.App;
import utils.EjercicioUtils;

public class T9Ejercicio2 {

    private static final int[][] matriz = new int[2][4];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 - Rellenar matriz 2x4 con input del usuario");
        app.setPreguntas(new String[]{
                "Introduce el valor para posición [0][0]:",
                "Introduce el valor para posición [0][1]:",
                "Introduce el valor para posición [0][2]:",
                "Introduce el valor para posición [0][3]:",
                "Introduce el valor para posición [1][0]:",
                "Introduce el valor para posición [1][1]:",
                "Introduce el valor para posición [1][2]:",
                "Introduce el valor para posición [1][3]:"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta y muestra la matriz al final
    public static void procesarRespuesta(App app, String texto) {
        int index = app.getIndicePregunta(); // índice actual de pregunta

        // Guardar el valor introducido en la matriz
        if (index >= 0 && index < 8) {
            int fila = index / 4;
            int columna = index % 4;

            try {
                matriz[fila][columna] = Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("Por favor, introduce un número válido.\n");
                return; // salir sin avanzar la pregunta
            }
        }

        // Si acabamos de introducir el último número, imprimimos la matriz
        if (app.getIndicePregunta() >= app.getPreguntas().length - 1) { // índice de la última pregunta
            app.appendConsola("Matriz resultante:\n");
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    app.appendConsola(matriz[i][j] + " ");
                }
                app.appendConsola("\n");
            }
        }

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);
    }
}
