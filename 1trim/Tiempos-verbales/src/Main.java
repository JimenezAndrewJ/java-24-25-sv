import java.util.Scanner;

public class Main {
    private static String verbo = "";
    private static String[] pr(String terminacion, String raiz) {
        if (terminacion.equals("ar")) {
            return new String[]{raiz + "o", raiz + "as", raiz + "a", raiz + "amos", raiz + "áis", raiz + "an"};
        } else if (terminacion.equals("er")) {
            return new String[]{raiz + "o", raiz + "es", raiz + "e", raiz + "emos", raiz + "éis", raiz + "en"};
        } else if (terminacion.equals("ir")) {
            return new String[]{raiz + "o", raiz + "es", raiz + "e", raiz + "imos", raiz + "ís", raiz + "en"};
        }
        return new String[0];
    }

    private static String[] pps(String terminacion, String raiz) {
        if (terminacion.equals("ar")) {
            return new String[]{raiz + "é", raiz + "aste", raiz + "ó", raiz + "amos", raiz + "asteis", raiz + "aron"};
        } else if (terminacion.equals("er") || terminacion.equals("ir")) {
            return new String[]{raiz + "í", raiz + "iste", raiz + "ió", raiz + "imos", raiz + "isteis", raiz + "ieron"};
        }
        return new String[0];
    }

    private static String[] fu(String terminacion, String raiz) {
        return new String[]{verbo + "é", verbo + "ás", verbo + "á", verbo + "emos", verbo + "éis", verbo + "án"};
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pronombres[]= {"Yo","Tu","El","Nosotros","Vosotros","Ellos"};


        while (true) {
        String lee = scanner.nextLine().trim(); // comer
        if (lee.endsWith(" T")) break; // comprueba si hay un a T si lo hay Finaliza

            String[] parts = lee.split(" "); // seciona el string "comer F" → "comer" + "F"
            verbo = parts[0]; // guardar "comer"
            char tiempo = parts[1].charAt(0); // guardas el "F" el tiempo verbal
            String terminacion = verbo.substring(verbo.length() - 2); // substring coge de la posicion 3 hasta el final de la cadena. "er" (el 3 es por que 5 - 2 = 3 osea le dices desde donde empezar)
            String raiz = verbo.substring(0, verbo.length() - 2); // aqui haces lo mismo pero le dices que empiece a contar desde la posicion 0 y que acabe el la 3. "com"

            String[] conjugaciones; // defino el string conjugaciones en forma de array

            switch (tiempo) {
                case 'A':
                    conjugaciones = pr(terminacion, raiz);
                    break;
                case 'P':
                    conjugaciones = pps(terminacion, raiz);
                    break;
                case 'F':
                    conjugaciones = fu(terminacion, raiz);
                    break;
                default:
                    throw new IllegalArgumentException("Tiempo verbal no válido");
            }

            // Funcion para imprimir el resultado de la conjugacion
            for (int i = 0; i < pronombres.length; i++) {
                System.out.println(pronombres[i] + " " + conjugaciones[i]);
            }
            System.out.println();
        }
        scanner.close();
    }

}
