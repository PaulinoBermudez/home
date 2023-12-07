/*
 * Escribir un método dibujaCuadrado que dibuje un cuadrado
 * de cuatro por cuatro mediante caracteres *.
 *
 */
 
class dibujaCuadrado{
	static void dibujaCuadrado(){
		for (int i = 0; i<4;i++){
			System.out.println("* * * *");
		}
	}
		
	public static void main(String []args){
		dibujaCuadrado();
	}	
}