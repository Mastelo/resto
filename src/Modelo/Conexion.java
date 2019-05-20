/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author orlandolopez
 */
public class Conexion {
    
    private final String base = "bdrest";
    private final String user = "root";
    private final String pass = "";
    private final String url  = "jdbc:mysql://localhost:3306/"+ base;
    private Connection   con  = null;
    
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