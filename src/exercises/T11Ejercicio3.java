package exercises;

import main.App;

public class T11Ejercicio3 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 11 – Filtrado de números pares");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        int[] numeros = new int[20];

        // Rellenamos el array del 1 al 20
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }

        app.appendConsola("Números pares del 1 al 20:\n");

        mostrarPares(app, numeros);
    }

    private static void mostrarPares(App app, int[] numeros) {
        for (int numero : numeros) {

            // Si es impar, saltamos esta iteración
            if (numero % 2 != 0) {
                continue;
            }

            // Solo se ejecuta si es par
            app.appendConsola(numero + " ");
        }

        app.appendConsola("\n");
    }
}
