package exercises;
import main.App;
public class Ejercicio10 {

    // 🔹 Inicia el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 – Conversión de temperaturas");
        app.setPreguntas(new String[]{
                "Introduce la temperatura en °C:"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }

    // 🔹 Procesa cada respuesta parcial
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        app.getRespuestasTexto()[indice] = texto;
        String[] etiquetas = {
                "Temperatura en ºC"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            mostrarResultadoFinal(app);
        }
    }

    // 🔹 Mostrar resultado final
    public static void mostrarResultadoFinal(App app) {
        String entrada = app.getRespuestasTexto()[0].replace(",", ".");

        try {
            double C = Double.parseDouble(entrada);
            double F = C * 9 / 5 + 32;

            app.appendConsola("\n" + C + " °C equivalen a " + F + " °F\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: el valor ingresado no es un número válido.\n");
        }
    }
}
