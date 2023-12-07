/**
 * @(#)FicheroTextoBufferedApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FicheroTextoBufferedApp{
	
    public static void main(String[] args){
    	
        try(BufferedReader br=new BufferedReader(new FileReader("C:\\Java/fichero.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("C:\\Java/fichero.txt"));){
            //Escribimos en el fichero
            bw.write("Esto es una prueba usando BufferedReader");
            bw.newLine();
            bw.write("Seguimos usando BufferedReader");
            //Guardamos los cambios del fichero
            bw.flush();
            
            //Leemos el fichero y lo mostramos por pantalla
            String linea=br.readLine();
            
            while(linea!=null){
                System.out.println(linea);
                linea=br.readLine();
            }
            
        }catch(IOException e){
            System.out.println("Error E/S: "+e);
        }
    }
}