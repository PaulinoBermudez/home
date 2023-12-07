package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
    public Conexion(){
    }
    
    public Connection getConexion(){
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universidad", "root", "");
            System.out.println("Conexion realizada con exito");
        	} catch (Exception e) {
        }
        return con;
    }
}