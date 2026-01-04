package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio14 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 14 Tema 3 - Candidato a préstamo");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "Introduce tus ingresos mensuales",
                "¿Tienes deudas?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validaciones según tipo de dato
        if (indice == 0 || indice == 1) { // edad o ingresos
            try {
                Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        } else if (indice == 2) { // deudas
            if (!texto.equalsIgnoreCase("true") && !texto.equalsIgnoreCase("false")) {
                app.appendConsola("❌ Error: ingresa 'true' o 'false'.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto,
                new String[]{"Edad", "Ingresos mensuales", "Deudas"},
                new String[]{"años", "€", ""});

        EjercicioUtils.avanzarPregunta(app);

        // Evaluar préstamo si ya se respondieron todas las preguntas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            try {
                int edad = Integer.parseInt(app.getRespuestasTexto()[0]);
                int ingreso = Integer.parseInt(app.getRespuestasTexto()[1]);
                boolean deuda = Boolean.parseBoolean(app.getRespuestasTexto()[2]);
                app.setInputPanelVisible(false);

                if (edad < 21 || edad > 65) {
                    app.appendConsola("No tienes edad para solicitar un préstamo.\n");
                } else if (ingreso < 1000) {
                    app.appendConsola("No tienes ingresos suficientes para solicitar un préstamo.\n");
                } else if (deuda) {
                    app.appendConsola("No puedes solicitar un préstamo debido a tus deudas.\n");
                } else {
                    app.appendConsola("¡Enhorabuena! Puedes solicitar tu préstamo.\n");
                }

            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error inesperado: valores no válidos.\n");
            }
        }
    }
}
