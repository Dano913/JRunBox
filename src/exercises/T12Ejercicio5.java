package exercises;

import main.App;
import utils.EjercicioUtils;

public class T12Ejercicio5 {

    private static double[] notas = new double[10];
    private static int indiceNota = 0; // Para controlar cuántas notas se han ingresado

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 12 – Registro de notas de alumnos");

        // Primer mensaje para introducir la nota 1
        app.setPreguntas(new String[]{"Introduce la nota del alumno 1 (0 a 10):"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        double nota;

        try {
            nota = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("Entrada no válida. Introduce un número entre 0 y 10.\n");
            reiniciarPregunta(app);
            return;
        }

        if (nota < 0 || nota > 10) {
            app.appendConsola("La nota debe estar entre 0 y 10. Inténtalo de nuevo.\n");
            reiniciarPregunta(app);
            return;
        }

        // Guardar la nota válida
        notas[indiceNota] = nota;
        indiceNota++;

        // Si faltan notas, pedir la siguiente
        if (indiceNota < notas.length) {
            app.setPreguntas(new String[]{"Introduce la nota del alumno " + (indiceNota + 1) + " (0 a 10):"});
            EjercicioUtils.inicializarEntrada(app);
        } else {
            // Todas las notas ingresadas, calcular resultados
            mostrarResultados(app);
        }
    }

    private static void reiniciarPregunta(App app) {
        app.setPreguntas(new String[]{"Introduce la nota del alumno " + (indiceNota + 1) + " (0 a 10):"});
        EjercicioUtils.inicializarEntrada(app);
    }

    private static void mostrarResultados(App app) {
        double suma = 0;
        double max = notas[0];
        double min = notas[0];
        int aprobados = 0;
        int suspendidos = 0;

        for (double nota : notas) {
            suma += nota;
            if (nota > max) max = nota;
            if (nota < min) min = nota;
            if (nota >= 5) aprobados++;
            else suspendidos++;
        }

        double media = suma / notas.length;

        app.appendConsola("\n--- RESULTADOS DE LA CLASE ---\n");
        app.appendConsola(String.format("Nota media: %.2f\n", media));
        app.appendConsola(String.format("Nota más alta: %.2f\n", max));
        app.appendConsola(String.format("Nota más baja: %.2f\n", min));
        app.appendConsola("Alumnos aprobados: " + aprobados + "\n");
        app.appendConsola("Alumnos suspendidos: " + suspendidos + "\n");
    }
}
