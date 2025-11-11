package exercises;
import main.App;

public class T4Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 36 - Día de la semana");
        app.setPreguntas(new String[]{
                "Introduce un número del 1 al 7",
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
                int num1 = Integer.parseInt(respuestas[0]);
                String dia = switch(num1) {
                    case 1 -> "Lunes";
                    case 2 -> "Martes";
                    case 3 -> "Miércoles";
                    case 4 -> "Jueves";
                    case 5 -> "Viernes";
                    case 6 -> "Sábado";
                    case 7 -> "Domingo";
                    default -> "No se ha introducido un número válido"; // usamos null para indicar valor no válido
                };
                app.appendConsola(String.format("El día %d es: %s\n", num1, dia));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
