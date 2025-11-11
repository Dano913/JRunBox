package exercises;
import main.App;

public class T3Ejercicio4 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 24 - Compra con descuento");
        app.setPreguntas(new String[]{
                "Introduce el importe de la compra",
                "Introduce el descuento aplicado",
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Importe",
                "Descuento"
        };
        String[] unidades = {
                "€",
                "%"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + " " + unidades[indice] + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                double importe = Double.parseDouble(respuestas[0]);
                double descuento = Double.parseDouble(respuestas[1]);
                double finalPrice = importe - importe*(descuento/100);
                app.appendConsola("El importe final es"+finalPrice+".");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
