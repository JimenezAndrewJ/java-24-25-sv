import java.util.Scanner;

public class alturaPir {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int nivel = 1;
        int bloquesAcumulados = 1;
        int multBloques = 1;

        int bloquesUser = scanner.nextInt();

        while (bloquesUser > bloquesAcumulados){
            nivel = nivel +1 ;
            multBloques = multBloques +2;
            bloquesAcumulados= bloquesAcumulados+(multBloques*multBloques);
        }
        System.out.println(nivel);
    }
}

