package exercises;

import main.App;
import utils.EjercicioUtils;

public class T9Ejercicio1 {
    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 9 - Crear y mostrar una matriz");
        // Pregunta opcional o de ejemplo
        app.setPreguntas(new String[]{
                "Presiona enter para crear la matriz"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta y muestra un estado aleatorio
    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {

            // Defino matriz
            int[][] matriz = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            // Muestro matriz
            app.appendConsola("Matriz de 3x3:\n");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    app.appendConsola(matriz[i][j] + " ");
                }
                app.appendConsola("\n");
            }

        }
    }
}
