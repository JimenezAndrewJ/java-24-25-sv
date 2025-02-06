package pojo;

public class Almacen {

    private int Productosinventario;
    private Producto[] lstinventario;


    public Almacen(int Productosinventario) {
       this.Productosinventario = Productosinventario;
        lstinventario = new Producto[Productosinventario];
    }
    public int getProductosinventario() {
        return Productosinventario;
    }

    public void setProductosinventario(int productosinventario) {
        Productosinventario = productosinventario;
    }

    private int contador = 0;

    public void agregarProductosAlInventario(Producto producto){
        if (contador < 9){
            this.lstinventario[contador] = producto;
            contador++;
        }else{
            contador = 0;
        }
    }
    public void mostrarInventario() {
        System.out.println("almacen!!");
        for (int i = 0; i < lstinventario.length; i++) {
            Producto producto = lstinventario[i];
            if (producto!= null){
                System.out.println(lstinventario[i].toString());
            }else {
                System.out.println("Has llegado al final de la lista.");
                break;
            }
        }
    }

    public Producto buscarProductoporNombre(String nombre) {
        for (int i = 0; i < lstinventario.length; i++) {
            Producto producto = lstinventario[i];
            if (lstinventario[i].getNombre().equals(nombre)) {
                System.out.println(nombre);
                return lstinventario[i];
            }
        }
        return null;
    }
}

