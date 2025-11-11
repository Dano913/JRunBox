package exercises;
import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio2 {
    public enum Moneda {
        USD,
        GBP,
        JPY,
        CHF,
        SEK,
        PLN,
        MXN,
        CNY,
        BRL,
        TRY
    }

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 - Conversor de moneda");
        app.setPreguntas(new String[]{
                "Introduce una cantidad en euros",
                "Elige la moneda de destino (USD, GBP, JPY, CHF, SEK, PLN, MXN, CNY, BRL, TRY)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Cantidad",
                "Moneda"
        };
        String[] unidades = {
                "€",
                ""
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                double euros = Double.parseDouble(respuestas[0]);
                Moneda monedaDestino = Moneda.valueOf(respuestas[1].toUpperCase());

                double resultado = switch (monedaDestino) {
                    case USD -> euros * 1.1575;
                    case GBP -> euros * 0.8804;
                    case JPY -> euros * 178.46;
                    case CHF -> euros * 0.9278;
                    case SEK -> euros * 10.973;
                    case PLN -> euros * 4.230;
                    case MXN -> euros * 21.2582;
                    case CNY -> euros * 8.2377;
                    case BRL -> euros * 6.1196;
                    case TRY -> euros * 48.8867;
                };

                app.appendConsola(String.format("%.2f € equivalen a %.2f %s\n", euros, resultado, monedaDestino));

            } catch (NumberFormatException e) {
                app.appendConsola("\nError: No has introducido un número válido.\n");
            } catch (IllegalArgumentException e) {
                app.appendConsola("\nError: No has introducido una moneda válida.\n");
            }
        }
    }
}
