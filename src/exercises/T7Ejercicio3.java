package exercises;
import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio3 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 7 - Clasificador de temperatura");
        app.setPreguntas(new String[]{
                "Introduce una temperatura en grados Celsius",
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Temperatura"
        };
        String[] unidades = {
                "ºC"
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                int temperatura = Integer.parseInt(respuestas[0]);
                app.appendConsola(String.format("%.2f € equivalen a %.2f %s\n", temperatura));

            } catch (NumberFormatException e) {
                app.appendConsola("\nError: No has introducido un número válido.\n");
            } catch (IllegalArgumentException e) {
                app.appendConsola("\nError: No has introducido una moneda válida.\n");
            }
        }
    }
}
