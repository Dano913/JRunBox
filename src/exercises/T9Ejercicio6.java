package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T9Ejercicio6 {

    private static final int[][] matriz = new int[3][4];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 - Encontrar el mayor elemento de cada columna");
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

        // Calcular e imprimir promedio de cada fila
        app.appendConsola("\nNúmero más alto de cada columna\n");
        for (int j = 0; j < matriz[0].length; j++) {  // Recorrer columnas
            int maxColumna = matriz[0][j];        // Iniciar con el primer valor de la columna
            for (int i = 1; i < matriz.length; i++) { // Recorrer filas
                if (matriz[i][j] > maxColumna) {
                    maxColumna = matriz[i][j];
                }
            }
            app.appendConsola("Columna " + j + ": " + maxColumna + "\n");
        }

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
