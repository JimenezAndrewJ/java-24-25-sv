import java.sql.Time;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    private static final int filas=4;
    private static final int columnas=4;
    private static final int tablero[][]=new int[filas][columnas];
    static Random random= new Random();
    static int terminar = 0;
    static Scanner scanner = new Scanner(System.in);
    static Timer timer = new Timer();

private static void imprimir() {
                for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(tablero[i][j] + " ");
                }
                System.out.println(" ");
            }
        }


private static void tabla(){
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            tablero[i][j]=0;
        }
    }
}

    private static void llenartabla(){
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 2; k++) {
                int filaRandom;
                int columnaRandom;
                do {
                    filaRandom = random.nextInt(filas);
                    columnaRandom = random.nextInt(columnas);
                }while (tablero[filaRandom][columnaRandom] != 0);
                tablero[filaRandom][columnaRandom]= (i+1) ;
            }
        }
    }

    public static void main(String[] args) {

        tabla();

        llenartabla();

        imprimir();

        do {
        System.out.println("dame la primera posicion");
        System.out.println("fila");
        int filaU1 = scanner.nextInt();
        System.out.println("columna");
        int columnaU1 = scanner.nextInt();
        System.out.println(tablero[filaU1][columnaU1]);
        System.out.println("dame la segunda posicion");
        System.out.println("fila");
        int filaU2 = scanner.nextInt();
        System.out.println("columna");
        int columnaU2 = scanner.nextInt();
        System.out.println(tablero[filaU2][columnaU2]);

        if (tablero[filaU1][columnaU1]==tablero[filaU2][columnaU2]){
            System.out.println("bien");
            tablero[filaU1][columnaU1]=0;
            tablero[filaU2][columnaU2]=0;
        }else{
            System.out.println("fallo");
        }

            imprimir();
        terminar++;
        }while (terminar < 10);
    }
}