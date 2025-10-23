public class Ejercicio19 {
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 19 - Sistema de calificaciones");
        app.setPreguntas(new String[]{
                "Introudce la nota del primer examen",
                "Introudce la nota del segundo examen",
                "Introudce la nota del tercer examen"
        });
        app.setRespuestasTexto(new String[app.getPreguntas().length]);
        app.setIndicePregunta(0);
        app.setPreguntaLabel(app.getPreguntas()[0]);
        app.limpiarRespuestaField();
        app.setInputPanelVisible(true);
        app.limpiarConsola();
        app.requestFocusRespuesta();
    }
    public static void procesarRespuesta(App app, String texto){
        int indice = app.getIndicePregunta();
        String [] respuestas = app.getRespuestasTexto();
        respuestas[indice] = texto;
        String[] etiquetas = {
                "Primera nota",
                "Segunda nota",
                "Tercera nota"
        };
        try {
            double valor = Double.parseDouble(texto);

            if (valor < 1 || valor > 10) {
                app.appendConsola("❌ Error: la nota debe estar entre 1 y 10.\n");
                app.limpiarRespuestaField();
                app.requestFocusRespuesta();
                return;
            }
            respuestas[indice] = texto;
            app.appendConsola("Nota " + (indice + 1) + ": " + valor + "\n");
        } catch (NumberFormatException e) {
            app.appendConsola("❌ Error: ingresa un número válido.\n");
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
            return;
        }
        app.setIndicePregunta(indice + 1);

        if (app.getIndicePregunta() < app.getPreguntas().length) {
            app.setPreguntaLabel(app.getPreguntas()[app.getIndicePregunta()]);
            app.limpiarRespuestaField();
            app.requestFocusRespuesta();
        } else {
            app.setInputPanelVisible(false);

            try {
                double num1 = Double.parseDouble(respuestas[0]);
                double num2 = Double.parseDouble(respuestas[1]);
                double num3 = Double.parseDouble(respuestas[2]);
                double notaMedia = (num1+num2+num3)/3;

                if(notaMedia>=9){
                    app.appendConsola("La nota media es: "+notaMedia+". Has sacado un sobresaliente");
                }else if(notaMedia>=7){
                    app.appendConsola("La nota media es: "+notaMedia+". Has sacado un notable");
                }else if(notaMedia>=5){
                    app.appendConsola("La nota media es: "+notaMedia+". Has aprobado");
                }else if(notaMedia<5){
                    app.appendConsola("La nota media es: "+notaMedia+". Has suspendido");
                }
            } catch (NumberFormatException e) {
                app.appendConsola("Error: uno de los valores no es un número válido.\n");
            }
        }
    }
}
