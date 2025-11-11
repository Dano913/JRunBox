package exercises;
import main.App;
import utils.EjercicioUtils;

public class T6Ejercicio3 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 - Compra con IVA");
        app.setPreguntas(new String[]{
                "Introduce decenas de mil",
                "Introduce unidades de mil",
                "Introduce centenas",
                "Introduce decenas",
                "Introduce unidades",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Decenas de mil",
                "Unidades de mil",
                "Centenas",
                "Decenas",
                "Unidades"
        };
        String[] unidades = {
                "",
                "",
                "",
                "",
                "",
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                int decenaMil = Integer.parseInt(respuestas[0]);
                int unidadMil = Integer.parseInt(respuestas[1]);
                int centena = Integer.parseInt(respuestas[2]);
                int decena = Integer.parseInt(respuestas[3]);
                int unidad = Integer.parseInt(respuestas[4]);

                app.appendConsola(String.format("Número introducido: %d%d%d%d%d",
                        decenaMil, unidadMil, centena, decena, unidad));
            } catch (NumberFormatException e) {
                app.appendConsola("\nError: las entradas no son números válidos.\n");
            }
        }
    }
}
