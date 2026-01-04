package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 4 - Día de la semana");
        app.setPreguntas(new String[]{"Introduce un número del 1 al 7"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validación del número entre 1 y 7
        try {
            int num = Integer.parseInt(texto);
            if (num < 1 || num > 7) {
                app.appendConsola("❌ Error: ingresa un número entre 1 y 7.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{});
        EjercicioUtils.avanzarPregunta(app);

        // Mostrar el día correspondiente
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            int num = Integer.parseInt(app.getRespuestasTexto()[0]);
            String dia = switch (num) {
                case 1 -> "Lunes";
                case 2 -> "Martes";
                case 3 -> "Miércoles";
                case 4 -> "Jueves";
                case 5 -> "Viernes";
                case 6 -> "Sábado";
                case 7 -> "Domingo";
                default -> "Número inválido";
            };
            app.appendConsola(String.format("El día %d es: %s\n", num, dia));
        }
    }
}
