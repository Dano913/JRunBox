package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.Random;

public class T12Ejercicio8 {

    private static final int MAX_INTENTOS = 5;
    private static String palabraSecreta;
    private static int intentos = 0;

    // Lista de palabras de 5 letras
    private static final String[] palabras = {
            "perro", "cinco", "coche", "flota", "hindu",
            "lanza", "barco", "plaza", "arbol", "libro"
    };

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 12 – Wordle simplificado");

        seleccionarPalabraSecreta();

        // Inicializar primera pregunta
        app.setPreguntas(new String[]{"Introduce una palabra de 5 letras:"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String intento = texto.trim().toLowerCase();

        EjercicioUtils.limpiarRespuestaYFoco(app);

        if (intento.length() != 5) {
            app.appendConsola("La palabra debe tener exactamente 5 letras.\n");
            reiniciarPregunta(app);
            return;
        }

        intentos++;

        int aciertos = 0;
        int aproximaciones = 0;
        int fallos = 0;

        boolean[] usadaSecreta = new boolean[5];
        boolean[] usadaIntento = new boolean[5];

        // Contar aciertos
        for (int i = 0; i < 5; i++) {
            if (intento.charAt(i) == palabraSecreta.charAt(i)) {
                aciertos++;
                usadaSecreta[i] = true;
                usadaIntento[i] = true;
            }
        }

        // Contar aproximaciones
        for (int i = 0; i < 5; i++) {
            if (usadaIntento[i]) continue;

            for (int j = 0; j < 5; j++) {
                if (usadaSecreta[j]) continue;

                if (intento.charAt(i) == palabraSecreta.charAt(j)) {
                    aproximaciones++;
                    usadaSecreta[j] = true;
                    usadaIntento[i] = true;
                    break;
                }
            }
        }

        fallos = 5 - aciertos - aproximaciones;

        // Mostrar resultados
        app.appendConsola("\nIntento " + intentos + ": " + intento + "\n");
        app.appendConsola("Aciertos: " + aciertos + "\n");
        app.appendConsola("Aproximaciones: " + aproximaciones + "\n");
        app.appendConsola("Fallos: " + fallos + "\n");

        if (aciertos == 5) {
            app.appendConsola("\n¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta + "\n");
            intentos = 0; // Resetear intentos
            seleccionarPalabraSecreta(); // Nueva palabra secreta
            reiniciarPregunta(app);
        } else if (intentos >= MAX_INTENTOS) {
            app.appendConsola("\nSe han agotado los intentos. La palabra secreta era: " + palabraSecreta + "\n");
            intentos = 0; // Resetear intentos
            seleccionarPalabraSecreta(); // Nueva palabra secreta
            reiniciarPregunta(app);
        } else {
            reiniciarPregunta(app);
        }
    }

    private static void reiniciarPregunta(App app) {
        app.setPreguntas(new String[]{"Introduce una palabra de 5 letras:"});
        EjercicioUtils.inicializarEntrada(app);
    }

    private static void seleccionarPalabraSecreta() {
        Random rand = new Random();
        palabraSecreta = palabras[rand.nextInt(palabras.length)];
    }
}
