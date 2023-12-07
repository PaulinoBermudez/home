/**
 * @(#)ArchivoApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/28
 */

public class ArchivoApp{
	
  public static void main(String[] args){
  	
    Archivo archivo = new Archivo();
    String entrada = archivo.leerTextoArchivo("Prueba.txt");
    
    System.out.println(entrada);
    archivo.escribirTextoArchivo("PruebaCopia.txt", entrada);
  }
}
