package model;

public class Contacto {

    private String nombre;
    private String apellido;
    private int telefono;
    private String dni;
    private String email;

    public Contacto(String nombre, String apellido, int telefono, String dni, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.email = email;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getTelefono() { return telefono; }
    public String getDni() { return dni; }
    public String getEmail() { return email; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public void setDni(String dni) { this.dni = dni; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Apellido: " + apellido +
                ", Teléfono: " + telefono +
                ", Email: " + email;
    }
}
