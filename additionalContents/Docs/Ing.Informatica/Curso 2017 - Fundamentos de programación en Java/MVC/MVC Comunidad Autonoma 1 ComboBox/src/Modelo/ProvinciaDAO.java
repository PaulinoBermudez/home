package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ProvinciaDAO{
	
	public Vector<Provincia> mostrarProvincia(int idCCAA) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Provincia> datos = new Vector<Provincia>();
        Provincia dat = null;
        try {

            String sql = "SELECT * FROM provincias WHERE comunidad_id =" + idCCAA;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Provincia();
            dat.setId(0);
            dat.setNombre("Seleccionar Provincia");
            datos.add(dat);

            while (rs.next()) {
                dat = new Provincia();
                dat.setId(rs.getInt("id"));
                dat.setNombre(rs.getString("provincia"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
	
	
	
}
