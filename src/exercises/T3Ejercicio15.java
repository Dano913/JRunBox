package exercises;
import main.App;

public class T3Ejercicio15 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 35 - Sistema de envío");
        app.setPreguntas(new String[]{
                "Introduce el peso del paquete(kg)",
                "Introduce la distancia del envío(km)",
                "¿Es envío urgente?"
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
                "Peso",
                "Distancia",
                "Urgente"

        };
        String[] unidades = {
                "kg",
                "km",
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
                double precioBase = 5;
                double peso = Double.parseDouble(respuestas[0]);
                double pesoGratis = 5;
                double pesoExceso = peso - pesoGratis;
                double distancia = Double.parseDouble(respuestas[1]);
                double distanciaGratis = 100;
                double distanciaExceso = distancia -distanciaGratis;
                boolean urgente = Boolean.parseBoolean(respuestas[2]);
                double costeEnvio = precioBase;
                if (peso > pesoGratis) {
                    costeEnvio += pesoExceso * 2;
                }
                if (distancia > distanciaGratis) {
                    costeEnvio += 10;
                }
                if (urgente) {
                    costeEnvio *= 1.5; // se aplica sobre el total acumulado
                }

                app.appendConsola("El coste total del envío es " + costeEnvio);

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
