package exercises;
import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 4 - Sistema de repeticiones");
        app.setPreguntas(new String[]{
                "Elige un ejercicio (1: Flexiones, 2: Abdominales, 3: Sentadillas)",
                "¿Cuántas repeticiones vas a hacer?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        if (indice == 0 || indice == 1) {
            try {
                int valor = Integer.parseInt(texto);
                if (valor <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Ejercicio", "Repeticiones"}, new String[]{"", ""});
        EjercicioUtils.avanzarPregunta(app);
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.setInputPanelVisible(false);
            int ejercicio = Integer.parseInt(app.getRespuestasTexto()[0]);
            int repes = Integer.parseInt(app.getRespuestasTexto()[1]);
            String mensaje = switch(ejercicio) {
                case 1 -> "Flexiones";
                case 2 -> "Abdominales";
                case 3 -> "Sentadillas";
                default -> null;
            };
            if (mensaje != null) {
                app.appendConsola(String.format("Has elegido el ejercicio %s%n", mensaje));
                for (int i = 1; i <= repes; i++) {
                    app.appendConsola(String.format("Repetición %d completada%n", i));
                }
            } else {
                app.appendConsola("❌ El ejercicio no está disponible.\n");
            }
        }
    }
}
