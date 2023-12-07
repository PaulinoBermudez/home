/**
 * @(#)Test.java
 *
 *
 * @author Antonio Rivero 
 * @version 1.00 2015/12/30
 */

public class Test {

    public static void main (String[] args){

        Vehiculo v1 = new Vehiculo("asd",4);
        Taxi t1 = new Taxi("DC-2030", 4, "Manolo Romero", 2);
        v1 = t1;
        t1 = (Taxi)v1;
        System.out.println(t1);
    }
}