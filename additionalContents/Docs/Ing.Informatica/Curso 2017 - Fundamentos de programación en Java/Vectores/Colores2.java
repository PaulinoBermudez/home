import javax.swing.JOptionPane;

/**
 * @(#)Colores2.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/12/25
 */
 
public class Colores2 {
	
	public static void main (String[] args) {
		
		String[] colores = new String[5];
		
		colores[0] = "Rojo";
		colores[1] = "Verde";
		colores[2] = "Azul";
		colores[3] = "Amarillo";
		colores[4] = "Negro";
		
		
		try {
		
		for (int i=0; i<colores.length; i++){
			System.out.println(colores[i]);	
		}
		
		System.out.println(colores[5]);
		
		}catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError: Fuera del Indice del array\n");
            
            JOptionPane.showMessageDialog(
                null,
                "Acceso fuera del Indice del array");
			
			
		}
	}
}