package printers;


import herencia.Reporte;

public class PrintToJSON extends Reporte {
    public String getCadenaEnJSON() {
        return cadenaEnJSON;
    }

    public void setCadenaEnJSON(String cadenaEnJSON) {
        this.cadenaEnJSON = cadenaEnJSON;
    }

    private String cadenaEnJSON;
    public PrintToJSON(String cadena){
        super(cadena);
        cadenaEnJSON = "hola";
    }
    public void imprimirCadena(){
        System.out.println(super.cadenaAtransformar);
        System.out.println(this.cadenaEnJSON);
    }


}