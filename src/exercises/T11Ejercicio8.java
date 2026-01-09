package exercises;

import main.App;

public class T11Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 11 – Validador de edades");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        int[] edades = {25, -5, 34, 150, 0, 45, 120, 200, 17};

        app.appendConsola("Edades introducidas:\n");
        for (int edad : edades) {
            app.appendConsola(edad + " ");
        }

        app.appendConsola("\n\nEdades válidas:\n");
        mostrarEdadesValidas(app, edades);

        int contador = contarEdadesValidas(edades);
        app.appendConsola("\nCantidad de edades válidas: " + contador + "\n");
    }

    private static int contarEdadesValidas(int[] edades) {
        int contador = 0;

        for (int edad : edades) {
            if (edad < 0 || edad > 120) {
                continue; // Ignora edades inválidas
            }
            contador++;
        }

        return contador;
    }

    private static void mostrarEdadesValidas(App app, int[] edades) {
        for (int edad : edades) {
            if (edad < 0 || edad > 120) {
                continue; // Ignora edades inválidas
            }
            app.appendConsola(edad + " ");
        }
        app.appendConsola("\n");
    }
}
