package exercises;

import main.App;
import utils.EjercicioUtils;

public class T8Ejercicio8 {

    private static final String[] animalesBase = {"Perro", "Gato", "Elefante", "Tigre", "Mono", "León", "Cebra"};
    private static final String[] animalesArray = new String[15]; // tamaño del array generado
    private static boolean arrayGenerado = false;

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio - Contar repeticiones de animales");
        app.setPreguntas(new String[]{
                "Introduce un animal de la lista: Perro, Gato, Elefante, Tigre, Mono, León, Cebra"
        });

        EjercicioUtils.inicializarEntrada(app);
        arrayGenerado = false; // Para generar un nuevo array cada vez que se inicia
    }

    public static void procesarRespuesta(App app, String texto) {

        // Generar array aleatorio solo una vez por ejercicio
        if (!arrayGenerado) {
            for (int i = 0; i < animalesArray.length; i++) {
                int indiceAleatorio = (int) (Math.random() * animalesBase.length);
                animalesArray[i] = animalesBase[indiceAleatorio];
            }
            arrayGenerado = true;
        }

        // Contar cuántas veces aparece el animal introducido
        int contador = 0;
        for (int i = 0; i < animalesArray.length; i++) {
            if (animalesArray[i].equalsIgnoreCase(texto.trim())) {
                contador++;
            }
        }

        // Mostrar resultado
        if (contador > 0) {
            app.appendConsola("El animal \"" + texto + "\" se repite " + contador + " veces.\n");
        } else {
            app.appendConsola("El animal \"" + texto + "\" no está en el array.\n");
        }

        // Mostrar el array completo al final
        app.appendConsola("Array generado: ");
        for (int i = 0; i < animalesArray.length; i++) {
            app.appendConsola(animalesArray[i] + (i < animalesArray.length - 1 ? ", " : "\n"));
        }

        // Avanzar a la siguiente pregunta si hay más
        EjercicioUtils.avanzarPregunta(app);
    }
}
