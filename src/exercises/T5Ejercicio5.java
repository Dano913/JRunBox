package exercises;

import main.App;
import utils.EjercicioUtils;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class T5Ejercicio5 {

    private static boolean activo = true;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 5 - Menú interactivo con do-while y switch");
        app.setPreguntas(new String[]{
                "Menú: 1 = Saludar 2 = Despedirse 3 = Ver hora actual 4 = Salir Elige una opción:"
        });
        EjercicioUtils.inicializarEntrada(app);
        app.appendConsola("Bienvenido al menú interactivo.\n");
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {"Opción seleccionada"};
        String[] unidades = {""};
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        int opcion;

        try {
            opcion = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("Por favor, introduce un número válido (1-4).\n");
            reiniciarEntrada(app);
            return;
        }

        // Simulación del do-while: se repite mientras "activo" sea true
        do {
            switch (opcion) {
                case 1:
                    app.appendConsola("👋 ¡Hola! Espero que estés teniendo un gran día.\n");
                    break;

                case 2:
                    app.appendConsola("👋 ¡Adiós! Nos vemos pronto.\n");
                    break;

                case 3:
                    LocalTime hora = LocalTime.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
                    app.appendConsola("🕒 Hora actual: " + hora.format(formato) + "\n");
                    break;

                case 4:
                    app.appendConsola("✅ Saliendo del menú... ¡Hasta luego!\n");
                    app.setInputPanelVisible(false);
                    activo = false;
                    return; // sale completamente
                default:
                    app.appendConsola("⚠️ Opción no válida. Introduce un número entre 1 y 4.\n");
                    break;
            }

            // Si no ha salido, se prepara para pedir otra opción
            reiniciarEntrada(app);
            return; // vuelve al bucle visual
        } while (activo);
    }

    private static void reiniciarEntrada(App app) {
        EjercicioUtils.inicializarEntrada(app);
    }
}
