/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author orlandolopez
 */
public class ConsultaMesa extends Conexion {

    public boolean registrar(Mesa mesa) {
        boolean estado = false;

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT mesa (disponibilidad, capacidad) VALUES(?,?);";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, mesa.getEstado());
            ps.setInt(2, mesa.getCapacidad());
            ps.execute();

            estado = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return estado;
    }

    public boolean modificar(Mesa mesa) {
        boolean estado = false;

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE mesa SET Disponibilidad=?, Capacidad=? WHERE NroMesa=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, mesa.getEstado());
            ps.setInt(2, mesa.getCapacidad());
            ps.setInt(3, mesa.getNroMesa());
            ps.execute();

            estado = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return estado;
    }

    public boolean eliminar(Mesa mesa) {
        boolean estado = false;

        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM mesa WHERE NroMesa=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, mesa.getNroMesa());
            ps.execute();

            estado = true;
        } catch (SQLException e) {
            System.err.println(e);
        }
        return estado;
    }

    public boolean buscar(Mesa mesa) {
        boolean estado = false;

        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;

        String sql = "SELECT * FROM mesa WHERE NroMesa=?";

        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, mesa.getNroMesa());
            rs = ps.executeQuery();

            if (rs.next()) {
                mesa.setEstado(Integer.parseInt(rs.getString("Disponibilidad")));
                mesa.setCapacidad(Integer.parseInt(rs.getString("Capacidad")));
                estado = true;
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        return estado;
    }

    public ArrayList<Mesa> recuperarMesa() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String slq = "SELECT * FROM mesa";

        ArrayList<Mesa> listM = new ArrayList<>();
        try {
            ps = con.prepareCall(slq);

            rs = ps.executeQuery();                     

            while (rs.next()) {

                listM.add(new Mesa(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
                //System.err.println(listM);
            }
            System.err.println("hola");
        } catch (SQLException e) {
            System.err.println(e);
        }
        return listM;
    }
}
