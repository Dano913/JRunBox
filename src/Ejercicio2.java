import javax.swing.JOptionPane;
public class Ejercicio2 {
    public static void iniciarEjercicio(App app) {
        app.setPreguntas(new String[]{
                "Cuántos puntos ganas en la primera modificación?",
                "Cuántos puntos ganas en la segunda modificación?",
                "Cuántos puntos ganas en la tercera modificación?"
        });
        app.setRespuestasTexto(null);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.appendConsola("Puntuación inicial: 0\n");
        app.requestFocusRespuesta();
        app.setPuntuacion(0);
    }
    public static void procesarRespuesta(App app, String texto) {
        int indice = app.getIndicePregunta();
        try {
            int puntos = Integer.parseInt(texto);
            //Transforma la respuesta String a Int para operar
            app.setPuntuacion(app.getPuntuacion() + puntos);
            app.appendConsola("Después de modificación " + (indice + 1) + ": " + app.getPuntuacion() + "\n");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(app, "Por favor, ingresa un número válido.");
            //Salta el error si la respuesta introducida no es un dígito.
            return;
        }
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);
            app.appendConsola("\n¡Puntuación final: " + app.getPuntuacion() + "!\n");
        }
    }
}
