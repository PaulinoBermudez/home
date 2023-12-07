/**
 * @(#)Vehiculo.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/12/30
 */

public class Vehiculo{
		
    private String matricula;
    private int numeroDeRuedas;
    
    public Vehiculo(String matricula, int numDeRuedas){
    	this.matricula = matricula;
    	numeroDeRuedas = numDeRuedas;
    }
    
    public void setMatricula(String matricula){
      this.matricula = matricula;
    }
    
    public void setNumeroDeRuedas(int numRuedas){
    	numeroDeRuedas = numRuedas;
    }
    
    public String getMatricula(){
    	return matricula;
    }
    
    public int getNumeroDeRuedas(){
    	return numeroDeRuedas;
    }
    
    public String toString(){
    	return "Matricula: " + matricula + "\nNumero de ruedas: " + numeroDeRuedas;
    }
}
