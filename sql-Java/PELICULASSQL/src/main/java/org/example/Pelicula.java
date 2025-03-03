package org.example;

public class Pelicula {
    private int id;
    private String titulo;
    private String discripcion;
    private int anio;

    private Genero genero;

    // Constructor que recibe un objeto Genero ya creado
    public Pelicula(int id, String titulo, String discripcion, int anio, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.discripcion = discripcion;
        this.anio = anio;
        this.genero = genero;
    }


    public int geetId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiscripcion() {
        return discripcion;
    }

    public int getAnio() {
        return anio;
    }


    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", discripcion='" + discripcion + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'' +
                '}';
    }

}



