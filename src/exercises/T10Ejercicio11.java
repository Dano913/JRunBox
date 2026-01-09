package exercises;

import main.App;
import model.*;

import java.util.Map;

public class T10Ejercicio11 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 11 Tema 10 – Tienda online");

        // No hay input
        app.setInputPanelVisible(false);
        app.setPreguntaLabel("");
        app.limpiarConsola();

        simularTienda(app);
    }

    private static void simularTienda(App app) {

        // Productos
        Producto portatil = new Producto("P001", "Portátil", 899.99, 5);
        Producto raton = new Producto("P002", "Ratón", 25.50, 10);
        Producto teclado = new Producto("P003", "Teclado", 45.99, 8);

        // Cliente
        Cliente cliente = new Cliente("Ana Martínez", "ana@email.com");

        app.appendConsola("--- TIENDA ONLINE ---\n");
        app.appendConsola("Cliente: " + cliente.getNombre() + " (" + cliente.getEmail() + ")\n\n");

        // Añadir productos
        añadir(app, cliente, portatil, 1);
        añadir(app, cliente, raton, 2);
        añadir(app, cliente, teclado, 1);

        mostrarCarrito(app, cliente);

        // Eliminar producto
        app.appendConsola("\nEliminando Ratón del carrito... ✓\n");
        cliente.getCarrito().eliminarProducto(raton);

        mostrarCarrito(app, cliente);

        // Finalizar compra
        app.appendConsola("\nFinalizando compra...\n");
        cliente.getCarrito().finalizarCompra();
        app.appendConsola("✓ Compra realizada con éxito\n");
        app.appendConsola("Stock actualizado\n");
    }

    private static void añadir(App app, Cliente cliente, Producto producto, int cantidad) {
        boolean ok = cliente.getCarrito().añadirProducto(producto, cantidad);
        app.appendConsola(
                "Añadiendo " + producto.getNombre() + " (" + producto.getPrecio() + "€) x" +
                        cantidad + " al carrito... " + (ok ? "✓" : "✗") + "\n"
        );
    }

    private static void mostrarCarrito(App app, Cliente cliente) {
        app.appendConsola("\n--- CARRITO DE COMPRA ---\n");

        int i = 1;
        for (Map.Entry<Producto, Integer> entry : cliente.getCarrito().getProductos().entrySet()) {
            Producto p = entry.getKey();
            int cantidad = entry.getValue();
            double subtotal = p.getPrecio() * cantidad;

            app.appendConsola(
                    i++ + ". " + p.getNombre() + " x" + cantidad + " - " +
                            String.format("%.2f", subtotal) + "€\n"
            );
        }

        app.appendConsola(
                "Total: " +
                        String.format("%.2f", cliente.getCarrito().calcularTotal()) + "€\n"
        );
    }
}
