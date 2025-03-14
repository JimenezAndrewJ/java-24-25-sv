import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        // CTRL + ALT + L
        Scanner sc = new Scanner(System.in);


        while (true) {
            String codigo = sc.nextLine().trim();
            if (codigo.equals("0")) break;

            int longitud = codigo.length();



            boolean esEAN8 = longitud <= 8;
            boolean esEAN13 = longitud > 8 && longitud <= 13;


            if (esEAN8) {
                while (codigo.length() < 8) {
                    codigo = "0" + codigo; // 00187587
                }
            } else if (esEAN13) {
                while (codigo.length() < 13) {
                    codigo = "0" + codigo;
                }
            }

            int sumaImpares = 0; // *3

            int sumaPares = 0;   // *1

            int contPos = 0;



            for (int i = codigo.length() - 2; i >= 0; i--) { // Me salto el último dígito
                int digito = Integer.parseInt(String.valueOf(codigo.charAt(i)));
                contPos++;
                if (contPos % 2 == 0) {
                    sumaPares = sumaPares + (digito * 1);
                } else {
                    sumaImpares = sumaImpares + (digito * 3);
                }
            }


            int sumaPonderada = sumaImpares + sumaPares;

            int digitoControlCalculado;
            int resto = sumaPonderada % 10;
            digitoControlCalculado = (resto == 0) ? 0 : (10 - resto);


            int digitoControlReal = Integer.parseInt(String.valueOf(codigo.charAt(codigo.length() - 1)));
            boolean controlValido = (digitoControlCalculado == digitoControlReal);


            if (controlValido) {
                System.out.print("SI");
            } else {
                System.out.println("NO");
                continue;
            }

            if (esEAN13 && controlValido) {
                int[] prefijos = {380, 50, 560, 70, 590, 850, 890};
                String[] paises = {"Bulgaria", "Inglaterra", "Portugal", "Noruega", "Polonia", "Cuba", "India"};


                String nombrePais = "Desconocido";
                int prefijoPais = 0;
                for (int i = 0; i < prefijos.length; i++) {
                    prefijoPais = Integer.parseInt(codigo.substring(0, (String.valueOf( prefijos[i] )).length()) );
                    if (prefijos[i] == prefijoPais) {
                        nombrePais = paises[i];
                        break;
                    }
                }
                System.out.print(" " + nombrePais);
            }
            System.out.println();
        }
    }
}
