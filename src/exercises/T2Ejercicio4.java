package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio4 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 2 - Par o impar");
        app.setPreguntas(new String[]{
                "Introduce un número"
        });

        // Inicializa el panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Número" };

        // Guardar la respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, calcular par/impar
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularParImpar(app);
        }
    }

    private static void calcularParImpar(App app) {
        String[] respuestas = app.getRespuestasTexto();

        try {
            int num = Integer.parseInt(respuestas[0]);
            int resto = num % 2;
            String parImpar = (resto == 0) ? "par" : "impar";

            app.appendConsola("El número " + num + " es " + parImpar + " con resto: " + resto + ".\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: el valor introducido no es un número válido.\n");
        }
    }
}
