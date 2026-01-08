package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio2 {

    private static final String TRUE_PASSWORD = "1234";

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 5 - Validación por contraseña con do-while");
        app.setPreguntas(new String[]{"Introduce la contraseña"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        app.appendConsola("Contraseña introducida: " + texto + "\n");

        boolean correcta;

        do {
            correcta = texto.equals(TRUE_PASSWORD);

            if (!correcta) {
                app.appendConsola("❌ Contraseña incorrecta. Inténtalo de nuevo.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }

        } while (!correcta);

        app.appendConsola("✅ ¡Contraseña correcta! Acceso concedido.\n");
        app.setInputPanelVisible(false);
    }
}
