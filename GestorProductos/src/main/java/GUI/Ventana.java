/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;




/**
 *
 * @author toxic
 */
public class Ventana extends JFrame{
    
     public Ventana()
    {
        super("Gestor Productos");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container mainPanel = getContentPane();
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        // Contenedores secundarios
        FlowLayout x = new FlowLayout();
        
        JPanel secondPanel = new JPanel(x);
        
        
        // Creacion de componentes
        
        // Label Titulo
        Label titulo = new Label("Gestor de productos");
        configurarTitulos(titulo);
        
        
        // Boton
        
        Button crearProducto = new Button("Crear Producto");
        
        Button almacen = new Button("Gestionar Productos");
        
        configurarBotones(crearProducto);
        configurarBotones(almacen);
        
        
        
        // Se añade todo a los contenedores
        mainPanel.add(secondPanel, BorderLayout.CENTER);
        mainPanel.add(titulo, BorderLayout.NORTH);
        
        secondPanel.add(crearProducto);
        secondPanel.add(almacen);
        
        
        // Escuchadores
        
        class EscuchaBotonProducto implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new VentanaProductos();
                
                
            }
        }
        class EscuchaBotonAlmacen implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new VentanaAlmacen();
            }
        }
        
        almacen.addActionListener(new EscuchaBotonAlmacen());
        crearProducto.addActionListener(new EscuchaBotonProducto());
    }
     
     // metodo utilitario botones
     public static void configurarBotones(Button boton)
     {
         boton.setBackground(Color.BLACK);
         boton.setForeground(Color.WHITE);
         boton.setFont(new Font("New Time Roman",Font.BOLD,20));
         boton.setPreferredSize(new Dimension(200, 40));
         
         
         
     }
     public static void configurarTitulos(Label titulo)
     {
        titulo.setFont(new Font("New Time Roman",Font.BOLD,30));
        titulo.setForeground(Color.WHITE);
        titulo.setBackground(Color.DARK_GRAY);
        titulo.setAlignment(Label.CENTER);
     }
     
    
}
