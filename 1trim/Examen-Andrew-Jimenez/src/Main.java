import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final int fila= 10;
    private static final int columna= 10;
    private static int colcheck=0;
    private static int filcheck=0;
    private static int fAleY;
    private static int cAleY;
    private static int fAleD;
    private static int cAleD;
    private static boolean finalistaY=false, finalistaD=false;
    private static int vidasY=10;
    private static int vidasD=10;
    private static String[][] tableroY = new String[fila][columna];
    private static String[][] tableroD = new String[fila][columna];
    private static String[][] tableroDcopia = new String[fila][columna];
    private static String[][] tableroYcopia = new String[fila][columna];
    private static String[] movimientos ={"A","D","S","W","Q","E","Z","C"};
    private static int[][] sumaPosi=new int[8][2];
    private static Random ale = new Random();
    private static Scanner lee = new Scanner(System.in);
    private static boolean cambio = true;
    private static boolean poderActivadoY=false,poderActivadoD=false;
    private static int[][] trampasYoda=new int[5][2];
    private static int[][] trampasDark=new int[5][2];

    private static void llenarTablero(String[][] matriz){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                matriz[i][j]="L";
            }
        }
    }
    private static void meta(){
        tableroY[9][9]="F";
        tableroYcopia[9][9]="F";
        tableroDcopia[9][9]="F";
        tableroD[9][9]="F";
    }
    private static void jugador(){
        do {
            fAleY= ale.nextInt(fila);
            cAleY= ale.nextInt(columna);
            fAleD= ale.nextInt(fila);
            cAleD= ale.nextInt(columna);
        }while(!tableroY[fAleY][cAleY].equals("L")&&!tableroD[fAleD][cAleD].equals("L"));
        tableroY[fAleY][cAleY]="Y";
        tableroYcopia[fAleY][cAleY]="Y";
        tableroD[fAleD][cAleD]="V";
        tableroDcopia[fAleD][cAleD]="V";
    }
    private static void obstaculos(String[][] matriz,String[][] matrizCopia,int cant, String obsTablero){
        for (int i = 0; i < cant; i++) {
            int fAle,cAle;
            do {
                fAle= ale.nextInt(fila);
                cAle= ale.nextInt(columna);
            }while(!matriz[fAle][cAle].equals("L"));
            matriz[fAle][cAle]=obsTablero;
            matrizCopia[fAle][cAle]=obsTablero;
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (matriz[i][j].equals("T")){
                    matriz[i][j]="L";
                }
            }
        }
    }

    private static void tamprasalmacenarxy(String[][] matrizcopia1,String[][] matrizCopia2,int cant){
        for (int i = 0; i < cant; i++) {
            int fAleYoda,cAleYoda,fAleDark,cAleDark;
            do {
                fAleYoda= ale.nextInt(fila);
                cAleYoda= ale.nextInt(columna);
                fAleDark= ale.nextInt(fila);
                cAleDark= ale.nextInt(columna);
            }while(!matrizcopia1[fAleYoda][cAleYoda].equals("L")&&!matrizCopia2[fAleDark][cAleDark].equals("L"));
            matrizcopia1[fAleYoda][cAleYoda]="T";
            matrizCopia2[fAleDark][cAleDark]="T";
            trampasYoda[i][0]=fAleYoda;
            trampasYoda[i][1]=cAleYoda;
            trampasDark[i][0]=fAleDark;
            trampasDark[i][1]=cAleDark;
        }
    }
    private static void generarNuevasTrampas(int cant,int[][] matriz,String[][] matrizcopia){
        for (int i = 0; i < cant; i++) {
            int filacontrampas, columnacontrampas;
            do {
                filacontrampas= ale.nextInt(fila);
                columnacontrampas= ale.nextInt(columna);
            }while(matriz[i][1]!=columnacontrampas && matriz[i][0]!= filacontrampas);
            matrizcopia[matriz[i][0]][matriz[i][1]] = "L";
            matrizcopia[filacontrampas][columnacontrampas]="T";
            matriz[i][0]=filacontrampas;
            matriz[i][1]=columnacontrampas;
        }
    }
    private static void movMatriz(){
        //A
        sumaPosi[0][0]=0;
        sumaPosi[0][1]=-1;
        //D
        sumaPosi[1][0]=0;
        sumaPosi[1][1]=1;
        //S
        sumaPosi[2][0]=1;
        sumaPosi[2][1]=0;
        //W
        sumaPosi[3][0]=-1;
        sumaPosi[3][1]=0;
        //Q
        sumaPosi[4][0]=-1;
        sumaPosi[4][1]=-1;
        //E
        sumaPosi[5][0]=-1;
        sumaPosi[5][1]=1;
        //Z
        sumaPosi[6][0]=1;
        sumaPosi[6][1]=-1;
        //C
        sumaPosi[7][0]=1;
        sumaPosi[7][1]=1;
    }
    private static void imprimirtablero(String[][] matriz){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                System.out.print(matriz[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private static void trampasCambio(int cant,String[][] matriz){
        int ctrampale,ftrampale;
        for (int i = 0; i < cant; i++) {
            do {
                ctrampale= ale.nextInt(columna);
                ftrampale = ale.nextInt(fila);
            }while(matriz[ftrampale][ctrampale]!="L");
            matriz[ftrampale][ctrampale]="0";

        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (matriz[i][j].equals("T")){
                    matriz[i][j]="L";
                }
            }
        }
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (matriz[i][j].equals("0")){
                    matriz[i][j]="T";
                }
            }
        }
    }

    public static void main(String[] args) {
        llenarTablero(tableroY);
        llenarTablero(tableroYcopia);
        llenarTablero(tableroD);
        llenarTablero(tableroDcopia);
        meta();
        jugador();
        obstaculos(tableroY,tableroYcopia,5,"D");
        obstaculos(tableroD,tableroDcopia,5,"R");

        tamprasalmacenarxy(tableroYcopia,tableroDcopia,5);
        System.out.println("tablero yoda");


        //***************************************************************************
         do {
             if (cambio){
                 System.out.println("turno de yoda");
                 System.out.println("tablero yoda copia");
                 imprimirtablero(tableroYcopia);
                 System.out.println("tablero yoda Normal");
                 imprimirtablero(tableroY);
             }else {
                 System.out.println("turno de Vader");
                 System.out.println("tablero Dark copia");
                 imprimirtablero(tableroDcopia);
                 System.out.println("tablero Dark Normal");
                 imprimirtablero(tableroD);
             }
             String poderespecial="N";
             if (cambio){
             if (poderActivadoY == false){
                 System.out.println("quieres activar el poder especial si quieres pulsa *P*");
                 poderespecial= lee.next();
                 poderespecial = String.valueOf(poderespecial.charAt(0));
                 poderespecial= poderespecial.toUpperCase();
                 if (poderespecial.equals("P")) {
                     poderActivadoY = true;
                 }
             }else{
                 System.out.println("Ya activaste el poder");}
             }else {
                 if (poderActivadoD == false){
                     System.out.println("quieres activar el poder especial si quieres pulsa *P*");
                     poderespecial= lee.next();
                     poderespecial = String.valueOf(poderespecial.charAt(0));
                     poderespecial= poderespecial.toUpperCase();
                     if (poderespecial.equals("P")) {
                         poderActivadoD = true;
                     }

                 }else {
                     System.out.println("Ya activaste el poder");
                 }
             }

             //*****************************************************************************
             System.out.println("Dame la direccion por la que quieres que se mueva(si activaste el poder ignora estos campos)");
             String usuMov= lee.next();
             usuMov = String.valueOf(usuMov.charAt(0));
             usuMov= usuMov.toUpperCase();
             int posiMov= 0;
             movMatriz();
             for (int i = 0; i < movimientos.length; i++) {
                 if (movimientos[i].equals(usuMov)){
                     posiMov=i;
                 }
             }

             //*****************************************************************************
             System.out.println("dime las veces que quieres que se mueva 0-3");
             int NumMovimientos = lee.nextInt(4);
//limites*****************************************************************************
             if (poderespecial.equals("P")) {
                 System.out.println("Activaste el poder");
                 int filajugador, coljugador;
                 if (cambio){
                     do {
                         System.out.println("Dame una fila para moverte");
                         filajugador = lee.nextInt();
                         System.out.println("Dame una columna para moverte");
                         coljugador = lee.nextInt();
                     } while (!tableroYcopia[filajugador][coljugador].equals("L")&& !tableroYcopia[filajugador][coljugador].equals("D"));
                     filcheck=filajugador;
                     colcheck=coljugador;
             }
             if (!cambio){
                     do {
                         System.out.println("Dame una fila para moverte");
                         filajugador = lee.nextInt();
                         System.out.println("Dame una columna para moverte");
                         coljugador = lee.nextInt();
                     } while (!tableroDcopia[filajugador][coljugador].equals("L")&& !tableroDcopia[filajugador][coljugador].equals("R"));
                     filcheck=filajugador;
                     colcheck=coljugador;
             }
             }else {
             if (cambio){
                 colcheck= cAleY + (sumaPosi[posiMov][1]*NumMovimientos);
                 if (colcheck>=columna){
                     colcheck=colcheck-columna;
                 }if (colcheck<0){
                     colcheck=colcheck+columna;
                 }
                 filcheck= fAleY + (sumaPosi[posiMov][0]*NumMovimientos);
                 if (filcheck>=fila){
                     filcheck=filcheck-fila;
                 }if (filcheck<0){
                     filcheck=filcheck+fila;
                 }
             }else {colcheck= cAleD + (sumaPosi[posiMov][1]*NumMovimientos);
                 if (colcheck>=columna){
                     colcheck=colcheck-columna;
                 }if (colcheck<0){
                     colcheck=colcheck+columna;
                 }
                 filcheck= fAleD + (sumaPosi[posiMov][0]*NumMovimientos);
                 if (filcheck>=fila){
                     filcheck=filcheck-fila;
                 }if (filcheck<0){
                     filcheck=filcheck+fila;
                 }}}

         //*****************************************************************************

             if (cambio){
            switch (tableroYcopia[filcheck][colcheck]){
                case "L":
                    tableroYcopia[fAleY][cAleY]="L";
                    tableroY[fAleY][cAleY]="L";
                    tableroYcopia[filcheck][colcheck]="Y";
                    tableroY[filcheck][colcheck]="Y";
                    fAleY = filcheck;
                    cAleY = colcheck;
                    break;
                case "T":
                    --vidasY;
                    System.out.println("has pisado una trampa te quedan "+ vidasY);
                    break;
                case "F":
                    System.out.println("Has ganado");
                    tableroYcopia[fAleY][cAleY]="L";
                    tableroY[fAleY][cAleY]="L";
                    tableroYcopia[filcheck][colcheck]="Y";
                    tableroY[filcheck][colcheck]="Y";
                    fAleY = filcheck;
                    cAleY = colcheck;
                    finalistaY = true;
                    break;
                case "D":
                    --vidasY;
                    System.out.println("Has pisado un dark pierdes una vida te quedan: "+vidasY);
                    tableroYcopia[fAleY][cAleY]="L";
                    tableroY[fAleY][cAleY]="L";
                    tableroYcopia[filcheck][colcheck]="Y";
                    tableroY[filcheck][colcheck]="Y";
                    fAleY = filcheck;
                    cAleY = colcheck;
                    break;

            }
            //trampasCambio(5,tableroYcopia);
                 generarNuevasTrampas(5,trampasYoda,tableroYcopia);
//*****************************************************************************
        }else {
switch (tableroDcopia[filcheck][colcheck]){
            case "L":
                tableroDcopia[fAleD][cAleD]="L";
                tableroD[fAleD][cAleD]="L";
                tableroDcopia[filcheck][colcheck]="V";
                tableroD[filcheck][colcheck]="V";
                fAleD = filcheck;
                cAleD = colcheck;
                break;
            case "T":
                --vidasD;
                System.out.println("has pisado una trampa te quedan "+ vidasD);
                break;
            case "F":
                System.out.println("Has ganado");
                tableroDcopia[fAleD][cAleD]="L";
                tableroD[fAleD][cAleD]="L";
                tableroDcopia[filcheck][colcheck]="V";
                tableroD[filcheck][colcheck]="V";
                fAleD = filcheck;
                cAleD = colcheck;
                finalistaD = true;
                break;
            case "R":
                --vidasD;
                System.out.println("Has pisado un R2D2 pierdes una vida te quedan: "+vidasD);
                tableroDcopia[fAleD][cAleD]="L";
                tableroD[fAleD][cAleD]="L";
                tableroDcopia[filcheck][colcheck]="V";
                tableroD[filcheck][colcheck]="V";
                fAleD = filcheck;
                cAleD = colcheck;
                break;
        }
                 //trampasCambio(5,tableroYcopia);
                 generarNuevasTrampas(5,trampasDark,tableroDcopia);
        }
             //*****************************************************************************
             if (cambio){
             System.out.println("tablero yoda copia");
             imprimirtablero(tableroYcopia);
             System.out.println("tablero yoda Normal");
             imprimirtablero(tableroY);
             cambio=false;}
             else {
                 System.out.println("tablero Dark copia");
                 imprimirtablero(tableroDcopia);
                 System.out.println("tablero Dark Normal");
                 imprimirtablero(tableroD);
                 cambio= true;
             }

//*****************************************************************************
             if (finalistaD){
                 break;
             }
             if (finalistaY){
                 break;
             }
             //*****************************************************************************
        }while((vidasY != 0) || (vidasD != 0) || !finalistaY || !finalistaD);
    }
}