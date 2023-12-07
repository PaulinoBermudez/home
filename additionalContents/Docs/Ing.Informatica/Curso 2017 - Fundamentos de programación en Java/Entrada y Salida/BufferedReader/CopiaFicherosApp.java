/**
 * @(#)CopiaFicherosApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

public class CopiaFicherosApp{
 
    public static void main(String[] args){
    	
    	CopiaFicheros copiar = new CopiaFicheros();
    	
        copiar.copia ("C:/Java/ficheroOrigen.txt", "C:/Java/ficheroDestino.txt");
    }
}