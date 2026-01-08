package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio13 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 13 Tema 3 - Precio de entrada por edad");
        app.setPreguntas(new String[]{ "Introduce tu edad", "¿Qué día de la semana es hoy?" });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validación de edad en la primera pregunta
        if (indice == 0) {
            try {
                Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido para la edad.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }

        // Guardar y mostrar respuesta automáticamente
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{ "Edad", "Día de la semana" }, new String[]{ "años", "" });
        EjercicioUtils.avanzarPregunta(app);

        // Calcular precio final si se han respondido todas las preguntas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            try {
                int edad = Integer.parseInt(app.getRespuestasTexto()[0]);
                String dia = app.getRespuestasTexto()[1].toLowerCase();
                app.setInputPanelVisible(false);

                if (edad < 12) {
                    app.appendConsola("La entrada es gratis para los menores de 12 años.\n");
                } else if (edad <= 17 && dia.equals("martes")) {
                    app.appendConsola("La entrada hoy día martes para los niños de 12 a 17 años es gratis.\n");
                } else if (edad <= 17) {
                    app.appendConsola("La entrada cuesta 5€ para los niños de 12 a 17 años.\n");
                } else if (edad < 68 && dia.equals("jueves")) {
                    app.appendConsola("La entrada hoy día jueves cuesta 7€ para los adultos hasta los 64 años.\n");
                } else if (edad < 68) {
                    app.appendConsola("La entrada cuesta 10€ para los adultos hasta los 64 años.\n");
                } else {
                    app.appendConsola("La entrada cuesta 6€ para los adultos de más de 64 años.\n");
                }

            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error inesperado: la edad no es válida.\n");
            }
        }
    }
}
