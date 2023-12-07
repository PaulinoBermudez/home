/**
 * @(#)File3.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/6
 *
 * El siguiente programa muestra la diferencia entre
 * 	getPath().
 * 	getAbsolutePath().
 * 	getCanonicalPath().
 *
 * Ademas usa el metodo getProperty() de la clase System para
 * obtener el directorio de trabajo actual.
 */

import java.io.File;
import java.io.IOException;

public class File3 {
	
    public static void main(String[] args) throws IOException{
    	
        File f = new File("../../datos.dat");
        String dirActual = System.getProperty("user.dir");
        System.out.println("Directorio actual   " + dirActual);
        System.out.println("getPath()           " + f.getPath());
        System.out.println("getAbsolutePath()   " + f.getAbsolutePath());
        System.out.println("getCanonicalPath()  " + f.getCanonicalPath());   
    }
}