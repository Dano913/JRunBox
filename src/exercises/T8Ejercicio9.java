package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio9 {

    private static int[] numeros = new int[7];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 - Invertir el orden de un array");
        app.setPreguntas(new String[]{
                "Pulsa enter para generar array",
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Generar un nuevo array de enteros cada vez
        int i = 0;
        while (i < numeros.length) {
            int num = (int) (Math.random() * 100); // números 0 a 99
            boolean repetido = false;
            for (int j = 0; j < i; j++) {
                if (numeros[j] == num) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                numeros[i] = num;
                i++;
            }
        }

        // Imprimir array completo
        app.appendConsola("Array completo: ");
        for (int j = 0; j < numeros.length; j++) {
            app.appendConsola(numeros[j] + (j < numeros.length - 1 ? " " : "\n"));
        }

        int r= numeros.length;
        int [] reverso = new int[r];

        for (int j = 0; j < r; j++) {
            reverso[j] = numeros[r - 1 - j];  // Copiamos desde el final
        }

        app.appendConsola("Array reverso: ");
        // Imprimir array invertido
        for (int num : reverso) {
            app.appendConsola(num + " ");
        }

        app.appendConsola("\n");

        // Avanzar a la siguiente pregunta si corresponde
        EjercicioUtils.avanzarPregunta(app);
    }
}
