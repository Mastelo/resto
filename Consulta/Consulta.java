/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consulta;

import Modelo.Conexion;
import Modelo.Producto;
import Modelo.Producto_1;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author orlandolopez
 */
public class Consulta extends Conexion{
    
    public boolean registrar(Producto pro){
    
        boolean estado = false;
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT producto (nombre, descripcion, precio, tamanho, imagen) VALUES(?,?,?,?,?);";
        try {
            ps = con.prepareCall(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setDouble(3, pro.getPrecio());
            ps.setString(4, pro.getTamanho());
            ps.setBinaryStream(5, pro.getImage());
            ps.execute();
            
            estado = true;
            
        } catch (SQLException e) {
            System.err.println(e);
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
            
        }
        
        return estado;
    }
    
    public ArrayList<Producto> obtenerLista(){
        boolean estado = false;
        
        Producto producto;
        String [] dato = new String[3];
        
        ArrayList<Producto> nombre = new ArrayList<>();
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "Select * FROM pa.producto";
        
        try {
            ps = con.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {        
                
                producto = new Producto();
                producto.setId(rs.getInt(1));
                //System.out.println(rs.getString(1));
                dato [0] = rs.getString(1);
                dato [1] = rs.getString(2);
                dato [2] = rs.getString(3);
                
                
                nombre.add(producto);
                //nombre.add(rs.getString(2));
                //nombre.add(rs.getString(3));
            }
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return nombre;
    }
    
    public ArrayList<Producto_1> recuperarProducto(){
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();        
        String slq = "select * from pa.producto";
        
        ArrayList<Producto_1> listP = new ArrayList<>();
        try {
            ps = con.prepareCall(slq);
            
            rs = ps.executeQuery();
            //System.out.println(rs.getString(2));
            int cont = 0;
            while (rs.next()) {
                
                
                listP.add(new Producto_1(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),
                rs.getString(5),rs.getBlob(6)));
                //System.out.println(rs.getString(2)+"   "+rs.getString(3)+"  ");
                
                //System.out.println(listP.get(cont).getImage());
                //cont++;
            }
            
            //System.out.println(listP);
            //System.out.println("hola");
            
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listP;
    }
    
}
