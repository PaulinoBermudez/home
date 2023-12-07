package principal;

import controlador.ControladorPersona;
import modelo.PersonaDAO;
import vista.VistaPersona;

public class Principal {

    public static void main(String[] args) {
        VistaPersona vistaPersona = new VistaPersona();
        PersonaDAO personaDAO = new PersonaDAO();
        ControladorPersona CPersona = new ControladorPersona(vistaPersona, personaDAO);
        vistaPersona.setVisible(true);
        vistaPersona.setLocationRelativeTo(null);
    }

}
