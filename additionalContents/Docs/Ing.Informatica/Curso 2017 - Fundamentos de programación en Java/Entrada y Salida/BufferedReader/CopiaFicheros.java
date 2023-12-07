/**
 * @(#)CopiaFicheros.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopiaFicheros{
 
 /*   public static void main(String[] args){
        copia ("C:/Java/ficheroOrigen.txt", "C:/Java/ficheroDestino.txt");
    }*/
 
    public static void copia (String ficheroOriginal, String ficheroCopia){
        try{
        	
            // Se abre el fichero original para lectura
            FileInputStream fileInput = new FileInputStream(ficheroOriginal);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
             
            // Se abre el fichero donde se hara la copia
            FileOutputStream fileOutput = new FileOutputStream (ficheroCopia);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
             
            // Bucle para leer de un fichero y escribir en el otro.
            byte [] array = new byte[1000];
            int leidos = bufferedInput.read(array);
            while (leidos > 0){
                bufferedOutput.write(array,0,leidos);
                leidos=bufferedInput.read(array);
            }
 
            // Cierre de los ficheros
            bufferedInput.close();
            bufferedOutput.close();
        }
        catch (Exception e){
        	//Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
            e.printStackTrace();
        }
    }
}