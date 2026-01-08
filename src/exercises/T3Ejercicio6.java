package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio6 {

    private static final String[] ETIQUETAS = { "Edad" };

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 3 - Acceso a contenido");
        app.setPreguntas(new String[]{
                "Introduce tu edad"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Guardar y mostrar la respuesta usando utils
        EjercicioUtils.procesarRespuesta(app, texto, ETIQUETAS, null);

        // No hay más preguntas → finalizar ejercicio
        app.setInputPanelVisible(false);

        try {
            int edad = Integer.parseInt(texto);
            int edadMin = 16;

            if (edad >= edadMin) {
                app.appendConsola("Acceso concedido\n");
            } else {
                app.appendConsola("Acceso denegado. Debes tener al menos 16 años\n");
            }

        } catch (NumberFormatException e) {
            app.appendConsola("Error: la edad introducida no es un número válido.\n");
        }

        // Limpiar input y devolver foco (por coherencia)
        EjercicioUtils.limpiarRespuestaYFoco(app);
    }
}
