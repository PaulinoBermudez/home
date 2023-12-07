/**
 * @(#)CocheApp.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/20
 */

 public class CocheApp {
 	
    public static void main(String[] args) {
    	Datos dato = new Datos();
        dato.leerCoches();
        System.out.println("\nCoches introducidos:");
        dato.mostrarCoches();
        dato.mostrarPorMarca();
        dato.mostrarPorKm();
        System.out.println("\nCoche con mayor numero de Km: " + dato.mostrarMayorKm());
        System.out.println("\nCoches ordenados de menor a mayor numero de Km");
        dato.mostrarOrdenadosPorKm();
    } //fin metodo main
} //fin de la clase principal
