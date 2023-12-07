import java.io.*;
class Binario{
	static int convertirBin(int num){
		
		if (num==1)
		System.out.print(num);
		//caso base
		else{
			//caso recursivo
			convertirBin(num/2);
			System.out.print(num%2);
			
		}
		return num;
	}
		public static void main(String[] args) throws IOException{
        BufferedReader a=new BufferedReader (new InputStreamReader (System.in));
		System.out.print("introducir primer  numero  :  ");
		String numero1 =a.readLine ();
		int num=Integer.parseInt (numero1);
		
		int z;
		System.out.println();
		System.out.print("Resultado: ");
		z= convertirBin(num);
		System.out.println();
		System.out.println();
}
}