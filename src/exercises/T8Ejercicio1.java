package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio1 {
    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 8 - Crear y mostrar un array");
        // Pregunta opcional o de ejemplo
        app.setPreguntas(new String[]{
                "Presiona enter para imprimir el array"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta y muestra un estado aleatorio
    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            // Array de 5 frutas
            String[] frutas = {"Manzana", "Pera", "Plátano", "Naranja", "Melocotón"};

            // Imprimir en consola
            for (String fruta : frutas) {
                app.appendConsola(fruta + "\n");
            }
        }
    }
}
