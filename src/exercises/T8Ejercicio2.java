package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio2 {
    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 8 - Recorrer array con for");
        // Pregunta opcional o de ejemplo
        app.setPreguntas(new String[]{
                "Presiona enter para recorrer array con for"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta y muestra un estado aleatorio
    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            // Array de 5 frutas
            int[] numeros = {10, 20, 30, 40, 50 ,60};

            // Imprimir en consola
            for (int i = 0; i < numeros.length; i++) {
                app.appendConsola("Índice " + i + ": " + numeros[i] + "\n");
            }
        }
    }
}
