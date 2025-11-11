package exercises;
import main.App;
import utils.EjercicioUtils;

public class T6Ejercicio2 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 - Compra con IVA");
        app.setPreguntas(new String[]{
                "Introduce el valor de la compra(IVA incluido)",
                "Introduce el valor del IVA(valor entero)",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Valor de compra",
                "Valor de IVA"
        };
        String[] unidades = {
                "€",
                "%"
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double compraIVA = Double.parseDouble(respuestas[0]);
                int iva = Integer.parseInt(respuestas[1]);

                double compra = (100*compraIVA)/(100+iva);
                double ivaEuro = (compra*iva)/100;


                app.appendConsola("=== Valor de la Compra sin IVA===\n");
                app.appendConsola(String.format("Compra sin IVA: %.2f€\n", compra));
                app.appendConsola(String.format("IVA en euro: %.2f€\n", ivaEuro));

            } catch (NumberFormatException e) {
                app.appendConsola("\nError: las entradas no son números válidos.\n");
            }
        }
    }
}
