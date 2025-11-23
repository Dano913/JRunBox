package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio5 {
    private static int[] numeros = new int[10];
    private static boolean arrayGenerado = false;

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 - Contar elementos que cumplan una condición");
        app.setPreguntas(new String[]{
                "Pulsa enter para generar array",
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Generar el array aleatorio la primera vez
        if (!arrayGenerado) {
            int i = 0;
            while (i < numeros.length) {
                int num = (int) (Math.random() * 100); // número aleatorio 0-20
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
            arrayGenerado = false;
        }

        app.appendConsola("Números mayores de 50:\n");
        boolean hayMayores = false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > 50) {
                app.appendConsola("Número: " + numeros[i] + " en la posición " + i + "\n");
                hayMayores = true;
            }
        }
        if (!hayMayores) {
            app.appendConsola("No hay números mayores de 50 en el array.\n");
        }
        // Imprimir el array completo al final
        app.appendConsola("\nArray completo:\n");
        for (int i = 0; i < numeros.length; i++) {
            app.appendConsola(numeros[i] + (i < numeros.length - 1 ? ", " : "\n"));
        }
    }

}
