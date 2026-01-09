package exercises;

import main.App;

public class T11Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 11 – Procesamiento de pedidos");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        app.limpiarConsola();
        app.setPreguntaLabel("");

        String[] productos = {"Portátil", "Ratón", "Teclado", "Monitor", "USB"};
        int[] cantidades = {1, 2, 1, 3, 0}; // El último se debe ignorar
        double[] precios = {899.99, 25.50, 45.99, 299.99, 10.0};

        procesarPedidos(app, productos, cantidades, precios);
    }

    // Verifica si hay suficiente stock
    private static boolean verificarStock(int cantidad, int stock) {
        if (cantidad > stock) {
            return false; // Sale inmediatamente si no hay stock suficiente
        }
        return true;
    }

    // Calcula descuento por cantidad
    private static double calcularDescuento(double precio, int cantidad) {
        double total = precio * cantidad;

        if (cantidad >= 5) {
            total *= 0.9; // 10% de descuento
        } else if (cantidad >= 3) {
            total *= 0.95; // 5% de descuento
        }

        return total;
    }

    // Procesa los pedidos
    private static void procesarPedidos(App app, String[] productos, int[] cantidades, double[] precios) {
        double totalPedido = 0;
        int stockMax = 10; // stock máximo disponible por producto

        app.appendConsola("--- PROCESAMIENTO DE PEDIDOS ---\n");

        for (int i = 0; i < productos.length; i++) {
            String producto = productos[i];
            int cantidad = cantidades[i];
            double precio = precios[i];

            // Saltar productos con cantidad 0
            if (cantidad == 0) {
                app.appendConsola("Saltando " + producto + " porque la cantidad es 0.\n");
                continue;
            }

            // Verificar stock
            if (!verificarStock(cantidad, stockMax)) {
                app.appendConsola("No hay stock suficiente de " + producto + ".\n");
                continue;
            }

            double subtotal = calcularDescuento(precio, cantidad);
            totalPedido += subtotal;

            app.appendConsola("Añadiendo " + producto + " x" + cantidad + " - " + String.format("%.2f", subtotal) + "€\n");

            // Si el total supera 1000€, detener procesamiento
            if (totalPedido > 1000) {
                app.appendConsola("⚠ Límite de pedido superado: " + String.format("%.2f", totalPedido) + "€\n");
                break;
            }
        }

        app.appendConsola("\nTotal final del pedido: " + String.format("%.2f", totalPedido) + "€\n");
    }
}
