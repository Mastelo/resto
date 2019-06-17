
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class GraficaComida extends Conexion {
    private GraficaComida grafic;
    
    Connection cn = getConexion();
    
    public DefaultTableModel mostrarComida(){
        
        DefaultTableModel miModelo = null;
        try{
            String titulos []= {"Idcomida","Nombre"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select idc, nombre from comida1";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("idc");
               dts[1] = rs.getString("Nombre");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }
    
    public DefaultTableModel agruparComida(String fechaD, String fechaH){
      
        DefaultTableModel miModelo = null;
       
        try{
            String titulos []= {"Nombre","TotalPedidos"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "SELECT nombre, SUM(cantidad) AS TotalPedidos\n" +
                         "FROM comida c, pedido p, producto_pedido pp\n" +
                         "WHERE p.idpedido=pp.idpedido and pp.idcomida=c.idcomida and fechaPedido between '"+fechaD+"' and '"+fechaH+"'\n" +
                         "GROUP BY c.nombre\n" +
                         "ORDER BY SUM(cantidad) DESC\n" +
                         "LIMIT 0 , 3";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("Nombre");
               dts[1] = rs.getString("totalpedidos");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }   
    
    
    
    
}

