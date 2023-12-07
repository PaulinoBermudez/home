/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Persona;
import DAO.PersonaDAO;


public class Principal {

    PersonaDAO miPersonaDAO;

    /**
     * Método principal, hace el llamado al menú donde se presentan todas las
     * opciones del sistema
     *
     * @param args
     */
    public static void main(String[] args) {

        Principal miPrincipal = new Principal();
        miPrincipal.verMenu();
    }

    /**
     * Método que permite presentar las opciones del sistema. solicita el
     * ingreso de un numero y se envia a su correspondiente proceso
     */
    private void verMenu() {

        String textoMenu = "Menú Principal\n\n";
        textoMenu += "Ingrese alguna de las opciones del Menú    \n";
        textoMenu += "1. Registrar Persona\n";
        textoMenu += "2. Consultar Persona\n";
        textoMenu += "3. Ver Lista Personas\n";
        textoMenu += "4. Salir.\n\n";

        try {
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            defineSeleccion(seleccion);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Datos, "
                    + "solo se permiten valores numericos", "ERROR", JOptionPane.ERROR_MESSAGE);
            verMenu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el ingreso de Datos, "
                    + "solo se permiten valores numericos", "ERROR", JOptionPane.ERROR_MESSAGE);
            verMenu();
        }
    }

    /**
     * Permite determinar que accion ejecutar dependiendo del parametro de
     * ingreso correspondiente a las opciones del sistema
     *
     * @param seleccion
     */
    private void defineSeleccion(int seleccion) {

        System.out.println("Selecciona " + seleccion);

        switch (seleccion) {
            case 1:
                registrarPersona();
                verMenu();
                break;
            case 2:
                int doc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero"
                        + " de documento de la persona"));
                buscarPersona(doc);
                verMenu();
                break;
            case 3:
                obtenerRegistros();
                verMenu();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Ingrese un "
                        + "numero valido", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                verMenu();
                break;
        }
    }

    /**
     * Permite solicitar los datos de la persona a registrar, se solicitan
     * mediante una ventana de ingreso y se almacenan en un arreglo con toda la
     * informacion usando para esto un ciclo for, posteriormente estos datos son
     * almacenados en el atributo correspondiente del objeto persona para ser
     * enviado al metodo de registro en la clase DAO
     */
    private void registrarPersona() {
        miPersonaDAO = new PersonaDAO();
        Persona miPersona = new Persona();

        String mensajeIngreso = "Ingrese\n\n";

        String datosSolicitados[] = {"Documento : ", "Nombre : ",
            "Edad: ", "Profesión: ", "Telefono: "};
        String datosPersona[] = new String[5];
        for (int i = 0; i < datosSolicitados.length; i++) {
            //solicita el ingreso del dato y se almacena en el arreglo de datosPersona
            datosPersona[i] = JOptionPane.showInputDialog(null, mensajeIngreso
                    + datosSolicitados[i], "Datos Persona", JOptionPane.INFORMATION_MESSAGE);

            System.out.println(datosSolicitados[i] + datosPersona[i]);
        }

        miPersona.setDni(Integer.parseInt(datosPersona[0]));
        miPersona.setNombrePersona(datosPersona[1]);
        miPersona.setEdadPersona(Integer.parseInt(datosPersona[2]));
        miPersona.setProfesionPersona(datosPersona[3]);
        miPersona.setTelefonoPersona(Integer.parseInt(datosPersona[4]));

        miPersonaDAO.registrarPersona(miPersona);

    }

    /**
     * Permite obtener la lista de personas almacenada en la tabla persona si la
     * lista se encuentra vacia quiere decir que no hay personas registradas
     * acto seguido se presenta un mensaje en pantalla, sino se imprime la lista
     * de todas las personas registradas en la BD
     */
    private void obtenerRegistros() {
        miPersonaDAO = new PersonaDAO();
        Persona miPersona;

        //Se obtiene la lista de personas
        ArrayList<Persona> listaPersonas = miPersonaDAO.listaDePersonas();
        //se valida si se obtubo o no informacion
        if (listaPersonas.size() > 0) {
            int numeroPersona = 0;
            //se recorre la lista de personas asignandose cada posicion en un objeto persona
            for (int i = 0; i < listaPersonas.size(); i++) {
                numeroPersona++;
                miPersona = listaPersonas.get(i);
                System.out.println("****************Persona " + numeroPersona + "**********************");
                System.out.println("DNI Persona: " + miPersona.getDni());
                System.out.println("Nombre Persona: " + miPersona.getNombrePersona());
                System.out.println("Edad Persona: " + miPersona.getEdadPersona());
                System.out.println("Profesion Persona: " + miPersona.getProfesionPersona());
                System.out.println("Telefono Persona: " + miPersona.getTelefonoPersona());
                System.out.println("*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Actualmente no "
                    + "existen registros de personas", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /**
     * Permite la consulta de una persona en especifico mediante el envio de su
     * documento de identidad como parametro, en caso de que no se retorne
     * informacion se presenta un mensaje en pantalla, sino entonces se imprimen
     * los datos de la persona encontrada
     *
     * @param documento
     */
    private void buscarPersona(int documento) {
        miPersonaDAO = new PersonaDAO();
        Persona miPersona;
        ArrayList<Persona> personasEncontrada = miPersonaDAO.consultarPersona(documento);
        //se valida que se encuentre la persona
        if (personasEncontrada.size() > 0) {
            //se recorre la lista y se asignan los datos al objeto para imprimir los valores
            for (int i = 0; i < personasEncontrada.size(); i++) {
                miPersona = personasEncontrada.get(i);
                System.out.println("****************Persona*************************");
                System.out.println("DNI Persona: " + miPersona.getDni());
                System.out.println("Nombre Persona: " + miPersona.getNombrePersona());
                System.out.println("Edad Persona: " + miPersona.getEdadPersona());
                System.out.println("Profesión Persona: " + miPersona.getProfesionPersona());
                System.out.println("Telefono Persona: " + miPersona.getTelefonoPersona());
                System.out.println("*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El documento ingresado "
                    + "no corresponde a ninguna persona", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
