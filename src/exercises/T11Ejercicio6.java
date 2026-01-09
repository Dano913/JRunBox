package exercises;

import main.App;

public class T11Ejercicio6 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 6 Tema 11 – Procesador de tareas");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        String[] tareas1 = {
                "Revisar correos",
                "Preparar informe",
                "Llamar al cliente URGENTE",
                "Actualizar base de datos"
        };

        String[] tareas2 = {
                "Hacer copia de seguridad",
                "Ordenar escritorio",
                "Planificar la semana"
        };

        app.appendConsola("--- LISTA DE TAREAS 1 ---\n");
        app.appendConsola(procesarTareas(tareas1) + "\n\n");

        app.appendConsola("--- LISTA DE TAREAS 2 ---\n");
        app.appendConsola(procesarTareas(tareas2) + "\n");
    }

    private static String procesarTareas(String[] tareas) {

        for (String tarea : tareas) {
            if (tarea.contains("URGENTE")) {
                return "⚠ Tarea prioritaria encontrada: " + tarea;
            }
        }

        return "✔ No hay tareas urgentes";
    }
}
