package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 3 - Comparación de números");
        app.setPreguntas(new String[]{
                "Introduce el primer número",
                "Introduce el segundo número"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Primer número", "Segundo número" };
        double numero;

        // Validar que sea un número válido
        try {
            numero = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar la respuesta
        EjercicioUtils.procesarRespuesta(app, String.valueOf(numero), etiquetas, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, realizar comparación
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            compararNumeros(app);
        }
    }

    private static void compararNumeros(App app) {
        app.setInputPanelVisible(false);
        String[] respuestas = app.getRespuestasTexto();

        double num1 = Double.parseDouble(respuestas[0]);
        double num2 = Double.parseDouble(respuestas[1]);
        String resultado;

        if (num1 > num2) {
            resultado = num1 + " es mayor que " + num2;
        } else if (num1 < num2) {
            resultado = num1 + " es menor que " + num2;
        } else {
            resultado = num1 + " es igual a " + num2;
        }

        app.appendConsola(resultado + "\n");
    }
}
