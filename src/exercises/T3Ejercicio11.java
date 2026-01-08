package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio11 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 11 Tema 3 - Sistema de descuentos por niveles");
        app.setPreguntas(new String[]{
                "Introduce el importe de la compra",
                "¿Eres socio?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] etiquetas = { "Importe", "Tarjeta de Socio" };
        String[] unidades = { "€", "" };

        // Guardar y mostrar respuesta
        if (indice == 0) {
            // Validación de número para el importe
            try {
                Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }

        if (indice == 1) {
            // Validación booleano para socio
            if (!texto.equalsIgnoreCase("true") && !texto.equalsIgnoreCase("false")) {
                app.appendConsola("❌ Error: ingresa 'true' o 'false'.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }

        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, calcular descuento
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularDescuento(app);
        }
    }

    private static void calcularDescuento(App app) {
        app.setInputPanelVisible(false);

        try {
            double importe = Double.parseDouble(app.getRespuestasTexto()[0]);
            boolean socio = Boolean.parseBoolean(app.getRespuestasTexto()[1]);
            double finalPrice;

            if (importe >= 200 && socio) {
                finalPrice = importe * 0.8;
                app.appendConsola("Tienes un descuento del 20%. El importe final es " + finalPrice + " €.\n");
            } else if (importe < 200 && socio) {
                finalPrice = importe * 0.9;
                app.appendConsola("Tienes un descuento del 10%. El importe final es " + finalPrice + " €.\n");
            } else if (!socio && importe > 300) {
                finalPrice = importe * 0.95;
                app.appendConsola("Tienes un descuento del 5%. El importe final es " + finalPrice + " €.\n");
            } else {
                finalPrice = importe;
                app.appendConsola("No tienes ningún descuento. El importe final es " + finalPrice + " €.\n");
            }
        } catch (NumberFormatException e) {
            app.appendConsola("Error inesperado: el valor del importe no es válido.\n");
        }
    }
}
