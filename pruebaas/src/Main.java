import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int array[] = new int[10];
    Random numAleatorio= new Random();
        boolean bandera;
        for (int i = 0; i < 10; i++) {
            do{
                 bandera=true;
                array[i] = numAleatorio.nextInt(10) + 10;
                for (int j = 0; j < i; j++) {
                    if(array[i] == array[j]){
                        bandera = false;
                    }else{
                        bandera = true;
                    }
                }
            }while(bandera==false);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}