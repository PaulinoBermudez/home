import java.io.*;
import java.util.*;

public class Main{
    private static    boolean trazabilidad = false;
    private static    boolean entrada = false;
    private static    boolean salida = false;

    public static boolean NombreDeArchivoValido(String file) {
        //System.err.close();
        File f = new File(file);
        try {
                f.getCanonicalPath();
                if(!entrada){
                    if(f.exists()){
                        //EntradaConfig test = new EntradaConfig(file);
                        boolean testOk = true;
                        //if (test.getOKentrada()){
                            return true;
                        //}else{
                          //  return false;
                        //}
                    }else{         
                        System.out.println("No existe el archivo de entrada.");
                        System.exit(0);
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                System.out.println("Error el abrir archivo de entrada.");
                System.exit(0);
                return false;
            }
        }

    public static void main(String[] args) 
    {
        System.err.close();
        String nombrearchivoentrada = "";
        String nombrearchivosalida ="";
        
        if (args.length > 4) { //si hay más de 1 parámetro
            System.out.println("\nError 1: Hay demasiados parámetros. Máximo número parametros: 4.");
            System.out.println("Ejecute java -jar multiplicar.jar -h para ver ayuda.\n");
        }else{
            if (args.length == 0) { //si no hay parámetros      9
                System.out.println("\nError 0: Faltan parametros(fichero_entrada obligatorio). Minimo número de parametros: 1.");
                System.out.println("Ejecute java -jar express.jar con -h para ver ayuda.\n");
            }else{
                if(Arrays.asList(args).contains("-h")){
                    System.out.println("\nSINTAXIS:\n");
                    System.out.println("\njava -jar multiplica.jar [-t] [-h] fichero_entrada [fichero_salida] \n");
                    System.out.println("\n-t                Activa la trazabilidad\n");
                    System.out.println("\n-h                Muestra la ayuda \n");
                    System.out.println("\nfichero_salida    Nombre del fichero de salida  \n");
                }else{
                    if(Arrays.asList(args).contains("-t")){
                         trazabilidad = true;
                    }
                    for(int i=0;i<args.length;i++){
                        if(!((args[i].length()==2) && ((args[i].contains("-h") | (args[i].contains("-t")))))){
                            if((NombreDeArchivoValido(args[i]) && (!(entrada)))){
                                entrada = true;
                                nombrearchivoentrada = args[i];
                            }else{
                                if((entrada) && (!(salida))){
                                    nombrearchivosalida = args[i];
                                    if((nombrearchivoentrada.equals(nombrearchivosalida))){
                                        System.out.println("\nAVISO: Nombres de archivo entrada y salida son iguales, por favor redireccione la salida a otro archivo.No se genera archivo salida.\n");
                                    }else{
                                        salida = true;
                                    }
                                }
                            }
                        }
                    }
                    if((entrada) && (!(salida))){
                        if(trazabilidad){
                              System.out.println("\nTrazabilidad  en terminal.");
                              System.out.println("\nArchivo de entrada: "+nombrearchivoentrada);
                        }  
                        System.out.println("\nArchivo de entrada: "+nombrearchivoentrada);
                        Principal express = new Principal(nombrearchivoentrada, trazabilidad);
                    }else{
                        if((entrada) && (salida)){
                           if(trazabilidad){
                                System.out.println("\nArchivo de entrada: "+nombrearchivoentrada);
                                System.out.println("\nResultado y Trazabilidad  redirigida a archivo: "+nombrearchivosalida+"\n");
                                System.setOut(new Logger(System.out, nombrearchivosalida,false));
                                Principal express = new Principal(nombrearchivoentrada, trazabilidad);    
                            }else{
                                System.out.println("\nArchivo de entrada: "+nombrearchivoentrada);  
                                System.out.println("\nResultado  redirigido a archivo: "+nombrearchivosalida+"\n");
                                System.setOut(new Logger(System.out, nombrearchivosalida,false));
                                Principal express = new Principal(nombrearchivoentrada, trazabilidad); 
                            }                          
                        }else{
                        System.out.println("\nError 2: Archivos de entrada o salida no ok.");
                        System.out.println("Ejecute java -jar express.jar con -h para ver ayuda.\n");
                        }
                    }
                }
            }
        }
    }
}
