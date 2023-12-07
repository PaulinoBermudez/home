/**
 * @(#)Taxi.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/12/30
 */

public class Taxi extends Vehiculo{
	
    private String nombreDelConductor;
    private int numeroDePlazas;
    
    public Taxi(String matricula, 
    			int numDeRuedas, 
    			String nombreDelConductor, 
    			int numDePlazas){
    	super(matricula, numDeRuedas);
    	this.nombreDelConductor = nombreDelConductor;
    	numeroDePlazas = numDePlazas;
    }
    
    public void setNombreDelConductor(String nombre){
      nombreDelConductor = nombre;
    }
    
    public void setNumeroDePlazas(int numPlazas){
      numeroDePlazas = numPlazas;
    }
    
    public String getNombreDelConductor(){
      return nombreDelConductor;
    }
    
    public int getNumeroDePlazas(){
      return numeroDePlazas;
    }
    
    public String toString(){
      return super.toString() + "\nNombre del conductor: " + nombreDelConductor + "\nNumero de plazas: " + numeroDePlazas;
    }
}
