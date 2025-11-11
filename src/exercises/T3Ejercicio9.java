package exercises;
import main.App;

public class T3Ejercicio9 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 29 - Calculadora ICM");
        app.setPreguntas(new String[]{
                "Introduce tu peso en kilogramos",
                "Introduce tu altura en metros"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Peso",
                "Altura"
        };
        String[] unidades = {
                "kg",
                "m"
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
                double peso = Double.parseDouble(respuestas[0]);
                double altura = Double.parseDouble(respuestas[1]);
                double IMC = peso / (altura*altura);
                if(IMC<18.5) {
                    app.appendConsola("Tienes un IMC de"+IMC+" puntos. Estás por debajo del peso normal.");
                } else if(IMC>24.9){
                    app.appendConsola("Tienes un IMC de"+IMC+" puntos. Estás por encima del peso normal.");
                } else {
                    app.appendConsola("Tienes un IMC de"+IMC+" puntos. Estás en tu peso ideal.");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
