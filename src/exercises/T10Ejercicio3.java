package exercises;

import main.App;
import utils.EjercicioUtils;
import model.Rectangulo;

public class T10Ejercicio3 {

    private static Rectangulo rectangulo;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 Tema 10 – Métodos de instancia");

        app.setPreguntas(new String[]{
                "Ingresa la base del rectángulo",
                "Ingresa la altura del rectángulo"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        EjercicioUtils.avanzarPregunta(app);

        // Cuando ya se han introducido base y altura
        if (indice == 1) {
            double base = Double.parseDouble(app.getRespuestasTexto()[0]);
            double altura = Double.parseDouble(app.getRespuestasTexto()[1]);

            rectangulo = new Rectangulo(base, altura);

            app.appendConsola(
                    "Rectángulo con base " + rectangulo.getBase() +
                            " y altura " + rectangulo.getAltura() + "\n"
            );

            app.appendConsola("Área: " + rectangulo.calcularArea() + "\n");
            app.appendConsola("Perímetro: " + rectangulo.calcularPerimetro() + "\n");
        }
    }
}
