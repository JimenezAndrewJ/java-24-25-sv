import java.util.Scanner;

public class pes7 {
    private static Scanner scanner = new Scanner(System.in);
    private static int suma = 0, n = 0;
    private static void sumarNpares() {
        // Código ineficiente para sumar números pares
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                suma += i;
            }
        }
    }
    public static void main(String[] args) {

        System.out.print("Introduce un número entero positivo: ");
         n = scanner.nextInt();

        sumarNpares();

        System.out.println("La suma de los números pares de 1 a " + n + " es: " + suma);
        scanner.close();
    }
}
