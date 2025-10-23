import java.util.Locale;

public class Ejercicio9 {

    // 🔹 Inicia el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "Introduzca el nombre del producto",
                "Introduzca el precio del producto",
                "Introduzca el código del producto",
                "Introduzca disponibilidad(true/false)"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }

    // 🔹 Procesa cada respuesta parcial
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        app.getRespuestasTexto()[indice] = texto;
        String[] etiquetas = {
                "Producto",
                "Precio",
                "Código",
                "Disponibilidad"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            mostrarResultadoFinal(app);
        }
    }

    // 🔹 Mostrar tabla con información formateada
    public static void mostrarResultadoFinal(App app) {
        String[] respuestas = app.getRespuestasTexto();
        try {
            String nombre = respuestas[0];
            double precio = Double.parseDouble(respuestas[1]);
            int codigo = Integer.parseInt(respuestas[2]);
            boolean disponible = Boolean.parseBoolean(respuestas[3]);
            String dispoText = disponible ? "Disponible" : "No disponible";

            // Construir encabezado
            String header = String.format("%-25s %10s %10s %15s%n", "NOMBRE", "PRECIO", "CÓDIGO", "DISPONIBILIDAD");
            header += "---------------------------------------------------------------\n";
            app.appendConsola(header);

            // Construir fila con datos
            String fila = String.format(Locale.getDefault(), "%-24s %10.2f€ %10d %15s%n",
                    nombre, precio, codigo, dispoText);
            app.appendConsola(fila);

        } catch (NumberFormatException e) {
            app.appendConsola("Error: uno de los valores numéricos no es válido.\n");
        }
    }
}
