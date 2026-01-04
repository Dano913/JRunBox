package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio3 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 2 - Asignación compuesta");
        app.setPreguntas(new String[]{
                "Introduce un valor inicial",
                "Añade un primer valor para sumar",
                "Añade un segundo valor para restar",
                "Añade un tercer valor para multiplicar",
                "Añade un cuarto valor para dividir"
        });

        // Inicializa la entrada de manera genérica
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = {
                "Valor inicial",
                "Suma",
                "Resta",
                "Multiplicación",
                "División"
        };

        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si se han contestado todas las preguntas, hacer operaciones
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            realizarOperaciones(app);
        }
    }

    private static void realizarOperaciones(App app) {

        String[] respuestas = app.getRespuestasTexto();
        double resultado;

        try {
            // Valor inicial
            double valorInicial = Double.parseDouble(respuestas[0]);
            resultado = valorInicial;
            app.appendConsola("Valor inicial: " + resultado + "\n");

            // Suma
            double suma = Double.parseDouble(respuestas[1]);
            resultado += suma;
            app.appendConsola("Suma: " + resultado + "\n");

            // Resta
            double resta = Double.parseDouble(respuestas[2]);
            resultado -= resta;
            app.appendConsola("Resta: " + resultado + "\n");

            // Multiplicación
            double multiplicacion = Double.parseDouble(respuestas[3]);
            resultado *= multiplicacion;
            app.appendConsola("Multiplicación: " + resultado + "\n");

            // División
            double division = Double.parseDouble(respuestas[4]);
            if (division != 0) {
                resultado /= division;
                app.appendConsola("División: " + resultado + "\n");
            } else {
                app.appendConsola("Error: no se puede dividir entre 0.\n");
            }

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores no es un número válido.\n");
        }
    }
}
