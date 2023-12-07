/**
 * @(#)Comercial.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/9
 */

public class Comercial extends Empleado{
 
    /**
     * Comision por venta del comercial
     */
    private double comision; 
    
     /**
     * Constructor con 5 parametros
     * @param nombre nombre del comercial
     * @param apellido apellido del comercial
     * @param edad edad del comercial
     * @param salario salario del comercial
     * @param comision comision del comercial
     */
    public Comercial(String nombre, 
    				 String apellido, 
    				 int edad, 
    				 double salario, 
    				 double comision){
    				 	
        super(nombre, apellido, edad, salario);
        this.comision = comision;
    }
 
    /**
     * Suma un plus al salario del empleado
     * si el empleado tiene una comision menor que 50
     *
     * @param sueldoPlus
     * @return aumento
     */
     
    public boolean plus (double sueldoPlus){
 
        boolean aumento = false;
        
        if (comision<50){
            salario += sueldoPlus;
            aumento = true;
        }
        
        return aumento;
    }
}