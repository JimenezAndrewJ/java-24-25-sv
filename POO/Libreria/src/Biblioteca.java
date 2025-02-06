
public class Biblioteca {
    private static final int CAPACIDAD = 3;
    private static Libro[] libros = new Libro[CAPACIDAD];
    private static int contadorLibros = 0;

    void agregarLibro(Libro libro){
        if(contadorLibros < CAPACIDAD){
            libros[contadorLibros] = libro;
            contadorLibros++;
            System.out.println("CON ESPACIO");
        }else{
            System.out.println("SIN ESPACIO");
        }
    }
     void listarLibros(){
        // For normal
        // Foreach para Objetos
        for (Libro libro:libros
        ) {
            System.out.println(libro.toString());
        }
        /*for (int i = 0; i < contadorLibros; i++) {
          Libro libro = libros[i];
        }*/
    }
    public Libro buscarLibro(String titulo){
        for (Libro libro: libros) {
            if(libro.getTitulo().equals(titulo)){
                System.out.println("Este es tu libro");
                System.out.println(libro.toString());
                return libro;
            }
        }
        return null;
    }

    public Libro prestarLibro(String titulo){
        Libro novita;
        novita=buscarLibro(titulo);
                if (novita.isDisponible() == true){
                System.out.println("Tu libro esta disponible para prestar");
                novita.setDisponible(false);
                    }
        return novita;
    }



    public Libro devolverLibro(String titulo){
        Libro novita;
        novita=buscarLibro(titulo) ;
        if (novita.isDisponible() == true){
                System.out.println("Gracias por devolver el libro!!");
                novita.setDisponible(true);
            }
        return novita;
    }


}
