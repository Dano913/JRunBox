package exercises;
import main.App;

public class T4Ejercicio10 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 45 - Sistema de repeticiones");
        app.setPreguntas(new String[]{
                "Elige un ejercicio",
                "¿Cuantas repeticiones vas a hacer?"
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
                "Ejercicio",
                "Has elegido"

        };
        String[] unidades = {
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
                int ejercicio = Integer.parseInt(respuestas[0]);
                int repes = Integer.parseInt(respuestas[1]);
                String mensaje = switch(ejercicio) {
                    case 1 -> "Flexiones";
                    case 2 -> "Abdominales";
                    case 3 -> "Sentadillas";
                    default -> null;
                };
                if (mensaje != null) {
                    app.appendConsola(String.format("Has elegido el ejercicio %s", mensaje));
                    for (int i = 0; i < repes; i++) {
                        app.appendConsola(String.format("\nRepetición %d completada", i + 1));
                    }
                } else {
                    app.appendConsola("El ejercicio no está disponible");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
