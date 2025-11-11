package utils;

public class ExecutionUtils {

    @FunctionalInterface
    public interface CodeBlock {
        void run();
    }

    /**
     * Mide el tiempo de ejecución de un bloque de código y devuelve los milisegundos.
     */
    public static long medirTiempo(CodeBlock bloque) {
        long start = System.currentTimeMillis();
        bloque.run();
        long end = System.currentTimeMillis();
        return end - start;
    }
}
