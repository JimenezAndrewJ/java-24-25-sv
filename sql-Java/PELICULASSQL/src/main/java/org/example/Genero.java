package org.example;

public class Genero {
    private int generoId;
    private String generoTitulo;

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public String getGeneroTitulo() {
        return generoTitulo;
    }

    public void setGeneroTitulo(String generoTitulo) {
        this.generoTitulo = generoTitulo;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "generoTitulo='" + generoTitulo + '\'' +
                '}';
    }
}
