package model;

public class Estudiante {

    private String nombre;
    private int edad;
    private double nota;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nota = 0.0; // valor inicial
    }

    // Getter
    public double getNota() {
        return nota;
    }

    // Setter con validación
    public boolean setNota(double nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
            return true;
        } else {
            return false;
        }
    }

    // Getters adicionales
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
