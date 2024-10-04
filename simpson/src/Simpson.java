// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Simpson {
    // VISIBLE A NIVEL DE LA CLASE SMPSON
    static char[][] tablero=  new char[10][10];//crear matriz
    char personaje = '@';//darle valor a personaje
    //FIN

    /*software de gestión de venta ONLINE*/

    public void rellenarTablero(){//publico no estatico
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = personaje;//rellenar tablero
            }
        }
    }

    public static void main(String[] args) {
        Simpson simpson = new Simpson();
        simpson.rellenarTablero(); //llamo al algoritmo para el tablero
        System.out.println("tablero:");
        //mostrar tablero
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                   System.out.print(tablero[i][j] + " ");
            }
            System.out.println(); //nueva linea
        }
    }
}