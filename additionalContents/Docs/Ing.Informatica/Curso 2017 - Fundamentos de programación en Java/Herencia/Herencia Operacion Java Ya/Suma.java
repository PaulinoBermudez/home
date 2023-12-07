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


public class Suma extends Operacion{
	
	public void operar(){
		
        resultado = valor1 + valor2;
    }
}