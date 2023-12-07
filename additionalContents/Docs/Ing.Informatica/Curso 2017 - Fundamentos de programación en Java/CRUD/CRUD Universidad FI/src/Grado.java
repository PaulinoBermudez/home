
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * @(#)Grado.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/7/4
 */

public class Grado {

    private String nombre;
    private ArrayList<Asignatura> asignaturas;
    Scanner sc = new Scanner(System.in);

    public Grado(String nombre) {
        this.nombre = nombre;
        this.asignaturas = new ArrayList<Asignatura>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarAsignaturas(Asignatura asignatura) {
        this.asignaturas.add(asignatura);
    }

    public String getNombre() {
        return nombre;
    }

    //Imprimo las Asignatura reccorriendo el ArrayList con un Iterator
    public void listarAsignaturasIterator() {
        Iterator<Asignatura> iterador = asignaturas.iterator();
        while (iterador.hasNext()) {
            Asignatura asignatura = iterador.next();
            System.out.println(asignatura.toString());
        }
        System.out.println();
    }

    /*
     * Con este metodo eliminamos Objetos de tipo Asignatura
     * comparandolo con su nombre.
     *
     */
    public void eliminarAsignatura1() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.print("Eliminar Asignatura por su nombre: ");
        nombre = sc.nextLine();

        for (int i = 0; i < asignaturas.size(); i++) {
            // IMPORTANTE
            // Cuando el atributo es un String debo de usar .equals para hacer la comparacion
            if (asignaturas.get(i).getNombre().equals(nombre)) {
                asignaturas.remove(i);
            }
        }
        System.out.println("Asignatura " + nombre + " ha sido eliminada.");
        sc.close();
    }

    /*
     * Con este metodo eliminamos Objetos de tipo Asignatura
     * comparandolo con su nombre.
     *
     */
    public void eliminarAsignatura2() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean encontrado = false;
        System.out.print("Eliminar Asignatura por su nombre: ");
        nombre = sc.nextLine();
        int i = 0;
        while (i < asignaturas.size() && !encontrado) {
            // IMPORTANTE
            // Cuando el atributo es un String debo de usar .equals para hacer la comparacion
            if (asignaturas.get(i).getNombre().equals(nombre)) {
                asignaturas.remove(i);
                System.out.println("Asignatura " + nombre + " ha sido eliminada.");
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            System.out.println("La Asignatura " + nombre + " NO EXISTE!!!.");
            eliminarAsignatura2();
        }
        sc.close();
    }

    /*
     * Con este metodo eliminamos Objetos de tipo Asignatura
     * comparandolo con su nombre.
     *
     */
    public void eliminarAsignatura3() {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        boolean encontrado = false;
        boolean salir = false;
        while (!salir) {
            try {
                System.out.print("Dame un nombre para eliminarlo: ");
                nombre = sc.nextLine();
                salir = true;
            } catch (InputMismatchException ex) {
                System.out.println(">>Debes teclear un nombre correcto.");
                sc.nextLine(); // para limpiar el buffer del teclado, si lo quitas se queda en un bucle infinito
            }
        }
        // En este punto ya has leido un numero entero 
        int i = 0;
        while (i < asignaturas.size() && !encontrado) {
            // IMPORTANTE
            // Cuando el atributo es un String debo de usar .equals para hacer la comparacion
            if (asignaturas.get(i).getNombre().equals(nombre)) {
                asignaturas.remove(i);
                System.out.println("La Asignatura " + nombre + " ha sido eliminada.");
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            System.out.println("La Asignatura " + nombre + " NO EXISTE!!!.");
            eliminarAsignatura3();
        }
        sc.close();
    }

    /*   public String toString (){
        String mensaje = "\nNombre del Grado: " + nombre + 	
        			   	 "\nNumero de Asignaturas: " + asignaturas.size();
        return mensaje;
	}*/
    @Override
    public String toString() {
        String asignatura = "";
        for (Asignatura m : asignaturas) {
            asignatura = asignatura + m.getNombre() + "; ";
        }
        return "\nNombre del Grado: " + nombre
                + "\nNumero de Asignaturas: " + asignaturas.size()
                + " \nAsignaturas: " + asignatura;
    }
}
