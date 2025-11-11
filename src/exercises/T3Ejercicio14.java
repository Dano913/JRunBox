package exercises;
import main.App;

public class T3Ejercicio14 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 34 - Candidado a préstamo");
        app.setPreguntas(new String[]{
                "Introduce tu edad",
                "Introduce tus ingresos mensuales",
                "¿Tienes deudas?"
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
                "Ingresos mensuales",
                "Deudas"

        };
        String[] unidades = {
                "años",
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
                int edad = Integer.parseInt(respuestas[0]);
                int ingreso = Integer.parseInt(respuestas[1]);
                boolean deuda = Boolean.parseBoolean(respuestas[2]);
                if(edad >= 21 && edad <= 65) {
                    if(ingreso>=1000){
                        if(!deuda){
                            app.appendConsola("¡Enhorabuena! Puedes solicitar tu préstamo");
                        } else {
                            app.appendConsola("No puedes solicitar un préstamo debido a tus deudas");
                        }
                    } else {
                        app.appendConsola("No tienes ingresos suficientes para solicitar un préstamo");
                    }
                } else {
                    app.appendConsola("No tienes edad para solicitar un préstamo");
                }


            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
