package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T5Ejercicio4 {

    private static int numeroSecreto;
    private static int[] intentos = new int[100];
    private static int contador = 0;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio - Adivina el número (do-while simulado)");
        app.setPreguntas(new String[]{"Adivina el número (entre 1 y 10)"});
        EjercicioUtils.inicializarEntrada(app);

        // Generar número aleatorio entre 1 y 10
        Random rand = new Random();
        numeroSecreto = rand.nextInt(10) + 1;

        // Reiniciar contador e intentos
        contador = 0;
        for (int i = 0; i < intentos.length; i++) intentos[i] = 0;

        app.appendConsola("Se ha generado un número secreto entre 1 y 10.\n");
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
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // --- Simulación del do-while ---
        do {
            if (num < 1 || num > 10) {
                app.appendConsola("El número debe estar entre 1 y 10.\n");
                break; // volvemos a pedir número
            }

            intentos[contador] = num;
            contador++;

            if (num == numeroSecreto) {
                app.appendConsola("¡Correcto! Has adivinado el número secreto: " + numeroSecreto + "\n");
                app.appendConsola("Intentos realizados: ");
                for (int i = 0; i < contador; i++) {
                    app.appendConsola(intentos[i] + (i < contador - 1 ? ", " : "\n"));
                }
                app.appendConsola("Número total de intentos: " + contador + "\n");
                app.setInputPanelVisible(false);
                return; // termina el ejercicio
            } else if (num < numeroSecreto) {
                app.appendConsola("El número secreto es MAYOR que " + num + ".\n");
            } else {
                app.appendConsola("El número secreto es MENOR que " + num + ".\n");
            }

            // Preparamos el siguiente intento
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return; // termina este ciclo, esperando nuevo input

        } while (true);
    }
}
