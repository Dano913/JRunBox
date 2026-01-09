package exercises;

import main.App;
import utils.EjercicioUtils;

public class T12Ejercicio6 {

    private static final int TOTAL_EQUIPOS = 5;
    private static String[] bombo1 = new String[TOTAL_EQUIPOS];
    private static String[] bombo2 = new String[TOTAL_EQUIPOS];
    private static int indiceBombo = 0; // Controla qué bombo estamos rellenando
    private static int indiceEquipo = 0; // Controla el índice dentro del bombo

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 12 – Sorteo Mundial");

        // Inicializar primera pregunta
        app.setPreguntas(new String[]{"Introduce el nombre del equipo 1 del Bombo 1:"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        texto = texto.trim();

        if (texto.isEmpty()) {
            app.appendConsola("El nombre del equipo no puede estar vacío. Inténtalo de nuevo.\n");
            reiniciarPregunta(app);
            return;
        }

        // Validar que no exista ya en el mismo bombo
        if (indiceBombo == 0 && existeEnBombo(bombo1, texto, indiceEquipo)) {
            app.appendConsola("Este equipo ya está en el Bombo 1. Introduce otro.\n");
            reiniciarPregunta(app);
            return;
        }
        if (indiceBombo == 1 && existeEnBombo(bombo2, texto, indiceEquipo)) {
            app.appendConsola("Este equipo ya está en el Bombo 2. Introduce otro.\n");
            reiniciarPregunta(app);
            return;
        }

        // Guardar equipo
        if (indiceBombo == 0) {
            bombo1[indiceEquipo] = texto;
        } else {
            bombo2[indiceEquipo] = texto;
        }

        indiceEquipo++;

        // Pasar al siguiente equipo o cambiar de bombo
        if (indiceEquipo < TOTAL_EQUIPOS) {
            String siguientePregunta = "Introduce el nombre del equipo " + (indiceEquipo + 1) + " del Bombo " + (indiceBombo + 1) + ":";
            app.setPreguntas(new String[]{siguientePregunta});
            EjercicioUtils.inicializarEntrada(app);
        } else {
            if (indiceBombo == 0) {
                // Pasamos al Bombo 2
                indiceBombo = 1;
                indiceEquipo = 0;
                app.setPreguntas(new String[]{"Introduce el nombre del equipo 1 del Bombo 2:"});
                EjercicioUtils.inicializarEntrada(app);
            } else {
                // Ambos bombos completados
                mostrarEmparejamientos(app);
            }
        }
    }

    private static void reiniciarPregunta(App app) {
        String pregunta = "Introduce el nombre del equipo " + (indiceEquipo + 1) + " del Bombo " + (indiceBombo + 1) + ":";
        app.setPreguntas(new String[]{pregunta});
        EjercicioUtils.inicializarEntrada(app);
    }

    private static boolean existeEnBombo(String[] bombo, String equipo, int hastaIndice) {
        for (int i = 0; i < hastaIndice; i++) {
            if (bombo[i].equalsIgnoreCase(equipo)) return true;
        }
        return false;
    }

    private static void mostrarEmparejamientos(App app) {
        app.appendConsola("\n--- EMPAREJAMIENTOS DEL SORTEO ---\n");
        for (int i = 0; i < TOTAL_EQUIPOS; i++) {
            app.appendConsola(bombo1[i] + " vs " + bombo2[i] + "\n");
        }
    }
}
