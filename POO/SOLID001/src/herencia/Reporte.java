package herencia;

public abstract class Reporte {
    //ATRIBUTOS

    protected String cadenaAtransformar;

    //CONSTRUCTORES
    public Reporte(String cadena){
        this.cadenaAtransformar = cadena;
    }
    //METODOS
    public abstract void imprimirCadena();
    //GETTER/SETTER
    public String getCadenaAtransformar() {
        return cadenaAtransformar;
    }

    public void setCadenaAtransformar(String cadenaAtransformar) {
        this.cadenaAtransformar = cadenaAtransformar;
    }

}
