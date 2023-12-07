
/**
 * @(#)VehiculoApp.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/6/10
 */
public class VehiculoApp {

    public static void main(String args[]) {

        // Creo un objeto Turismo
        Turismo ibiza = new Turismo("1234ABC", "SEAT", "IBIZA", "VERDE", 1.0, true, 5, false);
        System.out.println(ibiza.imprimirInfo());
        System.out.println("");

        // Creo un objeto Deportivo
        Deportivo ferrari = new Deportivo("2322DFG", "Ferrari", "308F", "ROJO", 2.0, false, 5000);
        System.out.println(ferrari.imprimirInfo());
        System.out.println("");

        // Creo un objeto Furgoneta
        Furgoneta kangoo = new Furgoneta("4567UYH", "Renault", "kangoo", "AZUL", 3.0, false, 1500, 200);
        System.out.println(kangoo.imprimirInfo());
        System.out.println("");

    }
}
