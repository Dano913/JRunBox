package exercises;
import main.App;
public class T2Ejercicio10 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 20 - Calculadora de salario");
        app.setPreguntas(new String[]{
                "Introduce el salario por hora",
                "Introduce las horas trabajadas"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto){
        int indice = app.getIndicePregunta();
        String [] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Salario por hora",
                "Horas trabajadas"
        };
        String[] unidades = {
                "€",
                "h"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + " " + unidades[indice] + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                int horasLegales = 40;
                double salarioNormal = Double.parseDouble(respuestas[0]);
                int horasReales = Integer.parseInt(respuestas[1]);
                boolean extras = horasReales > horasLegales;
                int horasExtras = horasReales - horasLegales;
                double salarioExtras = salarioNormal*2;
                double salarioSemanal = (salarioNormal*horasReales);
                double salarioMensual = 4.33*salarioSemanal;
                if(extras) {
                    salarioSemanal = ((salarioNormal*horasLegales)+(salarioExtras*horasExtras));
                    salarioMensual = 4.33*salarioSemanal;
                    app.appendConsola("Has trabajado "+horasExtras+" horas extras.\n");
                }
                app.appendConsola("Tu salario a final de mes es "+salarioMensual+" €.");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
