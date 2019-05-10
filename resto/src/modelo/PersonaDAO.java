
package modelo;
import java.sql.*;
import java.util.ArrayList;


public class PersonaDAO {
    Conexion conexion;
    
    public PersonaDAO(){
        conexion = new Conexion();
    }
    
    public String insertPersona( String apellidos, String nombres, String fecha, String direccion, int telefono){
        String rptaRegistro=null;
        try {
            Connection accesoDB = conexion.getConexion();
            String sql = "INSERT INTO mesero ( apellidos, nombres, fechaNacimiento, direccion, telefono)\n" +
"VALUES (?,?,?,?,?);";
            CallableStatement ps = accesoDB.prepareCall(sql);
           // ps.setString(1, id);
            ps.setString(1, apellidos);
            ps.setString(2, nombres);
            ps.setString(3, fecha);
            ps.setString(4, direccion);
            ps.setInt(5, telefono);
            
            int numFAfectas = ps.executeUpdate();
            
            if(numFAfectas>0){
                rptaRegistro="Registro exitoso.";
            }
        } catch (Exception e) {
        }
        return rptaRegistro;
    }
    
    public ArrayList<Mesero> listPersona(){
        ArrayList listaPersona = new ArrayList();
        Mesero mesero;
        try {
            Connection acceDB = conexion.getConexion();
            
            PreparedStatement ps = acceDB.prepareStatement("select * from mesero");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mesero = new Mesero();
                mesero.setId(rs.getString(1));
                mesero.setApellidos(rs.getString(2));
                mesero.setNombres(rs.getString(3));
                mesero.setFechaN(rs.getString(4));
                mesero.setDireccion(rs.getString(5));
                mesero.setTelefono(rs.getInt(6));
                listaPersona.add(mesero);
            }
        } catch (Exception e) {
        }
        return listaPersona;
    }
    
    public int deletePersona(String id){
        int filAfectadas= 0;
        try {
            Connection accesoDB = conexion.getConexion();
            PreparedStatement ps = accesoDB.prepareStatement("delete from mesero where id=?");
           // CallableStatement cs = accesoDB.prepareCall("{call sp_deletePersona(?)}");
            ps.setString(1, id);
            filAfectadas = ps.executeUpdate();
        } catch (Exception e) {
        }
        
        return filAfectadas;
    }
    
    public int editPersona(String id, String apellidos, String nombres,String fecha, String direccion, int telefono){
        int filAfectadas=0;
        try {
            Connection accesoDB = conexion.getConexion();
            
            PreparedStatement ps = accesoDB.prepareStatement("UPDATE mesero SET apellidos=?, nombres=?, fechaNacimiento=?, direccion=?, telefono=? WHERE id=?;");
            
            //CallableStatement cs = accesoDB.prepareCall("{call sp_editPersona(?,?,?,?,?,?)}");
            
            ps.setString(1, apellidos);
            ps.setString(2, nombres);
            ps.setString(3, fecha);
            ps.setString(4, direccion);
            ps.setInt(5, telefono);
            ps.setString(6, id);
            filAfectadas = ps.executeUpdate();
        } catch (Exception e) {
        }
        return filAfectadas;  
    }
    
    public ArrayList<Mesero> buscaPersona(String apellido){
        ArrayList listaPersona = new ArrayList();
        Mesero mesero;
        try {
            Connection acceDB = conexion.getConexion();
            //problema en la busqueda
            String sql = "select * from mesero where apellidos like '%"+ apellido +"%';";
            PreparedStatement ps = acceDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                mesero = new Mesero();
                mesero.setId(rs.getString(1));
                mesero.setApellidos(rs.getString(2));
                mesero.setNombres(rs.getString(3));
                mesero.setFechaN(rs.getString(4));
                mesero.setDireccion(rs.getString(5));
                mesero.setTelefono(rs.getInt(6));
                listaPersona.add(mesero);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
        catch (Exception e) {
        }
        return listaPersona;
    }
}
