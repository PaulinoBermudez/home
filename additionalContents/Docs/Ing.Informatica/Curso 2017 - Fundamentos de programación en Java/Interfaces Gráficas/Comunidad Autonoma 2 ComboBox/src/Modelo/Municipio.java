package Modelo;

/**
 *
 * @author Toni
 */
public class Municipio {

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
    public Vector<Municipio> mostrarMunicipio(int idProvincia) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();

        Vector<Municipio> datos = new Vector<Municipio>();
        Municipio dat = null;
        try {

            String sql = "SELECT * FROM municipio WHERE id_provincia=" + idProvincia;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Municipio();
            dat.setId(0);
            dat.setNombre("Seleccionar Municipio");
            datos.add(dat);

            while (rs.next()) {
                dat = new Municipio();
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
