import java.util.ArrayList;

class AlmacenMusica implements IEstanteria {
    private ArrayList<Cancion> lstCanciones;

    public AlmacenMusica() {
        this.lstCanciones = new ArrayList<>();
    }

    @Override
    public void addCancion(String titulo) {
        lstCanciones.add(new Cancion(titulo));
        System.out.println("Canción agregada: " + titulo);
    }

    @Override
    public void updateCancion(String tituloViejo, String tituloNuevo) {
        for (Cancion cancion : lstCanciones) {
            if (cancion.getTitulo().equalsIgnoreCase(tituloViejo)) {
                cancion.setTitulo(tituloNuevo);
                System.out.println("Canción actualizada: " + tituloViejo + " -> " + tituloNuevo);
                return;
            }
        }
        System.out.println("Canción no encontrada.");
    }

    @Override
    public void deleteCancion(String titulo) {
        lstCanciones.removeIf(cancion -> cancion.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Canción eliminada: " + titulo);
    }

    @Override
    public void imprimir() {
        if (lstCanciones.isEmpty()) {
            System.out.println("No hay canciones en la lista.");
        } else {
            System.out.println("Lista de canciones:");
            for (Cancion cancion : lstCanciones) {
                System.out.println("- " + cancion.getTitulo());
            }
        }
    }
}