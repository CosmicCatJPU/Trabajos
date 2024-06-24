/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.Ventana.configurarTitulos;
import GUI.Ventana;
import Logica.Almacen;
import Logica.Producto;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author toxic
 */
public class VentanaAlmacen extends JFrame {

    public VentanaAlmacen() {
        super("Gestor Productos");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container mainPanel = getContentPane();
        setVisible(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        Label titulo = new Label("Gestor de productos");
        configurarTitulos(titulo);

        Button borrar = new Button("Borrar");

        Ventana.configurarBotones(borrar);

        // Lista de proeductos
        Vector<Producto> productos = Almacen.mostrarProductos();
        JList listaProductos = new JList(productos);
        listaProductos.setBackground(Color.GRAY);
        listaProductos.setForeground(Color.WHITE);

        mainPanel.add(titulo, BorderLayout.NORTH);

        mainPanel.add(listaProductos, BorderLayout.CENTER);

        mainPanel.add(borrar, BorderLayout.SOUTH);

        // Escuchadores
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {

            }

            @Override
            public void windowClosed(WindowEvent e) {
                
                new Ventana().setVisible(true);

            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                
            }
        });
        
        borrar.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                if (!productos.isEmpty())
                {
                    int indiceSeleccionado;
                    indiceSeleccionado = listaProductos.getSelectedIndex();
                    
                    listaProductos.remove(indiceSeleccionado);
                    Almacen.eliminarProducto(indiceSeleccionado);
                }
                
                listaProductos.repaint();
                listaProductos.validate();
                
                
                
                
                
                
                
            }
            
            
            
        });
        

        

    }

}
