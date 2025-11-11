package exercises;
import main.App;
import utils.EjercicioUtils;

public class T6Ejercicio4 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 - Compra con IVA");
        app.setPreguntas(new String[]{
                "Introduce el número de segundos",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Segundos totales"
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
                int segundosTotal = Integer.parseInt(respuestas[0]);
                int minutos = segundosTotal/60;
                int restoSec = segundosTotal%60;
                int horas = minutos/60;
                int restoMin = minutos%60;
                app.appendConsola(String.format("%d segundos = %d:%02d:%02d\n", segundosTotal, horas, restoMin, restoSec));


            } catch (NumberFormatException e) {
                app.appendConsola("\nError: las entradas no son números válidos.\n");
            }
        }
    }
}
