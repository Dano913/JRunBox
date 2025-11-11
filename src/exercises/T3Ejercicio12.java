package exercises;
import main.App;

public class T3Ejercicio12 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 32 - Validador de contraseña");
        app.setPreguntas(new String[]{
                "Introduce una contraseña"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Contraseña"

        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            try {
                String password = respuestas[indice]; // la contraseña que escribió el usuario

                // No puede ser "12345678" ni "password"
                if (password.equals("12345678") || password.equalsIgnoreCase("password")) {
                    app.appendConsola("No puedes poner esa contraseña, debe ser otra.\n");
                }
                // Debe tener al menos 8 caracteres
                else if (password.length() < 8) {
                    app.appendConsola("La contraseña debe tener al menos 8 caracteres.\n");
                }
                // Debe contener al menos un número
                else if (!password.matches(".*\\d.*")) {
                    app.appendConsola("La contraseña debe contener al menos un número.\n");
                }
                else {
                    app.appendConsola("Contraseña válida: " + password + "\n");
                }

            } catch (Exception e) {
                app.appendConsola("Error inesperado.\n");
            }

        }
    }
}
