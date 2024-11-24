import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mapear las potencias de 10 con sus símbolos correspondientes
        char[] simbolos = {'H', 'R', 'D', 'F', 'C', 'G', 'T'}; // De 1,000,000 a 1
        int[] val = {1000000, 100000, 10000, 1000, 100, 10, 1};

        while (true) {
            // Leer el número de entrada
            System.out.print("Dame un numero y lo paso a jerogrifico: ");
            int num = scanner.nextInt();

            // Si el número es 0, terminar el programa
            if (num == 0) break;
            if (num > 100000 || num < 0) {
                System.out.println("El numero no es valido");
                break;
            }

            StringBuilder resultado = new StringBuilder();

            // Descomponer el número en cada potencia de 10
            for (int i = 0; i < val.length; i++) {
                int cant = num / val[i]; // Cuántas veces cabe esta potencia en el número
                num %= val[i];               // dividimos el numero

                // agregar el simbolo a los numeros correspondiestes
                for (int j = 0; j < cant; j++) {
                    resultado.append(simbolos[i]);
                }
            }

            // Imprimir el resultado para este número
            System.out.println(resultado.toString());
        }

        scanner.close();
    }
}