

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/crud_alumnos";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            JOptionPane.showMessageDialog(
                null,
                "Conexion realizada correctamente");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}