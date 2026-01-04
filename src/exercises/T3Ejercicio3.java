package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio3 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 3 - Aprobado o suspenso");
        app.setPreguntas(new String[]{ "Introduce una nota" });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Nota" };
        int nota;

        // Validar que sea un número entero entre 0 y 10
        try {
            nota = Integer.parseInt(texto);
            if (nota < 0 || nota > 10) {
                app.appendConsola("❌ Error: la nota debe estar entre 0 y 10.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, String.valueOf(nota), etiquetas, null);

        // Avanzar pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, evaluar aprobado o suspenso
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarAprobadoSuspenso(app, nota);
        }
    }

    private static void evaluarAprobadoSuspenso(App app, int nota) {
        app.setInputPanelVisible(false);

        if (nota >= 5) {
            app.appendConsola("Has sacado un " + nota + ". Has aprobado.\n");
        } else {
            app.appendConsola("Has sacado un " + nota + ". Has suspendido.\n");
        }
    }
}
