package pojo;

public class Producto {
private String nombre;
private double precio;
private int stock;
    public Producto(String nombre, double precio, int stock) {
        this.nombre= nombre;
        this.precio = precio;
        this.stock = stock;
    }
    // METODO GETTER/SETTER
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + this.nombre + '\'' +
                ", precio=" +this.precio +
                ", stock=" + this.stock +
                '}';
    }
}
