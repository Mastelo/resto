

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexion {
    
     private final String base = "bdrest";
    private final String user = "root";
    private final String pass = "";
    //private final String url  = "jdbc:mysql://localhost:3307/"+ base;
    private final String url  = "jdbc:mysql://localhost:3307/bdrest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

     Connection   con  = null;
    
    public Connection getConexion(){
        
        try {
            //Class.forName("com.mysql.jbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.pass);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return con;
    }
    
    
}
