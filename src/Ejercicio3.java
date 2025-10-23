public class Ejercicio3 {

    // 🔹 Inicia el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "Ingresa un nombre (String):",
                "Ingresa la edad (int):",
                "Es estudiante? (true/false):",
                "Ingresa la altura (double):",
                "Ingresa la inicial (char):"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.limpiarConsola();
        app.setInputPanelVisible(true);
        app.requestFocusRespuesta();
    }

    // 🔹 Procesa cada respuesta parcial
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;

        String tipo = "String";
        //Establece String como tipo default.
        try {
            switch (indice) {
                case 1 -> { Integer.parseInt(texto); tipo = "int"; }
                case 2 -> { Boolean.parseBoolean(texto); tipo = "boolean"; }
                case 3 -> { Double.parseDouble(texto); tipo = "double"; }
                case 4 -> tipo = (texto.length() == 1) ? "char" : "String";
            }
            //Establece el texto que indicará el tipo segun el tipo de dato.
        } catch (Exception e) {
            tipo = "String";
            //Si no coincide con ningun tipo establece String
        }

        app.appendConsola(texto + " - Tipo: " + tipo + "\n");

        // Avanzar a siguiente pregunta
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("\n¡Ya sabemos todos los tipos de datos!\n");
        }
    }
}
