package exercises;

import main.App;

public class T5Ejercicio7 {

    private static int cantidad = 0;   // número de calificaciones a introducir
    private static int contador = 0;   // cuántas ya se han introducido

    public static void iniciarEjercicio(App app) {
        cantidad = 0;
        contador = 0;

        app.setTituloEjercicio("Ejercicio 7 - Calcular promedio con while");
        app.setPreguntas(new String[]{"¿Cuántas calificaciones vas a introducir?"});
        app.setRespuestasTexto(new String[1]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }

    public static void procesarRespuesta(App app, String texto) {
        // Fase 0: pedir cantidad
        if (cantidad == 0) {
            try {
                cantidad = Integer.parseInt(texto);
                if (cantidad <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Por favor, introduce un número válido mayor que 0.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }

            // Preparamos array para calificaciones
            app.setRespuestasTexto(new String[cantidad]);
            contador = 0;
            app.setPreguntaLabel("Introduce la calificación 1:");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Fase 1: pedir calificaciones una a una
        try {
            double cal = Double.parseDouble(texto);
            app.getRespuestasTexto()[contador] = texto;
            contador++;
            app.appendConsola("Calificación " + contador + ": " + texto + "\n");
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        if (contador < cantidad) {
            app.setPreguntaLabel("Introduce la calificación " + (contador + 1) + ":");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            // Todas las calificaciones introducidas
            double suma = 0;
            for (String s : app.getRespuestasTexto()) {
                try {
                    suma += Double.parseDouble(s);
                } catch (NumberFormatException ignored) {}
            }
            double promedio = suma / cantidad;

            app.appendConsola("\nSuma total: " + suma);
            app.appendConsola("\nPromedio de calificaciones: " + promedio + "\n");
            app.setInputPanelVisible(false);
        }
    }
}
