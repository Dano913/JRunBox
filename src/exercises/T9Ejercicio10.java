package exercises;

import main.App;
import utils.EjercicioUtils;

public class T9Ejercicio10 {

    private static double[][] notas;
    private static int numEstudiantes;
    private static int numAsignaturas;

    private static int estudianteActual = 0;
    private static int asignaturaActual = 0;

    private static boolean etiquetasMostradas = false;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 9 - Sistema de notas de una clase");
        app.setPreguntas(new String[]{
                "¿Cuántos estudiantes hay?",
                "¿Cuántas asignaturas hay?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Mantener estas líneas literal dentro del metodo
        String[] etiquetas = { "Estudiantes", "Asignaturas" };
        String[] unidades = { "", "" };

        if (numEstudiantes == 0) {
            numEstudiantes = Integer.parseInt(texto);
            EjercicioUtils.avanzarPregunta(app);

        } else if (numAsignaturas == 0) {
            numAsignaturas = Integer.parseInt(texto);
            notas = new double[numEstudiantes][numAsignaturas];

            if (!etiquetasMostradas) {
                app.appendConsola(etiquetas[0] + ": " + numEstudiantes + unidades[0] + "\n");
                app.appendConsola(etiquetas[1] + ": " + numAsignaturas + unidades[1] + "\n");
                etiquetasMostradas = true;
            }

            estudianteActual = 0;
            asignaturaActual = 0;
            app.setPreguntas(new String[]{generarPreguntaNota(estudianteActual, asignaturaActual)});
            EjercicioUtils.inicializarEntrada(app);

        } else {
            notas[estudianteActual][asignaturaActual] = Double.parseDouble(texto);

            app.appendConsola("La nota " + (asignaturaActual + 1) +
                    " del estudiante " + (estudianteActual + 1) +
                    " es: (" + notas[estudianteActual][asignaturaActual] + ")\n");
            app.limpiarRespuestaField();

            asignaturaActual++;
            if (asignaturaActual >= numAsignaturas) {
                asignaturaActual = 0;
                estudianteActual++;
            }

            if (estudianteActual < numEstudiantes) {
                app.setPreguntas(new String[]{generarPreguntaNota(estudianteActual, asignaturaActual)});
                EjercicioUtils.inicializarEntrada(app);
            } else {
                // Ejercicio terminado, mostrar resumen completo
                mostrarResumen(app);
            }
        }
    }

    private static String generarPreguntaNota(int estudiante, int asignatura) {
        return "Introduce la nota del estudiante " + (estudiante + 1) +
                " en la asignatura " + (asignatura + 1) + ":";
    }

    private static void mostrarResumen(App app) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- TABLA DE NOTAS ---\n");

        // Cabecera de asignaturas
        sb.append("       ");
        for (int j = 0; j < numAsignaturas; j++) {
            sb.append("Asig").append(j + 1).append("  ");
        }
        sb.append("\n");

        // Filas de estudiantes
        for (int i = 0; i < numEstudiantes; i++) {
            sb.append("Est ").append(i + 1).append(": ");
            for (int j = 0; j < numAsignaturas; j++) {
                sb.append(String.format("%5.1f", notas[i][j])).append("  ");
            }
            sb.append("\n");
        }

        // Promedios por estudiante
        sb.append("\n--- PROMEDIOS POR ESTUDIANTE ---\n");
        for (int i = 0; i < numEstudiantes; i++) {
            double suma = 0;
            for (int j = 0; j < numAsignaturas; j++) {
                suma += notas[i][j];
            }
            double promedio = suma / numAsignaturas;
            sb.append("Estudiante ").append(i + 1).append(": ")
                    .append(String.format("%.2f", promedio)).append("\n");
        }

        // Promedios por asignatura
        sb.append("\n--- PROMEDIOS POR ASIGNATURA ---\n");
        for (int j = 0; j < numAsignaturas; j++) {
            double suma = 0;
            for (int i = 0; i < numEstudiantes; i++) {
                suma += notas[i][j];
            }
            double promedio = suma / numEstudiantes;
            sb.append("Asignatura ").append(j + 1).append(": ")
                    .append(String.format("%.2f", promedio)).append("\n");
        }

        // Nota más alta
        double maxNota = -1;
        int estMax = -1, asigMax = -1;
        for (int i = 0; i < numEstudiantes; i++) {
            for (int j = 0; j < numAsignaturas; j++) {
                if (notas[i][j] > maxNota) {
                    maxNota = notas[i][j];
                    estMax = i;
                    asigMax = j;
                }
            }
        }
        sb.append("\n--- NOTA MÁS ALTA ---\n");
        sb.append("La nota más alta es ").append(maxNota)
                .append(" (Estudiante ").append(estMax + 1)
                .append(", Asignatura ").append(asigMax + 1).append(")\n");

        app.appendConsola(sb.toString());
    }
}
