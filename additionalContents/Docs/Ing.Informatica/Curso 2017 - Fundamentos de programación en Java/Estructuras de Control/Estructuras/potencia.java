import java.io.*;

class potencia {
	
	static int pot(int base, int potencia){
		if (potencia==0)// caso base
		return 1; 	
		else
		return base*pot (base, potencia-1);//caso recursivo 
				
	}
	
	public static void main(String[] args) throws IOException{
		
        BufferedReader a=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("introducir BASE  :  ");
		String numero1 =a.readLine ();
		int base=Integer.parseInt (numero1);
		
		BufferedReader b=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("introducir EXPONENTE  :  ");
		String numero2 =b.readLine ();
		int potencia=Integer.parseInt (numero2);
		
		int z;
		z= pot(base, potencia);
		System.out.println();
		System.out.print("Resultado: "+z);
		System.out.println();
		System.out.println();

}
}