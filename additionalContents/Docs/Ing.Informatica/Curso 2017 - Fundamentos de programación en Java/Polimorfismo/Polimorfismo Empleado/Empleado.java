/**
 * @(#)Empleado.java
 *
 * Contiene informacion de cada empleado, es una clase abstracta
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */
 
public abstract class Empleado {
 
    protected final static double SALARIO_DEF=600;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected double salario;
    
     /**
     * Constructor con 4 parametros
     * @param nombre nombre del empleado
     * @param apellido nombre del empleado
     * @param edad edad del empleado
     * @param salario salario del empleado
     */
    public Empleado(String nombre, String apellido, int edad, double salario){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.salario=salario;
    }
 
    /**
     * Devuelve el nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }
 
    /**
     * Modifica el nombre de un empleado
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    /**
     * Devuelve la edad de un empleado
     * @return edad del empleado
     */
    public int getEdad() {
        return edad;
    }
 
    /**
     * Modifica la edad de un empleado
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    /**
     * Devuelve el salarioBase
     * @return salarioBse
     */
    public double getSalario() {
        return salario;
    }
 
    /**
     * Modifica el salarioBase de los empleados
     * @param salarioBase
     */
    public  void setSalario(double salario) {
        this.salario = salario;
    }
 
    public abstract boolean plus (double sueldoPlus);
 
}