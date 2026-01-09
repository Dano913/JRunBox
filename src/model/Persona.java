package model;

public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private int telefono;
    private String dni;

    // Constructor solo con nombre y edad
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.apellido = "";
        this.telefono = 0;
        this.dni = "";
    }

    // Constructor completo
    public Persona(String nombre, String apellido, int edad, int telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Constructor para agenda sin edad
    public Persona(String nombre, String apellido, int telefono, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.dni = dni;
        this.edad = 0;
    }

    // GETTERS
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public int getEdad() { return edad; }
    public int getTelefono() { return telefono; }
    public String getDni() { return dni; }

    // SETTERS
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setTelefono(int telefono) { this.telefono = telefono; }
    public void setDni(String dni) { this.dni = dni; }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", Teléfono: " + telefono;
    }
}
