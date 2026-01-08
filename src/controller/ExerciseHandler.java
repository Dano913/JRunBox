package controller;

import main.App;
import java.lang.reflect.Method;

public class ExerciseHandler {

    // Configuración: número de ejercicios por tema
    private static final int[] EJERCICIOS_POR_TEMA = {10, 10, 15, 10, 10, 4, 10, 10, 10, 10};

    // Generar nombres legibles para la interfaz
    public static final String[] NOMBRES_EJERCICIOS = generarNombres(EJERCICIOS_POR_TEMA);

    /**
     * Genera nombres legibles: "T1 - Ejercicio 1", "T2 - Ejercicio 5", etc.
     */
    private static String[] generarNombres(int[] ejerciciosPorTema) {
        int total = 1; // +1 para "Seleccione Ejercicio"
        for (int n : ejerciciosPorTema) total += n;

        String[] nombres = new String[total];
        nombres[0] = "Seleccione Ejercicio";
        int index = 1;

        for (int t = 0; t < ejerciciosPorTema.length; t++) {
            int numEjercicios = ejerciciosPorTema[t];
            for (int e = 1; e <= numEjercicios; e++) {
                nombres[index++] = "T" + (t + 1) + " - Ejercicio " + e;
            }
        }

        return nombres;
    }

    /**
     * Inicia un ejercicio
     */
    public static void iniciarEjercicio(App app, String ejercicio) {
        ejecutarMetodo(app, ejercicio, "iniciarEjercicio");
    }

    /**
     * Procesa la respuesta de un ejercicio
     */
    public static void procesarRespuesta(App app, String ejercicio, String texto) {
        if (ejercicio == null) return;
        ejecutarMetodo(app, ejercicio, "procesarRespuesta", texto);
    }

    /**
     * Metodo genérico que ejecuta métodos estáticos de ejercicios usando reflexión
     */
    private static void ejecutarMetodo(App app, String ejercicio, String nombreMetodo, String... args) {
        try {
            // Convertir nombre legible en nombre de clase: "T1 - Ejercicio 1" -> "T1Ejercicio1"
            String claseEjercicio = ejercicio.replace(" - Ejercicio ", "Ejercicio");
            claseEjercicio = "exercises." + claseEjercicio; // Paquete completo

            // Obtener la clase mediante reflexión
            Class<?> clase = Class.forName(claseEjercicio);

            Method metodo;
            if (args.length > 0) {
                // procesarRespuesta(App app, String texto)
                metodo = clase.getMethod(nombreMetodo, App.class, String.class);
                metodo.invoke(null, app, args[0]); // null porque es metodo estático
            } else {
                // iniciarEjercicio(App app)
                metodo = clase.getMethod(nombreMetodo, App.class);
                metodo.invoke(null, app);
            }

        } catch (ClassNotFoundException e) {
            app.appendConsola("❌ Error: No se encontró " + ejercicio + "\n");
        } catch (NoSuchMethodException e) {
            app.appendConsola("❌ Error: El método '" + nombreMetodo + "' no existe en " + ejercicio + "\n");
        } catch (Exception e) {
            app.appendConsola("❌ Error al ejecutar " + ejercicio + ": " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
