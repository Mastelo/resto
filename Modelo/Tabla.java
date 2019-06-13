/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author orlandolopez
 */
public class Tabla {
    
    DefaultTableModel modelo2;
    
    private void CrearModelo2(){
    try {
        modelo2 = (new DefaultTableModel(null, new String [] {"id","Nombres","apellidos","direccion"}){
        Class[] types = new Class [] {
        java.lang.String.class,
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
        //tabla2.setModel(modelo2);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,e.toString()+"error2");
    }
 }
}
