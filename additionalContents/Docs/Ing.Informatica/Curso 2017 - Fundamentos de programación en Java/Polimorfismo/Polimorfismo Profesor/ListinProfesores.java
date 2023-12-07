/**
 * @(#)Text3.java
 *
 *
 * @author 
 * @version 1.00 2016/10/21
 */


 import java.util.ArrayList; //Ejemplo aprenderaprogramar.com

public class ListinProfesores{

    private ArrayList <Profesor> listinProfesores;

    //Constructor

    public ListinProfesores () {

        listinProfesores = new ArrayList <Profesor> ();
    }

    //Métodos

    public void addProfesor (Profesor profesor) {

        listinProfesores.add(profesor);
        
    }     // Cierre método addProfesor

    public void listar() {

        System.out.println ("Se procede a mostrar los datos de los profesores existentes en el listín");

        for (Profesor tmp: listinProfesores) {       //Uso de for extendido

            tmp.mostrarDatos(); }

    } //Cierre método

} //Cierre de la clase