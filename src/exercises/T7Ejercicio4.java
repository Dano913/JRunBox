package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class T7Ejercicio4 {

    public enum categoriaPlato {
        ENTRADA,
        PRINCIPAL,
        POSTRE,
        BEBIDA
    }

    private static final String[] ENTRADAS = {"Ensalada", "Sopa", "Croquetas"};
    private static final String[] PRINCIPALES = {"Pollo al curry", "Lasaña", "Paella"};
    private static final String[] POSTRES = {"Flan", "Tarta de queso", "Helado"};
    private static final String[] BEBIDAS = {"Agua", "Refresco", "Cerveza"};

    private static String[] platosActuales;
    private static boolean esperandoCategoria = true;
    private static categoriaPlato categoriaActual;
    private static final Map<categoriaPlato, ArrayList<String>> elecciones = new HashMap<>();

    public static void iniciarEjercicio(App app) {
        elecciones.clear();
        esperandoCategoria = true;
        app.setTituloEjercicio("Ejercicio 4 Tema 7 - Menú de restaurante");
        preguntarCategoria(app);
    }

    private static void preguntarCategoria(App app) {
        // Preguntar todas las categorías y mostrar elecciones previas
        StringBuilder sb = new StringBuilder("Introduce la categoría que quieras elegir o modificar:\n");
        for (categoriaPlato cat : categoriaPlato.values()) {
            sb.append("- ").append(cat.name());
            if (elecciones.containsKey(cat)) {
                sb.append(" (ya elegido: ").append(String.join(", ", elecciones.get(cat))).append(")");
            }
            sb.append("\n");
        }
        sb.append("Deja vacío para terminar.");

        app.setPreguntas(new String[]{sb.toString()});
        EjercicioUtils.inicializarEntrada(app);
        esperandoCategoria = true;
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Respuesta"};
        String[] unidades = {""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);

        if (texto.trim().isEmpty()) {
            // Mostrar resumen completo al terminar
            if (elecciones.isEmpty()) {
                app.appendConsola("No se han realizado elecciones.\n");
            } else {
                app.appendConsola("✅ Resumen de todas las elecciones:\n");
                for (categoriaPlato cat : categoriaPlato.values()) {
                    ArrayList<String> platos = elecciones.get(cat);
                    if (platos != null && !platos.isEmpty()) {
                        app.appendConsola(cat.name() + ": " + String.join(", ", platos) + "\n");
                    } else {
                        app.appendConsola(cat.name() + ": no elegido\n");
                    }
                }
            }
            return;
        }

        if (esperandoCategoria) {
            // Usuario introduce categoría
            // Usuario introduce categoría
            String categoriaTexto = texto.trim().toUpperCase();
            try {
                categoriaActual = categoriaPlato.valueOf(categoriaTexto);

                // Obtener array de platos según categoría
                platosActuales = switch (categoriaActual) {
                    case ENTRADA -> ENTRADAS;
                    case PRINCIPAL -> PRINCIPALES;
                    case POSTRE -> POSTRES;
                    case BEBIDA -> BEBIDAS;
                };

                // Mostrar solo los platos disponibles, no el historial
                app.appendConsola("Categoría elegida: " + categoriaActual.name() + "\n");
                app.appendConsola("Platos disponibles:\n");
                for (String plato : platosActuales) {
                    app.appendConsola("- " + plato + "\n");
                }

                // Pedir entrada del plato
                app.setPreguntas(new String[]{"Escribe el nombre del plato que quieres para " + categoriaActual.name()});
                EjercicioUtils.inicializarEntrada(app);
                esperandoCategoria = false;

            } catch (IllegalArgumentException e) {
                app.appendConsola("❌ Categoría no válida. Debes escribir ENTRADA, PRINCIPAL, POSTRE o BEBIDA.\n");
            }

        } else {
            // Usuario introduce plato
            String textoPlato = texto.trim();
            String platoElegido = null;

            for (String plato : platosActuales) {
                if (plato.equalsIgnoreCase(textoPlato)) {
                    platoElegido = plato;
                    break;
                }
            }

            if (platoElegido == null) {
                app.appendConsola("❌ Plato no válido. Escribe exactamente uno de los mostrados.\n");
                String pregunta = "Escribe el nombre del plato que quieres para " + categoriaActual.name() + ":\n" +
                        "- " + platosActuales[0] + "\n" +
                        "- " + platosActuales[1] + "\n" +
                        "- " + platosActuales[2];
                app.setPreguntas(new String[]{pregunta});
                EjercicioUtils.inicializarEntrada(app);
                return;
            }

            // Guardar elección sin sobrescribir anteriores
            elecciones.computeIfAbsent(categoriaActual, k -> new ArrayList<>()).add(platoElegido);

            // Mostrar la elección acumulada
            app.appendConsola("✅ Has elegido para " + categoriaActual.name() + ": " + platoElegido + "\n");
            app.appendConsola("Tus elecciones actuales:\n");
            for (Map.Entry<categoriaPlato, ArrayList<String>> entry : elecciones.entrySet()) {
                app.appendConsola(entry.getKey().name() + ": " + String.join(", ", entry.getValue()) + "\n");
            }

            // Si todas las categorías tienen al menos un plato, avisar que se puede modificar
            if (elecciones.size() == categoriaPlato.values().length) {
                app.appendConsola("Has elegido todos los platos. Si quieres modificar alguna categoría, elige de nuevo la categoría. Deja vacío para terminar.\n");
            }

            preguntarCategoria(app); // siguiente categoría o modificación
        }
    }
}
