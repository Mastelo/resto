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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author orlandolopez
 */
public class ControladorCantidad implements ActionListener{

    private Cantidad vCantidad;
    private Consulta consulta;
    //private ArrayList<JButton> botones;
    private int indice;
    private JButton botonSelec;
    
    ArrayList<Pedido2> pedidos ;
    ArrayList<Producto_1> productos;

    public ControladorCantidad(Cantidad vCantidad, Consulta consulta, JButton botonSelec){//, ArrayList<JButton> botones){
        this.vCantidad = vCantidad;
        this.consulta = consulta;
        
        this.botonSelec = botonSelec;
        //this.botones = botones;
        
        indice = 0;
        
        this.vCantidad.btnCantidad.addActionListener(this);
        pedidos = new ArrayList<>();
        
        
    }
    
    
    
    public void iniciar(){
        vCantidad.setTitle("Cantidad");        
        vCantidad.setLocationRelativeTo(null);  
        
        vCantidad.spnCantidad.setValue(1);
        
        pedidos = new ArrayList<>();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Producto_1> productos = consulta.recuperarProducto();
        if (e.getSource() == vCantidad.btnCantidad) {
            
            //ArrayList<Pedido2> pedidos = new ArrayList<>();
            //String nombre = productos.get(indice).getNombre();
            //double precio = productos.get(indice).getPrecio();
            
            int cantidad = (int)vCantidad.spnCantidad.getValue();
            //pedidos.add(new Pedido2(nombre, precio, ca));
            /*
            for (int i = 0; i < productos.size(); i++) {
                if (botonSelec.getName().equals(productos.get(i).getNombre())) {
                    System.out.println(botonSelec.getName() + "  " + cantidad + "   "+ productos.get(i).getPrecio());
                    pedidos.add(new Pedido2(botonSelec.getName(), cantidad, cantidad*productos.get(i).getPrecio()));
                    //verArray();
                }
            }*/
            System.out.println(botonSelec.getName() + "  " + cantidad + "   ");
                
            //System.out.println(nombre +"  "+ precio +"  "+ ca + "   " + i);                    
            //System.out.println(pedidos.get(indice).getNombre()+"   "+  pedidos.get(indice).getCantidad()+"   "+ pedidos.get(indice).getPrecio());
            //indice++;          
            /*
            System.out.println(vCantidad.spnCantidad.getValue());
            for (int i = 0; i < botones.size(); i++) {
                 System.out.println(" el boton es: "+ botones.get(i).getName());
            }*/
            this.vCantidad.setVisible(false);
        }                        
            //
        if (e.getSource() == vCantidad.spnCantidad) {
            
        }                
    }
    
    public void verArray(){
        for (int i = 0; i < pedidos.size(); i++) {
            //Pedido2 get = pedidos.get(i);
            System.out.println("------");
            System.err.println(pedidos.size());
            System.out.println(pedidos.get(i).getNombre());//pedidos.get(i).getPrecio());
        }
    }
    
}
