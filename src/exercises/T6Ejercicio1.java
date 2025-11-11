package exercises;
import main.App;
import utils.EjercicioUtils;

public class T6Ejercicio1 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 - Cobro de boadillos y bebidas");
        app.setPreguntas(new String[]{
                "Introduce cuantas bebídas vas a pedir",
                "Introduce cuantos bocatas vas a pedir",
                "Introduce el precio por bebida",
                "Introduce el precio por bocata",
                "Introduce cuantos alumnos sois",
        });
        EjercicioUtils.inicializarEntrada(app);
    }
    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Nº de Bebidas",
                "Nº de Bocatas",
                "Precio por bebida",
                "Precio por bocata",
                "Nº de Alumnos"
        };
        String[] unidades = {
                "",
                "",
                "€",
                "€",
                ""
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                int numBoc = Integer.parseInt(respuestas[0]);
                int numBeb = Integer.parseInt(respuestas[1]);
                double priceBoc = Double.parseDouble(respuestas[2]);
                double priceBeb = Double.parseDouble(respuestas[3]);
                int numAlumn = Integer.parseInt(respuestas[4]);

                double totalBoc = numBoc*priceBoc;
                double totalBeb = numBeb*priceBeb;
                double totalCompra = totalBoc+totalBeb;
                double cantAlumn = totalCompra/numAlumn;


                app.appendConsola("=== Resumen de la Compra ===\n");
                app.appendConsola(String.format("Total Bocadillos: %.2f€\n", totalBoc));
                app.appendConsola(String.format("Total Bebidas: %.2f€\n", totalBeb));
                app.appendConsola(String.format("Total Compra: %.2f€\n", totalCompra));
                app.appendConsola(String.format("Cantidad por Alumno: %.2f€\n", cantAlumn));

            } catch (NumberFormatException e) {
                app.appendConsola("\nError: las entradas no son números válidos.\n");
            }
        }
    }
}
