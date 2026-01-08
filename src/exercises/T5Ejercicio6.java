package exercises;

import java.util.concurrent.TimeUnit;
import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 5 - Cuenta atrás con while");
        app.setPreguntas(new String[]{"Introduce un número para la cuenta atrás"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Número introducido"};
        String[] unidades = {""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        int num;
        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        app.setInputPanelVisible(false);
        new Thread(() -> {
            int contador = num;
            app.appendConsola("Cuenta atrás:\n");
            while (contador > 0) {
                app.appendConsola(contador + "\n");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    app.appendConsola("El conteo fue interrumpido.\n");
                    return;
                }
                contador--;
            }
            app.appendConsola("¡Despegue!\n");
        }).start();
    }
}
