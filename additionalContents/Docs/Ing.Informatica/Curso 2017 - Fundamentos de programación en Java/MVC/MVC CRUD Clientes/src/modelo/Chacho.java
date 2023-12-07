/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Toni
 */
public class Chacho {
    
    public void chacho() throws SQLException {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM CLIENTE ORDER BY ID";
        co = Conexion.conectar();
        stm = co.createStatement();
        rs = stm.executeQuery(sql);

    }
    
}
