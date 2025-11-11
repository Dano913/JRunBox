package exercises;
import main.App;
public class T2Ejercicio3 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 13 - Asignación compuesta");
        app.setPreguntas(new String[]{
                "Introduce un valor inicial",
                "Añade un primer valor para sumar",
                "Añade un segundo valor para restar",
                "Añade un tercer valor para multiplicar",
                "Añade un cuarto valor para dividir"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        try {
            double valor = Double.parseDouble(texto);
            //Transforma a numero la respuesta.
            double resultado;
            //Crea la variable q se irá modificando.
            switch (indice) {
                //Cambia segun el índice del array.
                case 0:
                    app.setPuntuacion((int) valor);
                    //Guarda en una variable el valor obtenido de la respuesta
                    app.appendConsola("Valor inicial: " + valor + "\n");
                    break;
                case 1: // suma
                    resultado = app.getPuntuacion() + valor;
                    //Crea una variable para el resultado de la operacion
                    app.setPuntuacion((int) resultado);
                    //Guarda en una variable el resultado de la operacion
                    app.appendConsola("Suma: " + resultado + "\n");
                    break;
                case 2: // resta
                    resultado = app.getPuntuacion() - valor;
                    //Reasigna un nuevo valor porque las operaciones se concatenan
                    app.setPuntuacion((int) resultado);
                    //Guarda en una variable el resultado de la operacion
                    app.appendConsola("Resta: " + resultado + "\n");
                    break;
                case 3: // multiplicación
                    resultado = app.getPuntuacion() * valor;
                    app.setPuntuacion((int) resultado);
                    app.appendConsola("Multiplicación: " + resultado + "\n");
                    break;
                case 4: // división
                    if (valor != 0) {
                        resultado = app.getPuntuacion() / valor;
                        app.setPuntuacion((int) resultado);
                        app.appendConsola("División: " + resultado + "\n");
                    } else {
                        app.appendConsola("Error: no se puede dividir entre 0.\n");
                    }
                    break;
            }
        } catch (NumberFormatException e) {
            app.appendConsola("Error: ingresa un número válido.\n");
        }
        app.setIndicePregunta(indice + 1);
        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
        }
    }
}
