package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T12Ejercicio7 {

    private static final int MAX_INTENTOS = 7;
    private static int numeroSecreto;
    private static int intentos = 0;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 12 – Adivinación de números");

        // Generar número aleatorio entre 1 y 50
        Random rand = new Random();
        numeroSecreto = rand.nextInt(50) + 1;

        // Inicializar primera pregunta
        app.setPreguntas(new String[]{"Introduce un número entre 1 y 50:"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int numero;

        try {
            numero = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            app.appendConsola("Debes introducir un número válido.\n");
            reiniciarPregunta(app);
            return;
        }

        if (numero < 1 || numero > 50) {
            app.appendConsola("El número debe estar entre 1 y 50.\n");
            reiniciarPregunta(app);
            return;
        }

        intentos++;

        if (numero == numeroSecreto) {
            app.appendConsola("¡Felicidades! Has adivinado el número " + numeroSecreto +
                    " en " + intentos + " intentos.\n");
        } else {
            if (intentos >= MAX_INTENTOS) {
                app.appendConsola("Se han agotado los intentos. El número era: " + numeroSecreto + "\n");
            } else {
                if (numero < numeroSecreto) {
                    app.appendConsola("El número es mayor que " + numero + ".\n");
                } else {
                    app.appendConsola("El número es menor que " + numero + ".\n");
                }
                reiniciarPregunta(app);
            }
        }
    }

    private static void reiniciarPregunta(App app) {
        app.setPreguntas(new String[]{"Introduce un número entre 1 y 50:"});
        EjercicioUtils.inicializarEntrada(app);
    }
}
