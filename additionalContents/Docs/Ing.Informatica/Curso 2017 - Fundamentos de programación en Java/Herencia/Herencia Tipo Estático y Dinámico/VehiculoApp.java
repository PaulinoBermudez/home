/**
 * @(#)VehiculoApp.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/12/30
 */

public class VehiculoApp{
	
    public static void main(String []args){
    	
    	Vehiculo t1 = new Taxi("DC-2030", 4, "Manolo Romero", 2);
    	
    	System.out.println("Datos del taxi numero 1:\n\n" + t1.toString());
      
    }
}
