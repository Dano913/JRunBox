package exercises;

import main.App;
import model.Contacto;

public class T12Ejercicio2 {

    private static Contacto[] agenda = new Contacto[100];
    private static int totalContactos = 0;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 12 – Agenda con validación de email");
        app.setInputPanelVisible(false); // No necesitamos entrada real
        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        app.limpiarConsola();
        app.setPreguntaLabel("");

        // --- SIMULACIÓN DEL MENÚ ---

        // Opción 1: Agregar María
        app.appendConsola("--- MENÚ AGENDA ---\n");
        app.appendConsola("1. Agregar persona\n2. Buscar persona\n3. Borrar persona\n4. Listar personas\n5. Salir\n");
        app.appendConsola("Seleccione una opción: 1\n\n");

        agregarContacto(app, new Contacto(
                "María", "García", 654321987, "87654321B", "maria.garcia@example.com"
        ));

        // Opción 1: Agregar Juan con email duplicado
        app.appendConsola("\n--- MENÚ AGENDA ---\n");
        app.appendConsola("1. Agregar persona\n2. Buscar persona\n3. Borrar persona\n4. Listar personas\n5. Salir\n");
        app.appendConsola("Seleccione una opción: 1\n\n");

        agregarContacto(app, new Contacto(
                "Juan", "López", 611222333, "11223344C", "maria.garcia@example.com" // duplicado
        ));

        // Opción 1: Agregar Luis
        app.appendConsola("\n--- MENÚ AGENDA ---\n");
        app.appendConsola("1. Agregar persona\n2. Buscar persona\n3. Borrar persona\n4. Listar personas\n5. Salir\n");
        app.appendConsola("Seleccione una opción: 1\n\n");

        agregarContacto(app, new Contacto(
                "Luis", "Martínez", 600112233, "11223344D", "luis.martinez@example.com"
        ));

        // Opción 2: Buscar María por DNI
        app.appendConsola("\n--- MENÚ AGENDA ---\n");
        app.appendConsola("1. Agregar persona\n2. Buscar persona\n3. Borrar persona\n4. Listar personas\n5. Salir\n");
        app.appendConsola("Seleccione una opción: 2\n\n");

        buscarContacto(app, "87654321B");

        // Opción 4: Listar contactos
        app.appendConsola("\n--- MENÚ AGENDA ---\n");
        app.appendConsola("1. Agregar persona\n2. Buscar persona\n3. Borrar persona\n4. Listar personas\n5. Salir\n");
        app.appendConsola("Seleccione una opción: 4\n\n");

        listarContactos(app);
    }

    private static void agregarContacto(App app, Contacto contacto) {
        app.appendConsola("Introduce el nombre: " + contacto.getNombre() + "\n");
        app.appendConsola("Introduce el apellido: " + contacto.getApellido() + "\n");
        app.appendConsola("Introduce el teléfono: " + contacto.getTelefono() + "\n");
        app.appendConsola("Introduce el DNI: " + contacto.getDni() + "\n");
        app.appendConsola("Introduce el email: " + contacto.getEmail() + "\n");

        if (existeEmail(contacto.getEmail())) {
            app.appendConsola("ERROR: Ya existe un contacto con ese email.\n");
            return;
        }

        agenda[totalContactos++] = contacto;
        app.appendConsola("Persona agregada correctamente.\n");
    }

    private static boolean existeEmail(String email) {
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i] != null && agenda[i].getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    private static void buscarContacto(App app, String dni) {
        app.appendConsola("Introduce el DNI a buscar: " + dni + "\n");
        Contacto encontrado = null;
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i] != null && agenda[i].getDni().equalsIgnoreCase(dni)) {
                encontrado = agenda[i];
                break;
            }
        }

        if (encontrado != null) {
            app.appendConsola("Persona encontrada:\n" + encontrado.toString() + "\n");
        } else {
            app.appendConsola("No se encontró ninguna persona con ese DNI.\n");
        }
    }

    private static void listarContactos(App app) {
        app.appendConsola("Lista de personas:\n");
        boolean hayContactos = false;
        for (int i = 0; i < totalContactos; i++) {
            if (agenda[i] != null) {
                app.appendConsola(agenda[i].toString() + "\n");
                hayContactos = true;
            }
        }
        if (!hayContactos) {
            app.appendConsola("No hay contactos en la agenda.\n");
        }
    }
}
