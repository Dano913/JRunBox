package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio4 {
    private static int[] numeros = new int[7];
    private static boolean arrayGenerado = false;
    private static int intentos = 0;

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 8 - Buscar un elemento en el array");
        app.setPreguntas(new String[]{
                "Introduce el número secreto",
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        // Generar el array aleatorio la primera vez
        if (!arrayGenerado) {
            int i = 0;
            while (i < numeros.length) {
                int num = (int) (Math.random() * 21); // número aleatorio 0-20
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
            arrayGenerado = true;
        }

        // Contabilizar intentos
        intentos++;

        // Convertir la entrada del usuario a número
        int numeroBuscado;
        try {
            numeroBuscado = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            // Limpiar input y devolver foco
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Buscar el número en el array
        boolean encontrado = false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numeroBuscado) {
                app.appendConsola("Número " + numeroBuscado + " encontrado en la posición " + i + "\n");
                encontrado = true;
                break;
            }
        }

        // Mensaje si no se encontró
        if (!encontrado) {
            app.appendConsola("El número "+numeroBuscado+" no está en el array.\n");
            // Limpiar input y devolver foco
            EjercicioUtils.limpiarRespuestaYFoco(app);
        } else {
            // Número encontrado → mostrar intentos y avanzar
            app.appendConsola("Número de intentos realizados: " + intentos + "\n");

            // Mostrar el array completo
            app.appendConsola("Array generado: ");
            for (int i = 0; i < numeros.length; i++) {
                app.appendConsola(numeros[i] + (i < numeros.length - 1 ? ", " : "\n"));
            }

            // Reiniciar intentos y avanzar
            intentos = 0;
            arrayGenerado = false; // Para que al reiniciar el ejercicio se genere un nuevo arra
            EjercicioUtils.avanzarPregunta(app);
        }
    }

}
