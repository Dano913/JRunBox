package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio9 {

    private static int cantidadEstudiantes = 0;
    private static int contador = 0;

    public static void iniciarEjercicio(App app) {
        cantidadEstudiantes = 0;
        contador = 0;
        app.setTituloEjercicio("Ejercicio 9 Tema 5 - Sistema de notas");
        app.setPreguntas(new String[]{"¿Cuántos estudiantes hay en la clase?"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        if (cantidadEstudiantes == 0) {
            try {
                cantidadEstudiantes = Integer.parseInt(texto);
                if (cantidadEstudiantes <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Introduce un número válido mayor que 0.\n");
                EjercicioUtils.inicializarEntrada(app);
                return;
            }
            app.setRespuestasTexto(new String[cantidadEstudiantes]);
            contador = 0;
            app.setPreguntaLabel("Introduce la nota del estudiante 1 (0-10):");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        do {
            int nota;
            try {
                nota = Integer.parseInt(texto);
                if (nota < 0 || nota > 10) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Introduce una nota válida entre 0 y 10.\n");
                app.setPreguntaLabel("Introduce la nota del estudiante " + (contador + 1) + " (0-10):");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
            app.getRespuestasTexto()[contador] = texto;
            contador++;
            app.appendConsola("Nota del estudiante " + contador + ": " + texto + "\n");

            // Si quedan más estudiantes, se sale para esperar el siguiente input
            if (contador < cantidadEstudiantes) {
                app.setPreguntaLabel("Introduce la nota del estudiante " + (contador + 1) + " (0-10):");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        } while (contador < cantidadEstudiantes);
        app.appendConsola("\n--- REPORTE DE CALIFICACIONES ---\n");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            int nota = Integer.parseInt(app.getRespuestasTexto()[i]);
            String letra;
            switch (nota) {
                case 9, 10 -> letra = "A";
                case 7, 8 -> letra = "B";
                case 5, 6 -> letra = "C";
                case 3, 4 -> letra = "D";
                case 0, 1, 2 -> letra = "F";
                default -> letra = "Desconocida";
            }
            app.appendConsola("Estudiante " + (i + 1) + ": " + nota + " puntos = Calificación " + letra + "\n");
        }
        app.setInputPanelVisible(false);
    }
}
