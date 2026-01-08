package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio3 {

    private static final String[] nombres = new String[5];
    private static int indice = 0;

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 8 - Rellenar array con input del usuario");

        app.setPreguntas(new String[]{
                "Introduce el primer nombre",
                "Introduce el segundo nombre",
                "Introduce el tercer nombre",
                "Introduce el cuarto nombre",
                "Introduce el quinto nombre"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta
    public static void procesarRespuesta(App app, String texto) {

        // Guardar el nombre del usuario en el array
        nombres[indice] = texto;
        indice++;

        EjercicioUtils.avanzarPregunta(app);

        // Si ya hemos hecho todas las preguntas
        if (app.getIndicePregunta() >= app.getPreguntas().length) {

            app.appendConsola("\nHas introducido los siguientes nombres:\n");

            for (int i = 0; i < nombres.length; i++) {
                app.appendConsola("Nombre " + (i + 1) + ": " + nombres[i] + "\n");
            }

            // Reiniciar por si se repite el ejercicio
            indice = 0;
        }
    }
}
