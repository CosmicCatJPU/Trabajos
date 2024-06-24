/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author toxic
 */
public class Producto {
    
    private String nombre;
    private float precio;
    private int cantidad;
    
    
    public Producto(String nombre, float precio, int cantidad)
    {
        
        this.nombre = nombre;
        
        this.precio = precio; 
        
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public String toString()
    {
        String aux;
        
        aux = String.format("Nombre: "+nombre +"| Precio: "+precio + "| Cantidad: "+cantidad);
        
        return aux;
    }
    
}
