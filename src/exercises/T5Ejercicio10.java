package exercises;

import main.App;
import utils.EjercicioUtils;

public class T5Ejercicio10 {
    private static double saldo = 1000.0;
    private static int opcionActual = 0;
    private static boolean esperandoCantidad = false;
    private static String tipoOperacion = "";

    // Inicializa el cajero, limpia consola y muestra el menú principal
    public static void iniciarEjercicio(App app) {
        saldo = 1000.0;
        opcionActual = 0;
        esperandoCantidad = false;
        tipoOperacion = "";
        app.setTituloEjercicio("Ejercicio 10 Tema 5 - Cajero automático");
        app.limpiarConsola();
        app.appendConsola("╔════════════════════════════════════╗\n");
        app.appendConsola("║     CAJERO AUTOMÁTICO       ║\n");
        app.appendConsola("╚════════════════════════════════════╝\n\n");
        app.appendConsola("💰 Saldo inicial: " + saldo + "€\n\n");

        mostrarMenu(app);
    }

    // Muestra el menú de opciones al usuario
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

    // Procesa la respuesta del usuario según si está el menú o esperando cantidad
    public static void procesarRespuesta(App app, String texto) {
        if (esperandoCantidad) {
            procesarCantidad(app, texto);
        } else {
            procesarOpcionMenu(app, texto);
        }
    }

    // Procesa la opción elegida en el menú
    private static void procesarOpcionMenu(App app, String texto) {
        app.appendConsola("\n> Opción elegida: " + texto + "\n\n");

        try {
            opcionActual = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Opción inválida. Introduce un número (1-4).\n\n");
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        switch (opcionActual) {
            case 1:
                app.appendConsola("💵 Tu saldo actual es: " + saldo + "€\n\n");
                mostrarMenu(app);
                break;
            case 2:
                app.appendConsola("🏧 RETIRAR DINERO\n");
                app.appendConsola("Saldo disponible: " + saldo + "€\n");
                esperandoCantidad = true;
                tipoOperacion = "retirar";
                app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
                EjercicioUtils.inicializarEntrada(app);
                break;
            case 3:
                app.appendConsola("💳 DEPOSITAR DINERO\n");
                app.appendConsola("Saldo actual: " + saldo + "€\n");
                esperandoCantidad = true;
                tipoOperacion = "depositar";
                app.setPreguntas(new String[]{"¿Cuánto deseas depositar?"});
                EjercicioUtils.inicializarEntrada(app);
                break;
            case 4:
                app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                app.appendConsola("✅ Gracias por usar el cajero.\n");
                app.appendConsola("👋 ¡Hasta luego!\n");
                app.appendConsola("━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
                app.setInputPanelVisible(false);
                break;
            default:
                app.appendConsola("❌ Opción inválida. Elige entre 1 y 4.\n\n");
                EjercicioUtils.limpiarRespuestaYFoco(app);
        }
    }

    // Procesa la cantidad ingresada por el usuario para retiro o depósito
    private static void procesarCantidad(App app, String texto) {
        app.appendConsola("> Cantidad ingresada: " + texto + "€\n\n");

        double cantidad;
        try {
            cantidad = Double.parseDouble(texto);
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Cantidad inválida. Introduce un número.\n");
            app.setPreguntas(new String[]{
                    tipoOperacion.equals("retirar") ? "¿Cuánto deseas retirar?" : "¿Cuánto deseas depositar?"
            });
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        if (tipoOperacion.equals("retirar")) {
            procesarRetiro(app, cantidad);
        } else {
            procesarDeposito(app, cantidad);
        }
    }

    // Realiza la operación de retiro
    private static void procesarRetiro(App app, double cantidad) {
        if (cantidad > saldo) {
            app.appendConsola("❌ Fondos insuficientes.\n");
            app.appendConsola("💰 Tu saldo es: " + saldo + "€\n");
            app.appendConsola("🔄 Por favor, ingresa una cantidad válida.\n\n");
            app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

        if (cantidad <= 0) {
            app.appendConsola("❌ La cantidad debe ser positiva.\n\n");
            app.setPreguntas(new String[]{"¿Cuánto deseas retirar?"});
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

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

    // Realiza la operación de depósito
    private static void procesarDeposito(App app, double cantidad) {
        if (cantidad <= 0) {
            app.appendConsola("❌ La cantidad debe ser positiva.\n");
            app.appendConsola("🔄 Por favor, ingresa una cantidad válida.\n\n");
            app.setPreguntas(new String[]{"¿Cuánto deseas depositar?"});
            EjercicioUtils.limpiarRespuestaYFoco(app);
            return;
        }

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
