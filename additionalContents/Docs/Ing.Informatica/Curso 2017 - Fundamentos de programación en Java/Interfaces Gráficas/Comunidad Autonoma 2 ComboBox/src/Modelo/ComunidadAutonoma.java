package Modelo;

/**
 *
 * @author Toni
 */
public class ComunidadAutonoma {

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
    public Vector<ComunidadAutonoma> mostrarCCAA() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<ComunidadAutonoma> datos = new Vector<>();
        ComunidadAutonoma dat = null;
        try {

            String sql = "SELECT * FROM ccaa";
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
    }*/
}
