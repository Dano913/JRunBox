package exercises;
import main.App;

public class T4Ejercicio8 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 43 - Contar numeros pares e impares");
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
                int num1 = Integer.parseInt(respuestas[0]);
                String textoSuma = String.format("Recorriendo números del 1 al %d:\n", num1);
                int par = 0;
                int impar = 0;
                int contadorLinea = 0;
                for (int i=1; i<=num1; i++){
                    textoSuma += i + " ";
                    contadorLinea++;
                    if(i%2==0){
                        par++;
                    }else{
                        impar++;
                    }
                    if (contadorLinea == 20) { // cada 20 números, salto de línea
                        textoSuma += "\n";
                        contadorLinea = 0;
                    }
                }

                textoSuma += String.format("\nCantidad de pares: %d", par);
                textoSuma += String.format("\nCantidad de impares: %d", impar);

                app.appendConsola(textoSuma + "\n");
                app.appendConsola("------------------------------");
                int contadorPrimos = 0;
                int contadorLinea2 = 0;
                String listaPrimos = "";
                for (int i = 2; i <= num1; i++) {
                    boolean esPrimo = true;

                    for (int j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            esPrimo = false;
                            break;
                        }
                    }

                    if (esPrimo) {
                        contadorPrimos++;
                        listaPrimos += String.format("%-4d", i); // espaciado fijo
                        contadorLinea2++;

                        if (contadorLinea2 == 20) { // cada 20 números, salto de línea
                            listaPrimos += "\n";
                            contadorLinea2 = 0;
                        }
                    }
                }
                app.appendConsola(String.format("\nNúmeros primos del 1 al %d:\n%s\n", num1, listaPrimos.trim()));
                app.appendConsola(String.format("Total de números primos: %d\n", contadorPrimos));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
