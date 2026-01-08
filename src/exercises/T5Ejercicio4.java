package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T5Ejercicio4 {

    private static int numeroSecreto;
    private static int contador;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 5 - Adivina el número (do-while)");
        app.setPreguntas(new String[]{"Adivina el número (entre 1 y 10)"});
        EjercicioUtils.inicializarEntrada(app);
        numeroSecreto = new Random().nextInt(10) + 1;
        contador = 0;
        app.appendConsola("Se ha generado un número secreto entre 1 y 10.\n");
    }

    public static void procesarRespuesta(App app, String texto) {
        app.appendConsola("Número introducido: " + texto + "\n");
        int num;
        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Introduce un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        boolean correcto;
        do {
            contador++;
            if (num < 1 || num > 10) {
                app.appendConsola("❌ El número debe estar entre 1 y 10.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
            correcto = num == numeroSecreto;
            if (!correcto) {
                if (num < numeroSecreto) {
                    app.appendConsola("El número secreto es MAYOR.\n");
                } else {
                    app.appendConsola("El número secreto es MENOR.\n");
                }
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return; // ⬅️ simula repetición del do-while
            }
        } while (!correcto);
        app.appendConsola("✅ ¡Correcto! Has adivinado el número.\n");
        app.appendConsola("Intentos realizados: " + contador + "\n");
        app.setInputPanelVisible(false);
    }
}
