package exercises;
import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio4 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 – Nombres descriptivos");
        app.setPreguntas(new String[]{
                "Ingresa el título del libro:",
                "Ingresa el autor del libro:",
                "Ingresa el año de publicación:",
                "Ingresa el número de páginas:",
                "¿Disponible en biblioteca? (true/false):"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Título", "Autor", "Año de publicación", "Número de páginas", "Disponible en biblioteca"};
        String[] unidades = {"","",""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        // Mensaje final propio del ejercicio
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("\n¡Datos del libro completados!\n");
        }
    }
}
