package exercises;

import main.App;

public class T11Ejercicio4 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 11 – Promedio con validación");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        double[] notas = {8.5, 9.0, 12.0, -3.0, 7.5, 10.0, 15.0};

        app.appendConsola("Notas introducidas:\n");
        for (double nota : notas) {
            app.appendConsola(nota + " ");
        }

        app.appendConsola("\n\nCalculando promedio...\n");

        double promedio = calcularPromedio(app, notas);

        app.appendConsola("\nPromedio final: " + String.format("%.2f", promedio) + "\n");
    }

    private static double calcularPromedio(App app, double[] notas) {
        double suma = 0;
        int contador = 0;

        for (double nota : notas) {

            // Validación de nota
            if (nota < 0 || nota > 10) {
                app.appendConsola("Nota inválida ignorada: " + nota + "\n");
                continue;
            }

            suma += nota;
            contador++;
        }

        // Evitar división por cero
        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }
}
