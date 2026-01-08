package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio10 {

    private static double[] calificaciones;
    private static boolean faseCalificaciones = false; // indica si estamos introduciendo calificaciones

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 8 - Sistema de calificaciones con arrays");

        app.setPreguntas(new String[]{
                "Introduce el número de alumnos"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Fase de número de alumnos
        if (!faseCalificaciones) {
            int numAlumnos;
            try {
                numAlumnos = Integer.parseInt(texto);
                if (numAlumnos <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Por favor, introduce un número válido de alumnos.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }

            // Crear array de calificaciones
            calificaciones = new double[numAlumnos];

            // Generar preguntas dinámicas
            String[] preguntasAlumnos = new String[numAlumnos];
            for (int i = 0; i < numAlumnos; i++) {
                preguntasAlumnos[i] = "Introduce la calificación del alumno " + (i + 1);
            }

            app.setPreguntas(preguntasAlumnos);
            EjercicioUtils.inicializarEntrada(app);

            faseCalificaciones = true; // pasamos a fase de calificaciones
            app.appendConsola("Array creado para " + numAlumnos + " alumnos. Ahora introduce las calificaciones.\n");
        }
        // Fase de calificaciones
        else {
            int alumnoIndex = app.getIndicePregunta();
            double calificacion;
            try {
                calificacion = Double.parseDouble(texto);
                if (calificacion < 0 || calificacion > 10) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Introduce un valor válido entre 0 y 10.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }

            calificaciones[alumnoIndex] = calificacion;

            EjercicioUtils.avanzarPregunta(app);

            // Si ya terminamos todas las calificaciones
            if (app.getIndicePregunta() >= calificaciones.length) {
                double suma = 0;
                double max = calificaciones[0];
                double min = calificaciones[0];
                int aprobados = 0;

                for (double c : calificaciones) {
                    suma += c;
                    if (c > max) max = c;
                    if (c < min) min = c;
                    if (c >= 5) aprobados++;
                }

                double promedio = suma / calificaciones.length;

                // Mostrar resultados
                app.appendConsola("\nResultados:\n");
                app.appendConsola("Calificaciones: ");
                for (int i = 0; i < calificaciones.length; i++) {
                    app.appendConsola(String.format("%.2f%s", calificaciones[i], i < calificaciones.length - 1 ? ", " : "\n"));
                }
                app.appendConsola("Promedio: " + String.format("%.2f", promedio) + "\n");
                app.appendConsola("Número de aprobados: " + aprobados + "\n");
                app.appendConsola("Calificación más alta: " + String.format("%.2f", max) + "\n");
                app.appendConsola("Calificación más baja: " + String.format("%.2f", min) + "\n");

                faseCalificaciones = false; // Reiniciar para un posible nuevo ejercicio
            }
        }
    }
}
