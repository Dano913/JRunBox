package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 2 - Operadores lógicos");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "¿Tienes carnet de conducir?"
        });

        // Inicializa el panel de entrada de forma genérica
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Edad", "Carnet de conducir" };

        // Guardar la respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, evaluar condiciones
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarCondiciones(app);
        }
    }

    private static void evaluarCondiciones(App app) {
        String[] respuestas = app.getRespuestasTexto();
        int edadMin = 21;

        try {
            // Parsear las respuestas
            int edad = Integer.parseInt(respuestas[0]);
            boolean carnet = Boolean.parseBoolean(respuestas[1]);

            boolean mayoria = edad >= edadMin;

            // Mensajes individuales
            app.appendConsola(mayoria ? "Eres mayor de edad.\n" : "No eres mayor de edad.\n");
            app.appendConsola(carnet ? "Tienes carnet de conducir.\n" : "No tienes carnet de conducir.\n");

            // Combinación de condiciones
            app.appendConsola((mayoria && carnet)
                    ? "Puedes conducir legalmente.\n"
                    : "No puedes conducir todavía.\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: la edad introducida no es un número válido.\n");
        }
    }
}
