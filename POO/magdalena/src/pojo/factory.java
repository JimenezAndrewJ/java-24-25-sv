package pojo;

public class factory {
    int contador = 0;
    private Magdalena[] lstMagdalena = new Magdalena[4];


    public void addMagdalena(Magdalena miMagdalena){
        lstMagdalena[contador] = miMagdalena;
        contador++;
    }
    public void printMagdalena(){
        Magdalena magdalena;
        for (int i = 0; i < lstMagdalena.length; i++) {
            magdalena = lstMagdalena[i];
            System.out.println("Magdalena: [" + i + "]");
            System.out.println("Atributos: Sabor - " + magdalena.setTamanyo());
            System.out.println("Atributos: Color - " + magdalena.getColor());
        }
    }


}
