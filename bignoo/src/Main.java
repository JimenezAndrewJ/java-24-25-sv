import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int prim;
        int segu;
        int casilla;
        int[][] tabla = new int[3][9];

        Random ale = new Random();

        for (int j = 0; j < 9; j++) {
            prim = 10 * (j+1);
            for (int i = 0; i < 3; i++) {
                segu =  ale.nextInt(9);
                casilla = prim + segu;
                tabla[i][j]= casilla;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println(" ");

        }
        System.out.println(" ");
        System.out.println(" ");
        int columna= 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 9; j++) {
                if (tabla[i][j] > tabla[i+1][j]){
                int temp= tabla[i][j];
                tabla[i][j]=tabla[i+1][j];
                tabla[i+1][j]= temp;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}