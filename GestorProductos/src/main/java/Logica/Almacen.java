/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class  Almacen {
    

    private static Vector<Producto> productos  = new Vector<Producto>();
    
    
    
    public static void agregarProducto(String nombre, float precio, int cantidad)
    {
        Producto producto = new Producto(nombre, precio, cantidad); 
        
        productos.add(producto);
    }
    
    public static void eliminarProducto(int indice)
    {
        productos.remove(indice);
    }
    public static Vector<Producto> mostrarProductos()
    {
        
        return productos;
    }
    
    

}   
    