package exercises;
import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 - Calculador con switch");
        app.setPreguntas(new String[]{
                "Introduce un número",
                "Introduce otro número",
                "Que operación quieres realizar(+,-,*,/)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Operando 1",
                "Operando 2",
                "Operación"
        };
        String[] unidades = {
                "",
                "",
                ""
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double num1 = Double.parseDouble(respuestas[0]);
                double num2 = Double.parseDouble(respuestas[1]);
                char operador = respuestas[2].charAt(0);

                double operacion = switch(operador){
                    case '+' -> num1+num2;
                    case '-' -> num1-num2;
                    case '*' -> num1*num2;
                    case '/' -> num1/num2;
                    default -> {
                        app.appendConsola("Operador no válido: " + operador);
                        yield 0;
                    }
                };
                if (operador == '/' && num2 == 0) {
                    app.appendConsola("Error: División por cero\n");
                } else if (operador == '+' || operador == '-' || operador == '*' || operador == '/') {
                    app.appendConsola(String.format("El resultado de la operación es: %.2f\n", operacion));
                }

            } catch (NumberFormatException e) {
                app.appendConsola("\nError: No has introducido un número válido.\n");
            } catch (StringIndexOutOfBoundsException e) {
                app.appendConsola("\nError: No has introducido un operador.\n");
            }
        }
    }
}
