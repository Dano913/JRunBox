package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio6 {

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 8 - Calcular suma y promedio de un array");
        app.setPreguntas(new String[]{
                "Pulsa enter para generar array",
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        double[] numeros = new double[10];
        boolean arrayGenerado = false;
        double suma = 0;
        double promedio = suma / numeros.length;

        if (!arrayGenerado) {
            int i = 0;  // índice debe ser int
            while (i < numeros.length) {
                double num = Math.random() * 100; // número aleatorio entre 0.0 y 100.0
                num = Math.round(num * 100.0) / 100.0; // redondear a 2 decimales
                boolean repetido = false;
                for (int j = 0; j < i; j++) {
                    if (Math.abs(numeros[j] - num) < 0.0001) { // comparación para doubles
                        repetido = true;
                        break;
                    }
                }
                if (!repetido) {
                    numeros[i] = num;
                    i++;
                }
            }
            arrayGenerado = true;
        }

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i]; // suma = suma + numeros[i]
        }

        app.appendConsola(String.format("La suma de los números es: %.2f\n", suma));
        app.appendConsola(String.format("El promedio de los números es: %.2f\n", promedio));


        // Imprimir el array completo al final
        app.appendConsola("Array completo: ");
        for (int i = 0; i < numeros.length; i++) {
            app.appendConsola(numeros[i] + (i < numeros.length - 1 ? " " : "\n"));
        }
        app.appendConsola("\n");
    }

}
