package exercises;

import main.App;
import utils.EjercicioUtils;

public class T3Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 3 - Calculadora IMC");
        app.setPreguntas(new String[]{
                "Introduce tu peso en kilogramos",
                "Introduce tu altura en metros"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Peso", "Altura" };
        String[] unidades = { "kg", "m" };
        double valor;

        // Validación del número
        try {
            valor = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Guardar y mostrar la respuesta
        EjercicioUtils.procesarRespuesta(app, String.valueOf(valor), etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, calcular IMC
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularIMC(app);
        }
    }

    private static void calcularIMC(App app) {
        app.setInputPanelVisible(false);
        String[] respuestas = app.getRespuestasTexto();

        double peso = Double.parseDouble(respuestas[0]);
        double altura = Double.parseDouble(respuestas[1]);
        double IMC = peso / (altura * altura);

        String mensaje;
        if (IMC < 18.5) {
            mensaje = "Estás por debajo del peso normal.";
        } else if (IMC > 24.9) {
            mensaje = "Estás por encima del peso normal.";
        } else {
            mensaje = "Estás en tu peso ideal.";
        }

        app.appendConsola("Tienes un IMC de " + String.format("%.2f", IMC) + " puntos. " + mensaje + "\n");
    }
}
