/**
 * @(#)arrayLSimple.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/4/8
 */


import java.util.ArrayList;
import javax.swing.JOptionPane;
 
public class arrayLSimple {
 
    ArrayList miAL = new ArrayList(); //Array List simple
 
    public static void main(String args[]){
 
        arrayLSimple obA = new arrayLSimple();        
        obA.menu();        
    }
 
    public void menu(){
        String op;
       do{
           op = JOptionPane.showInputDialog(null,"1.  Introducir dato\n"
                                              	+"2.  Modificar dato\n"
                                              	+"3.  Eliminar dato\n"
                                              	+"4.  Buscar dato\n"
                                              	+"5.  Mostrar datos\n"
                                              	+"6.  Salir");
 
           switch(op){
 
               case "1"://Bloque para introducir datos al array list                   
                        String a;                        
                        a = JOptionPane.showInputDialog(null, "Digite dato a ingresar: ");
                        miAL.add(a);                                    
                   break;
                   
               case "2"://Bloque para Modificar dato del array                  
                        String b, c;
                        int indice;
                        b = JOptionPane.showInputDialog(null, "Ingrese el dato a Modificar: ");
                        if(miAL.contains(b)){
                            indice = miAL.indexOf(b);
                            c = JOptionPane.showInputDialog(null, "Ingrese el nuevo dato: ");
                            miAL.set(indice, c);
                        }else{
                            JOptionPane.showMessageDialog(null, "No existe el dato a modificar !", "", JOptionPane.ERROR_MESSAGE);
                        }
                   break;
                   
               case "3"://Bloque para eliminar dato del array                  
                        String d;
                        b = JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar: ");
                        for(int i=0; i<miAL.size(); i++){
                            if(miAL.get(i).equals(b)){
                                miAL.remove(i);
                            }
                        }                   
                   break;
                   
               case "4"://Bloque para buscar datos en el array list                  
                        String mostrarBus= "No se ha encontrado nada!", f;                        
                        c = JOptionPane.showInputDialog(null, "Ingrese el dato a buscar: ");
                        for( int i = 0 ; i  < miAL.size(); i++){
                            if(miAL.get(i).equals(c)){
                                mostrarBus  ="";
                                mostrarBus += "Dato en  posicion "+i+" : "+miAL.get(i);                                
                            }                        
                       }
                         JOptionPane.showMessageDialog(null, mostrarBus);
                   break;
                   
               case "5"://Bloque para mostar los datos del array list
 
                       String Salida= "";
                       for( int i = 0 ; i  < miAL.size(); i++){
                        Salida += "Numero posicion "+i+" : "+miAL.get(i)+"\n"; 
                       }
                        JOptionPane.showMessageDialog(null, Salida);                                   
                   break;
                   	                  
               case "6":
                   System.exit(0);
                   break;
                   
               default:
                   JOptionPane.showMessageDialog(null, "Opcion invalida !");
                   break;
           }      
       }while(!op.equals("6"));
    }    
}