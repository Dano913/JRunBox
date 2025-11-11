package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio10 {
    private static double saldo = 1000.0;
    private static int opcionActual = 0;
    private static boolean esperandoCantidad = false;
    private static String tipoOperacion = ""; // "retirar" o "depositar"

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 - Cajero Automático");

        // Reiniciar variables
        saldo = 1000.0;
        opcionActual = 0;
        esperandoCantidad = false;
        tipoOperacion = "";

        app.limpiarConsola();
        app.appendConsola("╔════════════════════════════════════╗\n");
        app.appendConsola("║     CAJERO AUTOMÁTICO       ║\n");
        app.appendConsola("╚════════════════════════════════════╝\n\n");
        app.appendConsola("💰 Saldo inicial: " + saldo + "€\n\n");

        mostrarMenu(app);
    }

    private static void mostrarMenu(App app) {
        app.appendConsola("━━━━━━━━━━━ MENÚ ━━━━━━━━━━━\n");
        app.appendConsola("1️⃣  Consultar saldo\n");
        app.appendConsola("2️⃣  Retirar dinero\n");
        app.appendConsola("3️⃣  Depositar dinero\n");
        app.appendConsola("4️⃣  Salir\n");
        app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        app.setPreguntas(new String[]{"Elige una opción:"});
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        // Si estamos esperando una cantidad (para retirar o depositar)
        if (esperandoCantidad) {
            procesarCantidad(app, texto);
            return;
        }

        // Si no, estamos procesando la opción del menú
        procesarOpcionMenu(app, texto);
    }

    private static void procesarOpcionMenu(App app, String texto) {
        app.appendConsola("\n> Opción elegida: " + texto + "\n\n");

        try {
            opcionActual = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Opción inválida. Introduce un número (1-4).\n\n");
            mostrarMenu(app);
            return;
        }

        // DO-WHILE implícito: el menú se muestra al menos una vez y se repite
        do {
            // SWITCH para cada opción
            switch (opcionActual) {
                case 1:
                    // Consultar saldo
                    app.appendConsola("💵 Tu saldo actual es: " + saldo + "€\n\n");
                    mostrarMenu(app);
                    return; // Sale para esperar nueva opción

                case 2:
                    // Retirar dinero
                    app.appendConsola("🏧 RETIRAR DINERO\n");
                    app.appendConsola("Saldo disponible: " + saldo + "€\n");
                    esperandoCantidad = true;
                    tipoOperacion = "retirar";

                    app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
                    app.setIndicePregunta(0);
                    app.setPreguntaLabel(app.getPreguntas()[0]);
                    app.limpiarRespuestaField();
                    app.requestFocusRespuesta();
                    return;

                case 3:
                    // Depositar dinero
                    app.appendConsola("💳 DEPOSITAR DINERO\n");
                    app.appendConsola("Saldo actual: " + saldo + "€\n");
                    esperandoCantidad = true;
                    tipoOperacion = "depositar";

                    app.setPreguntas(new String[]{"¿Cuánto deseas depositar?"});
                    app.setIndicePregunta(0);
                    app.setPreguntaLabel(app.getPreguntas()[0]);
                    app.limpiarRespuestaField();
                    app.requestFocusRespuesta();
                    return;

                case 4:
                    // Salir
                    app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                    app.appendConsola("✅ Gracias por usar el cajero.\n");
                    app.appendConsola("👋 ¡Hasta luego!\n");
                    app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                    app.setInputPanelVisible(false);
                    return;

                default:
                    app.appendConsola("❌ Opción inválida. Elige entre 1 y 4.\n\n");
                    mostrarMenu(app);
                    return;
            }
        } while (opcionActual != 4); // Repite mientras no elija salir
    }

    private static void procesarCantidad(App app, String texto) {
        app.appendConsola("> Cantidad ingresada: " + texto + "€\n\n");

        double cantidad;
        try {
            cantidad = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Cantidad inválida. Introduce un número.\n");

            app.setPreguntas(new String[]{
                    tipoOperacion.equals("retirar")
                            ? "¿Cuánto deseas retirar?"
                            : "¿Cuánto deseas depositar?"
            });
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        if (tipoOperacion.equals("retirar")) {
            procesarRetiro(app, cantidad);
        } else if (tipoOperacion.equals("depositar")) {
            procesarDeposito(app, cantidad);
        }
    }

    private static void procesarRetiro(App app, double cantidad) {
        // WHILE para validar que no retire más del saldo disponible
        while (cantidad > saldo) {
            app.appendConsola("❌ Fondos insuficientes.\n");
            app.appendConsola("💰 Tu saldo es: " + saldo + "€\n");
            app.appendConsola("🔄 Por favor, ingresa una cantidad válida.\n\n");

            app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return; // Sale y espera nueva cantidad
        }

        // Validar que sea positiva
        if (cantidad <= 0) {
            app.appendConsola("❌ La cantidad debe ser positiva.\n\n");

            app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }

        // Retiro exitoso
        saldo -= cantidad;
        app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        app.appendConsola("✅ Retiro exitoso.\n");
        app.appendConsola("💵 Has retirado: " + cantidad + "€\n");
        app.appendConsola("💰 Nuevo saldo: " + saldo + "€\n");
        app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");

        esperandoCantidad = false;
        tipoOperacion = "";
        mostrarMenu(app);
    }

    private static void procesarDeposito(App app, double cantidad) {
        // Validar que sea positiva
        while (cantidad <= 0) {
            app.appendConsola("❌ La cantidad debe ser positiva.\n");
            app.appendConsola("🔄 Por favor, ingresa una cantidad válida.\n\n");

            app.setPreguntas(new String[]{"¿Cuánto deseas depositar?"});
            app.setIndicePregunta(0);
            app.setPreguntaLabel(app.getPreguntas()[0]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return; // Sale y espera nueva cantidad
        }

        // Depósito exitoso
        saldo += cantidad;
        app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
        app.appendConsola("✅ Depósito exitoso.\n");
        app.appendConsola("💳 Has depositado: " + cantidad + "€\n");
        app.appendConsola("💰 Nuevo saldo: " + saldo + "€\n");
        app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n");

        esperandoCantidad = false;
        tipoOperacion = "";
        mostrarMenu(app);
    }
}