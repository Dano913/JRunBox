package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T9Ejercicio10 {

    private static final int[][] matriz = new int[4][4];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 - Sumar elementos de una matriz");
        app.setPreguntas(new String[]{
                "Presiona enter para crear la matriz"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta: genera la matriz, la muestra y calcula la suma
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Altura",
                "Peso"
        };
        String[] unidades = {
                "metros",
                "kg"

        };
        Random rand = new Random();
        int sumaTotal = 0;

        // Generar matriz aleatoria y calcular suma
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = rand.nextInt(100); // números 0..99
                sumaTotal += matriz[i][j];       // sumar cada elemento
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

        // Imprimir suma total
        app.appendConsola("\nSuma de todos los números: " + sumaTotal + "\n");

        // Avanzar a la siguiente pregunta (si aplica)
        EjercicioUtils.avanzarPregunta(app);
    }
}
