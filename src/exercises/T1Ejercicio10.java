package exercises;

import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 1 – Conversión de temperaturas");
        app.setPreguntas(new String[]{
                "Introduce la temperatura en °C:"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Guardar respuesta y mostrar etiqueta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{ "Temperatura en ºC" }, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si se completaron las respuestas, realizar conversión
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String entrada = app.getRespuestasTexto()[0].replace(",", ".");
            try {
                double C = Double.parseDouble(entrada);
                double F = C * 9 / 5 + 32;
                app.appendConsola("\n" + C + " °C equivalen a " + F + " °F\n");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: el valor ingresado no es un número válido.\n");
            }
        }
    }
}
