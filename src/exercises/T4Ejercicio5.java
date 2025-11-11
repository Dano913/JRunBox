package exercises;
import main.App;

public class T4Ejercicio5 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 40 - Estaciones del año");
        app.setPreguntas(new String[]{
                "Introduce el número de mes"
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
                "Número de mes"

        };
        String[] unidades = {
                "",
                "",
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
                int mes = Integer.parseInt(respuestas[0]);
                String estacion = switch(mes) {
                    case 12, 1, 2 -> "Invierno";
                    case 3, 4, 5 -> "Primavera";
                    case 6, 7, 8 -> "Verano";
                    case 9, 10, 11 -> "Otoño";
                    default -> "No se ha introducido un número válido";
                };
                app.appendConsola(String.format("El mes %d es: %s\n", mes, estacion));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
