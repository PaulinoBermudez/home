package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MunicipioDAO{
	
	public Vector<Municipio> mostrarMunicipio(int idProvincia) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Municipio> datos = new Vector<Municipio>();
        Municipio dat = null;
        try {

            String sql = "SELECT * FROM municipios WHERE provincia_id =" + idProvincia;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Municipio();
            dat.setId(0);
            dat.setNombre("Seleccionar Municipio");
            datos.add(dat);

            while (rs.next()) {
                dat = new Municipio();
                dat.setId(rs.getInt("id"));
                dat.setNombre(rs.getString("municipio"));
                dat.setLatitud(rs.getString("latitud"));
                dat.setLongitud(rs.getString("longitud"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
	
}
