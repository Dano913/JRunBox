package exercises;
import main.App;
import utils.EjercicioUtils;

public class T1Ejercicio1 {
// Define una clase pública con 2 métodos estáticos, que se pueden ejecutar sin crear un objeto de la clase, solo llamándolos.
    public static void iniciarEjercicio(App app) {
    // Este metodo prepara el ejercicio inicializando todos los valores necesarios.
        app.setTituloEjercicio("Ejercicio 1 – Datos personales");
        //Establece el título del ejercicio
        app.setPreguntas(new String[]{
                "Ingresa tu nombre",
                "Ingresa tu edad",
                "Ingresa tu ciudad"
        });
        //Crea un array de preguntas.
        EjercicioUtils.inicializarEntrada(app);
        //Funciones de renderizado del cuestionario
    }

    public static void procesarRespuesta(App app, String texto) {
    // Este metodo procesa cada respuesta introducida.
        String[] etiquetas = {"Nombre", "Edad", "Ciudad"}; // Etiquetas para enunciar la solucion
        String[] unidades = {"","",""}; // Unidades para enunciar la solución
        EjercicioUtils.procesarRespuesta(app, texto, etiquetas, unidades);
        // Funciones de manejo de las preguntas y respuestas
    }
}
