package exercises;

import main.App;

public class T11Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 11 – Secuencia de Fibonacci");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        app.appendConsola("--- Fibonacci hasta 100 ---\n");
        generarFibonacci(app, 100);

        app.appendConsola("\n--- Fibonacci hasta 1000 ---\n");
        generarFibonacci(app, 1000);

        app.appendConsola("\n--- Fibonacci hasta 10000 ---\n");
        generarFibonacci(app, 10000);
    }

    private static void generarFibonacci(App app, int limite) {

        int a = 0;
        int b = 1;

        app.appendConsola(a + " ");
        app.appendConsola(b + " ");

        while (true) {
            int siguiente = a + b;

            if (siguiente > limite) {
                break;
            }

            app.appendConsola(siguiente + " ");

            a = b;
            b = siguiente;
        }

        app.appendConsola("\n");
    }
}
