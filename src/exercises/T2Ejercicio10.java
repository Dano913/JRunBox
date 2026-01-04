package exercises;

import main.App;
import utils.EjercicioUtils;

public class T2Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 2 - Calculadora de salario");
        app.setPreguntas(new String[]{
                "Introduce el salario por hora",
                "Introduce las horas trabajadas"
        });

        // Inicializa panel de entrada y respuestas
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        String[] etiquetas = { "Salario por hora", "Horas trabajadas" };
        String[] unidades = { "€", "h" };

        // Guardar respuesta y mostrarla
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);

        // Avanzar a la siguiente pregunta
        EjercicioUtils.avanzarPregunta(app);

        // Si ya no quedan preguntas, calcular salario
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            calcularSalario(app);
        }
    }

    private static void calcularSalario(App app) {
        String[] respuestas = app.getRespuestasTexto();

        try {
            double salarioHora = Double.parseDouble(respuestas[0]);
            int horasTrabajadas = Integer.parseInt(respuestas[1]);
            int horasLegales = 40;

            double salarioExtraHora = salarioHora * 2;
            int horasExtras = Math.max(0, horasTrabajadas - horasLegales);

            double salarioSemanal = salarioHora * Math.min(horasTrabajadas, horasLegales)
                    + salarioExtraHora * horasExtras;

            double salarioMensual = salarioSemanal * 4.33; // semanas promedio por mes

            if (horasExtras > 0) {
                app.appendConsola("Has trabajado " + horasExtras + " horas extras.\n");
            }

            app.appendConsola("Tu salario a final de mes es " + salarioMensual + " €.\n");

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores no es un número válido.\n");
        }
    }
}
