package exercises;

import main.App;
import utils.EjercicioUtils;
import java.time.LocalTime;

public class T7Ejercicio6 {

    public static int obtenerHoraActual() {
        return LocalTime.now().getHour();
    }
    public static int obtenerMinutoActual() {
        return LocalTime.now().getMinute();
    }

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 7 - Generador de Mensajes de Saludo");
        // Solo se mostrará esta vez
        app.setPreguntas(new String[]{
                "¡Hola! (Pulsa Enter para continuar)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            int hora = obtenerHoraActual();
            int minuto = obtenerMinutoActual();
            String saludo;

            switch (hora) {
                case 0, 1, 2, 3, 4, 5 -> saludo = "¡Es de madrugada! Hora de descansar 😴";
                case 6, 7, 8, 9, 10, 11 -> saludo = "¡Buenos días! ☀️";
                case 12, 13, 14, 15, 16, 17, 18, 19 -> saludo = "¡Buenas tardes! 🌤️";
                default -> saludo = "¡Buenas noches! 🌙";
            }

            app.appendConsola(String.format("Son las %02d:%02d - %s", hora, minuto, saludo));
        }
    }
}