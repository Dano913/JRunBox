package exercises;
import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio3 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 3 – Tipos de variables");
        app.setPreguntas(new String[]{
                "Ingresa un nombre (String):",
                "Ingresa la edad (int):",
                "Es estudiante? (true/false):",
                "Ingresa la altura (double):",
                "Ingresa la inicial (char):"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        app.getRespuestasTexto()[indice] = texto;
        // Determinar el tipo de dato ingresado
        String tipo = "String";
        try {
            switch (indice) {
                case 1 -> { Integer.parseInt(texto); tipo = "int"; }
                case 2 -> { Boolean.parseBoolean(texto); tipo = "boolean"; }
                case 3 -> { Double.parseDouble(texto); tipo = "double"; }
                case 4 -> tipo = (texto.length() == 1) ? "char" : "String";
            }
        } catch (Exception e) {
            tipo = "String";
        }
        // Mostrar la respuesta con su tipo
        app.appendConsola(texto + " - Tipo: " + tipo + "\n");
        // Avanzar a siguiente pregunta de manera genérica
        EjercicioUtils.avanzarPregunta(app);
        // Mensaje final propio del ejercicio
        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            app.appendConsola("\n¡Ya sabemos todos los tipos de datos!\n");
        }
    }
}
