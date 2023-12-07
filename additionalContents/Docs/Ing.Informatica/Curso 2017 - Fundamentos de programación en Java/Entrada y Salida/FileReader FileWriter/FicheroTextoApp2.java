/**
 * @(#)FicheroTextoApp2.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/29
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTextoApp2{
    public static void main(String[] args){
    	
        try{
            //Creo los objetos, abro streams
            FileWriter fw = new FileWriter("C:\\Java/fichero1.txt");
            FileReader fr = new FileReader("C:\\Java/fichero1.txt");

            //Escribimos en el fichero un String
            fw.write("Esto es una prueb");
            
            //Escribimos en el fichero un caracter 97 (a) 
            fw.write(97);
            
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            // -1 indica que no hay m�s caracteres.
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            //Cerramos el stream
            fw.close();
            fr.close();
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}