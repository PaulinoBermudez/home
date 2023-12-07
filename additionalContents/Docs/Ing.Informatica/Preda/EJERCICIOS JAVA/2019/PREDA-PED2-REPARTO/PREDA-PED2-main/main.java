import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


/** 
 * Clase principal del proyecto
 */
public class main {
   public static boolean imprimirTraza = false;         // Boolean que indica si se debe imprimir la traza
   public static boolean imprimirAyuda = false;         // Boolean que indica si se debe imprimir la ayuda
   public static boolean mostrarPorPantalla=true;       // Boolean que indica si el problema se debe mostrar por pantalla
   public static boolean ficheroEntradaOk=false;        // Boolean que indica si el fichero de entrada está ok   
   public static String nombreFicheroSalida;            // String que indica el nombre del fichero de salida

   
   /**
    * Método principal
    * @param args los argumentos que se pasan por el terminal
    */
   public static void main(String[] args) throws IOException {  
       File ficheroEntrada, ficheroOk = null;
       String argumento; 
       // Bucle para comprobar los argumentos y hacer con cada de uno de ellos lo que le corresponda
       for (int i = 0; i<args.length; i++){
           argumento = args[i];
           ficheroEntrada  = new File(args[i]); 
                  
           if (argumento.equals("-t") ) { 
               imprimirTraza = true;
           } else if (argumento.equals("-h") ) {
               imprimirAyuda = true;
           } else if (ficheroEntrada.exists() && !ficheroEntradaOk) {
               ficheroEntradaOk = true;
               ficheroOk = new File(args[i]);
           } else if  (!ficheroEntradaOk) { 
               String resFicheroStandard = ""; 
               Scanner sc = new Scanner(System.in);
               System.out.println("Introduce el número de activos:");
               int nActivos = sc.nextInt();
               sc.nextLine();
               System.out.println("Introduce el valor de cada activo:");
               String valor = sc.nextLine();
               resFicheroStandard += nActivos + "\n" + valor;
               File archivoStandard = new File(args[i]);
               BufferedWriter bw;
               bw = new BufferedWriter(new FileWriter(archivoStandard));
               bw.write(resFicheroStandard);
               bw.close();
               ficheroOk = archivoStandard;
           } else {
               mostrarPorPantalla = false;
               nombreFicheroSalida = args[i];
               File ficheroSalidaAux = new File(nombreFicheroSalida);
               if(ficheroSalidaAux.exists()){
                   System.out.println("ERROR: Esta salida ya existe, introduce otra salida.");
                   System.exit(0);
               }
           }
       }
       
       // If-else que en función de los atributos boolean hace la mayor parte de lo que aparece por pantalla en el programa
       if(imprimirAyuda) {
           System.out.println("SINTAXIS:");
           System.out.println("reparto [-t][-h] [fichero_entrada] [fichero_salida]");
           System.out.println("-t              Traza las llamadas recursivas");
           System.out.println("-h              Muestra esta ayuda");
           System.out.println("fichero_entrada Nombre del fichero de entrada");
           System.out.println("fichero_salida  Nombre del fichero de salida");
       } else {
           operacionesFichero operaciones = new operacionesFichero();
           if (!operaciones.comprobarFicheroEntrada(ficheroOk)) { 
               if(operaciones.error == 1){System.out.println("ERROR: En la primera fila no has introducido un número.");
               } else if(operaciones.error == 2){System.out.println("ERROR: En la segunda fila no has introducido un vector de números.");
               } else if(operaciones.error == 3){System.out.println("ERROR: El número de la primera fila no coincide con la talla del vector de la segunda fila.");
               } else { System.out.println("ERROR DESCONOCIDO.");}
           } else {
               if(!mostrarPorPantalla){ 
                   System.out.println("Nº de activos: : " + operaciones.nActivos);
                   System.out.println("Valor de los activos: " + Arrays.toString(operaciones.valor));
                   System.out.println("Fichero salida: " + nombreFicheroSalida + " generado y guardado.");
                   PrintStream fileStream = new PrintStream(nombreFicheroSalida);
                   System.setOut(fileStream);
                   reparto reparto = new reparto();
                   reparto.resolverSeparacionSocios(operaciones.valor);
                   System.out.println(reparto.res);
               } else {
                   System.out.println("Nº de activos: " +  operaciones.nActivos);
                   System.out.println("Valor de los activos: " + Arrays.toString(operaciones.valor));
                   System.out.println("\nRESULTADO: ");
                   reparto reparto = new reparto();
                   reparto.resolverSeparacionSocios(operaciones.valor);
                   System.out.println(reparto.res);
                   if(imprimirTraza){ 
                       System.out.println("\nTRAZA: ");
                       System.out.println(reparto.traza);
                   }
               }
           }     
       }
       System.exit(0);
   }   
}
