package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 4 - Suma de números con for");
        app.setPreguntas(new String[]{
                "Introduce un número"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int num;
        try {
            num = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Número"}, new String[]{""});
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            int suma = 0;
            StringBuilder textoSuma = new StringBuilder("Sumando: ");
            for (int i = 1; i <= num; i++) {
                textoSuma.append(i);
                suma += i;
                if (i != num) textoSuma.append(" + ");
            }
            app.appendConsola(textoSuma.toString());
            app.appendConsola(String.format("\nLa suma de los números del 1 al %d es: %d\n", num, suma));
        }
    }
}
