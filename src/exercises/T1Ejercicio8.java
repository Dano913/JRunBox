package exercises;

import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 1 – Área de rectángulo");
        app.setPreguntas(new String[]{
                "¿Cuánto mide la base del rectángulo?",
                "¿Cuánto mide la altura del rectángulo?"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Guardar la respuesta y mostrar etiqueta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{ "Base", "Altura" }, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si se han completado las respuestas, calcular el área
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double base = Double.parseDouble(respuestas[0]);
                double altura = Double.parseDouble(respuestas[1]);
                double area = base * altura;
                app.appendConsola("\nÁrea del rectángulo: " + area + "\n");
            } catch (NumberFormatException e) {
                app.appendConsola("\nError: las entradas no son números válidos.\n");
            }
        }
    }
}
