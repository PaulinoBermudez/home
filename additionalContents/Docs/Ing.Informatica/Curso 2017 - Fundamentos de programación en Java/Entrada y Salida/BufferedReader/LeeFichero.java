/**
 * @(#)LeeFichero.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
 
class LeeFichero{
	
   public static void main(String [] arg){
   	
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
 
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Java/fichero.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!= null)
            System.out.println(linea);
      }
      catch(Exception e){
            //Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
        	e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            
            //Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
            e2.printStackTrace();
         }
      }
   }
}