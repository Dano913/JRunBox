package exercises;

import main.App;
import utils.EjercicioUtils;

import java.util.ArrayList;

public class T12Ejercicio9 {

    private static final String[] ingredientes = {"Queso", "Jamón", "Piña", "Tomate", "Pepperoni"};
    private static final int[] precios = {10, 15, 8, 6, 12};
    private static final int MAX_INGREDIENTES = 5;

    private static ArrayList<String> pizzaSeleccionada = new ArrayList<>();
    private static int subtotal = 0;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 12 – Pizza personalizada");

        // Primer mensaje al usuario
        app.setPreguntas(new String[]{"Ingresa el número del ingrediente que quieres agregar (0 para terminar):"});
        EjercicioUtils.inicializarEntrada(app);

        mostrarMenu(app);
    }

    private static void mostrarMenu(App app) {
        app.appendConsola("Bienvenido al menú de pizzas personalizadas:\n");
        for (int i = 0; i < ingredientes.length; i++) {
            app.appendConsola((i + 1) + ". " + ingredientes[i] + " (" + precios[i] + ")\n");
        }
    }

    public static void procesarRespuesta(App app, String texto) {
        int opcion;
        try {
            opcion = Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido.\n");
            reiniciarPregunta(app);
            return;
        }

        if (opcion == 0) {
            // Terminar selección
            mostrarPizzaFinal(app);
            pizzaSeleccionada.clear();
            subtotal = 0;
            reiniciarPregunta(app);
            return;
        }

        if (opcion < 0 || opcion > ingredientes.length) {
            app.appendConsola("Opción no válida.\n");
            reiniciarPregunta(app);
            return;
        }

        String ingrediente = ingredientes[opcion - 1];

        if (pizzaSeleccionada.contains(ingrediente)) {
            app.appendConsola("Ya agregaste " + ingrediente + ". Elige otro.\n");
            reiniciarPregunta(app);
            return;
        }

        if (pizzaSeleccionada.size() >= MAX_INGREDIENTES) {
            app.appendConsola("No puedes agregar más de " + MAX_INGREDIENTES + " ingredientes.\n");
            reiniciarPregunta(app);
            return;
        }

        pizzaSeleccionada.add(ingrediente);
        subtotal += precios[opcion - 1];

        // Mostrar selección actual y subtotal
        app.appendConsola("Ingredientes actuales: " + String.join(", ", pizzaSeleccionada) + "\n");
        app.appendConsola("Subtotal: $" + subtotal + "\n");

        reiniciarPregunta(app);
    }

    private static void mostrarPizzaFinal(App app) {
        if (pizzaSeleccionada.isEmpty()) {
            app.appendConsola("No seleccionaste ningún ingrediente.\n");
        } else {
            app.appendConsola("\nTu pizza tendrá: " + String.join(", ", pizzaSeleccionada) + "\n");
            app.appendConsola("El total a pagar es: $" + subtotal + "\n");
            app.appendConsola("¡Gracias por tu pedido!\n");
        }
    }

    private static void reiniciarPregunta(App app) {
        EjercicioUtils.limpiarRespuestaYFoco(app);
        app.setPreguntas(new String[]{"Ingresa el número del ingrediente que quieres agregar (0 para terminar):"});
        EjercicioUtils.inicializarEntrada(app);
    }
}
