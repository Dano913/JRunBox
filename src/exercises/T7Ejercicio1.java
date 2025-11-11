package exercises;
import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 - Sistema de Calificaciones Avanzado");
        app.setPreguntas(new String[]{
                "Introduce tu calificación",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Calificación"
        };
        String[] unidades = {
                ""
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double calificacion = Double.parseDouble(respuestas[0]);
                int rango = (int) Math.floor(calificacion);
                String letra = switch(rango) {
                    case 9, 10 -> "A";
                    case 7, 8 -> "B";
                    case 5, 6 -> "C";
                    case 3, 4 -> "D";
                    case 0, 1, 2 -> "F";
                    default -> "No se ha introducido una nota válida";
                };
                app.appendConsola(String.format("Tu calificación es %.1f por lo tanto tienes una %S", calificacion, letra));


            } catch (NumberFormatException e) {
                app.appendConsola("\nError: No has introducido un número válido.\n");
            }
        }
    }
}
