package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Locale;

public class T1Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 1 – Información de producto");
        app.setPreguntas(new String[]{
                "Introduzca el nombre del producto",
                "Introduzca el precio del producto",
                "Introduzca el código del producto",
                "Introduzca disponibilidad(true/false)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {

        int indice = app.getIndicePregunta();
        String[] etiquetas = { "Producto", "Precio", "Código", "Disponibilidad" };

        try {
            switch (indice) {
                case 0:
                    // Nombre: cualquier texto no vacío
                    if (texto.trim().isEmpty()) {
                        app.appendConsola("El nombre no puede estar vacío.\n");
                        return;
                    }
                    break;

                case 1:
                    // Precio: double
                    Double.parseDouble(texto.replace(",", "."));
                    break;

                case 2:
                    // Código: int
                    Integer.parseInt(texto);
                    break;

                case 3:
                    // Disponibilidad: true / false
                    if (!texto.equalsIgnoreCase("true") && !texto.equalsIgnoreCase("false")) {
                        app.appendConsola("Introduce 'true' o 'false'.\n");
                        return;
                    }
                    break;
            }

            // Si llega aquí, el dato es válido
            EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);
            EjercicioUtils.avanzarPregunta(app);

        } catch (NumberFormatException e) {
            app.appendConsola("Tipo de dato incorrecto. Inténtalo de nuevo.\n");
            return;
        }

        // Mostrar tabla al final
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();

            String nombre = respuestas[0];
            double precio = Double.parseDouble(respuestas[1].replace(",", "."));
            int codigo = Integer.parseInt(respuestas[2]);
            boolean disponible = Boolean.parseBoolean(respuestas[3]);
            String dispoText = disponible ? "Disponible" : "No disponible";

            app.appendConsola("\n");
            app.appendConsola(String.format("%-25s %10s %10s %15s%n",
                    "NOMBRE", "PRECIO", "CÓDIGO", "DISPONIBILIDAD"));
            app.appendConsola("---------------------------------------------------------------\n");

            app.appendConsola(String.format(Locale.getDefault(),
                    "%-24s %10.2f€ %10d %15s%n",
                    nombre, precio, codigo, dispoText));
        }
    }
}
