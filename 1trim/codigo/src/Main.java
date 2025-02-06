import java.nio.charset.Charset;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int impar = 0;
        int par = 0;
        int suma = 0;
        int posi = 0;
        boolean verificador = false;

        while (true) {


                String codigo = scanner.nextLine();
                if (codigo.equals("0")) break;

                int longitud = codigo.length();

                boolean EAN8 = longitud <= 8;
                boolean EAN13 = longitud > 8 && longitud <= 13;


                for (int i = codigo.length() - 2; i >= 0; i--) {

                    posi++;
                    if (posi % 2 == 0) {
                        par = par + Integer.parseInt(String.valueOf(codigo.charAt(i)))*1;

                    } else {
                        impar = impar + Integer.parseInt(String.valueOf(codigo.charAt(i)))*3;
                    }
                }

                suma = impar + par;


                int resto = suma % 10;
                int Ncontrol = (resto == 0) ? 0: (10 - resto);
                int Unum = Integer.parseInt(String.valueOf(codigo.charAt(longitud-1)));

                verificador = (Ncontrol == Unum);


                if (verificador) {
                    System.out.println("SI");
                } else {
                    System.out.println("NO");
                }


            while (EAN13 && verificador) {

                int[] prefijos= {0,380,50};
                String[] paises = {"EEUU","BUlGARIA","INGLATERRA"};

                String paisPre = "DESCONOCIDO";
                int prefijoC = 0;
                for (int i = 0; i < prefijos.length; i++) {
                    prefijoC = Integer.parseInt((codigo.substring(0,(String.valueOf(prefijos[i])).length())));
                    if (prefijos[i] == prefijoC){
                        paisPre = paises[i];
                        break;
                    }
                }
                    System.out.printf(" " + paisPre);
                break;
                }
                System.out.println();
            }

        }
    }
