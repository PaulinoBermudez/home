/**
 * Escriba un m�todo que permita realizar el cifrado C�sar de un texto.
 * Para realizar el cifrado C�sar se necesita el texto a cifrar y un
 * n�mero que indica el desplazamiento que se emplea de los caracteres
 * para cifrar. Si el n�mero es 2 la letra 'a' se sustituye por la letra
 * 'c', la 'b'por la 'd', etc. Utilice para elcijrado el alfabeto espa�ol
 * que incluya la �. Para simplificar el ejercicio suponga que los textos
 * son en min�sculas. Los caracteres que no pertenezcan al alfabeto en
 * min�sculas permanecer�n como en el original.
 */


import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 

public class CifradoCesar { 

    static String charMin = "abcdefghijklmnopqrstuvwxyz"; 
    static String charMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 

    public static void main(String[] args){ 

        try {

        String texto = ""; 
        int n = 0; 
        System.out.println("Texto a cifrar"); 
        texto = bf.readLine(); 
        System.out.println("Desplazamiento para el cifrado.(numero entero)"); 

        n = Integer.parseInt(bf.readLine()); 
        System.out.println(n); 
        System.out.println("Texto: "+texto); 
        System.out.println("Texto cifrado: "+cifCesar(texto,n)); 

        } catch (Exception e) { 

            System.out.print("Valor no valido."); 
        }
    } 
   
    private static String cifCesar(String entrada,int desp){ 

        String salida = ""; 
        for(int i = 0;i<entrada.length();i++){ 
            if((charMin.indexOf(entrada.charAt(i)) != -1) || (charMay.indexOf(entrada.charAt(i)) != -1)) 
                salida += (charMin.indexOf(entrada.charAt(i)) != -1) ? charMin.charAt( ( (charMin.indexOf(entrada.charAt(i)) )+desp)%charMin.length() ) : charMay.charAt(( charMay.indexOf(entrada.charAt(i)) +desp)%charMay.length()); 
            else 
                salida += entrada.charAt(i); 
        } 
        return salida; 
    } 
} 