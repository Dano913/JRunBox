package exercises;

import main.App;
import utils.EjercicioUtils;

import java.time.LocalTime;

public class T7Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 - Sistema de niveles de juego");
        // Solo se mostrará esta vez
        app.setPreguntas(new String[]{
                "Introduce tu puntuación"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Puntuación"
        };
        String[] unidades = {
                "puntos"
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            int puntuacion = Integer.parseInt(respuestas[0]);
            String nivel;
            int grupo;
            if (puntuacion >= 0 && puntuacion <= 100) grupo = 1;
            else if (puntuacion <= 500) grupo = 2;
            else if (puntuacion <= 1000) grupo = 3;
            else if (puntuacion <= 5000) grupo = 4;
            else if (puntuacion > 5000) grupo = 5;
            else grupo = 0; // puntuación inválida

            switch (grupo) {
                case 1 -> nivel = "Principiante";
                case 2 -> nivel = "Intermedio";
                case 3 -> nivel = "Avanzado";
                case 4 -> nivel = "Experto";
                case 5 -> nivel = "Maestro";
                default -> nivel = "No has introducido puntuación válida";
            }

            app.appendConsola(String.format("Tu puntuación es de %d puntos, por tanto eres nivel %s", puntuacion, nivel));
        }
    }
}