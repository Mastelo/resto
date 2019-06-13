/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Consulta.Consulta;
import Modelo.Pedido2;
import Modelo.Producto_1;
import Vista.Cantidad;
import Vista.VistaPedido;
import Vista.VistaPedido2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orlandolopez
 */
public final class ControladorPedido implements ActionListener {
    
    private VistaPedido2 pedido;
    private Consulta consulta;
    private Cantidad vCantidad;

    JScrollPane scroll = new JScrollPane();
    
    DefaultTableModel modelo2;
    
    private ArrayList<JButton> botones = new ArrayList<>();
    private int indice;
    
    public ControladorPedido(VistaPedido2 pedido, Consulta consulta) {
        this.pedido = pedido;
        this.consulta = consulta;
               
        this.pedido.btnPrueba.addActionListener(this);
        this.pedido.btnTabla.addActionListener(this);
        
        vCantidad = new Cantidad();
        
        cargarBotones();
        
        indice = 0;
    }
    
    public void iniciar(){
        pedido.setTitle("Pedido");        
        pedido.setLocationRelativeTo(null);  
        
        //pedido.jPanelGrande.setPreferredSize(new Dimension(380,500));        
        /*
        scroll.setBounds(420, 36, 400, 420);               
        scroll.setViewportView(pedido.jPanelGrande);        
        pedido.add(scroll);*/
        
        //cargarBotones();
        //cargarImagenes();
        crearTabla();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == pedido.btnPrueba) {
            //consulta.recuperarProducto();
            //JOptionPane.showMessageDialog(null,"kk");
            //cargarBotones();
            System.out.println();
        }
        if (e.getSource() == pedido.btnTabla) {
            //c<cargarTabla();
            
        }
    }
    
    //-----------------------------------------------------------------------
    
    public void cargarImagenes(){
        
        /*
        ImageIcon img = new ImageIcon("/Users/orlandolopez/NetBeansProjects/Coma/src/Imagenes/Chicharon.png");
        Image imgEs = img.getImage().getScaledInstance(pedido.lblImagen.getWidth(), pedido.lblImagen.getHeight(), Image.SCALE_SMOOTH);
        pedido.lblImagen.setIcon(new ImageIcon(imgEs));
        
        ImageIcon img2 = new ImageIcon("/Users/orlandolopez/NetBeansProjects/Coma/src/Imagenes/Fricase.png");
        Image imgEs2 = img2.getImage().getScaledInstance(pedido.lblImagen1.getWidth(), pedido.lblImagen1.getHeight(), Image.SCALE_SMOOTH);
        pedido.lblImagen1.setIcon(new ImageIcon(imgEs2));
        */
    }

    
    
    
    public void crearTabla(){
        
        //String [] titulo = {"Nombre", "Cantidad", "Precio"};
        DefaultTableModel modelo = crearModelo2();
        
        pedido.tblProductos.setModel(modelo);
        
    }
    
    public void cargarBotones(){
        //ImageIcon img = new ImageIcon("/Users/orlandolopez/NetBeansProjects/Coma/src/Imagenes/Chicharon.png");
        
        ArrayList<Producto_1> productos = consulta.recuperarProducto();
        
        for (int i = 0; i < productos.size(); i++) {
            try {
                Blob imgen = productos.get(i).getImage();
                byte [] imagen = convertirBLob(imgen);
                ImageIcon img = new ImageIcon(imagen);
                String text = productos.get(i).getNombre();
                double precioProducto = productos.get(i).getPrecio();
                //String nombre = "btnComida" + i ;
                String nombre = text ;
                JButton boton = new JButton(text, img);
                boton.setName(nombre);//productos.get(i).getNombre()             
                pedido.panelBtn.add(boton);
                botones.add(boton); 
                pedido.panelBtn.updateUI();
                /*
                */
                
                //System.out.println(botones.get(i).getText());
                //System.out.println(botones.get(i).getName());
                //System.out.println("p :" +productos.get(i).getPrecio());
                //System.out.println(botones.get(i).set);
            } catch (SQLException e) {
                System.err.println(e);
            }
            
        }
        boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {                        
                        JButton obj = (JButton)e.getSource();
                        String nombre = obj.getText();
                        if (e.getSource() == obj) {
                            //JOptionPane.showMessageDialog(null,"Soy " + nombre);
                            
                            //System.err.println(obj.getName());
                            //Cantidad cant = new Cantidad();
                            ControladorCantidad ctrl = new ControladorCantidad(vCantidad, consulta, obj);
                            ctrl.iniciar();
                            //int cantidad = (int)cant.spnCantidad.getValue();
                            //System.err.println("La cantidad es: "+ cantidad);
                            //tablaPedido(text, precioProducto, cantidad);
                            
                            vCantidad.setVisible(true);
                            
                        }
                        
                        //System.out.println(nombre);
                        
                    }
                });
        
        
    }
    
    public byte [] convertirBLob(Blob blob) throws SQLException{
        int bloblegth = (int) blob.length();
        byte [] blobbyte = blob.getBytes(1, bloblegth);
        return blobbyte;
    }
    
    //modelo de la tabla
    private DefaultTableModel crearModelo2(){
        try {
            modelo2 = (new DefaultTableModel(
            null, new String [] {"Nombre",
                                 "Cantidad",
                                 "Total"}){
            Class[] types = new Class [] {
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false,false,false,false
            };
            
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
                return canEdit [colIndex];
            }
            });            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString()+"error2");
        }
        return modelo2;
    }
    
    public void cargarTabla(ArrayList<Pedido2> pedidos){
        //ArrayList<Producto_1> productoSelec = consulta.recuperarProducto();
        ArrayList<Pedido2> pedidosTabla = pedidos;
        //int  cantidad = 2;
        Object O[]=null;
        for (int i = 0; i < pedidosTabla.size(); i++) {
            modelo2.addRow(O);
            Pedido2 getP = (Pedido2) pedidosTabla.get(i);
            modelo2.setValueAt(getP.getNombre(), i, 0);
            //modelo2.setValueAt(getP.getCantidad(), i, 2);
            modelo2.setValueAt(getP.getCantidad(),i,1);
            modelo2.setValueAt(getP.getPrecio(), i, 2);
        }
    }
    
    public void tablaPedido(String nombreProducto, double precioProducto, int cantidad){
        ArrayList<Pedido2> pedidos = new ArrayList<>();
        
        double total = precioProducto * cantidad;
        
        pedidos.add(new Pedido2(nombreProducto, cantidad, total));
        
        cargarTabla(pedidos);
    }
}
