package Modelo;

/**
 *
 * @author Toni
 */
public class Provincia {

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /*
    public Vector<Provincia> mostrarProvincia(int idCCAA) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Provincia> datos = new Vector<Provincia>();
        Provincia dat = null;
        try {

            String sql = "SELECT * FROM provincia WHERE id_ccaa=" + idCCAA;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Provincia();
            dat.setId(0);
            dat.setNombre("Seleccionar Provincia");
            datos.add(dat);

            while (rs.next()) {
                dat = new Provincia();
                dat.setId(rs.getInt("id"));
                dat.setNombre(rs.getString("nombre"));
                datos.add(dat);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }*/
}
