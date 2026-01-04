package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 4 - Tabla de multiplicar con for");
        app.setPreguntas(new String[]{
                "Introduce un número"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Validar número
        int num;
        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar la respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        // Mostrar tabla de multiplicar
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("Tabla del " + num + ":\n");
            for (int i = 1; i <= 10; i++) {
                app.appendConsola(String.format("%d x %d = %d\n", num, i, num * i));
            }
        }
    }
}
