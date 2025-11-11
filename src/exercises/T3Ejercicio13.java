package exercises;
import main.App;

public class T3Ejercicio13 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 33 - Precio de entrada por edad");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "¿Qué día de la semana es hoy?"
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
                "Edad",
                "Día de la semana"

        };
        String[] unidades = {
                "años",
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
                int edad = Integer.parseInt(respuestas[0]);
                String dia = respuestas[1];
                if(edad<12){
                    app.appendConsola("La entrada es gratis para los menores de 12 años.");
                } else if(edad<=17 && dia.equals("martes")){
                    app.appendConsola("La entrada hoy dia martes para los niños de 12 a 17 años es gratis.");
                }else if(edad<=17){
                    app.appendConsola("La entrada cuesta 5€ para los niños de 12 a 17 años.");
                }else if(edad<68 && dia.equals("jueves")){
                    app.appendConsola("La entrada hoy dia jueves cuesta 7€ para los adultos hasta los 64 años");
                }else if(edad<68) {
                    app.appendConsola("La entrada cuesta 10€ para los adultos hasta los 64 años");
                } else {
                    app.appendConsola("La entrada cuesta 6€ para los adultos de más de 64 años");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
