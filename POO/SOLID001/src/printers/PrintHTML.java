package printers;

import INTERFACES.Print;
import herencia.Reporte;

public class PrintHTML extends Reporte {
    private String cadenaEnHTML = " jiji";

    public String getCadenaEnHTML() {
        return cadenaEnHTML;
    }

    public void setCadenaEnHTML(String cadenaEnHTML) {
        this.cadenaEnHTML = cadenaEnHTML;

    }

    public PrintHTML(String cadena) {
        super(cadena);
    }
    @Override
    public void imprimirCadena(){
        System.out.println(super.cadenaAtransformar);
        System.out.println(this.cadenaEnHTML);
    }


}
