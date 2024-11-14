import java.util.Random;
import java.util.Scanner;
public class Main {
    private static final int Fila = 10;
    private static final int Columna = 10;
    private static final int Obstaculos = 5;
    private static int vidasY = 3;
    private static int vidasV = 3;
    private static int filaY;
    private static int columnaY;
    private static int filaD;
    private static int columnaD;
    private static int fuerarango;
    private static int fuerarango2;


    private static String[][] tableroYoda = new String[Fila][Columna];
    private static String[][] tableroDark = new String[Fila][Columna];
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean turnos;


    private static void tableroL() {//Llenar tableros de L
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {
                tableroYoda[i][j] = "L";
                tableroDark[i][j] = "L";
            }
        }
    }

    private static void imprimirD() {
        System.out.println("tablero dark");
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {

                System.out.print(tableroDark[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void ImprimirY() {//Imprimir tableros
        System.out.println("tablero yoda");
        for (int i = 0; i < Fila; i++) {
            for (int j = 0; j < Columna; j++) {

                System.out.print(tableroYoda[i][j] + " ");
            }
            System.out.println(" ");
        }

    }

    private static void fin() {//Crear fin del juego
        tableroYoda[9][9] = "F";
        tableroDark[9][9] = "F";
    }

    private static void LlenarJugador() { //Crear posicion de jugadores
        do {
            filaY = random.nextInt(10);
            columnaY = random.nextInt(10);
            filaD = random.nextInt(10);
            columnaD = random.nextInt(10);

        } while (tableroYoda[filaY][columnaY] != "L" && tableroDark[filaD][columnaD] != "L");
        tableroYoda[filaY][columnaY] = "Y";
        tableroDark[filaD][columnaD] = "V";
    }

    private static void LlenarObstaculoM(String Muro, String Vader, String Yoda, String Poti) {
        int filaM;
        int columnaM;
        //llenar tabla de muros
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroDark[filaM][columnaM] != "L");
            tableroDark[filaM][columnaM] = Muro;
        }
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroYoda[filaM][columnaM] != "L");
            tableroYoda[filaM][columnaM] = Muro;
        }

        //llenar tabla de R2D2
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroDark[filaM][columnaM] != "L");
            tableroDark[filaM][columnaM] = Vader;
        }
        //Llenar tabla de DarkMaul
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroYoda[filaM][columnaM] != "L");
            tableroYoda[filaM][columnaM] = Yoda;
        }
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroYoda[filaM][columnaM] != "L");
            tableroYoda[filaM][columnaM] = Poti;
        }
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (tableroDark[filaM][columnaM] != "L");
            tableroDark[filaM][columnaM] = Poti;
        }
    }



    public static void main(String[] args) {

        tableroL();
        fin();
        LlenarObstaculoM("M", "R", "D","P");
        LlenarJugador();


        System.out.println(filaY + " " + columnaY);
        do {



            while (turnos == false) {
                System.out.println("Turno YODA");
                ImprimirY();
                System.out.println("Dame la dirreccion");
                String leer = sc.nextLine();
                System.out.println("Dame el numero de movimientos (solo funciona con AWDS)");
                int nUsu = 1;

                switch (leer) {
                    case "A":
                        fuerarango2 = columnaY - nUsu;
                        if ((columnaY - nUsu) < 0) {
                            fuerarango2 = nUsu + columnaY;
                            int limite2 = 0;

                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }

                            switch (tableroYoda[filaY][fuerarango2]) {
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroYoda[filaY][columnaY] = "L";
                                    int filaYAletoria;
                                    int columnaYAletoria;
                                    do {
                                       filaYAletoria= random.nextInt(9);
                                       columnaYAletoria= random.nextInt(9);
                                    }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                    tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                    break;

                            }

                        break;
                    case "D":
                        fuerarango2 = columnaY + nUsu;
                        if ((columnaY + nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaY;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }

                            switch (tableroYoda[filaY][fuerarango2]) {
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    columnaY = fuerarango2;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroYoda[filaY][columnaY] = "L";
                                    int filaYAletoria;
                                    int columnaYAletoria;
                                    do {
                                        filaYAletoria= random.nextInt(9);
                                        columnaYAletoria= random.nextInt(9);
                                    }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                    tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                    break;
                            }
                        break;
                    case "S":
                        fuerarango = filaY + nUsu;
                        if ((filaY + nUsu) >= 10) {
                            fuerarango = filaY + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }

                            switch (tableroYoda[fuerarango][columnaY]) {
                                case "D":
                                    vidasY -= 1;
                                    System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroYoda[filaY][columnaY] = "L";
                                    int filaYAletoria;
                                    int columnaYAletoria;
                                    do {
                                        filaYAletoria= random.nextInt(9);
                                        columnaYAletoria= random.nextInt(9);
                                    }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                    tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                    break;
                            }
                        break;
                    case "W":
                        fuerarango = filaY - nUsu;
                        if ((filaY - nUsu) < 0) {
                            fuerarango = nUsu - filaY;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }
                            switch (tableroYoda[fuerarango][columnaY]) {
                                case "L":
                                    tableroYoda[filaY][columnaY] = "L";
                                    filaY = fuerarango;
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
                                    tableroYoda[filaY][columnaY] = "Y";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroYoda[filaY][columnaY] = "L";
                                    int filaYAletoria;
                                    int columnaYAletoria;
                                    do {
                                        filaYAletoria= random.nextInt(9);
                                        columnaYAletoria= random.nextInt(9);
                                    }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                    tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                    break;
                            }
                        break;
                    case "Q":
                        int fuerarango = filaY - nUsu;
                        int fuerarango2 = columnaY - nUsu;
                        if ((filaY - nUsu) < 0) {//(columnaY -nUsu) < 0
                            fuerarango = nUsu - filaY;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaY - nUsu) < 0) {
                            fuerarango2 = nUsu - columnaY;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroYoda[fuerarango][fuerarango2]) {
                            case "L":
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
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
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "F":
                                System.out.println("Fin");
                                filaY = fuerarango;
                                columnaY = fuerarango2;
                                break;
                            case "P":
                                tableroYoda[filaY][columnaY] = "L";
                                int filaYAletoria;
                                int columnaYAletoria;
                                do {
                                    filaYAletoria= random.nextInt(9);
                                    columnaYAletoria= random.nextInt(9);
                                }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                break;
                        }

                        break;
                    case "E":
                        fuerarango = filaY - nUsu;
                        fuerarango2 = columnaY + nUsu;
                        if ((filaY - nUsu) < 0) {
                            fuerarango = nUsu - filaY;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaY + nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaY;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroYoda[fuerarango][fuerarango2]) {
                            case "L":
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
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
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "P":
                                tableroYoda[filaY][columnaY] = "L";
                                int filaYAletoria;
                                int columnaYAletoria;
                                do {
                                    filaYAletoria= random.nextInt(9);
                                    columnaYAletoria= random.nextInt(9);
                                }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                break;
                        }
                        break;
                    case "Z":
                        fuerarango = filaY + nUsu;
                        fuerarango2 = columnaY - nUsu;
                        if ((filaY + nUsu) >= 10) {
                            fuerarango = filaY + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaY - nUsu) < 0) {
                            fuerarango2 = nUsu + columnaY;
                            int limite2 = 0;

                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroYoda[fuerarango][fuerarango2]) {
                            case "L":
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
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
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "P":
                                tableroYoda[filaY][columnaY] = "L";
                                int filaYAletoria;
                                int columnaYAletoria;
                                do {
                                    filaYAletoria= random.nextInt(9);
                                    columnaYAletoria= random.nextInt(9);
                                }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                break;
                        }
                        break;
                    case "C":
                        fuerarango = filaY + nUsu;
                        fuerarango2 = columnaY + nUsu;
                        if ((filaY + nUsu) >= 10) {
                            fuerarango = filaY + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaY + nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaY;
                            int limite2 = 0;

                            if (fuerarango2 >= 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroYoda[fuerarango][fuerarango2]) {
                            case "L":
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
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
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroYoda[filaY][columnaY] = "L";
                                filaY = fuerarango;
                                columnaY = fuerarango2;
                                tableroYoda[filaY][columnaY] = "Y";
                                break;
                            case "P":
                                tableroYoda[filaY][columnaY] = "L";
                                int filaYAletoria;
                                int columnaYAletoria;
                                do {
                                    filaYAletoria= random.nextInt(9);
                                    columnaYAletoria= random.nextInt(9);
                                }while (tableroYoda[filaYAletoria][columnaYAletoria]!= "L");
                                tableroYoda[filaYAletoria][columnaYAletoria] = "Y";
                                break;
                        }
                        break;

                }
                if (vidasY == 0) {
                    System.out.println("has perdido todas tus vidas Yoda");
                }
                if (tableroYoda[9][9] == "Y") {
                    System.out.println("has ganado Yoda");
                }
                turnos = true;
                ImprimirY();
                System.out.println(filaY + " " + columnaY);
            }

            while (turnos) {
                System.out.println("Turno Vader");
                imprimirD();
                System.out.println("Dame la dirreccion");
                String leer = sc.nextLine();
                System.out.println("Dame el numero de movimientos (solo funciona con AWDS)");
                int nUsu = 1;
                switch (leer) {
                    case "A":
                        fuerarango2 = columnaD - nUsu;
                        if ((columnaD - nUsu) < 0) {
                            fuerarango2 = nUsu + columnaD;
                            int limite2 = 0;

                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }

                            switch (tableroDark[filaD][fuerarango2]) {
                                case "D":
                                    vidasV -= 1;
                                    System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                    tableroDark[filaD][columnaD] = "L";
                                    columnaD = fuerarango2;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "L":
                                    tableroDark[filaD][columnaD] = "L";
                                    columnaD = fuerarango2;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroDark[filaD][columnaD] = "L";
                                    int filaDAletoria;
                                    int columnaDAletoria;
                                    do {
                                        filaDAletoria= random.nextInt(9);
                                        columnaDAletoria= random.nextInt(9);
                                    }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                    tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                    break;
                            }
                        break;
                    case "D":
                        fuerarango2 = columnaD + nUsu;
                        if ((columnaD+ nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaD;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }
                            switch (tableroDark[filaD][fuerarango2]) {
                                case "D":
                                    vidasV -= 1;
                                    System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                    tableroDark[filaD][columnaD] = "L";
                                    columnaD = fuerarango2;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "L":
                                    tableroDark[filaD][columnaD] = "L";
                                    columnaD = fuerarango2;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroDark[filaD][columnaD] = "L";
                                    int filaDAletoria;
                                    int columnaDAletoria;
                                    do {
                                        filaDAletoria= random.nextInt(9);
                                        columnaDAletoria= random.nextInt(9);
                                    }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                    tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                    break;
                            }

                        break;
                    case "S":
                        fuerarango = filaD + nUsu;
                        if ((filaD + nUsu) >= 10) {
                            fuerarango = filaD + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }
                            switch (tableroDark[fuerarango][columnaD]) {
                                case "D":
                                    vidasV -= 1;
                                    System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                    tableroDark[filaD][columnaD] = "L";
                                    filaD = fuerarango;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "L":
                                    tableroDark[filaD][columnaD] = "L";
                                    filaD = fuerarango;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroDark[filaD][columnaD] = "L";
                                    int filaDAletoria;
                                    int columnaDAletoria;
                                    do {
                                        filaDAletoria= random.nextInt(9);
                                        columnaDAletoria= random.nextInt(9);
                                    }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                    tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                    break;
                            }

                        break;
                    case "W":
                        fuerarango = filaD - nUsu;
                        if ((filaD - nUsu) < 0) {
                            fuerarango = nUsu - filaD;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }

                            switch (tableroDark[fuerarango][columnaD]) {
                                case "L":
                                    tableroDark[filaD][columnaD] = "L";
                                    filaD = fuerarango;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "M":
                                    System.out.println("no se puede mover");
                                    break;
                                case "D":
                                    vidasV -= 1;
                                    System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                    tableroDark[filaD][columnaD] = "L";
                                    filaD = fuerarango;
                                    tableroDark[filaD][columnaD] = "V";
                                    break;
                                case "F":
                                    System.out.println("Fin");
                                    break;
                                case "P":
                                    tableroDark[filaD][columnaD] = "L";
                                    int filaDAletoria;
                                    int columnaDAletoria;
                                    do {
                                        filaDAletoria= random.nextInt(9);
                                        columnaDAletoria= random.nextInt(9);
                                    }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                    tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                    break;
                            }

                        break;
                    case "Q":
                        int fuerarango = filaD - nUsu;
                        int fuerarango2 = columnaD - nUsu;
                        if ((filaD - nUsu) < 0) {//(columnaD -nUsu) < 0
                            fuerarango = nUsu - filaD;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaD - nUsu) < 0) {
                            fuerarango2 = nUsu - columnaD;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroDark[fuerarango][fuerarango2]) {
                            case "L":
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "M":
                                System.out.println("no se puede mover");
                                break;
                            case "D":
                                vidasV -= 1;
                                System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "F":
                                System.out.println("Fin");
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                break;
                            case "P":
                                tableroDark[filaD][columnaD] = "L";
                                int filaDAletoria;
                                int columnaDAletoria;
                                do {
                                    filaDAletoria= random.nextInt(9);
                                    columnaDAletoria= random.nextInt(9);
                                }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                break;
                        }

                        break;
                    case "E":
                        fuerarango = filaD - nUsu;
                        fuerarango2 = columnaD + nUsu;
                        if ((filaD - nUsu) < 0) {
                            fuerarango = nUsu - filaD;
                            int limite = 0;

                            if (fuerarango != 10) {
                                limite = 10 - fuerarango;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaD + nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaD;
                            int limite2 = 0;
                            if (fuerarango2 != 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroDark[fuerarango][fuerarango2]) {
                            case "L":
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "M":
                                System.out.println("no se puede mover");
                                break;
                            case "D":
                                vidasV -= 1;
                                System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "P":
                                tableroDark[filaD][columnaD] = "L";
                                int filaDAletoria;
                                int columnaDAletoria;
                                do {
                                    filaDAletoria= random.nextInt(9);
                                    columnaDAletoria= random.nextInt(9);
                                }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                break;
                        }
                        break;
                    case "Z":
                        fuerarango = filaD + nUsu;
                        fuerarango2 = columnaD - nUsu;
                        if ((filaD + nUsu) >= 10) {
                            fuerarango = filaD + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaD - nUsu) < 0) {
                            fuerarango2 = nUsu + columnaD;
                            int limite2 = 0;

                            if (fuerarango2 != 10) {
                                limite2 = 10 - fuerarango2;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroDark[fuerarango][fuerarango2]) {
                            case "L":
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "M":
                                System.out.println("no se puede mover");
                                break;
                            case "D":
                                vidasV -= 1;
                                System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "P":
                                tableroDark[filaD][columnaD] = "L";
                                int filaDAletoria;
                                int columnaDAletoria;
                                do {
                                    filaDAletoria= random.nextInt(9);
                                    columnaDAletoria= random.nextInt(9);
                                }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                break;
                        }
                        break;
                    case "C":
                        fuerarango = filaD + nUsu;
                        fuerarango2 = columnaD + nUsu;
                        if ((filaD + nUsu) >= 10) {
                            fuerarango = filaD + nUsu;
                            int limite = 0;

                            if (fuerarango >= 10) {
                                limite = fuerarango - 10;
                                fuerarango = limite;
                            }
                        }

                        if ((columnaD + nUsu) >= 10) {
                            fuerarango2 = nUsu + columnaD;
                            int limite2 = 0;

                            if (fuerarango2 >= 10) {
                                limite2 = fuerarango2 - 10;
                                fuerarango2 = limite2;
                            }
                        }
                        switch (tableroDark[fuerarango][fuerarango2]) {
                            case "L":
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "M":
                                System.out.println("no se puede mover");
                                break;
                            case "D":
                                vidasV -= 1;
                                System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "F":
                                System.out.println("Fin");
                                tableroDark[filaD][columnaD] = "L";
                                filaD = fuerarango;
                                columnaD = fuerarango2;
                                tableroDark[filaD][columnaD] = "V";
                                break;
                            case "P":
                                tableroDark[filaD][columnaD] = "L";
                                int filaDAletoria;
                                int columnaDAletoria;
                                do {
                                    filaDAletoria= random.nextInt(9);
                                    columnaDAletoria= random.nextInt(9);
                                }while (tableroDark[filaDAletoria][columnaDAletoria]!= "L");
                                tableroDark[filaDAletoria][columnaDAletoria] = "V";
                                break;
                        }
                        break;

                }
                if (vidasV == 0) {
                    System.out.println("has perdido todas tus vidas Vader");
                }
                if (tableroDark[9][9] == "V") {
                    System.out.println("has ganado Vader");
                }
                turnos = false;
                imprimirD();
            }
        } while (vidasY > 0||vidasV > 0||tableroYoda[9][9] != "Y"||tableroDark[9][9] != "V") ;
    }
}
