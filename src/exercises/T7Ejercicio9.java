package exercises;

import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 7 - Calculadora de IMC con Clasificación");
        // Solo se mostrará esta vez
        app.setPreguntas(new String[]{
                "Introduce tu altura",
                "Introduce tu peso"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Altura",
                "Peso"
        };
        String[] unidades = {
                "metros",
                "kg"

        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            double altura = Double.parseDouble(respuestas[0]);
            double peso = Double.parseDouble(respuestas[1]);
            double IMC = peso/(altura*altura);
            int rango = 0;
            if(IMC<18.5){
                rango = 1;
            }else if(IMC>18.5&&IMC<24.9){
                rango = 2;
            }else if(IMC>25&&IMC<29.9){
                rango=3;
            }else if(IMC>=30){
                rango=4;
            }
            String rangoTexto = switch (rango) {
                case 1 -> "Bajo peso";
                case 2 -> "Peso normal";
                case 3 -> "Sobrepeso";
                case 4 -> "Obesidad";
                default -> "Rango no válido";
            };

            app.appendConsola(String.format("Tu IMC es %.2f y corresponde a: %s", IMC, rangoTexto));
        }
    }
}