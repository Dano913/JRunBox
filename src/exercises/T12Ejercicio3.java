package exercises;

import main.App;
import java.util.Random;
import utils.EjercicioUtils;

public class T12Ejercicio3 {

    private static int filas;
    private static int columnas;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 12 – Suma de matrices");

        // Pedimos tamaño de la matriz
        app.setPreguntas(new String[]{
                "Introduce el número de filas",
                "Introduce el número de columnas"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Convertimos la respuesta a entero
        int valor = Integer.parseInt(texto);

        if (indice == 0) filas = valor;
        if (indice == 1) columnas = valor;

        EjercicioUtils.avanzarPregunta(app);

        // Cuando ya tenemos filas y columnas
        if (indice == 1) {
            mostrarResultado(app);
        }
    }

    private static void mostrarResultado(App app) {
        app.limpiarConsola();
        app.setPreguntaLabel("");

        app.appendConsola("Tamaño de las matrices: " + filas + " filas x " + columnas + " columnas\n\n");

        // Generar matrices aleatorias
        int[][] matriz1 = generarMatrizAleatoria(filas, columnas);
        int[][] matriz2 = generarMatrizAleatoria(filas, columnas);

        // Sumar matrices
        int[][] sumaMatrices = sumarMatrices(matriz1, matriz2);

        // Mostrar matrices
        app.appendConsola("--- MATRIZ 1 ---\n");
        imprimirMatriz(app, matriz1);

        app.appendConsola("\n--- MATRIZ 2 ---\n");
        imprimirMatriz(app, matriz2);

        app.appendConsola("\n--- SUMA DE MATRICES ---\n");
        imprimirMatriz(app, sumaMatrices);
    }

    private static int[][] generarMatrizAleatoria(int filas, int columnas) {
        Random random = new Random();
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(51); // números entre 0 y 50
            }
        }
        return matriz;
    }

    private static int[][] sumarMatrices(int[][] m1, int[][] m2) {
        int[][] suma = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                suma[i][j] = m1[i][j] + m2[i][j];
            }
        }
        return suma;
    }

    private static void imprimirMatriz(App app, int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                app.appendConsola(String.format("%4d", matriz[i][j]));
            }
            app.appendConsola("\n");
        }
    }
}
