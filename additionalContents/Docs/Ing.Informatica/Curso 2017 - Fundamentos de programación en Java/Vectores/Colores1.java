import javax.swing.JOptionPane;

/**
 * @(#)Colores1.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/12/25
 */

public class Colores1 {
	public static void main (String[] args) {
		
		String colores[] = {"Rojo","Verde","Azul","Amarillo","Negro"};
		
		try {
		
		for (int i=0; i<colores.length; i++){
			System.out.println(colores[i]);	
		}
		
		System.out.println(colores[5]);
		
		}catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: Fuera del Indice del array\n");
            
            JOptionPane.showMessageDialog(
                null,
                "Acceso fuera del Indice del array");
		}	
	}
}