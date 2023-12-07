
/**
 * @(#)Lanzador.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/19
 */

public class Lanzador {

    public static void main(String[] args) {

        //Creamos los objetos de clase.
        Grado Informatica = new Grado("Informatica");
        Grado Economia = new Grado("Economia");

        Profesor Lorenzo = new Profesor("Lorenzo", "Arbona", 784512);
        Profesor Toni = new Profesor("Toni", "Rivero", 3652658);
        Profesor Carrasco = new Profesor("Luis ", "Carrasco", 658454);
        Profesor Novo = new Profesor("Alberto", "Novo", 325698);

        Asignatura matematicas = new Asignatura("Matematicas", 6, Lorenzo);
        Asignatura programacion = new Asignatura("Fundamentos de Informatica", 6, Toni);
        Asignatura historiaEconomica = new Asignatura("Historia Economica", 6, Carrasco);
        Asignatura contabilidad = new Asignatura("Contabilidad", 6, Novo);

        Alumno Vanessa = new Alumno("Vanessa", "Prieto", 101, "Castillo de Bellver, 1");
        Alumno Miguel = new Alumno("Miguel", "Malaje", 777123456, "Manacor");
        Alumno Juan = new Alumno("Juan", "Perez", 123456789, "Campos");

        //Mostramos la informacion de los Alumnos
        System.out.println("Informacion de los Alumnos");
        Vanessa.mostrarInfoAlumno();
        Miguel.mostrarInfoAlumno();
        Juan.mostrarInfoAlumno();

        //Mostramos la informacion de los Profesores
        System.out.println("Informacion de los Profesores");
        Lorenzo.mostrarInfoProfesor();
        Toni.mostrarInfoProfesor();

        //Agrego alumnos a las asignaturas
        matematicas.agregarAlumnos(Vanessa);
        matematicas.agregarAlumnos(Miguel);

        programacion.agregarAlumnos(Vanessa);
        programacion.agregarAlumnosPos(0, Juan);
        programacion.agregarAlumnosPos(0, Miguel);

        //Eliminio un Alumno de la Asignatura
        //programacion.eliminarAlumno1();
        System.out.println("Alumnos de Matematicas");
        matematicas.listarAlumnosIterator();

        System.out.println("Alumnos de Programacion");
        programacion.listarAlumnosIterator();

        System.out.println(matematicas.toString());
        System.out.println(programacion.toString());

        System.out.println();

        System.out.println("Probamos los bucles");
        System.out.println();

        //Prueba de los bucles.
        System.out.println("Listamos los Alumnos con for");
        matematicas.listarAlumnosFor();

        System.out.println("Listamos los Alumnos con for-each");
        programacion.listarAlumnosForEach();
        System.out.println();

        //Agrego asignaturas al Grado de Informatica
        Informatica.agregarAsignaturas(matematicas);
        Informatica.agregarAsignaturas(programacion);

        System.out.println("Listamos las asignaturas del Grado Iterator");
        System.out.println();

        Informatica.listarAsignaturasIterator();
        System.out.println();

        System.out.println("Listamos las asignaturas del Grado toString");
        System.out.println();
        System.out.println(Informatica.toString());

        //Agrego asignaturas al Grado de Economia
        Economia.agregarAsignaturas(historiaEconomica);
        Economia.agregarAsignaturas(contabilidad);

        System.out.println("Listamos las asignaturas del Grado toString");
        System.out.println();
        System.out.println(Economia.toString());

//	    Economia.eliminarAsignatura1();
        System.out.println(Economia.toString());
        
        //Buscamos un alumno por numero de telefono
        matematicas.buscarAlumno();

    }
}
