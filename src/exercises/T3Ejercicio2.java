package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio2 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 3 - Positivo o negativo");
        app.setPreguntas(new String[]{ "Introduce un número" });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Número" };
        int numero;

        // Validar que el usuario introduzca un número
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, String.valueOf(numero), etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, evaluar positivo o negativo
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarPositivoNegativo(app, numero);
        }
    }

    private static void evaluarPositivoNegativo(App app, int numero) {
        app.setInputPanelVisible(false);

        if (numero > 0) {
            app.appendConsola(numero + " es positivo.\n");
        } else if (numero < 0) {
            app.appendConsola(numero + " es negativo.\n");
        } else {
            app.appendConsola("El número es cero.\n");
        }
    }
}
