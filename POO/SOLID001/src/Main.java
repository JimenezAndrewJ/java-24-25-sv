import herencia.Reporte;
import printers.PrintHTML;
import printers.PrintToJSON;
import printers.PrintToXML;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Reporte printToJSON = new PrintToJSON("ASFS");
        Reporte printToXML = new PrintToXML("FDSA");
        Reporte printToHTML = new PrintHTML("dsad");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(printToJSON);
        lst.add(printToXML);
        lst.add(printToHTML);

        for (Reporte reporte:lst
             ) {
           reporte.imprimirCadena();
        }
    }
}