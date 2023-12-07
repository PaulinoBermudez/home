/**
 * @(#)Filtro.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/6
 */

import java.io.FilenameFilter;
import java.io.File;

//Clase Filtro implementa el interface FilenameFilter
public class Filtro implements FilenameFilter {
	
    String extension;
    
    Filtro(String extension) {
        this.extension = extension;
    }

    //implementacion del metodo accept del interface
    @Override
    public boolean accept(File ruta, String nombre) {
    	// Saber si un archivo tiene una determinada extensión.
        return nombre.endsWith(extension);
    }
}