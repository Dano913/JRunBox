package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio3 {

    private static int suma = 0;

    public static void iniciarEjercicio(App app) {


        app.setTituloEjercicio("Ejercicio 48 - Suma de números positivos");
        app.setPreguntas(new String[]{"Introduce un número positivo (0 o negativo para terminar)"});
        suma= 0;
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Número introducido", "Suma actual"};
        String[] unidades = {"", ""};

        // Guardamos la respuesta y mostramos en consola
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

        while (num > 0) {
            suma += num; // acumulamos el número positivo
            app.appendConsola("Suma actual: " + suma + "\n");

            // Preparar para el siguiente número
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();

            return; // salimos hasta el siguiente intento
        }

        // Si el número es cero o negativo, terminamos el ejercicio
        app.appendConsola("Número negativo o cero introducido. Fin del ejercicio.\n");
        app.appendConsola("Suma total: " + suma + "\n");
        app.setInputPanelVisible(false);
    }
}
