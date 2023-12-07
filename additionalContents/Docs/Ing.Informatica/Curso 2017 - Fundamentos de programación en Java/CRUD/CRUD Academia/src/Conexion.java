
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String servidor = "jdbc:mysql://localhost/academia";
    private String usuario = "root"; // Nombre de usuario por defecto
    private String pass = ""; // Clave por defecto
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conexion;

    public Conexion() {

        try {
            // Levanto el driver
            Class.forName(driver);
            // Establezco la conexión
            conexion = DriverManager.getConnection(servidor, usuario, pass);
            System.out.println("Conexion realizada con exito");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Conexion fallida");
        }
    }

    public Connection getConnection() {
        return conexion; // Devuelvo el objeto Connection
    }
}
