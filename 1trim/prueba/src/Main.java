import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    private static final int filas = 10;
    private static final int columnas = 10;
    private static final int pruebas = 10;
    private static final String[][] tabla1 = new String[filas][columnas];
    private static final String[][] tabla2 = new String[filas][columnas];
    static Random random = new Random();//implementamos funcion random para generar numeros aleatorios
    static Scanner scanner = new Scanner(System.in);//implementamos el scanner para que podamos ingresar valores

    private static void llenarTablero1(){//leno la tabla de numeros
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int numAle = random.nextInt(10,100);
                tabla1[i][j] = String.valueOf(numAle);
            }
        }
    }

    private static void llenarTablero2() {//lleno la tabla de caracteres
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tabla2[i][j] = "XX";
            }
        }
    }

    private static void imprimirTablero1(){//imprimimos la tabla 1 solo para prueba en la final no se tendria q mostrar
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tabla1[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    private static void imprimirTablero2(){//imprimimos la tabla que se tiene que mostrar de caracteres
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(tabla2[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        llenarTablero1();//llamamos funciones solo para pruebas *QUITAR*
        llenarTablero2();//llamamos funciones
        imprimirTablero1();//llamamos funciones

        System.out.println("*******Tabla inicial*******");
        System.out.println("********Empieza el juego********");
        for (int k = 0; k < pruebas; k++) {//hacemos un bucle de intentos que tiene el usuarios

            imprimirTablero2();

            System.out.println("Dame 10 numeros este es el:" + (k+1));
            String numUsuario = String.valueOf(scanner.next());//esto sirve para q el usuario pueda ingresar valores

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (numUsuario.equals(tabla1[i][j])) {//vemos si coincide el valor dado con alguno de la tabla1
                        tabla2[i][j] = numUsuario;//si coincide pues intercambiamos el valor de la tabla de X por el número dado por el usuario
                    }
                }
            }
        }

        System.out.println("*******Tabla final*******");
        imprimirTablero2();//llamamos funciones
    }
}