package exercises;

import main.App;
import model.Calculadora;

public class T10Ejercicio9 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 9 Tema 10 – Métodos estáticos");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarOperaciones(app);
    }

    private static void mostrarOperaciones(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        int a = 10;
        int b = 5;

        app.appendConsola("Suma: " + a + " + " + b + " = " + Calculadora.sumar(a, b) + "\n");
        app.appendConsola("Resta: " + a + " - " + b + " = " + Calculadora.restar(a, b) + "\n");
        app.appendConsola("Multiplicación: " + a + " * " + b + " = " + Calculadora.multiplicar(a, b) + "\n");
        app.appendConsola("División: " + a + " / " + b + " = " + Calculadora.dividir(a, b) + "\n");
        app.appendConsola("Potencia: 2^3 = " + Calculadora.potencia(2, 3) + "\n");
    }
}
