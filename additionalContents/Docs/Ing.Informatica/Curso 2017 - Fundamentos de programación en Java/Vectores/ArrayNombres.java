import javax.swing.JOptionPane;

/**
 * @(#)ArrayNombres.java
 *
 *
 * @author 
 * @version 1.00 2015/12/25
 */

public class ArrayNombres {
	
	public static void main(String[] args) {
		
		try{
		
		
		String[ ] nombre = new String[4];
		
		nombre[0] = "Luis";
        nombre[1] = "María";
		nombre[2] = "Carlos";
		nombre[3] = "Jose";
		nombre[4] = "Ismael";   //Error:No existe esta variable array de índice 4
		
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("\nError: Fuera del Indice del array\n");
            
            JOptionPane.showMessageDialog(
                null,
                "Acceso fuera del Indice del array");
		}
		
     }
 }