package exercises;

import main.App;
import model.Libro;
import model.Usuario;
import model.Prestamo;

import java.util.ArrayList;

public class T10Ejercicio10 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 10 – Sistema de biblioteca");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        simularBiblioteca(app);
    }

    private static void simularBiblioteca(App app) {

        // Crear libros
        Libro libro1 = new Libro("Don Quijote", "Miguel de Cervantes", "001");
        Libro libro2 = new Libro("Cien años de soledad", "Gabriel García Márquez", "002");
        Libro libro3 = new Libro("1984", "George Orwell", "003");

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro1);
        libros.add(libro2);
        libros.add(libro3);

        // Crear usuarios
        Usuario usuario1 = new Usuario("Juan Pérez", 101);
        Usuario usuario2 = new Usuario("María López", 102);

        ArrayList<Prestamo> prestamos = new ArrayList<>();

        app.appendConsola("--- BIBLIOTECA ---\n");
        mostrarLibrosDisponibles(app, libros);

        // Juan intenta tomar Don Quijote
        app.appendConsola("\nUsuario " + usuario1 + " intenta tomar prestado " + libro1.getTitulo() + "\n");
        if (libro1.prestar()) {
            Prestamo prestamo = new Prestamo(libro1, usuario1);
            prestamos.add(prestamo);
            app.appendConsola("✓ Préstamo realizado el " + prestamo.getFechaPrestamoFormateada() + "\n");
        } else {
            app.appendConsola("✗ El libro no está disponible\n");
        }

        // María intenta tomar Don Quijote
        app.appendConsola("\nUsuario " + usuario2 + " intenta tomar prestado " + libro1.getTitulo() + "\n");
        if (libro1.prestar()) {
            Prestamo prestamo = new Prestamo(libro1, usuario2);
            prestamos.add(prestamo);
            app.appendConsola("✓ Préstamo realizado el " + prestamo.getFechaPrestamoFormateada() + "\n");
        } else {
            app.appendConsola("✗ El libro no está disponible\n");
        }

        // Juan devuelve Don Quijote
        app.appendConsola("\nUsuario " + usuario1 + " devuelve " + libro1.getTitulo() + "\n");
        libro1.devolver();
        app.appendConsola("✓ Libro devuelto\n");

        // Mostrar libros disponibles
        app.appendConsola("\nLibros disponibles ahora:\n");
        mostrarLibrosDisponibles(app, libros);
    }

    private static void mostrarLibrosDisponibles(App app, ArrayList<Libro> libros) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        app.appendConsola("Libros disponibles:\n");
        for (Libro l : libros) {
            if (l.isDisponible()) {
                app.appendConsola("- " + l.toString() + "\n");
            }
        }
    }
}
