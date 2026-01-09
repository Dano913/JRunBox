package exercises;

import main.App;

public class T11Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 11 – Validador de Contraseña");

        // No hay entrada de usuario
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {

        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        String[] contrasenas = {
                "abc123",
                "password",
                "Password",
                "Password1",
                "Pass1",
                "JAVA2024"
        };

        for (String c : contrasenas) {
            app.appendConsola(
                    "Contraseña: " + c + " → " +
                            (validarContrasena(c) ? "VÁLIDA ✅" : "NO válida ❌") + "\n"
            );
        }
    }

    private static boolean validarContrasena(String password) {

        // Longitud mínima
        if (password.length() < 8) {
            return false;
        }

        boolean tieneMayuscula = false;
        boolean tieneNumero = false;

        for (char c : password.toCharArray()) {

            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }

            if (Character.isDigit(c)) {
                tieneNumero = true;
            }

            // Salida anticipada
            if (tieneMayuscula && tieneNumero) {
                return true;
            }
        }

        return false;
    }
}
