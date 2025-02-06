import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
        String arrayNumAlet[] = new String[6];
        Random aleatorio= new Random();
        Scanner lee = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
               arrayNumAlet[i] = String.valueOf( aleatorio.nextInt(10));
        }

        for (int i = 0; i < 6; i++) {
                System.out.print(arrayNumAlet[i]+" ");
            }


        for (int j = 0; j <3; j++) {


        System.out.println("dame un numero: ");
        System.out.println(" ");
        String cadUsuario = lee.next();
        int i = 0;

        do {
            if (cadUsuario.equals(arrayNumAlet[i])) {
               arrayNumAlet[i] = "XX";
            }
            i=i+1;
        }while(i < 6);

            for (i = 0; i < 6; i++) {
                System.out.print(arrayNumAlet[i]+" ");
            }
            System.out.println(" ");
        }
        }
    }
