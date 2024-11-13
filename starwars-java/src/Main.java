import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int Fila= 10;
    private static final int Columna= 10;
    private static final int Obstaculos= 5;
    private static int vidasY= 3;
    private static int vidasV= 3;
    private static int filaY ;
    private static int columnaY;
    private static int filaD ;
    private static int columnaD;

    private static String[][] tableroYoda= new String[Fila][Columna];
    private static String[][] tableroDark= new String[Fila][Columna];
    static Random random= new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean turnos= false;


    private static void tableroL(){//Llenar tableros de L
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {
                tableroYoda[i][j]= "L";
                tableroDark[i][j]= "L";
            }
        }
    }

    private static void imprimirD(){
        System.out.println("tablero dark");
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {

                System.out.print(tableroDark[i][j]+" ");
            }
            System.out.println(" ");
        }
    }

    private static void ImprimirY(){//Imprimir tableros
        System.out.println("tablero yoda");
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {

                System.out.print(tableroYoda[i][j]+" ");
            }
            System.out.println(" ");
        }

    }
    private static void fin(){//Crear fin del juego
        tableroYoda[9][9]= "F";
        tableroDark[9][9]= "F";
    }

    private static void LlenarJugador(){ //Crear posicion de jugadores
        do {
         filaY = random.nextInt(10);
         columnaY = random.nextInt(10);
         filaD = random.nextInt(10);
         columnaD = random.nextInt(10);

        }while (tableroYoda[filaY][columnaY] != "L" && tableroDark[filaD][columnaD] != "L");
        tableroYoda[filaY][columnaY]= "Y";
        tableroDark[filaD][columnaD]= "V";
    }

    private static void LlenarObstaculoM(String Muro, String Vader, String Yoda){
        int filaM;
        int columnaM;
        //llenar tabla de muros
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM= random.nextInt(10-1);
                columnaM= random.nextInt(10-1);
            }while (tableroDark[filaM][columnaM]!= "L");
            tableroDark[filaM][columnaM]= Muro;
        }
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM= random.nextInt(10-1);
                columnaM= random.nextInt(10-1);
            }while (tableroYoda[filaM][columnaM]!= "L");
            tableroYoda[filaM][columnaM]= Muro;
        }

        //llenar tabla de R2D2
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM= random.nextInt(10-1);
                columnaM= random.nextInt(10-1);
            }while (tableroDark[filaM][columnaM]!= "L");
            tableroDark[filaM][columnaM]= Vader;
        }
        //Llenar tabla de DarkMaul
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM= random.nextInt(10-1);
                columnaM= random.nextInt(10-1);
            }while (tableroYoda[filaM][columnaM]!= "L");
            tableroYoda[filaM][columnaM]= Yoda;
        }
    }


    public static void main(String[] args) {

        tableroL();
        fin();
        LlenarJugador();
        LlenarObstaculoM("M","R","D");
        ImprimirY();
       // imprimirD();

        System.out.println(filaY+" "+ columnaY);
        //do {
            System.out.println("Dame la dirreccion");
            String leer = sc.nextLine();
        System.out.println("Dame el numero de movimientos (solo funciona con AWDS)");
            int nUsu=1;

          //  while (turnos==false) {
        System.out.println("Turno YODA");
                switch (leer){
                    case "A":
                        if ((columnaY-nUsu) < 0) {
                            int fuerarango = nUsu - columnaY;
                            int limite = 0;
                           if (fuerarango != 10) {
                               limite = 10 - fuerarango;
                           }

                                switch (tableroYoda[filaY][limite]){
                                    case "D":
                                        vidasY -= 1;
                                        System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                        tableroYoda[filaY][columnaY] = "L";
                                        columnaY = limite;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                    case "L":
                                        tableroYoda[filaY][columnaY] = "L";
                                        columnaY = limite;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                    case "M":
                                        System.out.println("no se puede mover");
                                        break;
                                    case "F":
                                        System.out.println("Fin");
                                        break;
                                }

                        }else{

                            switch (tableroYoda[filaY][columnaY-nUsu]) {
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = columnaY-nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = columnaY - nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                            }
                        }

                        break;
                    case "D":
                        if ((columnaY+nUsu) >= 10) {
                            int fuerarango = nUsu + columnaY;
                            int limite = 0;
                            if (fuerarango != 10) {
                                limite = fuerarango-10;
                            }

                                switch (tableroYoda[filaY][limite]){
                                    case "D":
                                        vidasY -= 1;
                                        System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                        tableroYoda[filaY][columnaY] = "L";
                                        columnaY = limite;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                    case "L":
                                        tableroYoda[filaY][columnaY] = "L";
                                        columnaY = limite;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                    case "M":
                                        System.out.println("no se puede mover");
                                        break;
                                    case "F":
                                        System.out.println("Fin");
                                        break;
                                }

                        }else{

                            switch (tableroYoda[filaY][columnaY + nUsu]){
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = columnaY+nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = columnaY + nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                            }
                        }
                        break;
                    case "S":
                        if ((filaY+nUsu) >= 10) {
                            int fuerarango = nUsu + filaY;
                            int limite = fuerarango-10;

                            switch (tableroYoda[limite][columnaY]){
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = limite;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = limite;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                            }
                        }else{
                            switch (tableroYoda[filaY+nUsu][columnaY]){
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY += nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY += nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY += nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                            }
                        }


                        break;
                    case "W":
                        if ((filaY -nUsu) < 0) {
                            int fuerarango = nUsu - filaY;
                            int limite =0;
                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                            }

                            switch (tableroYoda[limite][columnaY]){
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = limite;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = limite;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                        System.out.println("Fin");
                                        break;
                            }
                        }else{
                                switch (tableroYoda[filaY-nUsu][columnaY]){
                                    case "M":
                                        System.out.println("no se puede mover");
                                        break;
                                    case "D":
                                        vidasY -= 1;
                                        System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                        tableroYoda[filaY][columnaY] = "L";
                                        filaY -= nUsu;
                                        tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                    case "L":
                                        tableroYoda[filaY][columnaY] = "L";
                                        filaY -= nUsu;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                    case "F":
                                        System.out.println("Fin");
                                        tableroYoda[filaY][columnaY] = "L";
                                        filaY -= nUsu;
                                        tableroYoda[filaY][columnaY] = "Y";
                                        break;
                                }
                        }
                        break;
                    case "Q":
                        int fuerarango= filaY - nUsu ;
                        int fuerarango2 = columnaY - nUsu;
                        if ((filaY -nUsu) < 0||(columnaY -nUsu) < 0){
                        if ((filaY -nUsu) < 0) {//(columnaY -nUsu) < 0
                            fuerarango = nUsu - filaY;
                            int limite =0 ;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango= limite;
                            }}

                        if ((columnaY -nUsu) < 0) {
                            fuerarango2 = nUsu - columnaY;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }
                            switch (tableroYoda[fuerarango][fuerarango2]){
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY=fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY= fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    filaY = fuerarango;
                                    columnaY= fuerarango2;
                                    break;
                            }
                        }else{
                            switch (tableroYoda[fuerarango][fuerarango2]){
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY -= nUsu;
                                    columnaY -= nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY -= nUsu;
                                    columnaY -= nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY -= nUsu;
                                    columnaY -= nUsu;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                            }
                        }
                        break;
                    case "E":
                         fuerarango= filaY - nUsu ;
                         fuerarango2 = columnaY + nUsu;
                        if ((filaY -nUsu) < 0||(columnaY +nUsu) >= 10){
                            if ((filaY -nUsu) < 0) {//(columnaY -nUsu) < 0
                                fuerarango = nUsu - filaY;
                                int limite =0 ;

                                if (fuerarango != 10) {
                                    limite = 10 - fuerarango;
                                    fuerarango= limite;
                                }}

                            if ((columnaY + nUsu) >= 10) {
                                fuerarango2 = nUsu + columnaY;
                                int limite2 = 0;
                                if (fuerarango2 != 10) {
                                    limite2 =  fuerarango2-10;
                                    fuerarango2 = limite2;
                                }
                            }
                            switch (tableroYoda[fuerarango][fuerarango2]){
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY=fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY= fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY= fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                            }
                        }else{
                            switch (tableroYoda[fuerarango][fuerarango2]){
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY =fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY =fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    columnaY= fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                            }
                        }
                        break;
                    case "Z":

                        break;
                    case "C":

                        break;

                }
        ImprimirY();
        System.out.println(filaY+" "+ columnaY);
        //    };
      //  }while ();

    }
}