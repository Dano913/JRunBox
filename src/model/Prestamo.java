package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {

    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaPrestamo;

    public Prestamo(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
    }

    public Libro getLibro() {
        return libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getFechaPrestamoFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaPrestamo.format(formatter);
    }
}
