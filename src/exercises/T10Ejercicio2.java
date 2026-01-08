package exercises;

import main.App;
import utils.EjercicioUtils;
import model.Persona;

public class T10Ejercicio2 {

    private static Persona persona;

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 2 Tema 10 – Getters y Setters");

        app.setPreguntas(new String[]{
                "Ingresa el nombre inicial",
                "Ingresa la edad inicial",
                "Ingresa el nuevo nombre",
                "Ingresa la nueva edad"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();

        EjercicioUtils.avanzarPregunta(app);

        // Cuando se han respondido las dos primeras preguntas
        if (indice == 1) {
            String nombreInicial = app.getRespuestasTexto()[0];
            int edadInicial = Integer.parseInt(app.getRespuestasTexto()[1]);

            persona = new Persona(nombreInicial, edadInicial);

            app.appendConsola("\nDatos iniciales:\n");
            app.appendConsola("Nombre: " + persona.getNombre() + "\n");
            app.appendConsola("Edad: " + persona.getEdad() + "\n\n");
        }

        // Cuando se han respondido todas
        if (indice == 3) {
            persona.setNombre(app.getRespuestasTexto()[2]);
            persona.setEdad(Integer.parseInt(app.getRespuestasTexto()[3]));

            app.appendConsola("Datos modificados:\n");
            app.appendConsola("Nombre: " + persona.getNombre() + "\n");
            app.appendConsola("Edad: " + persona.getEdad() + "\n");
        }
    }
}
