package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio3 {

    private static int suma = 0;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 5 - Suma de números positivos");
        app.setPreguntas(new String[]{
                "Introduce un número positivo (0 o negativo para terminar)"
        });
        suma = 0;
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        app.appendConsola("Número introducido: " + texto + "\n");

        int num;

        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Por favor, introduce un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        boolean continuar;

        do {
            continuar = num > 0;

            if (continuar) {
                suma += num;
                app.appendConsola("Suma actual: " + suma + "\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return; // ⬅️ simula la repetición del do-while
            }

        } while (continuar);

        app.appendConsola("Fin del ejercicio.\n");
        app.appendConsola("Suma total: " + suma + "\n");
        app.setInputPanelVisible(false);
    }
}
