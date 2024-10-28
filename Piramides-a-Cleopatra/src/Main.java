import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos
        System.out.print("Ingresa el número de casos: ");
        int casos = scanner.nextInt();

        for (int i = 0; i < casos; i++) {
            // Leer los tres años
            System.out.print("Ingresa tres años (A, B, C): ");
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            if (A >= -10000 && A <= 10000 && B >= -10000 && B <= 10000 && C >= -10000 && C <= 10000) {
                break; // sale cuando los años son validos
            } else {
                System.out.println("Error: Todos los años deben estar entre -10000 y 10000.");
            }

            // Calcular las distancias. Elevamos los numeros por que no podemos operar con negativos
            int distanciaA = (A - B)*(A - B);
            int distanciaC = (C - B)*(C - B);

            // Determinar el resultado
            if (distanciaA < distanciaC) {
                System.out.println(A);
            } else if (distanciaC < distanciaA) {
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
