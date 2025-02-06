
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AlmacenMusica almacenMusica = new AlmacenMusica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar canción");
            System.out.println("2. Editar canción");
            System.out.println("3. Eliminar canción");
            System.out.println("4. Mostrar canciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título de la canción: ");
                    String titulo = scanner.nextLine();
                    almacenMusica.addCancion(titulo);
                    break;
                case 2:
                    System.out.print("Ingrese el título de la canción a editar: ");
                    String tituloViejo = scanner.nextLine();
                    System.out.print("Ingrese el nuevo título: ");
                    String tituloNuevo = scanner.nextLine();
                    almacenMusica.updateCancion(tituloViejo, tituloNuevo);
                    break;
                case 3:
                    System.out.print("Ingrese el título de la canción a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    almacenMusica.deleteCancion(tituloEliminar);
                    break;
                case 4:
                    almacenMusica.imprimir();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
