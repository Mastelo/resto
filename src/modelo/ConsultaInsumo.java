
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class ConsultaInsumo {
     Conexion conexion;
        public boolean registrar(Insumo ins){
            conexion =new Conexion();
    
        boolean estado = false;
        
        PreparedStatement ps = null;
        SimpleDateFormat Ffecha = new SimpleDateFormat("yyyy-MM-dd");
        
        String sql = "INSERT insumo  (nombreIn, descripcionIn, precioIn, fechaIn, UnidadIn) VALUES(?,?,?,?,?);";
        try {
            Connection accesoDB2 = conexion.getConexion();
            ps = accesoDB2.prepareCall(sql);
            ps.setString(1, ins.getNombre());
            ps.setString(2, ins.getDescripcion());
            ps.setDouble(3, ins.getPrecio());
            ps.setString(4,ins.getFechaC());
            ps.setString(5, ins.getUnidad());
            ps.execute();
            
            estado = true;
            
        } catch (SQLException e) {
            System.err.println(e);
        } 
        
        return estado;
    }
        public ArrayList<Insumo> listInsumo(){
        ArrayList listaInsumo = new ArrayList();
        Insumo insumo;
        try {
            Connection acceDB2 = conexion.getConexion();
            
            PreparedStatement ps = acceDB2.prepareStatement("select * from insumo");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                insumo = new Insumo();
                insumo.setNombre(rs.getString(2));
                //System.out.println(rs.getString(2));
                insumo.setDescripcion(rs.getString(3));                                   
                insumo.setPrecio(rs.getDouble(4));
                insumo.setFechaC(rs.getString(5));
                insumo.setUnidad(rs.getString(6));
                System.out.println(rs.getString(6));
                listaInsumo.add(insumo);
            }
        } catch (Exception e) {
        }
        return listaInsumo;
    }
}
