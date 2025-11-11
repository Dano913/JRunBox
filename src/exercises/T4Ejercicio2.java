package exercises;
import main.App;

public class T4Ejercicio2 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 37 - Calificación con Switch");
        app.setPreguntas(new String[]{
                "Introduce una letra de calificación(A, B, C, D, F)",
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
                "Número",

        };
        String[] unidades = {
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
                char letra = respuestas[0].charAt(0);
                String calificacion = "";
                switch(letra) {
                    case 'A' -> {calificacion = "Excelente";}
                    case 'B' -> {calificacion = "Muy bien";}
                    case 'C' -> {calificacion = "Bien";}
                    case 'D' -> {calificacion = "Suficiente";}
                    case 'F' -> {calificacion = "Insuficiente";}
                    default -> {app.appendConsola("Letra no esperada");}
                }
                app.appendConsola(String.format("Calificación %s: %s", letra, calificacion));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
