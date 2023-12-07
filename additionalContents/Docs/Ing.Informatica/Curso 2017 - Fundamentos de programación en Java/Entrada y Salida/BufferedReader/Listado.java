/**
 * @(#)Listado.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/14
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;

public class Listado{
	
	public static String leer(){
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		try{
			return br.readLine();
		}
		catch(Exception e){
			System.out.println("Error E/S: "+e);
		}
		return "";
	}
	
	public static void main (String[] args){
		
		System.out.println ("Indique nombre de directorio");
		System.out.println ("Trayectoria absoluta, ejemplo : C:/Java");
		
		String nomdir = leer();
		File archivo = new File(nomdir);
		
		if (archivo.exists())
			if (archivo.isDirectory()){
				System.out.println ("contenido de " + nomdir);
				String arr[] = archivo.list();
				
				for(int j = 3; j < arr.length; j++){
					
					File otro = new File(nomdir + "\\" + arr[j]);
					if (otro.isDirectory())
						System.out.println (arr[j] + " <DIR>");
					else
					System.out.println(arr[j]);	
				}
			}
			else
				System.out .println (nomdir + " no es un directorio");
		else
			System.out.println("No existe") ;	
	}
}