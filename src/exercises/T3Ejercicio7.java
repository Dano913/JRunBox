package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 3 - Calificación con letra");
        app.setPreguntas(new String[]{ "Introduce tu nota" });

        // Inicializa el panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Nota" };
        double nota;

        // Validar que sea un número válido
        try {
            nota = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Validar que la nota esté entre 1 y 10
        if (nota < 1 || nota > 10) {
            app.appendConsola("❌ Error: la nota debe estar entre 1 y 10.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar y mostrar la respuesta
        EjercicioUtils.procesarRespuesta(app, String.valueOf(nota), etiquetas, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, evaluar calificación
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            mostrarCalificacion(app, nota);
        }
    }

    private static void mostrarCalificacion(App app, double nota) {
        app.setInputPanelVisible(false);
        String calificacion;

        if (nota < 5) {
            calificacion = "Suspenso";
        } else if (nota < 7) {
            calificacion = "Aprobado";
        } else if (nota < 9) {
            calificacion = "Notable";
        } else {
            calificacion = "Sobresaliente";
        }

        app.appendConsola("Tu calificación es: " + calificacion + "\n");
    }
}
