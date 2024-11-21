import java.util.Random;
import java.util.Scanner;

public class repaso {
    static final int maxFil = 10;
    static final int maxCol = 10;
    static char tablaY[][] = new char[maxFil][maxCol];
    static char tablaV[][] = new char[maxFil][maxCol];
    static Random ale = new Random();
    static int aleFYoda;
    static int aleCYoda;
    static int  aleFVader;
    static int aleCVader;
    static int aleoF;
    static int aleoC;
    static boolean cambio=false;

    private static void tablas(){
        for (int i = 0; i < maxFil; i++) {
            for (int j = 0; j < maxCol; j++) {
                tablaV[i][j] = 'L';
                tablaY[i][j] = 'L';
            }
        }
    }
    private static void fin(){
        tablaV[9][9]= 'F';
        tablaY[9][9]= 'F';
    }
    private static void Personajes(){
        do {
            aleFYoda= ale.nextInt(10);
        aleCYoda= ale.nextInt(10);
        aleFVader= ale.nextInt(10);
        aleCVader= ale.nextInt(10);
        }while (tablaV[aleFYoda][aleCYoda] != 'L' && tablaV[aleFVader][aleCVader] != 'L');
        tablaY[aleFYoda][aleCYoda]= 'Y';
        tablaV[aleFVader][aleCVader]= 'V';
    }
    private static void ImprimirY(){
        for (int i = 0; i < maxFil; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(tablaY[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void ImprimirV(){
        for (int i = 0; i < maxFil; i++) {
            for (int j = 0; j < maxCol; j++) {
                System.out.print(tablaV[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
private static void obstaculos(char[][] matriz, char obs, int cant ){
    for (int i = 0; i < cant; i++) {
        do {
            aleoF= ale.nextInt(10);
            aleoC= ale.nextInt(10);
        }while (matriz[aleoF][aleoC]!='L');
        matriz[aleoF][aleoC]=obs;
    }
}
private static void tpenemigo(char[][] matriz, char obs, int cant){
    if (cambio) {
        for (int i = 0; i < cant; i++) {
            do {
                aleoF = ale.nextInt(10);
                aleoC = ale.nextInt(10);
            } while (matriz[aleoF][aleoC] != 'L');
            matriz[aleoF][aleoC] = 0;
        }
        for (int j = 0; j < maxFil; j++) {
            for (int k = 0; k < maxCol; k++) {
                if (matriz[j][k] == obs) {
                    matriz[j][k] = 'L';
                }
            }
        }
        for (int i = 0; i < cant; i++) {
            do {
                aleoF = ale.nextInt(10);
                aleoC = ale.nextInt(10);
            } while (matriz[aleoF][aleoC] != 0);
            matriz[aleoF][aleoC] = obs;
        }
    }
    cambio = false;
}
    public static void main(String[] args){
tablas();
fin();
Personajes();
obstaculos(tablaY,'M',5);
obstaculos(tablaY,'D',5);
obstaculos(tablaV,'M',5);
obstaculos(tablaV,'R',5);
//ImprimirV();
ImprimirY();
        Scanner lee= new Scanner(System.in);
        String movimiento= lee.next();
        if (movimiento.equals("D")){
            tablaY[aleFYoda][aleCYoda]='L';
            aleCYoda=aleCYoda+1;
            tablaY[aleFYoda][aleCYoda]='Y';
            cambio=true;
        }
        tpenemigo(tablaY,'D',5);
        ImprimirY();
       // ImprimirV();
    }
}
