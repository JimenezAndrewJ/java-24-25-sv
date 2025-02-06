import java.lang.reflect.Array;
import java.util.Arrays;

public class Pelicula {
    private Pelicula peliNext = null;
    private String titulo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pelicula(String titulo){
        this.titulo = titulo;

    }

}
