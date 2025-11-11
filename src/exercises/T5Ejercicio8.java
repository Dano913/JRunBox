package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio8 {
    private static boolean primeraEjecucion = true;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 53 - Validación de edad con do-while");
        app.setPreguntas(new String[]{"Introduce tu edad:"});
        primeraEjecucion = true; // Reiniciar flag para simular do-while
        EjercicioUtils.inicializarEntrada(app);
        app.appendConsola("=== Sistema de Validación de Edad ===\n");
        app.appendConsola("(Rango válido: 0 - 120 años)\n\n");
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Edad introducida"};
        String[] unidades = {"años"};

        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);

        int edad = -1;
        boolean valido = false;

        // Simular do-while: PRIMERO ejecuta el bloque
        do {
            try {
                edad = Integer.parseInt(texto);

                if (edad >= 0 && edad <= 120) {
                    valido = true;
                } else {
                    app.appendConsola("❌ Edad no válida. Debe estar entre 0 y 120.\n");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("❌ Edad no válida. Introduce un número entero.\n");
            }

            // Si no es válido, preparar para nueva entrada
            if (!valido) {
                app.appendConsola("Por favor, intenta de nuevo.\n\n");
                app.setIndicePregunta(0);
                app.setPreguntaLabel(app.getPreguntas()[0]);
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return; // Sale del método para esperar nueva entrada
            }

            // CONDICIÓN del while: se repite mientras NO sea válido
            // Pero como usamos return arriba, esto nunca itera en el mismo método

        } while (!valido); // Esta condición se evalúa DESPUÉS del bloque

        // Solo llega aquí si valido == true
        app.appendConsola("\n✅ ¡Edad válida registrada: " + edad + " años!\n");

        // Clasificación
        if (edad < 18) {
            app.appendConsola("📋 Categoría: Menor de edad\n");
        } else if (edad < 65) {
            app.appendConsola("📋 Categoría: Adulto\n");
        } else {
            app.appendConsola("📋 Categoría: Adulto mayor\n");
        }

        app.setInputPanelVisible(false);
    }
}