package exercises;

import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 – Uso de constantes");
        app.setPreguntas(new String[]{
                "¿Cómo se llama tu aplicación?",
                "¿Cuál es la versión?",
                "El valor de pi es", // se llenará automáticamente
                "¿Cuál es tu usuario?",
                "¿Cuál es tu nivel?",
                "¿Qué puntuación tienes?",
                "Actualiza tu usuario si lo deseas",
                "Actualiza tu nivel",
                "Actualiza tu puntuación"
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] etiquetas = {
                "Nombre", "Versión", "Pi", "Usuario", "Nivel",
                "Puntuación", "Usuario actualizado", "Nivel actualizado", "Puntuación actualizado"
        };
        // Si es la pregunta de Pi, asignamos el valor automáticamente
        if (indice == 2) {
            texto = String.valueOf(Math.PI);
        }
        // Guardar la respuesta y mostrar etiqueta
        app.getRespuestasTexto()[indice] = texto;
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);
        // Mensaje final propio del ejercicio
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("¡Datos Actualizados!\n");
        }
    }
}
