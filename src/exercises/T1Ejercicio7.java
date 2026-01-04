package exercises;
import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio7 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 1 – Presentación personal");
        app.setPreguntas(new String[]{
                "Ingresa tu nombre",
                "Ingresa tu apellido",
                "Ingresa tu edad",
                "Ingresa tu ciudad"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{
                "Nombre", "Apellido", "Edad", "Ciudad"
        }, null);
        int indice = app.getIndicePregunta();
        // Mostrar mensaje parcial según índice
        String[] respuestas = app.getRespuestasTexto();
        String mensaje = switch (indice) {
            case 0 -> !respuestas[0].isEmpty() ? "Mi nombre es " + respuestas[0] : "";
            case 1 -> !respuestas[1].isEmpty() ? "Mi apellido es " + respuestas[1] : "";
            case 2 -> !respuestas[2].isEmpty() ? "Tengo " + respuestas[2] + " años" : "";
            case 3 -> !respuestas[3].isEmpty() ? "Vivo en " + respuestas[3] : "";
            default -> "";
        };
        if (!mensaje.isEmpty()) app.appendConsola(mensaje + "\n");
        EjercicioUtils.avanzarPregunta(app);
        // Mensaje final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("\n¡Hola! Me llamo " +
                    respuestas[0] + " " + respuestas[1] +
                    ". Tengo " + respuestas[2] +
                    " años y vivo en " + respuestas[3] + ".\n");
        }
    }
}
