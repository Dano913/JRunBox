package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T9Ejercicio7 {

    private static final int[][] matriz = new int[3][4];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 9 - Transponer una matriz");
        app.setPreguntas(new String[]{
                "Presiona enter para crear la matriz"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta: genera la matriz, la muestra y calcula el promedio de cada fila
    public static void procesarRespuesta(App app, String texto) {
        Random rand = new Random();

        // Generar matriz aleatoria
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(101);
            }
        }

        // Imprimir matriz
        app.appendConsola("Matriz generada:\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                app.appendConsola(matriz[i][j] + " ");
            }
            app.appendConsola("\n");
        }

        // Transponer e imprimir la matriz
        app.appendConsola("\nMatriz transpuesta:\n");

        int filas = matriz.length;
        int columnas = matriz[0].length;

        // La matriz transpuesta tendrá dimensiones invertidas
        for (int j = 0; j < columnas; j++) {        // Columnas pasan a ser filas
            for (int i = 0; i < filas; i++) {       // Filas pasan a ser columnas
                app.appendConsola(matriz[i][j] + " ");
            }
            app.appendConsola("\n");
        }

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
