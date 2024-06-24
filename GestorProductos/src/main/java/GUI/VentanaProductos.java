package GUI;

import Logica.Almacen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

/**
 *
 * @author toxic
 */
public class VentanaProductos extends JFrame {

    public VentanaProductos() {
        super("Productos");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        ubicacionFrame(this);

        // paneles
        Label titulo = new Label("Producto");
        Ventana.configurarTitulos(titulo);
        JPanel producto = new JPanel();
        producto.setLayout(new GridBagLayout());

        // Interior del pantel producto
        JLabel nombre = new JLabel("Producto");
        configuracionTextos(nombre);
        JTextField txNombre = new JTextField(20);

        JLabel precio = new JLabel("Precio");
        configuracionTextos(precio);
        JTextField txPrecio = new JTextField(20);

        JLabel cantidad = new JLabel("Cantidad en Stock");
        configuracionTextos(cantidad);
        JTextField txCantidad = new JTextField(20);

        // Botones
        Button agregar = new Button("Agregar");
        Ventana.configurarBotones(agregar);

        //Agregando a contenedores
        // MainFrame
        getContentPane().add(titulo, BorderLayout.NORTH);
        getContentPane().add(producto, BorderLayout.CENTER);
        getContentPane().add(agregar, BorderLayout.SOUTH);
        // producto
        producto.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridwidth = 1;
        c.weightx = 1;
        c.weighty = 1;

        c.gridx = 0;
        c.gridy = 0;
        producto.add(nombre, c);

        c.gridx = 1;
        c.gridy = 0;
        producto.add(txNombre, c);

        c.gridx = 0;
        c.gridy = 2;
        producto.add(precio, c);
        c.gridx = 1;
        c.gridy = 2;
        producto.add(txPrecio, c);

        c.gridx = 0;
        c.gridy = 3;
        producto.add(cantidad, c);
        c.gridx = 1;
        c.gridy = 3;
        producto.add(txCantidad, c);

        // Escuchadores
        
        addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                new Ventana().setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {
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
        
        class Agregar implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog emergente = new JDialog();
                emergente.setSize(500, 100);
                emergente.setVisible(true);
                ubicacionFrame(emergente);
                setVisible(false);
                emergente.setLayout(new FlowLayout());

                Label textoT = new Label();
                Ventana.configurarTitulos(textoT);

                try {
                    String nombre = txNombre.getText();
                    float precio = Float.parseFloat(txPrecio.getText());
                    int cantidadStock = Integer.parseInt(txCantidad.getText());
                    Almacen.agregarProducto(nombre, precio, cantidadStock);
                    textoT.setText("Producto agregado correctamente");

                } catch (Exception t) {
                    textoT.setText("Producto no agregado, algun campo invalido");

                    emergente.setSize(800, 100);
                }

                emergente.add(textoT);

                emergente.repaint();
                emergente.revalidate();

                emergente.addWindowListener(new CierreModal());

            }

            class CierreModal implements WindowListener {

                @Override
                public void windowOpened(WindowEvent e) {
                }

                @Override
                public void windowClosing(WindowEvent e) {

                    new Ventana().setVisible(true);

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    
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

            }

        }

        agregar.addActionListener(new Agregar());

    }

    private void configuracionTextos(JLabel texto) {
        texto.setFont(new Font("New Time Roman", Font.BOLD, 10));
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setForeground(Color.black);
    }

    private void ubicacionFrame(Container contenedor) {
        Dimension dimPantalla = getToolkit().getScreenSize();

        int x = (int) ((dimPantalla.getWidth() - contenedor.getWidth()) / 2);
        int y = (int) ((dimPantalla.getHeight() - contenedor.getHeight()) / 2);

        contenedor.setLocation(x, y);
    }

}
