package model;

public class Calculadora {

    // Métodos estáticos: no requieren crear un objeto

    public static int sumar(int a, int b) {
        return a + b;
    }

    public static int restar(int a, int b) {
        return a - b;
    }

    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("No se puede dividir entre 0");
        }
    }

    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }
}
