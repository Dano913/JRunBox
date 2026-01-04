package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 3 - Par o impar");
        app.setPreguntas(new String[]{ "Introduce un número" });

        // Inicializa el panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Número" };
        int numero;

        // Validar que sea un número entero
        try {
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar la respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, String.valueOf(numero), etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si no quedan preguntas, calcular par o impar
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            evaluarParImpar(app, numero);
        }
    }

    private static void evaluarParImpar(App app, int numero) {
        app.setInputPanelVisible(false);
        String parImpar = (numero % 2 == 0) ? "par" : "impar";
        app.appendConsola("El número " + numero + " es " + parImpar + ".\n");
    }
}
