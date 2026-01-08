package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 2 - Sistema de calificaciones");
        app.setPreguntas(new String[]{
                "Introduce la nota del primer examen",
                "Introduce la nota del segundo examen",
                "Introduce la nota del tercer examen"
        });

        // Inicializa el panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Primera nota", "Segunda nota", "Tercera nota" };

        double valor;

        // Validar que la nota sea un número y esté entre 1 y 10
        try {
            valor = Double.parseDouble(texto);
            if (valor < 1 || valor > 10) {
                app.appendConsola("❌ Error: la nota debe estar entre 1 y 10.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        // Guardar la respuesta y mostrarla en consola
        EjercicioUtils.procesarRespuesta(app, String.valueOf(valor), etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, calcular la nota media
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularMedia(app);
        }
    }

    private static void calcularMedia(App app) {
        String[] respuestas = app.getRespuestasTexto();

        try {
            double num1 = Double.parseDouble(respuestas[0]);
            double num2 = Double.parseDouble(respuestas[1]);
            double num3 = Double.parseDouble(respuestas[2]);
            double notaMedia = (num1 + num2 + num3) / 3;

            String mensaje;
            if (notaMedia >= 9) {
                mensaje = "Has sacado un sobresaliente";
            } else if (notaMedia >= 7) {
                mensaje = "Has sacado un notable";
            } else if (notaMedia >= 5) {
                mensaje = "Has aprobado";
            } else {
                mensaje = "Has suspendido";
            }

            app.appendConsola("La nota media es: " + notaMedia + ". " + mensaje + "\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: algún valor no es un número válido.\n");
        }
    }
}
