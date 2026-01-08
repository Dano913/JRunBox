package exercises;

import main.App;
import model.Libro;

public class T10Ejercicio4 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 4 Tema 10 – Sobrecarga de constructores");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        // No necesitamos preguntas para este ejercicio
        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        // Constructor con título, autor y ISBN + páginas
        Libro libro1 = new Libro("1984", "George Orwell", "203", 328);

        // Constructor con título, autor y páginas (sin ISBN)
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", 400);

        // Constructor con título, autor y páginas
        Libro libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez", 471);

        // Mostrar resultados en consola
        app.appendConsola(
                "Libro 1: " +
                        libro1.getTitulo() + ", " +
                        libro1.getAutor() + ", " +
                        libro1.getPaginas() + " páginas\n"
        );

        app.appendConsola(
                "Libro 2: " +
                        libro2.getTitulo() + ", " +
                        libro2.getAutor() + ", " +
                        libro2.getPaginas() + " páginas\n"
        );

        app.appendConsola(
                "Libro 3: " +
                        libro3.getTitulo() + ", " +
                        libro3.getAutor() + ", " +
                        libro3.getPaginas() + " páginas\n"
        );
    }
}
