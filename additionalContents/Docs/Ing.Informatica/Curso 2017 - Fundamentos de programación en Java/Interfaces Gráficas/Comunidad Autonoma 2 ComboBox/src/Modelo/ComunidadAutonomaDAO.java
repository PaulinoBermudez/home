package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Toni
 */
public class ComunidadAutonomaDAO {

    public Vector<ComunidadAutonoma> mostrarCCAA() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<ComunidadAutonoma> datos = new Vector<>();
        ComunidadAutonoma dat = null;
        try {

            String sql = "SELECT * FROM comunidades";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new ComunidadAutonoma();
            dat.setId(0);
            dat.setNombre("Selecciona CCAA");
            datos.add(dat);

            while (rs.next()) {
                dat = new ComunidadAutonoma();
                dat.setId(rs.getInt("id"));
                dat.setNombre(rs.getString("nombre"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }

}
