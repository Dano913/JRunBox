package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T9Ejercicio9 {

    private static final int[][] matriz = new int[10][10];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 9 - Tabla de multiplicar en una matriz");
        app.setPreguntas(new String[]{
                "Presiona enter para crear la matriz"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Genera la matriz
    public static void procesarRespuesta(App app, String texto) {
        // Generar matriz
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j] = (j + 1) * (i + 1);
            }
        }

        // Imprimir matriz
        app.appendConsola("Matriz generada:\n");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                app.appendConsola(String.format("%4d", matriz[i][j]));
            }
            app.appendConsola("\n");
        }

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
