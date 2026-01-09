package exercises;

import main.App;

public class T11Ejercicio2 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 11 – Búsqueda en Array con break");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        int[] numeros = {4, 7, 2, 9, 5, 1};
        int objetivo = 9;

        int indice = buscarNumero(numeros, objetivo);

        app.appendConsola("Array: ");
        for (int n : numeros) {
            app.appendConsola(n + " ");
        }
        app.appendConsola("\n\n");

        if (indice != -1) {
            app.appendConsola(
                    "Número " + objetivo + " encontrado en el índice: " + indice + "\n"
            );
        } else {
            app.appendConsola(
                    "Número " + objetivo + " no encontrado en el array\n"
            );
        }
    }

    public static int buscarNumero(int[] numeros, int objetivo) {
        int indice = -1;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == objetivo) {
                indice = i;
                break; // salir del bucle al encontrarlo
            }
        }

        return indice;
    }
}
