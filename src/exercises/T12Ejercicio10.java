package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T12Ejercicio10 {

    private static String jugador1;
    private static String jugador2;
    private static int puntosJugador1;
    private static int puntosJugador2;
    private static int turnoActual;
    private static Random random = new Random();

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 12 – Juego de dardos");
        app.setPreguntas(new String[]{
                "Ingresa el nombre del Jugador 1:",
                "Ingresa el nombre del Jugador 2:"
        });

        EjercicioUtils.inicializarEntrada(app);
        app.limpiarConsola();
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        EjercicioUtils.avanzarPregunta(app);

        if (indice == 0) {
            jugador1 = texto.trim();
            app.appendConsola("Jugador 1 registrado: " + jugador1 + "\n");
        }

        if (indice == 1) {
            jugador2 = texto.trim();
            app.appendConsola("Jugador 2 registrado: " + jugador2 + "\n\n");

            // Inicializar puntos y turno
            puntosJugador1 = 301;
            puntosJugador2 = 301;
            turnoActual = 1;

            jugarTurnos(app);
        }
    }

    private static void jugarTurnos(App app) {
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            app.appendConsola("=== Turno " + turnoActual + " ===\n");

            // Turno jugador 1
            int puntuacionTurno1 = lanzarDardos(app, jugador1);
            if (puntosJugador1 - puntuacionTurno1 >= 0) {
                puntosJugador1 -= puntuacionTurno1;
            } else {
                app.appendConsola(jugador1 + " se pasa, puntos no cambian.\n");
            }

            if (puntosJugador1 == 0) {
                app.appendConsola("\n🎯 ¡" + jugador1 + " ha ganado la partida en " + turnoActual + " turnos!\n");
                break;
            }

            // Turno jugador 2
            int puntuacionTurno2 = lanzarDardos(app, jugador2);
            if (puntosJugador2 - puntuacionTurno2 >= 0) {
                puntosJugador2 -= puntuacionTurno2;
            } else {
                app.appendConsola(jugador2 + " se pasa, puntos no cambian.\n");
            }

            if (puntosJugador2 == 0) {
                app.appendConsola("\n🎯 ¡" + jugador2 + " ha ganado la partida en " + turnoActual + " turnos!\n");
                break;
            }

            // Mostrar puntuaciones y quién va ganando
            app.appendConsola("Puntos actuales: " + jugador1 + " -> " + puntosJugador1 +
                    " | " + jugador2 + " -> " + puntosJugador2 + "\n");
            app.appendConsola("Va ganando: " + (puntosJugador1 < puntosJugador2 ? jugador1 : jugador2) + "\n\n");

            turnoActual++;
        }

        // Reset del input para permitir reiniciar el juego si se desea
        EjercicioUtils.limpiarRespuestaYFoco(app);
        EjercicioUtils.inicializarEntrada(app);
    }

    private static int lanzarDardos(App app, String jugador) {
        int totalTurno = 0;
        app.appendConsola(jugador + " lanza sus 3 dardos: ");
        for (int i = 0; i < 3; i++) {
            int dardo = random.nextInt(61); // 0 a 60
            totalTurno += dardo;
            app.appendConsola(dardo + (i < 2 ? ", " : ""));
        }
        app.appendConsola(" | Total turno: " + totalTurno + "\n");
        return totalTurno;
    }
}
