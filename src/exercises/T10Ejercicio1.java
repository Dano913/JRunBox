package exercises;

import main.App;
import utils.EjercicioUtils;
import model.Persona;

public class T10Ejercicio1 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 1 Tema 10 – Clase simple");

        app.setPreguntas(new String[]{
                "Ingresa tu nombre",
                "Ingresa tu edad"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        String[] etiquetas = {"Nombre", "Edad"};

        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, null);
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {
            String nombre = app.getRespuestasTexto()[0];
            int edad = Integer.parseInt(app.getRespuestasTexto()[1]);

            Persona persona = new Persona(nombre, edad);

            app.appendConsola("\n¡Datos de la Persona registrados!\n");
            app.appendConsola("Nombre: " + persona.getNombre() + "\n");
            app.appendConsola("Edad: " + persona.getEdad() + "\n");
        }
    }
}
