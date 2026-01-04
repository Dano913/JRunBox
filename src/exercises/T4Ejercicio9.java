package exercises;
import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 4 - Factorial con for");
        app.setPreguntas(new String[]{"Introduce un número entero positivo"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int num1;

        // Validar número
        try {
            num1 = Integer.parseInt(texto);
            if (num1 < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número entero positivo.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.setInputPanelVisible(false);

            // Calcular factorial
            long factorial = 1;
            for (int i = 1; i <= num1; i++) factorial *= i;

            app.appendConsola(String.format("Factorial de %d es %d%n", num1, factorial));
        }
    }
}
