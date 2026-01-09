package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Carrito {

    private Map<Producto, Integer> productos;

    public Carrito() {
        productos = new LinkedHashMap<>();
    }

    public boolean añadirProducto(Producto producto, int cantidad) {
        if (producto.getStock() >= cantidad) {
            productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
            return true;
        }
        return false;
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void finalizarCompra() {
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            entry.getKey().reducirStock(entry.getValue());
        }
        productos.clear();
    }
}
