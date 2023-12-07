/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.UNED.torneotenis;

import java.util.InputMismatchException;

/**
 *
 * @author pauli
 */
public class OperacionesTorneo {
    public void OperacionesFichero(){
    
    }
    public static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public void EscribirTorneo(){
        try{
            Torneo juego = new Torneo();
        } catch(NegativeArraySizeException negativo){
            System.out.println("El programa no funcina con números negativos.\n Ejecute la ayuda con el argumento '-h'o vuelva a ejecutarlo con otros datos, gracias.");
        } catch(InputMismatchException letra){
            System.out.println("El programa no funcina con caracteres.\n Ejecute la ayuda del programa con el argumento '-h' o vuelva a ejecutarlo con otros datos, gracias.");
        } // Try-catch 
    }
}
