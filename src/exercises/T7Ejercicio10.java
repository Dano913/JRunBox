package exercises;

import main.App;
import utils.EjercicioUtils;
import java.util.Random;

public class T7Ejercicio10 {

    // Enum con los posibles estados del pedido
    public enum EstadoPedido {
        PENDIENTE,
        PROCESANDO,
        ENVIADO,
        EN_TRANSITO,
        ENTREGADO,
        CANCELADO
    }

    // Devuelve un estado aleatorio
    public static EstadoPedido obtenerEstadoActual() {
        EstadoPedido[] estados = EstadoPedido.values();
        Random random = new Random();
        int indice = random.nextInt(estados.length);
        return estados[indice];
    }

    // Inicializa el ejercicio
    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 10 Tema 7 - Sistema de Estado de Pedido");
        // Pregunta opcional o de ejemplo
        app.setPreguntas(new String[]{
                "Presiona Enter para generar el estado del pedido"
        });

        EjercicioUtils.inicializarEntrada(app);
    }

    // Procesa la respuesta y muestra un estado aleatorio
    public static void procesarRespuesta(App app, String texto) {
        EjercicioUtils.avanzarPregunta(app);

        if (app.getIndicePregunta() >= app.getPreguntas().length) {

            // Obtener estado aleatorio del pedido
            EstadoPedido estadoAleatorio = obtenerEstadoActual();

            // Mostrar mensaje según el estado usando switch
            String mensaje = switch (estadoAleatorio) {
                case PENDIENTE -> "El pedido está pendiente.\n";
                case PROCESANDO -> "El pedido se está procesando.\n";
                case ENVIADO -> "El pedido ha sido enviado.\n";
                case EN_TRANSITO -> "El pedido está en tránsito.\n";
                case ENTREGADO -> "El pedido ha sido entregado.\n";
                case CANCELADO -> "El pedido ha sido cancelado.\n";
            };

            app.appendConsola(mensaje);

            // Indicar el siguiente paso esperado
            String siguientePaso;
            switch (estadoAleatorio) {
                case PENDIENTE -> siguientePaso = "Siguiente paso esperado: PROCESANDO";
                case PROCESANDO -> siguientePaso = "Siguiente paso esperado: ENVIADO";
                case ENVIADO -> siguientePaso = "Siguiente paso esperado: EN_TRANSITO";
                case EN_TRANSITO -> siguientePaso = "Siguiente paso esperado: ENTREGADO";
                case ENTREGADO, CANCELADO -> siguientePaso = null; // No hay siguiente paso
                default -> siguientePaso = null;
            }

            if (siguientePaso != null) {
                app.appendConsola(siguientePaso);
            }
        }
    }
}
