/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestorproductos;

import GUI.Ventana;
import Logica.Almacen;
import javax.swing.SwingUtilities;




/**
 *
 * @author toxic
 */
public class GestorProductos {

    public static void main(String[] args) {
        
         
        
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ventana().setVisible(true);
                
            }
        });
         
        
        
        
    }
}
