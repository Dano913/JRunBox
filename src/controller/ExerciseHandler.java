package controller;
import exercises.*;
import main.App;
public class ExerciseHandler {

    public static final String[] NOMBRES_EJERCICIOS = {
            "Seleccione Ejercicio", "Ejercicio 1","Ejercicio 2","Ejercicio 3","Ejercicio 4","Ejercicio 5",
            "Ejercicio 6","Ejercicio 7","Ejercicio 8","Ejercicio 9","Ejercicio 10",
            "Ejercicio 11","Ejercicio 12","Ejercicio 13","Ejercicio 14","Ejercicio 15",
            "Ejercicio 16","Ejercicio 17","Ejercicio 18","Ejercicio 19","Ejercicio 20"
    };

    public static void iniciarEjercicio(App app, String ejercicio) {
        switch (ejercicio) {
            case "Ejercicio 1" -> Ejercicio1.iniciarEjercicio(app);
            case "Ejercicio 2" -> Ejercicio2.iniciarEjercicio(app);
            case "Ejercicio 3" -> Ejercicio3.iniciarEjercicio(app);
            case "Ejercicio 4" -> Ejercicio4.iniciarEjercicio(app);
            case "Ejercicio 5" -> Ejercicio5.iniciarEjercicio(app);
            case "Ejercicio 6" -> Ejercicio6.iniciarEjercicio(app);
            case "Ejercicio 7" -> Ejercicio7.iniciarEjercicio(app);
            case "Ejercicio 8" -> Ejercicio8.iniciarEjercicio(app);
            case "Ejercicio 9" -> Ejercicio9.iniciarEjercicio(app);
            case "Ejercicio 10" -> Ejercicio10.iniciarEjercicio(app);
            case "Ejercicio 11" -> Ejercicio11.iniciarEjercicio(app);
            case "Ejercicio 12" -> Ejercicio12.iniciarEjercicio(app);
            case "Ejercicio 13" -> Ejercicio13.iniciarEjercicio(app);
            case "Ejercicio 14" -> Ejercicio14.iniciarEjercicio(app);
            case "Ejercicio 15" -> Ejercicio15.iniciarEjercicio(app);
            case "Ejercicio 16" -> Ejercicio16.iniciarEjercicio(app);
            case "Ejercicio 17" -> Ejercicio17.iniciarEjercicio(app);
            case "Ejercicio 18" -> Ejercicio18.iniciarEjercicio(app);
            case "Ejercicio 19" -> Ejercicio19.iniciarEjercicio(app);
            case "Ejercicio 20" -> Ejercicio20.iniciarEjercicio(app);
        }
    }

    public static void procesarRespuesta(App app, String ejercicio, String texto) {
        if (ejercicio == null) return;

        switch (ejercicio) {
            case "Ejercicio 1" -> Ejercicio1.procesarRespuesta(app, texto);
            case "Ejercicio 2" -> Ejercicio2.procesarRespuesta(app, texto);
            case "Ejercicio 3" -> Ejercicio3.procesarRespuesta(app, texto);
            case "Ejercicio 4" -> Ejercicio4.procesarRespuesta(app, texto);
            case "Ejercicio 5" -> Ejercicio5.procesarRespuesta(app, texto);
            case "Ejercicio 6" -> Ejercicio6.procesarRespuesta(app, texto);
            case "Ejercicio 7" -> Ejercicio7.procesarRespuesta(app, texto);
            case "Ejercicio 8" -> Ejercicio8.procesarRespuesta(app, texto);
            case "Ejercicio 9" -> Ejercicio9.procesarRespuesta(app, texto);
            case "Ejercicio 10" -> Ejercicio10.procesarRespuesta(app, texto);
            case "Ejercicio 11" -> Ejercicio11.procesarRespuesta(app, texto);
            case "Ejercicio 12" -> Ejercicio12.procesarRespuesta(app, texto);
            case "Ejercicio 13" -> Ejercicio13.procesarRespuesta(app, texto);
            case "Ejercicio 14" -> Ejercicio14.procesarRespuesta(app, texto);
            case "Ejercicio 15" -> Ejercicio15.procesarRespuesta(app, texto);
            case "Ejercicio 16" -> Ejercicio16.procesarRespuesta(app, texto);
            case "Ejercicio 17" -> Ejercicio17.procesarRespuesta(app, texto);
            case "Ejercicio 18" -> Ejercicio18.procesarRespuesta(app, texto);
            case "Ejercicio 19" -> Ejercicio19.procesarRespuesta(app, texto);
            case "Ejercicio 20" -> Ejercicio20.procesarRespuesta(app, texto);
        }
    }
}
