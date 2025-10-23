package exercises;
import main.App;
public class Ejercicio16 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 16 - Calculadora de descuento");
        app.setPreguntas(new String[]{
                "¿Cuánto cuesta el producto?",
                "¿Qué porcentaje de descuento tiene?",
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
                "Precio del producto",
                "Descuento sobre el precio",
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
                double originalPrice = Double.parseDouble(respuestas[0]);
                double discount = Double.parseDouble(respuestas[1]);
                double finalPrice = originalPrice - originalPrice*(discount/100);
                app.appendConsola("El precio final con descuento es: "+finalPrice+" €.");

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
