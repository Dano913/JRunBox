package exercises;
import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 46 - Contador básico con while");
        app.setPreguntas(new String[]{
                "Introduce un número",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Número"};
        String[] unidades = {""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                int num1 = Integer.parseInt(app.getRespuestasTexto()[0]);
                String frase = "Contando con While:\n";
                int contador = 1;
                app.appendConsola(frase);
                while (contador <= num1) {
                    app.appendConsola(contador + "\n");
                    contador++;
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
