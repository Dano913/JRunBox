package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio4 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 4 - Menú de opciones");
        app.setPreguntas(new String[]{
                "Elige una opción:\n--- MENÚ ---\n1. Ver perfil\n2. Configuración\n3. Ayuda\n4. Salir"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        try {
            int opcion = Integer.parseInt(texto);
            if (opcion < 1 || opcion > 4) {
                app.appendConsola("❌ Error: opción inválida (1-4).\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Opción elegida"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            int opcion = Integer.parseInt(app.getRespuestasTexto()[0]);
            String mensaje = switch (opcion) {
                case 1 -> "Ver perfil";
                case 2 -> "Configuración";
                case 3 -> "Ayuda";
                case 4 -> "Salir";
                default -> "Opción no disponible"; // Esto nunca debería pasar
            };
            app.appendConsola("Has seleccionado: " + mensaje + "\n");
        }
    }
}
