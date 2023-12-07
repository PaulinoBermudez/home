import java.io.*;

class TablaMultiplicar{
	public static void main  (String [] argumentos  )throws  IOException {
		BufferedReader a=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("Tabla de Multiplicar por  :  ");
		String numero1 =a.readLine ();
		int num1=Integer.parseInt (numero1);
		
		System.out.println();
		
		System.out.print("Orden de multiplicacion hasta:  ");
		BufferedReader b=new BufferedReader (new InputStreamReader (System.in));
		String numero2 =b.readLine ();
		int num2=Integer.parseInt (numero2);
		
		System.out.println();
		System.out.print("***********************************");
		System.out.println();
		System.out.println();
		
		
		for (int x=0;x<=num2;x++){
			System.out.print("   " +num1);
			System.out.print(" * ");
			System.out.print(+x);
			int total=num1*x;
			System.out.print(" = ");
			System.out.println(total);
		}
		
		System.out.println();
		System.out.print("***********************************");			
		System.out.println();
		}
}