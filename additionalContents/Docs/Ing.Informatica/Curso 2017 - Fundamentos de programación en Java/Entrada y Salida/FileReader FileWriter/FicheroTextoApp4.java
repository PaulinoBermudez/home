/**
 * @(#)FicheroTextoApp4.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/29
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTextoApp4{
	
    public static void main(String[] args){
    	
        try(FileWriter fw=new FileWriter("E:\\fichero1.txt");
            FileReader fr=new FileReader("E:\\fichero1.txt")){
            
            //Escribimos en el fichero un String
            fw.write("Esto es una prueb");
            
            //Escribimos en el fichero un caracter 97 (a) 
            fw.write(97);
            
            //Guardamos los cambios del fichero
            fw.flush();
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            // -1 indica que no hay más caracteres.
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}
