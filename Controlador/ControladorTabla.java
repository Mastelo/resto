/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Consulta;
import Modelo.Pedido;
import Vista.VistaListaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orlandolopez
 */
public class ControladorTabla implements ActionListener{
    
    private Pedido pedido;
    private Consulta consulta;
    private Vista.VistaListaProductos vistalista;
    
    DefaultTableModel model = new DefaultTableModel();

    public ControladorTabla(Pedido pedido, Consulta consulta, VistaListaProductos vistalista) {
        this.pedido = pedido;
        this.consulta = consulta;
        this.vistalista = vistalista;
        
        this.vistalista.btnListar.addActionListener(this);
        
        
    }
    
    public void iniciar(){
        vistalista.setTitle("lista de productos");
        vistalista.setLocationRelativeTo(null);
        
        
        
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Foto");
        
        this.vistalista.tableProductos.setModel(model);
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vistalista.btnListar) {
            //tabla();
            
            System.out.println(consulta.obtenerLista());
            //JOptionPane.showMessageDialog(null, "datos");
        }
    }
    
    
    private void tabla(){
        
        
        Object[] columna = new Object[1];
        //String [] dato = consulta.obtenerLista();
        //ArrayList nombres = consulta.obtenerLista();
        
        //for (int i =  0; i  < nombres.size(); i ++) {
        
        
            //model.addRow(nombre);
        //}*/
        for (int i = 0; i < consulta.obtenerLista().size(); i++) {
            columna [0] = consulta.obtenerLista().get(i).getId();
            model.addRow(columna);
        }
        
    }
    
    /*private void rellenarTabla(){
        String [] dato = consulta.obtenerLista();                                 
    }*/
    
}
