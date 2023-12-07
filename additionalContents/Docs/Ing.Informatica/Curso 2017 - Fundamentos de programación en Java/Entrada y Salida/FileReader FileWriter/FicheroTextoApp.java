/**
 * @(#)FicheroTextoApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/29
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTextoApp{
	
    public static void main(String[] args){
    	
        try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw = new FileWriter("C:\\Java/fichero1.txt");
            
            //Escribimos en el fichero un String
            fw.write("Esto es una prueb");
            
            //Escribimos en el fichero un caracter 97 (a) 
            fw.write(97);
            
            //Cierro el stream
            fw.close();
            
            //Abro el stream, el fichero debe existir
            FileReader fr=new FileReader("C:\\Java/fichero1.txt");
            
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            
            // -1 indica que no hay más caracteres.
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            //Cerramos el stream
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}