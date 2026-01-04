package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 2 - Condiciones compuestas");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "¿Eres estudiante?"
        });

        // Inicializa entrada de manera genérica
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Edad", "Estudiante" };

        // Guardar respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan más preguntas, evaluar condiciones compuestas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarDescuentos(app);
        }
    }

    private static void evaluarDescuentos(App app) {
        String[] respuestas = app.getRespuestasTexto();
        int edadLimite = 26;

        try {
            int edad = Integer.parseInt(respuestas[0]);
            boolean estudiante = Boolean.parseBoolean(respuestas[1]);
            boolean joven = edad < edadLimite;

            if (joven && estudiante) {
                app.appendConsola("Tienes menos de " + edadLimite + " años y eres estudiante, por tanto optas al descuento especial.\n");
            } else if (joven) {
                app.appendConsola("Tienes menos de " + edadLimite + " años pero no eres estudiante, por tanto sólo optas al descuento joven.\n");
            } else if (estudiante) {
                app.appendConsola("Eres estudiante pero tienes " + edadLimite + " años o más, por tanto sólo optas al descuento estudiante.\n");
            } else {
                app.appendConsola("No eres estudiante y tienes " + edadLimite + " o más, por tanto no optas a ningún descuento.\n");
            }

        } catch (NumberFormatException e) {
            app.appendConsola("Error: la edad introducida no es un número válido.\n");
        }
    }
}
