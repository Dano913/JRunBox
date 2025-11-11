package exercises;
import main.App;

public class T4Ejercicio4 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 39 - Menú de opciones");
        app.setPreguntas(new String[]{
                "Elige una opción:" +
                        "--- MENÚ ---" +
                        "1. Ver perfil" +
                        "2. Configuración" +
                        "3. Ayuda<br>4. Salir"
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
                "Opción elegida"

        };
        String[] unidades = {
                ""
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + " " + unidades[indice] + "\n");
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                int opcion = Integer.parseInt(respuestas[0]);
                String mensaje;
                switch(opcion) {
                    case 1 -> mensaje = "Ver perfil";
                    case 2 -> mensaje = "Configuración";
                    case 3 -> mensaje = "Ayuda";
                    case 4 -> mensaje = "Salir";
                    default -> mensaje = "Opción no disponible";
                }
                app.appendConsola(String.format("Has seleccionado: %s\n", mensaje));
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
