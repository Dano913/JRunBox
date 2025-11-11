package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio2 {
    private static final String TRUE_PASSWORD = "1234";
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 47 - Validación por contraseña con do-while simulado");
        app.setPreguntas(new String[]{"Introduce la contraseña"});
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Contraseña introducida"};
        String[] unidades = {""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        doWhile(app);
    }
    private static void doWhile(App app) {
        String passwrd = app.getRespuestasTexto()[0];
        boolean condicion = !passwrd.equals(TRUE_PASSWORD);
        do {
            app.appendConsola("Contraseña incorrecta. Inténtalo de nuevo.\n");
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } while (condicion);
        app.appendConsola("¡Contraseña correcta! Acceso concedido.\n");
        app.setInputPanelVisible(false);
    }
}
