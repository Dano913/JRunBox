package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 4 - Estaciones del año");
        app.setPreguntas(new String[]{
                "Introduce el número de mes (1-12)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Validar que sea un número de mes válido
        int mes;
        try {
            mes = Integer.parseInt(texto);
            if (mes < 1 || mes > 12) {
                app.appendConsola("❌ Error: el mes debe estar entre 1 y 12.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar y mostrar la respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número de mes"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        // Mostrar estación
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String estacion = switch (mes) {
                case 12, 1, 2 -> "Invierno";
                case 3, 4, 5 -> "Primavera";
                case 6, 7, 8 -> "Verano";
                case 9, 10, 11 -> "Otoño";
                default -> "No válido"; // nunca debería pasar
            };
            app.appendConsola("El mes " + mes + " corresponde a: " + estacion + "\n");
        }
    }
}