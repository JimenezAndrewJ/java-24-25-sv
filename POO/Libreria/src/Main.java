
public class Main {
    public static void main(String[] args) {
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 1605, true);
        Libro libro2 = new Libro("1984", "George Orwell", 1949, true);
        Libro libro3 = new Libro("El Principito", "Antoine de Saint-Exupéry", 1943, true);
Biblioteca Biblioteca = new Biblioteca();

        // Agregar libros a la biblioteca
        Biblioteca.agregarLibro(libro1);
        Biblioteca.agregarLibro(libro2);
        Biblioteca.agregarLibro(libro3);

        // Listar libros
        Biblioteca.listarLibros();

        // Buscar y prestar un libro
        Biblioteca.buscarLibro("1984");
        Biblioteca.prestarLibro("1984");
        Biblioteca.listarLibros();

        // Intentar prestar el mismo libro
        Biblioteca.prestarLibro("1984");

        // Devolver el libro
        Biblioteca.devolverLibro("1984");
        Biblioteca.listarLibros();
    }
}