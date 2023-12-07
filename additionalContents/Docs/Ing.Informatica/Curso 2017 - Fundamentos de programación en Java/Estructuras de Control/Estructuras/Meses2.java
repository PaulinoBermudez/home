/**
 * @(#)Text3.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/7
 */


public class Meses2 {
    public static void main(String[] args) {

        int mes = 10;
        int año = 2002;
        int numDias = 0;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDias = 30;
                break;
            case 2:
                if ( ((año % 4 == 0) && !(año % 100 == 0))|| (año % 400 == 0) )
                    numDias = 29;
                else
                    numDias = 28;
                break;
        }
        System.out.println("Numero de Dias = " + numDias);
    }
}