package CRUD;

import Conexion.Conectar;
import VO.ProductoVO;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/*Metodo listar*/
public class ProductoCRUD{

    public ArrayList<ProductoVO> Listar_ProductoVO(){
        ArrayList<ProductoVO> list = new ArrayList<ProductoVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM producto;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoVO vo = new ProductoVO();
                vo.setIdproducto(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setPrecio(rs.getDouble(3));
                vo.setDescripcion(rs.getString(4));
                vo.setFoto(rs.getBytes(5));
                vo.setTamaño(rs.getString(6));
                
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }


/*Metodo agregar*/
    public void Agregar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO producto (id, nombre, precio, descripcion, foto, tamaño)\n" +
"VALUES (NULL,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getDescripcion());
            ps.setBytes(4, vo.getFoto());
            ps.setString(5, vo.getTamaño());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se registro los datos del plato/bebida");
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ya existe el plato/bebida ");
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
                
            }catch(Exception ex){}
        }
    }

/*Metodo Modificar*/
    public void Modificar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, descripcion = ?, foto = ?, tamaño = ?\n" +
"WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getDescripcion());
            ps.setBytes(4, vo.getFoto());
            ps.setString(5, vo.getTamaño());
            
            
            //tiene que ser ultimo por que, para modificar necesita el id
            ps.setInt(6, vo.getIdproducto());
    
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }

    public void Modificar_ProductoVO2(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE producto SET nombre = ?, precio = ?, descripcion = ?, tamaño = ? \n" +
"WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getPrecio());
            ps.setString(3, vo.getDescripcion());
            ps.setInt(4, vo.getIdproducto());
            ps.setString(6,vo.getTamaño());
            
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
/*Metodo Eliminar*/
    public void Eliminar_ProductoVO(ProductoVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM producto WHERE id = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdproducto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }


}
