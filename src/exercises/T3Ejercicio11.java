package exercises;
import main.App;

public class T3Ejercicio11 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 31 - Sistema de descuentos por niveles");
        app.setPreguntas(new String[]{
                "Introduce el importe de la compra",
                "¿Eres socio?"
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
                "Tarjeta de Socio"

        };
        String[] unidades = {
                "€",
                ""
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
                boolean socio = Boolean.parseBoolean(respuestas[1]);
                double price20 = importe - importe*(20.0/100);
                double price10 = importe - importe*(10.0/100);
                double price05 = importe - importe*(5.0/100);
                if(importe>=200 && socio){
                    app.appendConsola("Tienes un descuento del 20%. El importe final es "+price20);
                } else if(importe<200 && socio){
                    app.appendConsola("Tienes un descuento del 10%. El importe final es "+price10);
                } else if(!socio && importe>300) {
                    app.appendConsola("Tienes un descuento del 5%. El importe final es "+price05);
                } else {
                    app.appendConsola("No tienes ningun descuento. El importe final es "+importe);
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
