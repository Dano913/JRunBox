package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T9Ejercicio8 {

    private static final int[][] matriz = new int[3][4];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 9 - Contar pares e impares en una matriz");
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

        // Contar e imprimir la cantidad de pares e impares
        app.appendConsola("\nConteo de pares e impares:\n");

        int pares = 0;
        int impares = 0;

        for (int i = 0; i < matriz.length; i++) {          // recorrer filas
            for (int j = 0; j < matriz[i].length; j++) {   // recorrer columnas
                if (matriz[i][j] % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }
            }
        }

        app.appendConsola("Números pares: " + pares + "\n");
        app.appendConsola("Números impares: " + impares + "\n");

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
