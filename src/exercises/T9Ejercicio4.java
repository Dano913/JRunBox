package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T9Ejercicio4 {

    private static final int[][] matriz = new int[3][5];
    private static boolean matrizGenerada = false;   // para generar la matriz solo una vez
    private static boolean matrizRevelada = false;   // para controlar cuándo mostrarla

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 - Buscar número en la matriz");
        app.setPreguntas(new String[]{
                "Introduce un número para comprobar si está en la matriz"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta del usuario
    public static void procesarRespuesta(App app, String texto) {
        // Generar la matriz la primera vez
        if (!matrizGenerada) {
            Random rand = new Random();
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = rand.nextInt(100); // números 0..99
                }
            }
            matrizGenerada = true;
        }

        // Comprobar si el usuario quiere salir
        if (texto.equalsIgnoreCase("salir")) {
            app.appendConsola("Has terminado el ejercicio.\n");
            return;
        }

        // Comprobar si el número ingresado está en la matriz
        try {
            int numero = Integer.parseInt(texto);
            boolean encontrado = false;
            int filaEncontrada = -1;
            int columnaEncontrada = -1;

            for (int i = 0; i < matriz.length && !encontrado; i++) {
                for (int j = 0; j < matriz[i].length && !encontrado; j++) {
                    if (matriz[i][j] == numero) {
                        encontrado = true;
                        filaEncontrada = i;
                        columnaEncontrada = j;
                    }
                }
            }

            if (encontrado) {
                app.appendConsola("¡Correcto! El " + numero + " está en la posición ["
                        + filaEncontrada + "][" + columnaEncontrada + "]\n");

                // Revelar la matriz la primera vez que aciertan un número
                if (!matrizRevelada) {
                    app.appendConsola("La matriz completa es:\n");
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            app.appendConsola(matriz[i][j] + " ");
                        }
                        app.appendConsola("\n");
                    }
                    matrizRevelada = true;
                }

            } else {
                app.appendConsola("Número "+numero+" no encontrado. Intenta de nuevo.\n");
            }

        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido o 'salir' para terminar.\n");
        }

        // Limpiar el input después de cada intento
        app.limpiarRespuestaField();
    }
}
