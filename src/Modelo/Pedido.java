
package Modelo;
import java.sql.*;
import java.util.ArrayList;
import Modelo.Conexion;

public class Pedido  {
    Conexion conexion;
    
    public Pedido(){
        conexion = new Conexion();
    }
    
    public ArrayList<Producto> listPersona(){
        ArrayList listaPersona = new ArrayList();
        Producto producto;
        try {
            Connection acceDB = conexion.getConexion();
            
            PreparedStatement ps = acceDB.prepareStatement("select * from producto");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                producto = new Producto();
                producto.setId(rs.getInt(1));
               // producto.setApellidos(rs.getString(2));
              //  producto.setNombres(rs.getString(3));
              //  producto.setFechaN(rs.getString(4));
               // producto.setDireccion(rs.getString(5));
               // producto.setTelefono(rs.getInt(6));
                listaPersona.add(producto);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
    
}
