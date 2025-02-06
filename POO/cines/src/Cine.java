public class Cine {

    private static int contadorLibros = 0;
void agregarPeli(Pelicula next){

this.contadorLibros++;
}

void listarPeliculas(){
    for (Pelicula next: lstTitulo
         ) {
        System.out.println(next.getTitulo());
    }

    }
    public void buscarPeli(String titulo) {
        for (Pelicula Peli: lstTitulo
             ) {if (Peli.getTitulo().equals(titulo)){
            System.out.println(Peli.getTitulo());
        }
        }
    }
}
