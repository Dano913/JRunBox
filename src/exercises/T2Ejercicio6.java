package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 2 - Calculadora de descuento");
        app.setPreguntas(new String[]{
                "¿Cuánto cuesta el producto?",
                "¿Qué porcentaje de descuento tiene?"
        });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Precio del producto", "Descuento sobre el precio" };
        String[] unidades = { "€", "%" };

        // Guardar respuesta y mostrarla con unidad
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, calcular precio final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularDescuento(app);
        }
    }

    private static void calcularDescuento(App app) {
        String[] respuestas = app.getRespuestasTexto();

        try {
            double precioOriginal = Double.parseDouble(respuestas[0]);
            double descuento = Double.parseDouble(respuestas[1]);
            double precioFinal = precioOriginal - precioOriginal * (descuento / 100);

            app.appendConsola("El precio final con descuento es: " + precioFinal + " €.\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores no es un número válido.\n");
        }
    }
}
