package exercises;
import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 5 - Contador básico con while");
        app.setPreguntas(new String[]{"Introduce un número"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Validación: debe ser número positivo
        try {
            int valor = Integer.parseInt(texto);
            if (valor <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido mayor que 0.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.setInputPanelVisible(false);

            int num1 = Integer.parseInt(app.getRespuestasTexto()[0]);
            app.appendConsola("Contando con While:\n");

            int contador = 1;
            while (contador <= num1) {
                app.appendConsola(contador + "\n");
                contador++;
            }
        }
    }
}
