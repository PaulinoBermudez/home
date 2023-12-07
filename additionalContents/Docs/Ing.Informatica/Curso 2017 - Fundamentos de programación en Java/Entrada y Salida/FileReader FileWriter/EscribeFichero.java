/**
 * @(#)EscribeFichero.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class EscribeFichero{
	
    public static void main(String[] args){
    	
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try{
        	/*
        	 * Si queremos agregar texto al final de un fichero
        	 * ya existente, simplemente debemos poner un
        	 * flag a true como segundo parametro del
        	 * constructor de FileWriter.
        	 *
        	 * FileWriter fichero = new FileWriter("c:/prueba.txt",true);
        	 */
            fichero = new FileWriter("c:/Java/prueba.txt",true);
            pw = new PrintWriter(fichero);
 
            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);
 
        } catch (Exception e) {
        	
        	// Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           }catch (Exception e2){
           	
           	//Se utiliza para imprimir el registro del stack
        	// donde se ha iniciado la excepción. 	
            e2.printStackTrace();
           }
        }
    }
}