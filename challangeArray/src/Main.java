import java.util.Random;
import java.util.Scanner;

public class Main {
    // static String array[] = new String[6];
    public static void main(String[] args) {
        Random aleatorio = new Random();
        Scanner lee = new Scanner(System.in);

        String array[] = new String[6];
        for (int i = 0; i < array.length; i++) {
            int numAle = aleatorio.nextInt(100);
            // entero a cadena
            // int a String
            array[i] = String.valueOf(numAle) ;
        }
        // IMPRIMIR
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Dame un num1");
        String cadU1 = lee.next();
        for (int i = 0; i < array.length; i++) {
            if(cadU1.equals(array[i])){
                array[i] = "XX";
            }
        }
        System.out.println("Dame un num2");
        String cadU2 = lee.next();
        for (int i = 0; i < array.length; i++) {
            if(cadU2.equals(array[i])){
                array[i] = "XX";
            }
        }
        System.out.println("Dame un num3");
        String cadU3 = lee.next();
        for (int i = 0; i < array.length; i++) {
            if(cadU3.equals(array[i])){
                array[i] = "XX";
            }
        }
        // IMPRIMIR EL ARRAY
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}