import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random ale = new Random();
        String[] pais={"E","A","F","G","C","O","J","L","M","I"};
        String[][] matriz =new String[10][10];
        int[] puntuaciones = {12,10,8,7,6,5,4,3,2,1};
        String[][] votaciones =new String[11][13];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matriz[i][j]= ".";

            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                votaciones[i][j]= ".";

            }
        }

        for (int i = 0; i < pais.length; i++) {
            int fAle;
            int cAle;
            do {
                fAle=ale.nextInt(10);
                cAle=ale.nextInt(10);
            }while(matriz[fAle][cAle]!=".");
            matriz[fAle][cAle]=pais[i];
            votaciones[i+1][1]=String.valueOf(fAle);
            votaciones[i+1][2]=String.valueOf(cAle);
            votaciones[0][i+3] = pais[i];
            votaciones[i+1][0] = pais[i];
            votaciones[0][1]="X";
            votaciones[0][2]="Y";
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(votaciones[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 1; i < 11; i++) {
            for (int j = 3; j <13; j++) {
                int pa= puntuaciones[ale.nextInt(puntuaciones.length)];
                votaciones[i][j]=String.valueOf(pa);
            }
        }
        System.out.println();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(votaciones[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 13; i++) {

            for (int j = 1; j < 11; j++) {
                for (int k = 3; k < 13; k++) {
                    for (int l = k+1; l < 13; l++) {
                        if (votaciones[j][k].equals(votaciones[j][l])){
                            int pa= puntuaciones[ale.nextInt(puntuaciones.length)];
                            votaciones[j][l]=String.valueOf(pa);
                        }
                    }
                }
            }
        }
/*
        int numAletorio=0;
            for (int j = 1; j < 11; j++) {
                for (int k = 4; k < 13; k++) {
                    int sw;
                    sw=0;
                    do {
                        for (int l = 3; l <= k-1; l++) {
                            numAletorio = Integer.parseInt(votaciones[j][l]) ;
                           // System.out.println(numAletorio);
                            //System.out.println(votaciones[j][k]);
                            if (votaciones[j][k].equals(String.valueOf(numAletorio))){
                                    numAletorio = puntuaciones[ale.nextInt(puntuaciones.length)];

                                    sw=0;
                                    l=3;
                            }
                            else {
                                sw = 1;
                            }

                        }
                    } while (sw==0);
                    //System.out.println(numAletorio);
                    votaciones[j][k]=String.valueOf(numAletorio);

                }
            }

*/
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(votaciones[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
//**
        for (int i = 1; i < 11; i++) {
            for (int j = 3; j < 13; j++) {
                for (int k = 3; k < 12; k++) {
                    if (Integer.parseInt(votaciones[i][k]) < Integer.parseInt(votaciones[i][k+1])) {
                       String max = votaciones[i][k];
                        votaciones[i][k]=votaciones[i][k+1];
                        votaciones[i][k+1]=max;
                    }
                }
            }
        }
        //**
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(votaciones[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}