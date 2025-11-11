package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Locale;

public class T1Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 – Información de producto");
        app.setPreguntas(new String[]{
                "Introduzca el nombre del producto",
                "Introduzca el precio del producto",
                "Introduzca el código del producto",
                "Introduzca disponibilidad(true/false)"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = { "Producto", "Precio", "Código", "Disponibilidad" };

        // Guardar respuesta y mostrar etiqueta
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);
        EjercicioUtils.avanzarPregunta(app);

        // Si se completaron todas las respuestas, mostrar tabla formateada
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            try {
                String nombre = respuestas[0];
                double precio = Double.parseDouble(respuestas[1]);
                int codigo = Integer.parseInt(respuestas[2]);
                boolean disponible = Boolean.parseBoolean(respuestas[3]);
                String dispoText = disponible ? "Disponible" : "No disponible";

                // Encabezado
                String header = String.format("%-25s %10s %10s %15s%n", "NOMBRE", "PRECIO", "CÓDIGO", "DISPONIBILIDAD");
                header += "---------------------------------------------------------------\n";
                app.appendConsola(header);

                // Fila con datos
                String fila = String.format(Locale.getDefault(), "%-24s %10.2f€ %10d %15s%n",
                        nombre, precio, codigo, dispoText);
                app.appendConsola(fila);

            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores numéricos no es válido.\n");
            }
        }
    }
}
