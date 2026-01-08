package exercises;

import main.App;
import utils.EjercicioUtils;

public class T4Ejercicio3 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 4 - Calculadora con switch");
        app.setPreguntas(new String[]{
                "Introduce un número",
                "Introduce otro número",
                "Introduce la operación (+, -, *, /)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        // Validación de números
        if (indice == 0 || indice == 1) {
            try {
                Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Error: ingresa un número válido.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }

        // Validación de operación
        if (indice == 2) {
            if (!"+-*/".contains(texto)) {
                app.appendConsola("❌ Error: operación inválida, usa +, -, *, /\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
        }

        // Guardar y mostrar respuesta
        EjercicioUtils.procesarRespuesta(app, texto, new String[]{"Primer número", "Segundo número", "Operación"}, new String[]{"", "", ""});
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no hay más preguntas, calcular resultado
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            try {
                int num1 = Integer.parseInt(app.getRespuestasTexto()[0]);
                int num2 = Integer.parseInt(app.getRespuestasTexto()[1]);
                char operando = app.getRespuestasTexto()[2].charAt(0);
                double resultado;

                resultado = switch (operando) {
                    case '+' -> num1 + num2;
                    case '-' -> num1 - num2;
                    case '*' -> num1 * num2;
                    case '/' -> (double) num1 / num2;
                    default -> Double.NaN;
                };

                app.appendConsola(String.format("%d %s %d = %.2f\n", num1, operando, num2, resultado));
            } catch (NumberFormatException e) {
                app.appendConsola("Error inesperado: número inválido.\n");
            }
        }
    }
}
