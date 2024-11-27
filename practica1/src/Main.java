import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int columna=10 ;
    private static final int fila =10;
    private static int[][] movimientos = new int[8][2];
    private static String[][] tablaY = new String[fila][columna];
    private static String[][] tablaD = new String[fila][columna];
    private static String[] teclas = {"A","D","W","S","Q","E","Z","C"};
    private static int colcheck, filcheck;
    private static Random ale = new Random();
    private static boolean cambio = true;
    private static int vidasY= 5;
    private static int vidasD=5;
   private static int filAleY,colAleY,filAleD,colAleD;

    private static void llenarTablero(String[][] matriz){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < fila; j++) {
                matriz[i][j]= "L";
            }
        }
    }
    private static void imprimirJugadores(String[][] matriz1,String[][] matriz2, String pers1,String pers2){


        do {
            filAleY = ale.nextInt(10);
            colAleY = ale.nextInt(10);
            filAleD = ale.nextInt(10);
            colAleD = ale.nextInt(10);
        }while((matriz1[filAleY][colAleY]!="L") && (matriz2[filAleD][colAleD]!="L") );
        matriz1[filAleY][colAleY]=pers1;
        matriz2[filAleD][colAleD]=pers2;
    }


    private static void finJuego(String[][] matriz){
        matriz[9][9]="F";
    }

    private static void obs(String[][] matriz, String obstaculo,int cant){
        for (int i = 0; i < cant; i++) {
            int filAle,colAle;
            do {
                filAle = ale.nextInt(10);
                colAle = ale.nextInt(10);
            }while(matriz[filAle][colAle]!="L" );
            matriz[filAle][colAle]=obstaculo;
        }
        }

        private static void limitesYoda(int npos, int nmov){

            colcheck=colAleY+(movimientos[npos][1]*nmov);
            if (colcheck>=10){
                colcheck = colcheck-columna;
            }
            if (colcheck<0) {
                colcheck = colcheck+columna;
            }

            filcheck=filAleY+(movimientos[npos][0]*nmov);
            if (filcheck>=10){
                filcheck= filcheck-fila;
            }
            if (filcheck<0) {
                filcheck = filcheck+fila;
            }


        }

    private static void limitesDark(int npos, int nmov){
        colcheck=colAleD+(movimientos[npos][1]*nmov);
        if (colcheck>=10){
            colcheck = colcheck-columna;
        }
        if (colcheck<0) {
            colcheck = colcheck+columna;
        }

        filcheck=filAleD+(movimientos[npos][0]*nmov);
        if (filcheck>=10){
            filcheck= filcheck-fila;
        }
        if (filcheck<0) {
            filcheck = filcheck+fila;
        }

    }
 private static void sumasdcamino(){
        //********************************************************
        //A
        movimientos[0][0] =0;
        movimientos[0][1] =-1;
        //D
        movimientos[1][0] =0;
        movimientos[1][1] =1;
        //W
        movimientos[2][0] =-1;
        movimientos[2][1] =0;
        //S
        movimientos[3][0] =1;
        movimientos[3][1] =0;
        //Q
        movimientos[4][0] =-1;
        movimientos[4][1] =-1;
        //E
        movimientos[5][0] =-1;
        movimientos[5][1] =1;
        //Z
        movimientos[6][0] =1;
        movimientos[6][1] =-1;
        //C
        movimientos[7][0] =1;
        movimientos[7][1] =1;


    }
    private static void imprimirTablero(String[][] matriz){
        System.out.println();
        System.out.println();
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) {
llenarTablero(tablaY);
        llenarTablero(tablaD);
        finJuego(tablaY);
        finJuego(tablaD);
        imprimirJugadores(tablaY,tablaD,"Y","V");
        obs(tablaY,"M",5);
        obs(tablaY,"P",5);
        obs(tablaY,"D",5);
        obs(tablaD,"M",5);
        obs(tablaD,"P",5);
        obs(tablaD,"R",5);
    imprimirTablero(tablaY);

    sumasdcamino();
        Scanner lee= new Scanner(System.in);
        System.out.println("Empieza Yoda");
        do {
            System.out.println("Dame la Direccion que quieres A,S,D,W,Q,E,Z,C");
        String usuT= lee.next();
            System.out.println("Dame el numero de veces que quieres que se mueva en esa direccion");
        int numMovimientos = lee.nextInt();

        usuT= String.valueOf(usuT.charAt(0));
        usuT= usuT.toUpperCase();
        int posicion=0;
        for (int i = 0; i < teclas.length; i++) {
            if (usuT.equals(teclas[i])){
                posicion=i;
            }
        }
        if (cambio){
            limitesYoda(posicion,numMovimientos);
        }else {
            limitesDark(posicion,numMovimientos);
        }

switch (cambio) {
    case true:
        switch (tablaY[filcheck][colcheck]) {
            case "L":
                tablaY[filAleY][colAleY] = "L";
                tablaY[filcheck][colcheck] = "Y";
                filAleY = filcheck;
                colAleY = colcheck;
                break;
            case "M":
                System.out.println("no se puede mover hay un muro");
                break;
            case "P":
                System.out.println("pisaste una poti enderpearl");
                tablaY[filAleY][colAleY] = "L";
                do {
                    filAleY = ale.nextInt(10);
                    colAleY = ale.nextInt(10);
                } while ((tablaY[filAleY][colAleY] != "L"));
                tablaY[filAleY][colAleY] = "Y";

                break;
            case "D":
                --vidasY;
                System.out.println("pisaste un dark perdiste una vida te quedan: " + vidasY);
                tablaY[filAleY][colAleY] = "L";
                tablaY[filcheck][colcheck] = "Y";
                filAleY = filcheck;
                colAleY = colcheck;
                break;
            case "F":
                tablaY[filAleY][colAleY] = "L";
                tablaY[filcheck][colcheck] = "Y";
                filAleY = filcheck;
                colAleY = colcheck;
                break;
        }
        imprimirTablero(tablaY);
        if (tablaY[9][9].equals("Y")) {
            System.out.println("Ganaste Yoda");
            break;
        }
        cambio = false;
        System.out.println("TURNO DE VADER");
        imprimirTablero(tablaD);
        break;
    case false:
        switch (tablaD[filcheck][colcheck]) {
            case "L":
                tablaD[filAleD][colAleD] = "L";
                tablaD[filcheck][colcheck] = "V";
                filAleD = filcheck;
                colAleD = colcheck;
                break;
            case "M":
                System.out.println("no se puede mover hay un muro");
                break;
            case "P":
                System.out.println("pisaste una poti enderpearl");
                tablaD[filAleD][colAleD] = "L";
                do {
                    filAleD = ale.nextInt(10);
                    colAleD = ale.nextInt(10);
                } while ((tablaD[filAleD][colAleD] != "L"));
                tablaD[filAleD][colAleD] = "V";

                break;
            case "D":
                --vidasY;
                System.out.println("pisaste un dark perdiste una vida te quedan: " + vidasD);
                tablaD[filAleD][colAleD] = "L";
                tablaD[filcheck][colcheck] = "V";
                filAleD = filcheck;
                colAleD = colcheck;
                break;
            case "F":
                tablaD[filAleD][colAleD] = "L";
                tablaD[filcheck][colcheck] = "V";
                filAleD = filcheck;
                colAleD = colcheck;
                break;
        }
        imprimirTablero(tablaD);
        if (tablaD[9][9].equals("V")) {
            System.out.println("Ganaste Vader");
            break;
        }
        System.out.println("Turno de Yoda");
        imprimirTablero(tablaY);
cambio = true;
        break;
}

        }while (vidasY!=0||vidasD!=0);
        }
}