package exercises;

import main.App;
import model.Producto;

public class T10Ejercicio7 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 Tema 10 – Método toString()");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarProductos(app);
    }

    private static void mostrarProductos(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        Producto p1 = new Producto("Teclado", 45.99, 10);
        Producto p2 = new Producto("Ratón", 25.50, 25);
        Producto p3 = new Producto("Monitor", 299.99, 5);

        // Mostramos los productos usando toString() automáticamente
        app.appendConsola(p1.toString() + "\n");
        app.appendConsola(p2.toString() + "\n");
        app.appendConsola(p3.toString() + "\n");
    }
}
