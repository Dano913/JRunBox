package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio15 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 15 Tema 3 - Sistema de envío");
        app.setPreguntas(new String[]{
                "Introduce el peso del paquete(kg)",
                "Introduce la distancia del envío(km)",
                "¿Es envío urgente?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validaciones
        if (indice == 0 || indice == 1) { // peso o distancia
            try {
                Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        } else if (indice == 2) { // urgente
            if (!texto.equalsIgnoreCase("true") && !texto.equalsIgnoreCase("false")) {
                app.appendConsola("❌ Error: ingresa 'true' o 'false'.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto,
                new String[]{"Peso", "Distancia", "Urgente"},
                new String[]{"kg", "km", ""});

        EjercicioUtils.avanzarPregunta(app);

        // Calcular coste si ya se respondieron todas las preguntas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            try {
                double peso = Double.parseDouble(app.getRespuestasTexto()[0]);
                double distancia = Double.parseDouble(app.getRespuestasTexto()[1]);
                boolean urgente = Boolean.parseBoolean(app.getRespuestasTexto()[2]);

                double costeEnvio = 5; // precio base
                double pesoExceso = Math.max(0, peso - 5);
                double distanciaExceso = Math.max(0, distancia - 100);

                costeEnvio += pesoExceso * 2;
                if (distanciaExceso > 0) costeEnvio += 10;
                if (urgente) costeEnvio *= 1.5;

                app.appendConsola("El coste total del envío es " + costeEnvio + " €.\n");

            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error inesperado: valores no válidos.\n");
            }
        }
    }
}
