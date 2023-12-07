package Modelo;

import Vista.ComboComunidades;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

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
                dat.setNombre(rs.getString("comunidad"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }

    public void LLenarTabla(ComboComunidades comboVista) {

        try {
            ComunidadAutonoma ccaa = (ComunidadAutonoma) comboVista.getCbxComunidad().getSelectedItem();
            DefaultTableModel modelo = new DefaultTableModel();
            comboVista.getJtProvincias().setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            java.sql.Connection con = conn.getConexion();

            String sql = "SELECT id, provincia FROM provincias WHERE comunidad_id = " + ccaa.getId();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();

            modelo.addColumn("ID");
            modelo.addColumn("Provincia");

            int[] anchos = {50, 200};
            for (int i = 0; i < comboVista.getJtProvincias().getColumnCount(); i++) {
                comboVista.getJtProvincias().getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                Object[] filas = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }

    }

}
