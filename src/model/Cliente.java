package model;

public class Cliente {

    private String nombre;
    private String email;
    private Direccion direccion; // Composición
    private Carrito carrito;     // Tienda online

    // Constructor completo (dirección + carrito)
    public Cliente(String nombre, String email, Direccion direccion) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.carrito = new Carrito();
    }

    // Constructor simple (sin dirección, ejercicios previos)
    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = null;
        this.carrito = new Carrito();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public String mostrarDatos() {
        String datos = "Cliente: " + nombre + "\n" +
                "Email: " + email + "\n";

        if (direccion != null) {
            datos += "Dirección: " + direccion.toString();
        } else {
            datos += "Dirección: No especificada";
        }

        return datos;
    }

    @Override
    public String toString() {
        return nombre + " (" + email + ")";
    }
}
