package printers;

import INTERFACES.Print;
import herencia.Reporte;

public class PrintToXML extends Reporte {
    public String getCadenaEnXML() {
        return cadenaEnXML;
    }

    public void setCadenaEnXML(String cadenaEnXML) {
        this.cadenaEnXML = cadenaEnXML;
    }

    private String cadenaEnXML;

    public PrintToXML(String cadena){
        super(cadena);

    }
    public void imprimirCadena(){
        System.out.println(super.cadenaAtransformar);
        System.out.println(this.cadenaEnXML);
    }
}
