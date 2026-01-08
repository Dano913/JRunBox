package exercises;

import main.App;
import model.Cliente;
import model.Direccion;

public class T10Ejercicio7_1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7.1 Tema 10 – Relación entre clases");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarCliente(app);
    }

    private static void mostrarCliente(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        Direccion direccion = new Direccion("Calle Mayor 15", "Madrid", "28001");
        Cliente cliente = new Cliente("Carlos Ruiz", "carlos.ruiz@email.com", direccion);

        app.appendConsola(cliente.mostrarDatos() + "\n");
    }
}
