package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 3 - Mayoría de edad");
        app.setPreguntas(new String[]{
                "Introduce tu edad"
        });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Edad" };

        int edad;

        // Validar que el valor sea un número
        try {
            edad = Integer.parseInt(texto);
            if (edad < 0) {
                app.appendConsola("❌ Error: la edad no puede ser negativa.\n");
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

        // Guardar respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, String.valueOf(edad), etiquetas, null);

        // Avanzar a la siguiente pregunta (aunque aquí solo hay una)
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, evaluar mayoría de edad
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarMayoridad(app, edad);
        }
    }

    // Método separado para evaluar la mayoría de edad
    private static void evaluarMayoridad(App app, int edad) {
        int edadLegal = 18;
        boolean mayoria = edad >= edadLegal;

        app.setInputPanelVisible(false);

        if (mayoria) {
            app.appendConsola("Tienes " + edad + ". Aunque no sirva para nada, puedes votar.\n");
        } else {
            app.appendConsola("Tienes " + edad + ". No puedes votar, pero no te preocupes, no tiene ninguna utilidad.\n");
        }
    }
}
