package exercises;
import main.App;

public class T4Ejercicio7 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 42 - Suma de números con for");
        app.setPreguntas(new String[]{
                "Introduce un número"
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
                "Número"

        };
        String[] unidades = {
                ""
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
                int num1 = Integer.parseInt(respuestas[0]); // * Guardo el número que he ingresado
                String textoSuma = "Sumando: ";            // ! Creo la frase de mi respuesta. "Sumando:..."
                int suma = 0;                             // ? Inicializa la variable suma que calculará la suma total.
                for (int i=1; i<=num1; i++){             // * El bucle se ejecuta hasta el número ingresado
                    textoSuma += i;                     // ! Añade los números que va registrando "Sumando: 1 + 2 + etc..."
                    suma += i;                         // ? Irá sumando el número registrado en cada vuelta a la suma total.
                    if(i !=num1){                     // ! Si i no es igual a mi número ingresado, continuará construyendo la frase con otro "+".
                        textoSuma += " + ";
                    }
                }
                app.appendConsola(textoSuma);   // ! Imprimo la frase para que se sepa que números estoy sumando
                app.appendConsola(String.format("\nLa suma de los numeros del 1 al %d es: %d", num1, suma)); // ? Imprimo la suma total
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
