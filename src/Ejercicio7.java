public class Ejercicio7 {
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "Ingresa tu nombre",
                "Ingresa tu apellido",
                "Ingresa tu edad",
                "Ingresa tu ciudad"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;

        // Obtener valores actuales
        String nombre = respuestas[0] != null ? respuestas[0] : "";
        String apellido = respuestas[1] != null ? respuestas[1] : "";
        String edad = respuestas[2] != null ? respuestas[2] : "";
        String ciudad = respuestas[3] != null ? respuestas[3] : "";

        // Mostrar mensaje parcial
        String mensaje = mensajeParcial(indice, nombre, apellido, edad, ciudad);
        if (!mensaje.isEmpty()) {
            app.appendConsola(mensaje + "\n"); // <- CORREGIDO
        }

        // Avanzar a la siguiente pregunta
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("\n" + fraseCompleta(nombre, apellido, edad, ciudad) + "\n"); // <- CORREGIDO
        }
    }

    // 🔹 Mensajes parciales
    public static String mensajeParcial(int indice, String nombre, String apellido, String edad, String ciudad) {
        switch (indice) {
            case 0 -> { return nombre.isEmpty() ? "" : "Mi nombre es " + nombre; }
            case 1 -> { return apellido.isEmpty() ? "" : "Mi apellido es " + apellido; }
            case 2 -> { return edad.isEmpty() ? "" : "Tengo " + edad + " años"; }
            case 3 -> { return ciudad.isEmpty() ? "" : "Vivo en " + ciudad; }
            default -> { return ""; }
        }
    }

    // 🔹 Mensaje final
    public static String fraseCompleta(String nombre, String apellido, String edad, String ciudad) {
        return "¡Hola! Me llamo " + nombre + " " + apellido + ". Tengo " + edad + " años y vivo en " + ciudad + ".";
    }

    public static void mostrarResultadoFinal(App app) {
        String[] respuestas = app.getRespuestasTexto();
        String nombre = respuestas[0] != null ? respuestas[0] : "";
        String apellido = respuestas[1] != null ? respuestas[1] : "";
        String edad = respuestas[2] != null ? respuestas[2] : "";
        String ciudad = respuestas[3] != null ? respuestas[3] : "";

        app.appendConsola("\n" + fraseCompleta(nombre, apellido, edad, ciudad) + "\n");
    }

}
