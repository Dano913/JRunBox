package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio2 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 4 - Calificación con Switch");
        app.setPreguntas(new String[]{"Introduce una letra de calificación (A, B, C, D, F)"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        char letra;

        // Validación de letra
        if (texto.length() != 1 || "ABCDF".indexOf(texto.toUpperCase()) == -1) {
            app.appendConsola("❌ Error: ingresa una letra válida (A, B, C, D, F).\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        } else {
            letra = texto.toUpperCase().charAt(0);
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto.toUpperCase(), new String[]{"Calificación"}, new String[]{});
        EjercicioUtils.avanzarPregunta(app);

        // Mostrar el significado de la calificación
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String descripcion = switch (letra) {
                case 'A' -> "Excelente";
                case 'B' -> "Muy bien";
                case 'C' -> "Bien";
                case 'D' -> "Suficiente";
                case 'F' -> "Insuficiente";
                default -> "Desconocida";
            };
            app.appendConsola(String.format("Calificación %s: %s\n", letra, descripcion));
        }
    }
}
