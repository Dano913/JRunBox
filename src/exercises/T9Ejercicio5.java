package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T9Ejercicio5 {

    private static final double[][] matriz = new double[4][3];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 - Promedio de cada fila de la matriz");
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
                matriz[i][j] = Math.round(rand.nextDouble() * 10000.0) / 100.0;
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
        app.appendConsola("\nPromedio de cada fila:\n");
        for (int i = 0; i < matriz.length; i++) {
            double sumaFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                sumaFila += matriz[i][j];
            }
            double promedioFila = Math.round((sumaFila / matriz[i].length) * 100.0) / 100.0;
            app.appendConsola("Fila " + i + ": " + promedioFila + "\n");
        }

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
