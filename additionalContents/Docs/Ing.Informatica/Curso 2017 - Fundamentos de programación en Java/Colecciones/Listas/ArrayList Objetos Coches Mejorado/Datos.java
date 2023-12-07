/**
 * @(#)Datos.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2016/2/20
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Datos {
	
	static ArrayList<Coche> coches = new ArrayList<Coche>();
	static Scanner sc = new Scanner(System.in);
	
	//Metodo para leer coches e introducirlos en el array
	public static void agregarCoches(){
        //Declaracion de variables para leer los datos de los coches
        String matricula;
        String marca;
        String modelo;
        int Km;
        //Variable auxiliar que contendra la referencia a cada coche nuevo.
        Coche coche;
        int i;
		int N;
        //se pide por teclado el numero de coches a leer
        do {
      //      System.out.print("Numero de coches: ");
            N = sc.nextInt();
        } while (N < 0);
        sc.nextLine(); //limpiar el intro
        
        //lectura de N coches
        for (i = 1; i <= N; i++) {
            //leer datos de cada coche
            System.out.println("Coche " + i);
            System.out.print("Matricula: ");
            matricula = sc.nextLine();          
            System.out.print("Marca: ");
            marca = sc.nextLine();
            System.out.print("Modelo: ");
            modelo = sc.nextLine();
            System.out.print("Numero de Kilometros: ");
            Km = sc.nextInt();
            sc.nextLine(); //limpiar el intro. NECESITA PONERLO DESPUES DE UN INT
            coche = new Coche(); //Se crea un objeto Coche y se asigna su referencia a aux
            //se asignan valores a los atributos del nuevo objeto
            coche.setMatricula(matricula);
            coche.setMarca(marca);
            coche.setModelo(modelo);
            coche.setKm(Km);
                      
           //se agrega el objeto al final del array
            coches.add(coche);
        }
    } //fin metodo leerCoches()
    
    //Metodo para mostrar todos los coches   
    public static void mostrarCoches(){
        for(int i = 0; i< coches.size(); i++)
            System.out.println(coches.get(i));  //se invoca el metodo toString de la clase Coche
    }
   
    //Metodo para mostrar todos los coches de una marca que se pide por teclado
    public static void mostrarPorMarca(){
        String marca;
   //     System.out.print("Mostrar por Marca: ");
        marca = sc.nextLine();
        System.out.println("Coches de la marca " + marca);
        
        for(int i = 0; i<coches.size(); i++){
        	
            if(coches.get(i).getMarca().equalsIgnoreCase(marca))
                System.out.println(coches.get(i));
        }
    }
  
    //Metodo para mostrar todos los coches con un numero de Km inferior
    //al numero de Km que se pide por teclado
    public static void mostrarPorKm(){
        int Km;
        System.out.print("Introduce numero de kilometros: ");
        Km = sc.nextInt();
        System.out.println("Coches con menos de " + Km + " Km");
        
        for(int i = 0; i<coches.size(); i++){
        	
            if(coches.get(i).getKm() < Km)
                System.out.println(coches.get(i));
        }
    }
   
   //Metodo que devuelve el Coche con mayor numero de Km
    public static Coche mostrarMayorKm(){
        Coche mayor = coches.get(0);
        
        for(int i = 0; i < coches.size(); i++){
            if(coches.get(i).getKm() > mayor.getKm())
                mayor = coches.get(i);
        }
        return mayor;
    }
   
  
    //Metodo que muestra los coches ordenados por numero de Km de menor a mayor
    public static void mostrarOrdenadosPorKm(){
        int i, j;
        Coche aux;
        for(i = 0; i< coches.size()-1; i++)
            for(j=0;j<coches.size()-i-1; j++)
                if(coches.get(j+1).getKm() < coches.get(j).getKm()){
                    aux = coches.get(j+1);
                    coches.set(j+1, coches.get(j));
                    coches.set(j, aux);                
                }
        mostrarCoches();
    }
}
