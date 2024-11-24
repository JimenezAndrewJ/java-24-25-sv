public class pes12 {
    private static int[] numeros = {4, 2, 9, 1, 5, 3};
    private static int objetivo = 9;
    private static boolean encontrado = false;

    private static void encontrar(){for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] == objetivo) {
            encontrado = true;
        }
    }
    }
        public static void main(String[] args) {

            encontrar();
            if (encontrado) {
                System.out.println("Número encontrado");
            } else {
                System.out.println("Número no encontrado");
            }
        }
    }

