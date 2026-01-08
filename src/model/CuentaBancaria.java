package model;

public class CuentaBancaria {

    private String titular;
    private double saldo;

    public CuentaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println(
                    "Depósito de " + cantidad + "€. Nuevo saldo: " + saldo + "€"
            );
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println(
                    "Retiro de " + cantidad + "€. Nuevo saldo: " + saldo + "€"
            );
        }
    }

    // Getters
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
