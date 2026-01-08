package model;

public class Libro {

    private String titulo;
    private String autor;
    private int paginas;
    private String ISBN;
    private boolean disponible;

    // Constructor sin parámetros (valores por defecto)
    public Libro(String number, String georgeOrwell, String id) {
        this.titulo = "Sin título";
        this.autor = "Autor desconocido";
        this.paginas = 0;
        this.ISBN = "000";
        this.disponible = true;
    }

    // Constructor con título, autor, ISBN y páginas opcionales
    public Libro(String titulo, String autor, String ISBN, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.paginas = paginas;
        this.disponible = true;
    }

    // Constructor con todos los parámetros: título, autor, páginas (sin ISBN)
    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.ISBN = "000";
        this.disponible = true;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // Métodos para prestar y devolver
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }

    public void devolver() {
        disponible = true;
    }

    @Override
    public String toString() {
        return titulo + " (" + autor + ") ISBN: " + ISBN;
    }
}
