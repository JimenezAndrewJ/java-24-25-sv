import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Dame un número total de bloques a utilizar (Usa 0 para salir): ");
            int bUtilizables = scanner.nextInt();

            if (bUtilizables == 0) break; // Salir si el usuario ingresa 0

            int niveles = 0;
            int bUsados = 0;

            // Calcular niveles que se pueden construir
            while (true) {
                int lado = 2 * niveles + 1; // Longitud del lado del nivel actual
                int bXnivel = lado * lado; // Bloques en el nivel actual

                if (bUsados + bXnivel > bUtilizables) {
                    break; // No hay suficientes bloques para un nuevo nivel
                }

                bUsados += bXnivel; // Acumular bloques usados
                niveles++; // Aumentar el número de niveles
            }

            System.out.println("Se contruyeron: " + niveles + " niveles con " + bUtilizables + " bloques.");
        }

        scanner.close(); // Cerrar el scanner al finalizar
    }
}
