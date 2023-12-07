/**
 * @(#)Switch1.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/7
 */

import java.util.Scanner;

public class Switch1 {

    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner(System.in);
        int opcion;
        System.out.println("Menus de opciones");
        System.out.println("------------------------");
        System.out.println("1.Calcular el área de un cuadrado");
        System.out.println("2. Calcular el area de un Triangulo");
        System.out.println("3. Calcular el area de un Circulo");
        System.out.println("4. finalizar");

        System.out.print("Elija la opcion:");
        opcion = entrada.nextInt();

        switch (opcion) {
        	
            case 1:
                System.out.println("Ha seleccionado calcular el area de un cuadrado...");
                int base;
                int altura;
                double areaCuadrado;
                System.out.println("Cual es la base del cuadrado");
                base = entrada.nextInt();
                System.out.println("Cual es la altura del cuadrado");
                altura = entrada.nextInt();

                areaCuadrado = base * altura;
                System.out.printf("El area del cuadrado es %f\n", areaCuadrado);
                break;
            
            case 2:
                System.out.println("Ha seleccionado calcular el area de un triangulo...");
                int lado1;
                int lado2;
                int lado3;
                double areaTriangulo;

                System.out.print("Dame el lado1");
                lado1 = entrada.nextInt();
                System.out.print("Dame el lado2");
                lado2 = entrada.nextInt();

                System.out.print("Dame el lado3");
                lado3 = entrada.nextInt();

                areaTriangulo = (lado1 * lado2) / 2;

                System.out.printf("El area del triangulo es %f\n", areaTriangulo);
                break;
           
            case 3:
                System.out.println("Ha seleccionado calcular el area de un circulo...");

                int radioCirculo;
                double areaCirculo;

                System.out.print("Cual es el radio del circulo?");
                radioCirculo = entrada.nextInt();

                areaCirculo = 3.1416 * (radioCirculo * radioCirculo);
                System.out.printf("El area del circulo es %f\n", areaCirculo);
                break;
            
            default:
                System.out.println("Ha seleccionado terminar");
        }
    }
}