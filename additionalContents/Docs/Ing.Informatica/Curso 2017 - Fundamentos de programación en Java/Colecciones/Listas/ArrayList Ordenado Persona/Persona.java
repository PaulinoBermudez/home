import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

public class Persona implements Comparable {
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fechaNacimiento;   
   
    public String toString() {
        return this.apellidos + " " + this.nombre + " " + this.dni + " "
        + DateFormat.getDateInstance(DateFormat.DEFAULT,
               Locale.getDefault()).format(this.fechaNacimiento);
    }
   
   public Persona(String nombre, String apellidos, String dni, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int compareTo(Object o) {
        Persona persona = (Persona)o;       
       
        if(this.apellidos.compareToIgnoreCase(persona.apellidos) == 0) {           
            if(this.nombre.compareToIgnoreCase(persona.nombre) == 0) {
                return this.dni.compareTo(persona.dni);
            } else {
                return this.nombre.compareToIgnoreCase(persona.nombre);
            }
        } else {
            return this.apellidos.compareToIgnoreCase(persona.apellidos);
        }       
       
    }
    
    
    public static void pintaLista(List lista) {
        for(int i=0;i<lista.size();i++) {
            System.out.println(lista.get(i));
        }
    }
    
    public class NacimientoPersonaComparator implements Comparator {

	    public int compare(Object o1, Object o2) {
	        Persona persona1 = (Persona)o1;
	        Persona persona2 = (Persona)o2;
	        return persona1.getFechaNacimiento().
	                compareTo(persona2.getFechaNacimiento());
	               
	    }
	}
	
	
	public static void main(String[] args) {
       
        List lista = new ArrayList();
       
        Calendar cal = Calendar.getInstance();
        cal.set(1976,3,21);   
        Persona persona1 = new Persona("Francisco Javier","Martínez Páez","11111111A",cal.getTime());
        cal.set(1973,8,12);
        Persona persona2 = new Persona("Roberto","Canales Mora","22222222B",cal.getTime());
        cal.set(1975,7,23);
        Persona persona3 = new Persona("Alejandro","Pérez García","33333333C",cal.getTime());       
        cal.set(1980,6,14);
        Persona persona4 = new Persona("Germán","Jiménez Centeno","44444444D",cal.getTime());       
        cal.set(1981,5,8);
        Persona persona5 = new Persona("Alfonso","Blanco Criado","55555555E",cal.getTime());       
        cal.set(1981,9,30);
        Persona persona6 = new Persona("Raúl","Expósito Díaz","66666666F",cal.getTime());
               
        lista.add(persona1);
        lista.add(persona2);
        lista.add(persona3);
        lista.add(persona4);
        lista.add(persona5);
        lista.add(persona6);
       
        System.out.println("=== SIN ORDENAR ===");
        pintaLista(lista);
        System.out.println();      
       
        System.out.println("=== ORDEN NATURAL DEFINIDO en compareTo ===");
        Collections.sort(lista);       
        pintaLista(lista);
        System.out.println();
        
        System.out.println("=== POR FECHAS DE NACIMIENTO ===");
//     	Collections.sort(lista, new NacimientoPersonaComparator());       
     	pintaLista(lista);   
  
    }
	
	
}