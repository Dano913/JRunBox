package exercises;

import main.App;
import model.Empleado;

public class T10Ejercicio8 {

    public static void iniciarEjercicio(App app) {
        app.setTituloEjercicio("Ejercicio 8 Tema 10 – Array de objetos");

        // Ocultar panel de entrada y botón porque no hay input
        app.setInputPanelVisible(false);

        mostrarEmpleados(app);
    }

    private static void mostrarEmpleados(App app) {
        // Limpiar consola
        app.limpiarConsola();

        // Borrar cualquier label de pregunta
        app.setPreguntaLabel("");

        // Crear array de empleados
        Empleado[] empleados = new Empleado[]{
                new Empleado("Ana Pérez", "Desarrolladora", 35000.0),
                new Empleado("Luis García", "Diseñador", 28000.0),
                new Empleado("María Torres", "Project Manager", 42000.0),
                new Empleado("Jorge Díaz", "Analista", 32000.0),
                new Empleado("Laura Sánchez", "Tester", 26000.0)
        };

        // Mostrar todos los empleados
        app.appendConsola("Lista de empleados:\n");
        for (int i = 0; i < empleados.length; i++) {
            app.appendConsola((i + 1) + ". " + empleados[i].toString() + "\n");
        }

        // Empleado con mayor salario
        Empleado mayorSalario = empleados[0];
        double sumaSalarios = 0.0;

        for (Empleado e : empleados) {
            if (e.getSalario() > mayorSalario.getSalario()) {
                mayorSalario = e;
            }
            sumaSalarios += e.getSalario();
        }

        double salarioPromedio = sumaSalarios / empleados.length;

        app.appendConsola("\nEmpleado con mayor salario: " + mayorSalario.getNombre() +
                " (" + mayorSalario.getSalario() + "€)\n");
        app.appendConsola("Salario promedio: " + salarioPromedio + "€\n");
    }
}
