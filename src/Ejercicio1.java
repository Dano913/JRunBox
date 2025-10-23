public class Ejercicio1 {
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
        app.setRespuestasTexto(new String[3]);
        //Crea un array vacio para guardar tantas respuestas como preguntas hay.
        app.setIndicePregunta(0);
        //Indica que empezamos en la primera pregunta.
        app.setPreguntaLabel(app.getPreguntas()[0]);
        //Muestra en la pantalla la primera pregunta.
        app.limpiarRespuestaField();
        //Limpia el campo de texto por si había algo.
        app.setInputPanelVisible(true);
        //Asegura que el panel de entrada para la respuesta está visible.
        app.limpiarConsola();
        //Limpia la consola donde se muestran los resultados anteriores.
        app.requestFocusRespuesta();
        //Pone el cursor directamente en el campo de texto para escribir sin clickar.
    }
    public static void procesarRespuesta(App app, String texto) {
    // Este metodo procesa cada respuesta introducida.
        int indice = app.getIndicePregunta();
        //Obtiene el número de la pregunta actual.
        app.getRespuestasTexto()[indice] = texto;
        //Guarda la respuesta del usuario en la posicion de array correspondiente.
        String[] etiquetas = {
                "Nombre",
                "Edad",
                "Ciudad"
        };
        app.appendConsola(etiquetas[indice] + ": " + texto + "\n");
        //Crea el texto que anuncia a que pregunta corresponde la respuesta y le da formato.
        app.setIndicePregunta(indice + 1);
        //Incrementa el índica para pasar a la siguiente pregunta.
        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            //Si quedan preguntas, muestra la siguiente, limpia el campo y coloca el cursor.
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("\n¡Datos completados!\n");
            //Si no quedan, oculta el panel de entrada y muestra el mensaje final en consola.
        }
    }
}
