import java.util.Random;

public class Main {
    private static int[][] matriz = new int[3][9];
    static Random random = new Random();

    private static void llenarMatriz() {
        // Llenar la matriz de acuerdo al rango en cada columna
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;        // valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
        }
    }

    private static void imprimir() {
        // Imprimir la matriz
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
private static void ordenar(){

    for (int k = 0; k < 9; k++) {
        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 3; j++) {
                if (matriz[i][k]>matriz[j][k]){
                    int aux = matriz[i][k];
                    matriz[i][k]= matriz[j][k];
                    matriz[j][k]= aux;
                }
            }
        }
    }
}

    public static void main(String[] args) {

        llenarMatriz();
        imprimir();
       ordenar();
        imprimir();
    }
}