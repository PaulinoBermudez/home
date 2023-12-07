/**
 * @(#)ListinProfesores.java
 *
 *
 * @author 
 * @version 1.00 2015/12/30
 */

import java.util.ArrayList;

public class ListinProfesores{

    private ArrayList <Profesor> listinProfesores;

    public ListinProfesores (){

        listinProfesores = new ArrayList <Profesor> ();
    }

    public void addProfesor (Profesor profesor){

        listinProfesores.add(profesor);
    }

    public void listar(){

        System.out.println ("Se procede a mostrar los datos de los profesores existentes en el listín");

        for (Profesor tmp: listinProfesores) {

            tmp.mostrarNombreApellidosYCarnet();
        }
    }
}