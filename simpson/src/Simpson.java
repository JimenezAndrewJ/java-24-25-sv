// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.util.Random;//asi es como se importa una funcion de la libreria de java en este caso la funcion se llama Random

public class Simpson {
    //todo lo que se ponga en el corchete mayor se podra usar en todos las diferentes cajas
    //INT significa que es un numero
    private static final int MAX_FILA_T = 10;//ponemos un valor maximo de filas
    private static final int MAX_COLUMNA_T = 10;//ponemos un valor maximo de COLUMNAS
    private static char[][] tablero;//definimos que tablero es una matriz

    // defini estas lineas de codigo para no tener que tener que escribirlas todo el rato y solo llamandolo por un nombre
    private static void printtablero() {
        System.out.println("tablero:");
        for (int i = 0; i < MAX_FILA_T; i++) {
            for (int j = 0; j < MAX_COLUMNA_T; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        tablero=new char[MAX_FILA_T][MAX_COLUMNA_T];//traemos el tablero dentro de este void
        //LLENAR TABLERO 'L'
        for (int i = 0; i < MAX_FILA_T; i++) {//Primero se selecciona la fila
            for (int j = 0; j < MAX_COLUMNA_T; j++) {//luego se llena la columna entera y cambia de fila
                    tablero[i][j] = 'L';//ponemos el valor dentro de las coordenadas [i] y [j]

            }
        }
        //mostrar tablero arriba esta definido
       printtablero();

                //PARTE DE BART

            Random aleatorio = new Random();//traemos la funcion Random de la libreria de java
        //esto nos dara 2 valores de fila y columna para usarlo como una coordenada de una posicion aleatoria
            int filaAleatorio = aleatorio.nextInt(MAX_FILA_T);//ira del 0-9 por que la matriz es de 10 valores
            int columnaAleatorio = aleatorio.nextInt(MAX_COLUMNA_T);//ira del 0-9 por que la matriz es de 10 valores

                tablero[filaAleatorio][columnaAleatorio] = 'B';//ponemos a bart dentro de una posicion aleatoria

       printtablero();//llamamos a la impresion del tablero para que me muestre como se esta viendo

        //PARTE DE 10 HOMERO
        int FilaAleatorioHomer;//definimos las variables q usaremos
        int ColumnaAleatorioHomer;
            for (int i = 0; i < 10; i++) {//hacemos que se repita 10 veces
                do {//usamos un DO para este bucle para q si o si se imprima
                    FilaAleatorioHomer = aleatorio.nextInt(MAX_FILA_T);//seleccionamos un numero de fila aleatorio
                    ColumnaAleatorioHomer = aleatorio.nextInt(MAX_COLUMNA_T);//seleccionamos un numero de columna aleatorio
                }while (tablero[FilaAleatorioHomer][ColumnaAleatorioHomer] != 'L');
                //ponemos la condicion de que si la casilla contiene algo distinto de L no ponga nada dentro de esta

                tablero[FilaAleatorioHomer][ColumnaAleatorioHomer] = 'H';//llenamos la coordenada con 'H'

            }
        printtablero();

            //CREAR MUROS
            int FilaAleatorioMuro;//definimos las variables q usaremos
            int ColumnaAleatorioMuro;
                for (int i = 0; i < 10; i++) {//hacemos que se repita 10 veces
                    do {//usamos un DO para este bucle para q si o si se imprima
                        FilaAleatorioMuro = aleatorio.nextInt(MAX_FILA_T);//seleccionamos un numero de fila aleatorio
                        ColumnaAleatorioMuro = aleatorio.nextInt(MAX_COLUMNA_T);//seleccionamos un numero de columna aleatorio
                    }while (tablero[FilaAleatorioMuro][ColumnaAleatorioMuro] != 'L' );
                    //ponemos la condicion de que si la casilla contiene algo distinto de L no ponga nada dentro de esta

                    tablero[FilaAleatorioMuro][ColumnaAleatorioMuro] = 'M';//llenamos de muros
                }
        printtablero();
            tablero[MAX_FILA_T - 1][MAX_COLUMNA_T - 1]= 'F';//ponemos la F en la posicion (9,9) para el final del juego
        printtablero();
    }
}
