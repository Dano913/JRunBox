package exercises;
import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 4 - Contar números pares e impares");
        app.setPreguntas(new String[]{"Introduce un número"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validar número antes de guardar
        int num1;
        try {
            num1 = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.setInputPanelVisible(false);

            // Contar pares e impares y listar primos
            int par = 0, impar = 0, contadorLinea = 0;
            StringBuilder numeros = new StringBuilder("Recorriendo números del 1 al " + num1 + ":\n");

            for (int i = 1; i <= num1; i++) {
                numeros.append(i).append(" ");
                contadorLinea++;
                if (i % 2 == 0) par++; else impar++;
                if (contadorLinea == 20) { numeros.append("\n"); contadorLinea = 0; }
            }
            numeros.append(String.format("\nCantidad de pares: %d\nCantidad de impares: %d\n", par, impar));
            app.appendConsola(numeros.toString());

            app.appendConsola("------------------------------");

            int contadorPrimos = 0, contadorLinea2 = 0;
            StringBuilder listaPrimos = new StringBuilder();
            for (int i = 2; i <= num1; i++) {
                boolean esPrimo = true;
                for (int j = 2; j <= Math.sqrt(i); j++) if (i % j == 0) { esPrimo = false; break; }
                if (esPrimo) {
                    contadorPrimos++;
                    listaPrimos.append(String.format("%-4d", i));
                    contadorLinea2++;
                    if (contadorLinea2 == 20) { listaPrimos.append("\n"); contadorLinea2 = 0; }
                }
            }
            app.appendConsola(String.format("\nNúmeros primos del 1 al %d:\n%s\nTotal de números primos: %d\n",
                    num1, listaPrimos.toString().trim(), contadorPrimos));
        }
    }
}
