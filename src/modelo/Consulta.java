/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    
}
