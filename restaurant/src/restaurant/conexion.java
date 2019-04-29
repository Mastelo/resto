/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;


import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class conexion {
    private Connection connection=null;

public final Connection conect(){
     try{
     Class.forName("com.mysql.jdbc.Driver");
     
    //String server="jdbc:mysql://localhost:3306/bd";
     String server="jdbc:mysql://localhost/BD?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

     String user ="root";
     String pass="ivan";
     
     connection= DriverManager.getConnection(server, user, pass);
     
     //JOptionPane.showMessageDialog(null,"Conexión establecida!");
     
     return connection;
             
     }catch(HeadlessException | ClassNotFoundException | SQLException ex){
       ex.printStackTrace();
       JOptionPane.showMessageDialog(null,"conexion fallida!");
       
     }  
  return null;
}
public ResultSet visualizar(){
    Connection conectar=conect();
    ResultSet rs = null;
    try{
        PreparedStatement ps = conectar.prepareStatement("select * from producto");//modificar plat por usuario
        rs=ps.executeQuery();  
    }catch(Exception ex){
        System.out.println("Error de consulta");
    }
    return rs;
 }
public void guardar_imagen(String ruta, String nombre, double precio, String descripcion, String tamanio){
    Connection conectar=conect();
    String insert="insert into producto (nombre,precio,descripcion,tamanio,foto) values (?,?,?,?,?)";
    FileInputStream fi=null;
    PreparedStatement ps =null;
    try{
        File file=new File(ruta);
        fi=new FileInputStream(file);
        ps=conectar.prepareStatement(insert);
        ps.setString(1,nombre);
        ps.setDouble(2, precio);
        ps.setString(3, descripcion);
        ps.setString(4,tamanio);
        ps.setBinaryStream(5,fi);
        
        ps.executeUpdate();
    }catch(Exception ex){
        System.out.println("Error al guardar");
    }
  }
public int existe_producto(String nombre){
    Connection conectar=conect();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql ="SELECT count(id) FROM producto WHERE nombre =?";//prueba 3
    
    try{
        
        ps=conectar.prepareStatement(sql);
        ps.setString(1,nombre);
        rs=ps.executeQuery();
        if(rs.next()){
            return rs.getInt(1);
        }
        return 1;
        
    }catch(Exception ex){
        System.out.println("error al comparar");
        return 1;
    }
  }
}
