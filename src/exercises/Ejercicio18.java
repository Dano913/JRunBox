package exercises;
import main.App;
public class Ejercicio18 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 18 - Operaciones combinadas");
        app.setPreguntas(new String[]{
                "Introudce el primer número",
                "Introduce el segundo número",
                "Introduce el tercer número"
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
                "Primer número",
                "Segundo número",
                "Tercer número"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                double num1 = Double.parseDouble(respuestas[0]);
                double num2 = Double.parseDouble(respuestas[1]);
                double num3 = Double.parseDouble(respuestas[2]);
                double suma = num1+num2+num3;
                double promedio = (num1+num2+num3)/3;
                double calculo = (num1*num2)/num3;
                app.appendConsola("La suma de los 3 números es: "+suma+"\n");
                app.appendConsola("El promedio de los 3 números es: "+promedio+"\n");
                app.appendConsola("El resultado del cálculo es: "+calculo+"\n");
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
