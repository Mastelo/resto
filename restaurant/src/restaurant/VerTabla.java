/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ivan
 */
public class VerTabla {
    public void visualizar_tabla(JTable tabla){
    
    
   conexion conn = new conexion();
   Connection con = conn.conect();
   ResultSet rs = conn.visualizar();
   
   tabla.setDefaultRenderer(Object.class,new TablaImagen());
   
   DefaultTableModel dt = new DefaultTableModel();
   dt.addColumn("Nombre");
   dt.addColumn("Foto");
   dt.addColumn("precio");//prueba
   //dt.addColumn("descripcion");//prueba
   //dt.addColumn("foto");
   try{
       while (rs.next()){
       Object[] fila = new Object[5];//remplazar [2]
       fila[0]= rs.getObject(2);
       fila [2]=rs.getObject(3);
       
       Blob blob =rs.getBlob(6);
       byte [] data= blob.getBytes(1,(int)blob.length());
       BufferedImage img =null;
       try{
           img = ImageIO.read(new ByteArrayInputStream(data));
       }catch(Exception ex){
           }
       ImageIcon icono = new ImageIcon(img);
       fila[1] = new JLabel(icono);
       dt.addRow(fila); 
       
        }
       tabla.setModel(dt);
       tabla.setRowHeight(100);
   }catch(Exception ex){
       System.out.println("Error al visualizar en la tabla");
   }
   
  }
}
    

