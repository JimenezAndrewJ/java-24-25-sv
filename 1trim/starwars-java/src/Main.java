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
    private static String leerY;
    private static String leerD;

    private static String[][] tableroYoda = new String[Fila][Columna];
    private static String[][] tableroDark = new String[Fila][Columna];
    static Random random = new Random();
    static Scanner sc = new Scanner(System.in);
    static boolean turnos;

    private static void movimientoG(String[][] matriz,String pers,String mov){
        if (matriz.equals(tableroYoda)) {
            switch (mov) {
                case "A":
                case "D":
                    switch (matriz[filaY][fuerarango2]) {
                        case "D":
                            vidasY -= 1;
                            System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                            matriz[filaY][columnaY] = "L";
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "L":
                            matriz[filaY][columnaY] = "L";
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "M":
                            System.out.println("no se puede mover");
                            break;
                        case "F":
                            System.out.println("Fin");
                            matriz[filaY][columnaY] = "L";
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "P":
                            matriz[filaY][columnaY].equals("L");
                            int filaYAletoria;
                            int columnaYAletoria;
                            do {
                                filaYAletoria = random.nextInt(9);
                                columnaYAletoria = random.nextInt(9);
                            } while (matriz[filaYAletoria][columnaYAletoria] != "L");
                            filaY = filaYAletoria;
                            columnaY = columnaYAletoria;
                            matriz[filaY][columnaY] = pers;
                            break;
                    }
                    break;
                case "W":
                case "S":
                    switch (matriz[fuerarango][columnaY]) {
                        case "D":
                            vidasY -= 1;
                            System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "L":
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "M":
                            System.out.println("no se puede mover");
                            break;
                        case "F":
                            System.out.println("Fin");
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "P":
                            matriz[filaY][columnaY] = "L";
                            int filaYAletoria;
                            int columnaYAletoria;
                            do {
                                filaYAletoria = random.nextInt(9);
                                columnaYAletoria = random.nextInt(9);
                            } while (matriz[filaYAletoria][columnaYAletoria] != "L");
                            filaY = filaYAletoria;
                            columnaY = columnaYAletoria;
                            matriz[filaY][columnaY] = pers;
                            break;
                    }
                    break;
                case "Q":
                case "E":
                    switch (matriz[fuerarango][fuerarango2]) {
                        case "L":
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "M":
                            System.out.println("no se puede mover");
                            break;
                        case "D":
                            vidasY -= 1;
                            System.out.println("Pisaste un Dark te quedan" + vidasY + "vidas");
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "F":
                            System.out.println("Fin");
                            matriz[filaY][columnaY] = "L";
                            filaY = fuerarango;
                            columnaY = fuerarango2;
                            matriz[filaY][columnaY] = pers;
                            break;
                        case "P":
                            matriz[filaY][columnaY] = "L";
                            int filaYAletoria;
                            int columnaYAletoria;
                            do {
                                filaYAletoria = random.nextInt(9);
                                columnaYAletoria = random.nextInt(9);
                            } while (matriz[filaYAletoria][columnaYAletoria] != "L");
                            filaY = filaYAletoria;
                            columnaY = columnaYAletoria;
                            matriz[filaY][columnaY] = pers;
                            break;
                    }
                    break;
            }
        }else {switch (mov) {
            case "A":
            case "D":
                switch (matriz[filaD][fuerarango2]) {
                    case "R":
                        vidasV -= 1;
                        System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                        matriz[filaD][columnaD] = "L";
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "L":
                        matriz[filaD][columnaD] = "L";
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "M":
                        System.out.println("no se puede mover");
                        break;
                    case "F":
                        System.out.println("Fin");
                        matriz[filaD][columnaD] = "L";
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "P":
                        matriz[filaD][columnaD].equals("L");
                        int filaDAletoria;
                        int columnaDAletoria;
                        do {
                            filaDAletoria = random.nextInt(9);
                            columnaDAletoria = random.nextInt(9);
                        } while (matriz[filaDAletoria][columnaDAletoria] != "L");
                        filaD = filaDAletoria;
                        columnaD = columnaDAletoria;
                        matriz[filaD][columnaD] = pers;
                        break;
                }
                break;
            case "W":
            case "S":
                switch (matriz[fuerarango][columnaD]) {
                    case "R":
                        vidasV -= 1;
                        System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "L":
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "M":
                        System.out.println("no se puede mover");
                        break;
                    case "F":
                        System.out.println("Fin");
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "P":
                        matriz[filaD][columnaD] = "L";
                        int filaDAletoria;
                        int columnaDAletoria;
                        do {
                            filaDAletoria = random.nextInt(9);
                            columnaDAletoria = random.nextInt(9);
                        } while (matriz[filaDAletoria][columnaDAletoria] != "L");
                        filaD = filaDAletoria;
                        columnaD = columnaDAletoria;
                        matriz[filaD][columnaD] = pers;
                        break;
                }
                break;
            case "Q":
            case "E":
                switch (matriz[fuerarango][fuerarango2]) {
                    case "L":
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "M":
                        System.out.println("no se puede mover");
                        break;
                    case "R":
                        vidasV -= 1;
                        System.out.println("Pisaste un R2D2 te quedan" + vidasV + "vidas");
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "F":
                        System.out.println("Fin");
                        matriz[filaD][columnaD] = "L";
                        filaD = fuerarango;
                        columnaD = fuerarango2;
                        matriz[filaD][columnaD] = pers;
                        break;
                    case "P":
                        matriz[filaD][columnaD] = "L";
                        int filaDAletoria;
                        int columnaDAletoria;
                        do {
                            filaDAletoria = random.nextInt(9);
                            columnaDAletoria = random.nextInt(9);
                        } while (matriz[filaDAletoria][columnaDAletoria] != "L");
                        filaD = filaDAletoria;
                        columnaD = columnaDAletoria;
                        matriz[filaD][columnaD] = pers;
                        break;
                }
                break;
        }

        }
    }

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

    private static void LlenarObstaculoM(String[][] matriz,String Muro) {
        int filaM;
        int columnaM;
        //llenar tabla de muros
        for (int i = 0; i < Obstaculos; i++) {
            do {
                filaM = random.nextInt(10 - 1);
                columnaM = random.nextInt(10 - 1);
            } while (matriz[filaM][columnaM] != "L");
            matriz[filaM][columnaM] = Muro;
        }
    }



    public static void main(String[] args) {

        tableroL();
        fin();
        LlenarObstaculoM(tableroDark, "M");
        LlenarObstaculoM(tableroDark,"P");
        LlenarObstaculoM(tableroDark,"R");
        LlenarObstaculoM(tableroYoda,"M");
        LlenarObstaculoM(tableroYoda,"P");
        LlenarObstaculoM(tableroYoda,"D");
        LlenarJugador();

        System.out.println(filaY + " " + columnaY);
        do {
            while (turnos == false) {
                System.out.println("Turno YODA");
                ImprimirY();
                System.out.println("Dame la dirreccion");
                leerY = sc.next();
                System.out.println("Dame el numero de movimientos (solo funciona con AWDS)");
                int nUsu = sc.nextInt();

                switch (leerY) {
                    case "A":
                        fuerarango2 = (columnaY - nUsu + tableroYoda[0].length) % tableroYoda[0].length;
                            movimientoG(tableroYoda,"Y","A");
                        break;
                    case "D":
                        fuerarango2 = (columnaY + nUsu + tableroYoda[0].length) % tableroYoda[0].length;
                        movimientoG(tableroYoda,"Y","D");
                        break;
                    case "S":
                        fuerarango = (filaY + nUsu) % tableroYoda.length;
                        movimientoG(tableroYoda,"Y","S");

                        break;
                    case "W":
                        fuerarango = (filaY - nUsu + tableroYoda.length) % tableroYoda.length;
                        movimientoG(tableroYoda,"Y","S");;
                        break;
                    case "Q":
                        fuerarango = (filaY - nUsu + tableroYoda.length) % tableroYoda.length;
                        fuerarango2 = (columnaY - nUsu + tableroYoda[0].length) % tableroYoda[0].length;
                        movimientoG(tableroYoda,"Y","Q");
                        break;
                    case "E":
                        fuerarango = (filaY - nUsu + tableroYoda.length) % tableroYoda.length;
                        fuerarango2 = (columnaY + nUsu) % tableroYoda[0].length;

                        movimientoG(tableroYoda,"Y","Q");
                        break;
                    case "Z":
                        fuerarango = (filaY + nUsu ) % tableroYoda.length;
                        fuerarango2 = (columnaY - nUsu + tableroYoda[0].length) % tableroYoda[0].length;

                        movimientoG(tableroYoda,"Y","Q");
                        break;
                    case "C":
                        fuerarango = (filaY + nUsu) % tableroYoda.length;
                        fuerarango2 = (columnaY + nUsu) % tableroYoda[0].length;
                        movimientoG(tableroYoda,"Y","Q");

                        break;
                }
                if (vidasY == 0) {
                    System.out.println("has perdido todas tus vidas Yoda");
                    break;
                }
                turnos = true;
                ImprimirY();
                System.out.println(filaY + " " + columnaY);
            }
            if (tableroYoda[9][9].equals("Y")) {
                System.out.println("¡Yoda ha llegado a la meta! Terminando el juego.");
                break; // Salir del bucle
            }
            while (turnos) {
                System.out.println("Turno Vader");
                imprimirD();
                System.out.println("Dame la dirreccion");
                leerD = sc.next();
                System.out.println("Dame el numero de movimientos (solo funciona con AWDS)");
                int nUsu = sc.nextInt();
                switch (leerD) {
                    case "A":
                        fuerarango2 = (columnaD - nUsu + tableroDark[0].length) % tableroDark[0].length;
                        movimientoG(tableroDark,"V","A");
                        break;
                    case "D":
                        fuerarango2 = (columnaD + nUsu + tableroDark[0].length) % tableroDark[0].length;
                        movimientoG(tableroDark,"V","D");
                        break;
                    case "S":
                        fuerarango = (filaD + nUsu) % tableroDark.length;
                        movimientoG(tableroDark,"V","S");
                        break;
                    case "W":
                        fuerarango = (filaD - nUsu + tableroDark.length) % tableroDark.length;
                        movimientoG(tableroDark,"V","S");;
                        break;
                    case "Q":
                        fuerarango = (filaD - nUsu + tableroDark.length) % tableroDark.length;
                        fuerarango2 = (columnaD - nUsu + tableroDark[0].length) % tableroDark[0].length;
                        movimientoG(tableroDark,"V","Q");
                        break;
                    case "E":
                        fuerarango = (filaD - nUsu + tableroDark.length) % tableroDark.length;
                        fuerarango2 = (columnaD + nUsu) % tableroDark[0].length;

                        movimientoG(tableroDark,"V","Q");
                        break;
                    case "Z":
                        fuerarango = (filaD + nUsu ) % tableroDark.length;
                        fuerarango2 = (columnaD - nUsu + tableroDark[0].length) % tableroDark[0].length;

                        movimientoG(tableroDark,"V","Q");
                        break;
                    case "C":
                        fuerarango = (filaD + nUsu) % tableroDark.length;
                        fuerarango2 = (columnaD + nUsu) % tableroDark[0].length;
                        movimientoG(tableroDark,"V","Q");
                        break;
                }
                if (vidasV == 0) {
                    System.out.println("has perdido todas tus vidas Vader");
                    break;
                }
                turnos = false;
                imprimirD();
            }
            if (tableroDark[9][9].equals("V")) {
                System.out.println("¡Vader ha llegado a la meta! Terminando el juego.");
                break; // Salir del bucle
            }
        } while(vidasY > 0||vidasV > 0||!tableroYoda[9][9].equals("Y")||!tableroYoda[9][9].equals("V")) ;
    }
}
