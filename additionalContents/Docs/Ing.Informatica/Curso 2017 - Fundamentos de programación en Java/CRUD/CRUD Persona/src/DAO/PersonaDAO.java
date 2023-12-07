package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Conexion.Conexion;
import Modelo.Persona;

/**
 *
 * @author Toni
 */
public class PersonaDAO {

    /**
     * Permite registrar un empleado
     *
     * @param persona
     */
    public void registrarPersona(Persona persona) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConnection().createStatement();
            estatuto.executeUpdate("INSERT INTO persona VALUES ('" 
                    + persona.getDni()+ "', '"
                    + persona.getNombrePersona() + "', '" 
                    + persona.getEdadPersona() + "', '"
                    + persona.getProfesionPersona() + "', '" 
                    + persona.getTelefonoPersona() + "')");
            JOptionPane.showMessageDialog(null, "Se ha registrado Exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            estatuto.close();
            conex.desconectar();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "No se Registro la persona");
        }
    }

    /**
     * permite consultar el empleado asociado al documento enviado como
     * parametro
     *
     * @param documento
     * @return
     */
    public ArrayList<Persona> consultarPersona(int dni) {
        ArrayList<Persona> miEmpleado = new ArrayList< >();
        Conexion conex = new Conexion();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona where dni = ? ");
            consulta.setInt(1, dni);
            ResultSet res = consulta.executeQuery();

            if (res.next()) {
                Persona persona = new Persona();
                persona.setDni(Integer.parseInt(res.getString("dni")));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
                persona.setProfesionPersona(res.getString("profesion"));
                persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
                miEmpleado.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar la Persona\n" + e);
        }
        return miEmpleado;
    }

    /**
     * permite consultar la lista de empleados
     *
     * @return
     */
    public ArrayList<Persona> listaDePersonas() {
        ArrayList<Persona> miEmpleado = new ArrayList<>();
        Conexion conex = new Conexion();

        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM persona");
            ResultSet res = consulta.executeQuery();
            while (res.next()) {
                Persona persona = new Persona();
                persona.setDni(Integer.parseInt(res.getString("dni")));
                persona.setNombrePersona(res.getString("nombre"));
                persona.setEdadPersona(Integer.parseInt(res.getString("edad")));
                persona.setProfesionPersona(res.getString("profesion"));
                persona.setTelefonoPersona(Integer.parseInt(res.getString("telefono")));
                miEmpleado.add(persona);
            }
            res.close();
            consulta.close();
            conex.desconectar();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar la Persona\n" + e);
        }
        return miEmpleado;
    }
}
