package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio4 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 3 - Compra con descuento");
        app.setPreguntas(new String[]{
                "Introduce el importe de la compra",
                "Introduce el descuento aplicado"
        });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Importe", "Descuento" };
        String[] unidades = { "€", "%" };
        double valor;

        // Validar que el usuario introduce un número
        try {
            valor = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, String.valueOf(valor), etiquetas, unidades);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, calcular precio final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularPrecioFinal(app);
        }
    }

    private static void calcularPrecioFinal(App app) {
        app.setInputPanelVisible(false);
        try {
            double importe = Double.parseDouble(app.getRespuestasTexto()[0]);
            double descuento = Double.parseDouble(app.getRespuestasTexto()[1]);
            double finalPrice = importe - importe * (descuento / 100);

            app.appendConsola(String.format("El importe final es: %.2f €.\n", finalPrice));
        } catch (NumberFormatException e) {
            app.appendConsola("Error inesperado: uno de los valores no es válido.\n");
        }
    }
}
