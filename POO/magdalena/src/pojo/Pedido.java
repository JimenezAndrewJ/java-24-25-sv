package pojo;

import pojo.*;
public class Pedido {
    private int numProductos;
    private Producto[] lstProductos; // Listas estáticas
    // = new Producto[5];
    private int contador = 0;
    public Pedido(int numProductos){
        this.numProductos = numProductos;
        lstProductos = new Producto[numProductos];//5
    }
    // getter/setter
    public int getNumProductos() {
        return numProductos;
    }
    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }
    //
    public void agregarProducto(Producto miProducto, int cant){
        if(contador<5){
            this.lstProductos[contador] = miProducto;
            contador++;
        }else{
            contador = 0;
        }

    }

    // toString
    @Override
    public String toString() {
        return "Pedido{" +
                "numProductos=" + numProductos +
                '}';
    }
    public void imprimirTicket() {
        System.out.println("Su ticket digital!!");
        System.out.println("Fecha ->" + " 14/01/2025");
        System.out.println("Hora ->" + " 12:10 ");
        for (int i = 0; i < lstProductos.length; i++) {
            Producto miProducto = lstProductos[i];
            if (miProducto!= null){
                System.out.println(lstProductos[i].toString());
            }else {
                System.out.println("Has llegado al final de la lista.");
                break;
            }
        }
    }

}