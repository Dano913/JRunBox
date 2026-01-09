package exercises;

import main.App;

public class T11Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 11 – Sistema de login");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola y labels
        app.limpiarConsola();
        app.setPreguntaLabel("");

        String usuarioCorrecto = "admin";
        String passwordCorrecta = "1234";

        boolean loginExitoso = intentarLogin(app, usuarioCorrecto, passwordCorrecta);

        if (loginExitoso) {
            app.appendConsola("\n✔ Acceso concedido\n");
        } else {
            app.appendConsola("\n✖ Acceso bloqueado tras 3 intentos\n");
        }
    }

    private static boolean intentarLogin(App app, String usuarioCorrecto, String passwordCorrecta) {

        // Simulación de credenciales introducidas en cada intento
        String[] usuariosIntento = {"user", "admin", "admin"};
        String[] passwordsIntento = {"0000", "0000", "1234"};

        for (int intento = 0; intento < 3; intento++) {

            app.appendConsola(
                    "Intento " + (intento + 1) + ": " +
                            "usuario='" + usuariosIntento[intento] + "', " +
                            "password='" + passwordsIntento[intento] + "'\n"
            );

            if (usuariosIntento[intento].equals(usuarioCorrecto)
                    && passwordsIntento[intento].equals(passwordCorrecta)) {

                app.appendConsola("✔ Credenciales correctas\n");
                break;
            }

            app.appendConsola("✖ Credenciales incorrectas\n");
        }

        // Verificación final
        return usuariosIntento[2].equals(usuarioCorrecto)
                && passwordsIntento[2].equals(passwordCorrecta);
    }
}
