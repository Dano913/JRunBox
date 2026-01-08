package exercises;

import main.App;
import model.CuentaBancaria;

public class T10Ejercicio5 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 5 Tema 10 – Múltiples objetos");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarResultado(app);
    }

    private static void mostrarResultado(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        CuentaBancaria cuenta1 = new CuentaBancaria("Juan García", 1500.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("María López", 800.0);
        CuentaBancaria cuenta3 = new CuentaBancaria("Pedro Martín", 1200.0);

        app.appendConsola("Cuenta de " + cuenta1.getTitular() + ": " + cuenta1.getSaldo() + "€\n");
        cuenta1.depositar(500.0);
        app.appendConsola("\n");

        app.appendConsola("Cuenta de " + cuenta2.getTitular() + ": " + cuenta2.getSaldo() + "€\n");
        cuenta2.retirar(200.0);
        app.appendConsola("\n");

        app.appendConsola("Cuenta de " + cuenta3.getTitular() + ": " + cuenta3.getSaldo() + "€\n");
        cuenta3.depositar(300.0);
        app.appendConsola("\n");

        app.appendConsola("Saldos finales:\n");
        app.appendConsola(cuenta1.getTitular() + ": " + cuenta1.getSaldo() + "€\n");
        app.appendConsola(cuenta2.getTitular() + ": " + cuenta2.getSaldo() + "€\n");
        app.appendConsola(cuenta3.getTitular() + ": " + cuenta3.getSaldo() + "€\n");
    }
}
