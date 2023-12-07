/**
 * @(#)EntradaPalabras.java
 *
 *
 * @author 
 * @version 1.00 2016/2/25
 */


import java.util.Scanner;

public class EntradaPalabras {

    private String palabra;

    //constructor
    public EntradaPalabras() {

        palabra="";
        pedirPalabra();
        quitarEspacio();
    }

    //metodo para pedir una entrada de teclado
    public void pedirPalabra() {

        Scanner entradaEscaner = new Scanner(System.in);
        palabra = entradaEscaner.nextLine();
    }

    //este metodo analiza los primeros caracteres para elimnar los espacios antes de la palabra
    public void quitarEspacio() {

        for (int i=0; i<getLongitud(); i++) {

            if (palabra.substring(0,1).equals(" ")) {
                palabra=palabra.substring(1,getLongitud());
            }else {
                palabra=palabra;
            }
        }
    }

    public String getPalabra() {

        return palabra;
    }

    public int getLongitud() {

        return palabra.length();
    }
}