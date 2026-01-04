package exercises;
import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio2 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 1 – Puntuaciones modificadas");
        app.setPreguntas(new String[]{
                "Cuántos puntos ganas en la primera modificación?",
                "Cuántos puntos ganas en la segunda modificación?",
                "Cuántos puntos ganas en la tercera modificación?"
        });
        app.setPuntuacion(0);
        app.appendConsola("Puntuación inicial: 0\n");
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        try {
            int puntos = Integer.parseInt(texto);
            // Transforma la respuesta String a int para operar
            app.setPuntuacion(app.getPuntuacion() + puntos);
            // Suma la puntuación actual
            app.appendConsola("Después de modificación " + (indice + 1) + ": " + app.getPuntuacion() + "\n");
            // Muestra el resultado parcial en consola
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, ingresa un número válido.\n");
            // Salta el error si la respuesta no es un número
            return;
        }
        EjercicioUtils.avanzarPregunta(app);
        // Avanza a la siguiente pregunta o finaliza
        // Si se ha contestado la última pregunta, mostramos la puntuación final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("\n¡Puntuación final: " + app.getPuntuacion() + "!\n");
            // Muestra la puntuación final
        }
    }
}
