package exercises;

import main.App;
import model.Estudiante;

public class T10Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 10 – Encapsulación");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        Estudiante estudiante = new Estudiante("Laura Fernández", 21);

        app.appendConsola("Estudiante: " + estudiante.getNombre() + "\n");

        asignarNota(app, estudiante, 8.5);
        asignarNota(app, estudiante, 12);
        asignarNota(app, estudiante, -3);
    }

    private static void asignarNota(App app, Estudiante estudiante, double nota) {

        app.appendConsola("\nAsignando nota " + nota + ": ");

        if (estudiante.setNota(nota)) {
            app.appendConsola("Correcto\n");
        } else {
            app.appendConsola("Error - La nota debe estar entre 0 y 10\n");
        }

        app.appendConsola("Nota actual: " + estudiante.getNota() + "\n");
    }
}
