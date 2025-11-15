package exercises;

import main.App;
import utils.EjercicioUtils;

public class T7Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 7 - Sistema de niveles de juego");
        // Solo se mostrará esta vez
        app.setPreguntas(new String[]{
                "Introduce la extensión de tu archivo"
        });
        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        String[] etiquetas = {
                "Extensión"
        };
        String[] unidades = {
                ""
        };
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String[] respuestas = app.getRespuestasTexto();
            String extension = respuestas[0];

            String categoria;
            switch (extension) {
                case "jpg", "jpeg", "png", "gif", "bmp", "svg", "webp" -> categoria = "Imagen";
                case "pdf", "doc", "docx", "odt", "txt", "rtf" -> categoria = "Documento";
                case "xls", "xlsx", "csv" -> categoria = "Hoja de cálculo";
                case "ppt", "pptx", "odp" -> categoria = "Presentación";
                case "mp3", "wav", "flac", "aac", "ogg" -> categoria = "Audio";
                case "mp4", "avi", "mkv", "mov", "wmv", "flv" -> categoria = "Video";
                case "zip", "rar", "7z", "tar", "gz" -> categoria = "Archivo comprimido";
                case "java", "py", "js", "html", "css", "cpp", "cs" -> categoria = "Código / Script";
                default -> categoria = "No se ha introducido una aextensión de archivo reconocida.";
            }

            app.appendConsola(String.format("La extensión es %s, por tanto el archivo es de tipo %s", extension, categoria));
        }
    }
}