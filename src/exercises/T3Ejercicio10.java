package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 3 - Entrada de parque de atracciones");
        app.setPreguntas(new String[]{
                "Introduce tu altura"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Altura" };
        String[] unidades = { "cm" };
        double altura;

        // Validación de número
        try {
            altura = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, String.valueOf(altura), etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, comprobar altura
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            comprobarAltura(app, altura);
        }
    }

    private static void comprobarAltura(App app, double altura) {
        app.setInputPanelVisible(false);

        double altMin = 120;
        double altMax = 200;

        if (altura < altMin) {
            app.appendConsola("No puedes subir a la atracción. Altura mínima " + altMin + " cm.\n");
        } else if (altura > altMax) {
            app.appendConsola("No puedes subir a la atracción. Altura máxima " + altMax + " cm.\n");
        } else {
            app.appendConsola("Puedes subir a la atracción.\n");
        }
    }
}
