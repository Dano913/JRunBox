package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio7 {

    private static int cantidad = 0;
    private static int contador = 0;
    private static double suma = 0;

    public static void iniciarEjercicio(App app) {
        cantidad = 0;
        contador = 0;
        suma = 0;
        app.setTituloEjercicio("Ejercicio 7 Tema 5 - Calcular promedio con while");
        app.setPreguntas(new String[]{"¿Cuántas calificaciones vas a introducir?"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        if (cantidad == 0) {
            try {
                cantidad = Integer.parseInt(texto);
                if (cantidad <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                app.appendConsola("Por favor, introduce un número válido mayor que 0.\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
                return;
            }
            app.setRespuestasTexto(new String[cantidad]);
            contador = 0;
            suma = 0;
            app.setPreguntaLabel("Introduce la calificación 1:");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        try {
            double cal = Double.parseDouble(texto);
            app.getRespuestasTexto()[contador] = texto;
            contador++;
            suma += cal;
            app.appendConsola("Calificación " + contador + ": " + texto + "\n");
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }
        if (contador < cantidad) {
            app.setPreguntaLabel("Introduce la calificación " + (contador + 1) + ":");
            EjercicioUtils.limpiarRespuestaYFoco(app);
        } else {
            // Todas las calificaciones introducidas
            double promedio = suma / cantidad;
            app.appendConsola("\nSuma total: " + suma);
            app.appendConsola("\nPromedio de calificaciones: " + promedio + "\n");
            app.setInputPanelVisible(false);
        }
    }
}
