/**
 * Excepciones
 * Ejemplo: Con try-catch
 *
 * @author Antonio Rivero
 * @version 1.00 2014/5/30
 */


public class Persona {
	private int edad;

    public void setEdad(int edadNueva) throws Exception{
    	if(edadNueva < 0 || edadNueva > 100) throw (new Exception("Edad no válida"));
    		edad = edadNueva;
    }
    
    public String toString(){
    	return "Edad de la persona: " + edad;
    }
}