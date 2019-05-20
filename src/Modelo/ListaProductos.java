
package Modelo;

import java.sql.*;
import java.util.ArrayList;


public class ListaProductos  {
    Conexion conexion;
    
    public ListaProductos(){
        conexion = new Conexion();
    }
    
    public ArrayList<Producto> listaProductos(){
        ArrayList listaPedido = new ArrayList();
        Producto producto;
        try {
            Connection acceDB = conexion.getConexion();
            
            PreparedStatement ps = acceDB.prepareStatement("select * from comida");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                producto = new Producto();
                
                producto.setId(rs.getInt(1));
                
                producto.setPrecio(rs.getDouble(3));
              
                listaPedido.add(producto);
            }
        } catch (Exception e) {
        }
        return listaPedido;
    }
    
    //obtener id del pedido y listar todos esos productos
    /*
    public ArrayList<Producto> listaPedido(){
        ArrayList listaPedido = new ArrayList();
        ProductoPedido productopedido;
        try {
            Connection acceDB = conexion.getConexion();
            //cambiar por llamada a funcion que obtenga el ultimo id insertado
            int nroPedido =1;
            PreparedStatement ps = acceDB.prepareStatement("select * from producto_pedido where idPedido=nroPedido ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                productopedido = new ProductoPedido();
                productopedido.setIdPedido(rs.getInt(1));
               // producto.setApellidos(rs.getString(2));
              //  producto.setNombres(rs.getString(3));
              //  producto.setFechaN(rs.getString(4));
               // producto.setDireccion(rs.getString(5));
               // producto.setTelefono(rs.getInt(6));
                listaPedido.add(productopedido);
            }
        } catch (Exception e) {
        }
        return listaPedido;
    }*/
    
    public String insertPedido(int idMesero){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "INSERT INTO pedido (idMesero) VALUES (?);";
            CallableStatement ps = accesoDB.prepareCall(sql);
            ps.setInt(1, idMesero);      
            int numFAfectas = ps.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
                
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception e) {
        }
        return rptaRegistro;
    }
    
    public String insertProductoPedido(int idPedido, int idProducto ,int cantidad,double subtotal){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "INSERT INTO producto_pedido (idPedido, idproducto, cantidad, subtotal) VALUES (?,?,?,?);";
            CallableStatement ps = accesoDB.prepareCall(sql);
            ps.setInt(1, idPedido);
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, subtotal);
            
            int numFAfectas = ps.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
            }
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        catch (Exception e) {
            
        }
        return rptaRegistro;
    }
    
}
