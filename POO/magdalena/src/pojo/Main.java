package pojo;

import pojo.Pedido;
import pojo.Producto;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Producto galleta = new Producto("galleta",2.50,7);
        Producto magdalena = new Producto("magdalena",2.50,20);
        Producto gominolas = new Producto("gominolas",2.50,50);
        Producto pasas = new Producto("pasas",2.50,60);
        Producto piedra = new Producto("piedra",2.50,90);
        Producto peras = new Producto("peras",2.50,10);
        Producto nueces = new Producto("nueces",2.50,80);
        Producto queso = new Producto("queso",2.50,40);
        Producto azucar = new Producto("azucar",2.50,204);
        System.out.println(magdalena.getNombre());
        magdalena.setStock(25);
        System.out.println(magdalena.toString());
        System.out.println(galleta.toString());

        Pedido Pedido = new Pedido(5);
            Pedido.agregarProducto(galleta,3);
            Pedido.agregarProducto(galleta,3);
            Pedido.agregarProducto(magdalena,3);
        Pedido.agregarProducto(magdalena,3);
        Pedido.agregarProducto(magdalena,3);
        Pedido.imprimirTicket();
        Almacen Almacen = new Almacen(9);
        Almacen.agregarProductosAlInventario(galleta);
        Almacen.agregarProductosAlInventario(gominolas);
        Almacen.agregarProductosAlInventario(pasas);
        Almacen.agregarProductosAlInventario(piedra);
        Almacen.agregarProductosAlInventario(nueces);
        Almacen.agregarProductosAlInventario(azucar);
        Almacen.agregarProductosAlInventario(queso);
        Almacen.agregarProductosAlInventario(magdalena);
        Almacen.agregarProductosAlInventario(peras);

        Almacen.mostrarInventario();
        Almacen.buscarProductoporNombre("galleta");

/*
        Magdalena magdalena0 = new Magdalena(0, "mediano", "rosa");
        Magdalena magdalena1 = new Magdalena(1, "grande", "verde");
        Magdalena magdalena2 = new Magdalena(2, "pequeño", "carbon");
        Magdalena magdalena3 = new Magdalena(3, "muy grande", "gris");

        //array estatico dejaremos de usarlo

       Magdalena[] listaMagdalenas = new Magdalena[4];
        listaMagdalenas[0] = magdalena0;
        listaMagdalenas[1] = magdalena1;
        listaMagdalenas[2] = magdalena2;
        listaMagdalenas[3] = magdalena3;

        for (int i = 0; i < listaMagdalenas.length; i++) {
            listaMagdalenas[i].llamada();
        }

        //array estatico crece segun mis necesidades
        ArrayList<Magdalena> listaMagDin = new ArrayList();
*/
    }
}