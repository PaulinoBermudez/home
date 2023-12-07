
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @(#)Asignatura.java
 * 
 * En esta clase podemos:
 * Agregar, Buscar, Eliminar y Listar.
 * Los objetos de tipo Alumno.
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/19
 */
public class Asignatura implements IAsignatura{

    private String nombre;
    private int creditos;
    private Profesor profesor;// Un solo Profesor
    private ArrayList<Alumno> alumnos; // Lista de Alumnos

    public Asignatura(String nombre, int creditos, Profesor profesor) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.profesor = profesor;
        this.alumnos = new ArrayList<Alumno>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    //Agrego objetos en el ArrayList
    public void agregarAlumnos(Alumno alumno) {
        this.alumnos.add(alumno);
    }
 
    //Agrego objetos en el ArrayList en una poscion.
    public void agregarAlumnosPos(int pos, Alumno alumno) {
        this.alumnos.add(pos, alumno);
    }

    //Agrego objetos en el ArrayList
    //Comprobando si el alumno ya se ha agregado
    public void agregarAlumnos2(Alumno alumno) {
        boolean encontrado = false;
        for (Alumno a : alumnos) {
            if (a.getTelefonoContacto() == alumno.getTelefonoContacto()) {
                encontrado = true;
            }
            System.out.println("El Alumno con este telefono Contacto ya ha sido agregado.");
        }
        if (!encontrado) {
            this.alumnos.add(alumno);
        }
    }

    public String getNombre() {
        return (this.nombre);
    }

    public int getCreditos() {
        return (this.creditos);
    }

    public Profesor getProfesor() {
        return (this.profesor);
    }

    //Imprimo los Alumnos reccorriendo el ArrayList con un Iterator
    public void listarAlumnosIterator() {
        Iterator<Alumno> iterador = alumnos.iterator();
        while (iterador.hasNext()) {
            Alumno alumno = iterador.next();
            System.out.println(alumno.toString());
        }
        System.out.println();
    }

    //Imprimo los Alumnos reccorriendo el ArrayList con un for
    public void listarAlumnosFor() {
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno alumno = alumnos.get(i);
            System.out.println("Alumno: " + alumno);
        }
        System.out.println();
    }

    //Imprimo los Alumnos reccorriendo el ArrayList con un for each
    public void listarAlumnosForEach() {
        for (Alumno alumno : alumnos) {
            System.out.println("Alumno: " + alumno);
        }
    }

    /*
     * Con este metodo buscamos Objetos de tipo Alumno
     * comparandolo con el Telefono de contacto.
     *
     */
    public void buscarAlumno() {
        Scanner sc = new Scanner(System.in);
        int telefonoContacto;
        System.out.print("Buscar Alumno por Telefono de Contacto: ");
        telefonoContacto = sc.nextInt();

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getTelefonoContacto() == telefonoContacto) {
                System.out.println("El Alumno con telefono Contacto " + telefonoContacto + " ha sido localizado.");
                System.out.println("Su nombre es: " + alumnos.get(i).getNombre() + " " + alumnos.get(i).getApellidos());
            }
        }
        sc.close();
    }
    
    /*
     * Con este metodo eliminamos Objetos de tipo Alumno
     * comparandolo con el Telefono de contacto.
     *
     */
    public void eliminarAlumno1() {
        Scanner sc = new Scanner(System.in);
        int telefonoContacto;
        System.out.print("Eliminar Alumno por Telefono de Contacto: ");
        telefonoContacto = sc.nextInt();

        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getTelefonoContacto() == telefonoContacto) {
                alumnos.remove(i);
            }
        }
        System.out.println("Alumno con telefono Contacto " + telefonoContacto + " ha sido eliminado.");
        sc.close();
    }

    /*
     * Con este metodo eliminamos Objetos de tipo Alumno
     * comparandolo con el Telefono de contacto.
     *
     */
    public void eliminarAlumno2() {
        Scanner sc = new Scanner(System.in);
        int telefonoContacto;
        boolean encontrado = false;
        System.out.print("Eliminar Alumno por Telefono de Contacto: ");
        telefonoContacto = sc.nextInt();
        int i = 0;
        while (i < alumnos.size() && !encontrado) {
            if (alumnos.get(i).getTelefonoContacto() == telefonoContacto) {
                alumnos.remove(i);
                System.out.println("El Alumno con telefono Contacto " + telefonoContacto + " ha sido eliminado.");
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            System.out.println("El Alumno con telefono Contacto " + telefonoContacto + " NO EXISTE!!!.");
            //eliminarAlumno2();
        }
        sc.close();
    }

    /*
     * Con este metodo eliminamos Objetos de tipo Alumno
     * comparandolo con el Telefono de contacto.
     *
     */
    public void eliminarAlumno3() {
        Scanner sc = new Scanner(System.in);
        int telefonoContacto = 0;
        boolean encontrado = false;
        boolean salir = false;
        while (!salir) {
            try {
                System.out.print("Dame un numero de telefono para eliminarlo: ");
                telefonoContacto = sc.nextInt();
                salir = true;
            } catch (InputMismatchException ex) {
                System.out.println(">>Debes teclear un numero entero.");
                sc.nextLine(); // para limpiar el buffer del teclado, si lo quitas se queda en un bucle infinito
            }
        }
        // En este punto ya hemos leido un numero entero 
        int i = 0;
        while (i < alumnos.size() && !encontrado) {
            if (alumnos.get(i).getTelefonoContacto() == telefonoContacto) {
                alumnos.remove(i);
                System.out.println("El Alumno con telefono Contacto "
                        + telefonoContacto + " ha sido eliminado.");
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            System.out.println("El Alumno con telefono Contacto "
                    + telefonoContacto + " NO EXISTE!!!.");
            eliminarAlumno3();
        }
        sc.close();
    }

    /*
	public String toString (){
        String mensaje = "\nAsignatura: " + nombre + 
        				 "\nCreditos: " + creditos +
        				 "\nProfesor Tutor: " + profesor +	
        			   	 "\nAlumnos: " + alumnos.size();
        return mensaje;
	}*/
    @Override
    public String toString() {
        String alumno = "";
        for (Alumno m : alumnos) {
            alumno = alumno + m.getNombre() + " " + m.getApellidos() + "; ";
        }
        return "\nAsignatura: " + nombre
                + "\nCreditos: " + creditos
                + "\nProfesor Tutor: " + profesor
                + "\nNumero de Alumnos: " + alumnos.size()
                + " \nAlumnos: " + alumno;
    }
}
