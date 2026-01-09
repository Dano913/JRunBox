package model;

public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor completo (tienda online)
    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor simple (ejercicios anteriores)
    public Producto(String nombre, double precio, int cantidad) {
        this.codigo = "000";
        this.nombre = nombre;
        this.precio = precio;
        this.stock = cantidad;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    // Gestión de stock
    public boolean reducirStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    public void aumentarStock(int cantidad) {
        stock += cantidad;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + String.format("%.2f", precio) + "€" +
                ", stock=" + stock +
                '}';
    }
}
