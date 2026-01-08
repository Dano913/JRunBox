package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Locale;

public class T8Ejercicio7 {

    private static int[] numeros = new int[6];

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 8 - Encontrar el número mayor y menor");
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

        // Encontrar mayor y menor
        int mayor = numeros[0];
        int menor = numeros[0];
        for (int j = 1; j < numeros.length; j++) {
            if (numeros[j] > mayor) mayor = numeros[j];
            if (numeros[j] < menor) menor = numeros[j];
        }

        // Mostrar resultados
        app.appendConsola("Número mayor: " + mayor + "\n");
        app.appendConsola("Número menor: " + menor + "\n");

        // Imprimir array completo
        app.appendConsola("Array completo: ");
        for (int j = 0; j < numeros.length; j++) {
            app.appendConsola(numeros[j] + (j < numeros.length - 1 ? ", " : "\n"));
        }
        app.appendConsola("\n");

        // Avanzar a la siguiente pregunta si corresponde
        EjercicioUtils.avanzarPregunta(app);
    }
}
