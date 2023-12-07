package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public static Connection getConexion() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexion realizada con exito");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexion fallida");
        }
        return connection;
    }

    /*
    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Establecemos la conexion con la base de datos. 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "");
        	} catch (Exception e) {
        }
        return con;
    }*/
}