import java.util.Random;

public class Sopadeletras {
    static String palabras[] = {"helada", "mesa", "patata"};
    static char[][] sopaLetras = new char[10][10];
    static char[][] sopaLetrascopia = new char[10][10];
    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    static Random aleatorio = new Random();

    private static void rellenarMatriz() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int numAle = aleatorio.nextInt(letras.length);
                sopaLetras[i][j] = letras[numAle];
            }
        }
    }

    private static void rellenarMatrizcopia() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sopaLetrascopia[i][j] = '0';
            }
        }
    }
    private static void imprimir() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetras[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void imprimirCopia() {
        //Matriz copia
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetrascopia[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        rellenarMatriz();
        rellenarMatrizcopia();
        imprimir();
imprimirCopia();
        for (int i = 0; i < palabras.length; i++) {
            //¿CUANTAS PALABRAS HAY EN EL ARRAY?
            int FilaAl=0;
            int ColAl=0;
            do {
                FilaAl=aleatorio.nextInt(10);
                ColAl=aleatorio.nextInt(10);
            }while (sopaLetrascopia[FilaAl][ColAl]!='0');
            //NO SUPERAR LIMITES
            if(ColAl + (palabras[i].length()-1) >=10){
                i--;
            }else {
            boolean islibre=true;
                for (int z = ColAl; z <= (ColAl+(palabras[i].length()-1)); z++) {
                    if (sopaLetrascopia[FilaAl][z]!='0'){
                        islibre = false;
                        break;
                    }
                }
                if (islibre){
                    int contador = 0;
                    for (int z = ColAl; z <= (ColAl+(palabras[i].length()-1)); z++) {
                        sopaLetras[FilaAl][z] = palabras[i].charAt(contador);
                       sopaLetrascopia[FilaAl][z] = palabras[i].charAt(contador);
                       contador++;
                        }
                    }
                }
            }
        imprimir();
        imprimirCopia();
        }
}




