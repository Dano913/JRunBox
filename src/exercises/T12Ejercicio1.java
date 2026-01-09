package exercises;

import main.App;
import model.Persona;

public class T12Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 12 – Agenda de personas");
        app.setInputPanelVisible(false); // No hay input real
        mostrarSimulacion(app);
    }

    private static void mostrarSimulacion(App app) {
        app.limpiarConsola();
        app.setPreguntaLabel("");

        // Inicializar agenda vacía
        Persona[] agenda = new Persona[0];

        // --- OPCIÓN 1: Agregar persona ---
        app.appendConsola("--- MENÚ AGENDA ---\n" +
                "1. Agregar persona\n" +
                "2. Buscar persona\n" +
                "3. Borrar persona\n" +
                "4. Listar personas\n" +
                "5. Salir\n" +
                "Seleccione una opción: 1\n\n");

        // Simulamos inputs
        String nombre = "Carlos";
        String apellido = "Pérez";
        int telefono = 612345678;
        String dni = "12345678A";

        app.appendConsola("Introduce el nombre: " + nombre + "\n");
        app.appendConsola("Introduce el apellido: " + apellido + "\n");
        app.appendConsola("Introduce el teléfono: " + telefono + "\n");
        app.appendConsola("Introduce el DNI: " + dni + "\n");

        // Agregar persona
        agenda = agregarPersona(agenda, new Persona(nombre, apellido, telefono, dni));
        app.appendConsola("Persona agregada correctamente.\n\n");

        // --- OPCIÓN 2: Buscar persona ---
        app.appendConsola("--- MENÚ AGENDA ---\n" +
                "1. Agregar persona\n" +
                "2. Buscar persona\n" +
                "3. Borrar persona\n" +
                "4. Listar personas\n" +
                "5. Salir\n" +
                "Seleccione una opción: 2\n\n");

        String dniBusqueda = "12345678A";
        app.appendConsola("Introduce el DNI a buscar: " + dniBusqueda + "\n");

        Persona encontrada = buscarPorDNI(agenda, dniBusqueda);
        if (encontrada != null) {
            app.appendConsola("Persona encontrada:\n" + encontrada.toString() + "\n\n");
        } else {
            app.appendConsola("No se encontró ninguna persona con ese DNI.\n\n");
        }

        // --- OPCIÓN 4: Listar personas ---
        app.appendConsola("--- MENÚ AGENDA ---\n" +
                "1. Agregar persona\n" +
                "2. Buscar persona\n" +
                "3. Borrar persona\n" +
                "4. Listar personas\n" +
                "5. Salir\n" +
                "Seleccione una opción: 4\n\n");

        app.appendConsola("Lista de personas:\n");
        listarPersonas(app, agenda);
        app.appendConsola("\n");

        // --- OPCIÓN 3: Borrar persona ---
        app.appendConsola("--- MENÚ AGENDA ---\n" +
                "1. Agregar persona\n" +
                "2. Buscar persona\n" +
                "3. Borrar persona\n" +
                "4. Listar personas\n" +
                "5. Salir\n" +
                "Seleccione una opción: 3\n\n");

        String dniBorrar = "12345678A";
        app.appendConsola("Introduce el DNI a borrar: " + dniBorrar + "\n");

        agenda = borrarPorDNI(agenda, dniBorrar);
        app.appendConsola("Persona eliminada correctamente.\n\n");

        // --- OPCIÓN 4: Listar personas nuevamente ---
        app.appendConsola("--- MENÚ AGENDA ---\n" +
                "1. Agregar persona\n" +
                "2. Buscar persona\n" +
                "3. Borrar persona\n" +
                "4. Listar personas\n" +
                "5. Salir\n" +
                "Seleccione una opción: 4\n\n");

        if (agenda.length == 0) {
            app.appendConsola("No hay personas en la agenda.\n");
        } else {
            app.appendConsola("Lista de personas:\n");
            listarPersonas(app, agenda);
        }
    }

    // MÉTODOS AUXILIARES
    private static Persona[] agregarPersona(Persona[] agenda, Persona nueva) {
        Persona[] nuevaAgenda = new Persona[agenda.length + 1];
        System.arraycopy(agenda, 0, nuevaAgenda, 0, agenda.length);
        nuevaAgenda[agenda.length] = nueva;
        return nuevaAgenda;
    }

    private static Persona buscarPorDNI(Persona[] agenda, String dni) {
        for (Persona persona : agenda) {
            if (persona.getDni().equalsIgnoreCase(dni)) {
                return persona;
            }
        }
        return null;
    }

    private static Persona[] borrarPorDNI(Persona[] agenda, String dni) {
        int count = 0;
        for (Persona persona : agenda) {
            if (!persona.getDni().equalsIgnoreCase(dni)) count++;
        }
        Persona[] nuevaAgenda = new Persona[count];
        int index = 0;
        for (Persona persona : agenda) {
            if (!persona.getDni().equalsIgnoreCase(dni)) {
                nuevaAgenda[index++] = persona;
            }
        }
        return nuevaAgenda;
    }

    private static void listarPersonas(App app, Persona[] agenda) {
        for (Persona persona : agenda) {
            app.appendConsola(persona.toString() + "\n");
        }
    }
}
