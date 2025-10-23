import java.util.Scanner;

public class prueba {
    public void ejecutarSuma() {
        Scanner lectorTeclado = new Scanner(System.in);

        System.out.print("Ingresa el primer número: ");
        int op1 = lectorTeclado.nextInt();

        System.out.print("Ingresa el segundo número: ");
        int op2 = lectorTeclado.nextInt();

        int suma = op1 + op2;
        System.out.println("La suma es: " + suma);

    }

    public static void main(String[] args) {
        prueba p = new prueba();
        p.ejecutarSuma();
    }
}
