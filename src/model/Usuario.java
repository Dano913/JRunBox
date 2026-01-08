package model;

public class Usuario {

    private String nombre;
    private int numeroSocio;

    public Usuario(String nombre, int numeroSocio) {
        this.nombre = nombre;
        this.numeroSocio = numeroSocio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    @Override
    public String toString() {
        return nombre + " (Socio " + numeroSocio + ")";
    }
}
