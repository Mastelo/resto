
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ListaPedidos {
    Conexion conexion;
    
    public ListaPedidos(){
        conexion = new Conexion();
    }
     public ArrayList<Producto> listaPedidos(){
        ArrayList listaPedidos = new ArrayList();
        ProductoPedido productopedido;
        try {
            Connection acceDB = conexion.getConexion();
            //cambiar por llamada a funcion que obtenga el ultimo id insertado
            //int nroPedido =1;
            PreparedStatement ps = acceDB.prepareStatement("select * from producto_pedido");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                productopedido = new ProductoPedido();
                
                productopedido.setIdPedido(rs.getInt(1));
                productopedido.setIdProducto(rs.getInt(2));
                productopedido.setCantidad(rs.getInt(3));
              //  producto.setFechaN(rs.getString(4));
               // producto.setDireccion(rs.getString(5));
               // producto.setTelefono(rs.getInt(6));
                listaPedidos.add(productopedido);
            }
        } catch (Exception e) {
        }
        return listaPedidos;
    }
    
}
