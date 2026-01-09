package exercises;

import main.App;
import java.util.Random;
import utils.EjercicioUtils;

public class T12Ejercicio4 {

    private static int[] array = new int[10];
    private static boolean menuIniciado = false;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 12 – Operaciones con array");

        // Generar array aleatorio de 10 posiciones entre 1 y 20
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20) + 1;
        }

        // Primer mensaje para iniciar menú
        app.setPreguntas(new String[]{"Selecciona una opción del menú:" +
                " 1. Imprimir array " +
                " 2. Mover a izquierda " +
                " 3. Mover a derecha " +
                " 4. Invertir " +
                " 5. Salir"});
        EjercicioUtils.inicializarEntrada(app);
        menuIniciado = true;
    }

    public static void procesarRespuesta(App app, String texto) {
        if (!menuIniciado) return;

        int opcion;
        try {
            opcion = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            reiniciarMenu(app);
            return;
        }

        switch (opcion) {
            case 1 -> imprimirArray(app);
            case 2 -> moverIzquierda(app);
            case 3 -> moverDerecha(app);
            case 4 -> invertirArray(app);
            case 5 -> {
                app.appendConsola("Saliendo del menú.\n");
                menuIniciado = false;
                return;
            }
            default -> app.appendConsola("Opción no válida. Intenta de nuevo.\n");
        }

        // Volver a mostrar el menú después de cada acción
        reiniciarMenu(app);
    }

    private static void reiniciarMenu(App app) {
        app.setPreguntas(new String[]{"Selecciona una opción del menú:\n" +
                "1. Imprimir array\n" +
                "2. Mover a izquierda\n" +
                "3. Mover a derecha\n" +
                "4. Invertir\n" +
                "5. Salir"});
        EjercicioUtils.inicializarEntrada(app);
    }

    private static void imprimirArray(App app) {
        app.appendConsola("Array actual:\n");
        for (int num : array) {
            app.appendConsola(num + " ");
        }
        app.appendConsola("\n");
    }

    private static void moverIzquierda(App app) {
        int primero = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = primero;
        app.appendConsola("Array movido a la izquierda.\n");
    }

    private static void moverDerecha(App app) {
        int ultimo = array[array.length - 1];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = ultimo;
        app.appendConsola("Array movido a la derecha.\n");
    }

    private static void invertirArray(App app) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        app.appendConsola("Array invertido.\n");
    }
}
