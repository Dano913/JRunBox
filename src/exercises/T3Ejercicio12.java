package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio12 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 12 Tema 3 - Validador de contraseña");
        app.setPreguntas(new String[]{ "Introduce una contraseña" });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Validación de la contraseña
        if (texto.equals("12345678") || texto.equalsIgnoreCase("password")) {
            app.appendConsola("❌ No puedes usar esa contraseña.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        if (texto.length() < 8) {
            app.appendConsola("❌ La contraseña debe tener al menos 8 caracteres.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        if (!texto.matches(".*\\d.*")) {
            app.appendConsola("❌ La contraseña debe contener al menos un número.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar y mostrar respuesta automáticamente
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{ "Contraseña" }, new String[]{ "" });
        EjercicioUtils.avanzarPregunta(app);

        // Mostrar resultado final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.setInputPanelVisible(false);
            app.appendConsola("✅ Contraseña válida: " + texto + "\n");
        }
    }
}
