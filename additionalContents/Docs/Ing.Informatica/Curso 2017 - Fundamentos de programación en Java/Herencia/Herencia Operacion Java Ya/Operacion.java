/**
 * Problema utilizando herencia.
 * Necesitamos implementar dos clases que llamaremos Suma y Resta.
 * Cada clase tiene como atributo valor1, valor2 y resultado.
 * Los metodos a definir son:
 * cargar1, (que inicializa el atributo valor1),
 * cargar2, (que inicializa el atributo valor2),
 * operar, que en el caso de la clase "Suma" suma los dos
 * atributos y en el caso de la clase "Resta" hace la
 * diferencia entre valor1 y valor2, y otro metodo mostrarResultado.
 */

import java.util.Scanner;

public class Operacion{
	
    protected Scanner teclado;
    protected int valor1;
    protected int valor2;
    protected int resultado;
    
    public Operacion(){
        teclado=new Scanner(System.in);
    }
    
    public void cargar1(){
        System.out.print("Ingrese el primer valor: ");
        valor1=teclado.nextInt();        
    }
    
    public void cargar2(){
        System.out.print("Ingrese el segundo valor: ");
        valor2=teclado.nextInt();
    }
    
    public void mostrarResultado(){
        System.out.println(resultado);
    }
}