import java.io.*;
import java.util.*;


/**
 * Esta clase se usa para la lectura parcial de archivos de entrada 
 *
 *
 * 
 * @author José Luis González Muñiz
 * @version 1.00
 */
public class EntradaConfig
{
  //Variable archivo de entrada
  private File archivo;
  //Variable usadas para la lectura de el archivo de entrada y la correcta utilización de los datos
  private FileReader fr;
  private BufferedReader br;
  private String opeA = "";
  private String opeB = "";
  private boolean bOpeA = false;
  private boolean bOpeB = false;
  
  //Contructor
  /**
   * Este es el contructor de la clase encargada de leer la configuración de los archios de entrada
   */
  //public EntradaConfig(File archivo)
  public EntradaConfig(String nombrearchivoentrada)
  {
      //this.archivo = archivo;
      this.archivo = new java.io.File(nombrearchivoentrada);
      fr = null;
      br = null;
      leerConfig();
  }

  //Métodos de la clase
  
  /**
   *
   *
   */
  private void leerConfig()
  {
   try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         // Lectura del fichero por lineas y asignación a variable de datos leeidos
         String linea;
         int lineaNum = 1;
         while(((linea=br.readLine()) != null)){
           if(linea.trim().isEmpty())
           {
           }
           else
           {
               linea = linea.replaceAll("\\s{2,}", " ").trim();
               if(lineaNum == 1 && linea.trim().contains(" "))
               {
                   opeA = linea.split(" ")[0];
                   opeB = linea.split(" ")[1];
                   break;
               }else
               {
                   if(lineaNum == 1)
                   {
                       opeA = linea;
                   }else{
                       linea = linea.replaceAll("\\s","").trim();
                       opeB = linea;
                   }
               }
               lineaNum = lineaNum+1;
            }
         }
         if (opeA.matches("[0-9]+")){
             System.out.println("MULTIPLICANDO A = "+opeA);
             bOpeA = true;
         }else
         {
             System.out.println("Multiplicando A no es númerico");
         }
         if (opeB.matches("[0-9]+")){
             System.out.println("MULTIPLICANDO B = "+opeB);
             bOpeB = true;
         }else
         {
             System.out.println("Multiplicando B no es númerico");
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
  }

  public boolean comprobarDatos()
  {
      if(bOpeA && bOpeB){return true;}
      else{return false;}
  }
  public String getOperandoA(){return this.opeA;}
  public String getOperandoB(){return this.opeB;}
 
}
