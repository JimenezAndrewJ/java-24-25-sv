package pojo;

public class Magdalena {
    //ATRIBUTOS
    private String color;
    private String tamanyo;
    private int id;
    //CONSTRUCTO
    //public Magdalena(){}//contraseña vacía
    public Magdalena(int id,String tamanyo, String color){
        this.id = id;
        this.tamanyo = tamanyo;
        this.color = color;
    }

    public String setTamanyo(){
        return tamanyo;
    }
    public String getColor(){
        return color;
    }
    //MÉTODO
    public void llamada(){
        System.out.println("La magdalena Nª "+ id + " es de color " + color + " y de tamaño " + tamanyo);
    }

}
