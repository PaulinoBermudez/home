/**
 * @(#)File4.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/6
 *
 * El programa muestra el contenido del directorio raíz
 * de la unidad actual de trabajo y de todos sus
 * subdirectorios de forma recursiva.
 * Para cada directorio se muestran primero los archivos
 * y a continuación las carpetas que contienen de forma recursiva.
 */

import java.io.File;

public class File4 {

    public static void main(String[] args) {
        recorrerDirectorios("/");
    }

    public static void recorrerDirectorios(String ruta) {
        //Se crea un objeto file con la ruta del directorio
        File directorio = new File(ruta);
        //Se comprueba si la ruta existe
        if (!directorio.exists()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no existe.");
            return;
        }
        //Se comprueba si es un directorio
        if (!directorio.isDirectory()) {
            System.out.println("La ruta " + directorio.getAbsolutePath() + " no es un directorio");
            return;
        }
        System.out.println(directorio.getAbsolutePath());
        //obtener todo el contenido del directorio
        File[] lista = directorio.listFiles();
        //se recorre el directorio y se muestran primero los archivos
        for (File s : lista) {
            if(s.isFile())
                System.out.println("Archivo ->  " + s.getName());
        }
        //se recorre de nuevo el directorio y se obtienen los subdirectorios
        for (File s : lista) {        
            //Si es un directorio se vuelve a llamar al método
            if (s.isDirectory()) {
                recorrerDirectorios(s.getAbsolutePath());
            }
        }
    }
}