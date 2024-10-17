//ANDREW JAIR JIMENEZ HUAMAN

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {


    private static final int maxNumFila = 10;
    private static final int maxNumColum = 10;
    private static char tabla[][] = new char[maxNumFila][maxNumColum];
    private static int filabart;
    private static int columnabart;
    Random ale = new Random();


    private static void llenarTabla(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tabla[i][j] ='L';
            }
          }
        tabla[9][9]='F';
    }
    //ANDREW JAIR JIMENEZ HUAMAN

    private static void imprimirTablero(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
        System.out.println(" ");
    }
    //ANDREW JAIR JIMENEZ HUAMAN

    private static void generarBart() {
        Random ale = new Random();
        filabart = ale.nextInt(10);
        columnabart = ale.nextInt(10);
        tabla[filabart][columnabart]='B';
    }
//ANDREW JAIR JIMENEZ HUAMAN

    private static void generarHomero() {
        Random ale = new Random();
        int filahomer;
        int columnahomero;
        for (int i = 0; i <10; i++) {
            do {
                filahomer = ale.nextInt(10);
                columnahomero = ale.nextInt(10);
            }while(tabla[filahomer][columnahomero] != 'L');
            tabla[filahomer][columnahomero] = 'H';
        }
    }
    //ANDREW JAIR JIMENEZ HUAMAN

    private static void generarMuro() {
        Random ale = new Random();
        int filaMuro;
        int columnaMuro;
        for (int i = 0; i <10; i++) {
            do {
                filaMuro = ale.nextInt(10);
                columnaMuro = ale.nextInt(10);
            }while(tabla[filaMuro][columnaMuro] != 'L');
            tabla[filaMuro][columnaMuro] = 'M';
        }
    }

    public static void main(String[] args) {

//ANDREW JAIR JIMENEZ HUAMAN

        llenarTabla();
        imprimirTablero();
        generarBart();
        imprimirTablero();
        generarHomero();
        imprimirTablero();
        generarMuro();
        imprimirTablero();

        int vidas = 10;
        System.out.println("Empieza el juego muevete con ASWD");
        do {

        Scanner leer = new Scanner(System.in);
            System.out.println("Dame una direccion");
        String usuario = String.valueOf(leer.next());
        System.out.println(usuario);

        switch (usuario){
            case "A":
                if ((columnabart-1) >= 0){
                    switch (tabla[filabart][columnabart-1]) {
                        case 'L':
                            columnabart = columnabart - 1;
                            break;
                        case 'H':
                            vidas = vidas - 1;
                            columnabart = columnabart - 1;
                            System.out.println("perdiste una vida te quedan: " + vidas);
                            break;
                        case 'M':
                            System.out.println("no se puede mover hay un muro");
                            break;
                        case 'F':
                            columnabart = columnabart - 1;
                            System.out.println("fin del juego");
                            break;
                    }
                }else {
                    System.out.println("fuera de limite");

                }
                tabla[filabart][columnabart] = 'B';
                tabla[filabart][columnabart+1] = 'L';
            break;
            case "D":
                if ((columnabart+1) != 10){
                    switch (tabla[filabart][columnabart+1]) {
                        case 'L':
                            columnabart = columnabart + 1;
                            break;
                        case 'H':
                            vidas = vidas - 1;
                            columnabart = columnabart + 1;
                            System.out.println("perdiste una vida te quedan: " + vidas);
                            break;
                        case 'M':
                            System.out.println("no se puede mover hay un muro");
                            break;
                        case 'F':

                            columnabart = columnabart + 1;
                            System.out.println("fin del juego");
                            break;
                    }
                }else {
                    System.out.println("fuera de limite");
                }
                tabla[filabart][columnabart] = 'B';
                tabla[filabart][columnabart-1] = 'L';
                break;
            case "S":
                if ((filabart+1) != 10){
                    switch (tabla[filabart+1][columnabart]) {
                        case 'L':
                            filabart = filabart + 1;
                            break;
                        case 'H':
                            vidas = vidas - 1;
                            filabart = filabart + 1;
                            System.out.println("perdiste una vida te quedan: " + vidas);
                            break;
                        case 'M':
                            System.out.println("no se puede mover hay un muro");
                            break;
                        case 'F':

                            filabart = filabart + 1;
                            System.out.println("fin del juego");
                            break;
                    }
                }else {
                    System.out.println("fuera de limite");

                }
                tabla[filabart][columnabart] = 'B';
                tabla[filabart-1][columnabart] = 'L';
                break;
            case "W":
                if ((filabart-1) >= 0){
                    switch (tabla[filabart-1][columnabart]) {
                        case 'L':
                            filabart = filabart - 1;
                            break;
                        case 'H':
                            vidas = vidas - 1;
                            filabart = filabart - 1;
                            System.out.println("perdiste una vida te quedan: " + vidas);
                            break;
                        case 'M':
                            System.out.println("no se puede mover hay un muro");
                            break;
                        case 'F':

                            filabart = filabart - 1;
                            System.out.println("fin del juego");
                            break;
                    }
                }else {
                    System.out.println("fuera de limite");

                }
                tabla[filabart][columnabart] = 'B';
                tabla[filabart+1][columnabart] = 'L';
                break;
        }
        imprimirTablero();
        }while (tabla[10][10]=='B'||vidas != 0 );
    }
}
//ANDREW JAIR JIMENEZ HUAMAN
