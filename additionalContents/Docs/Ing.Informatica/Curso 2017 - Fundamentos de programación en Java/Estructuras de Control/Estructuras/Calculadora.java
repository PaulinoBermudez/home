import java.io.*;
public class Calculadora {
	public static void main (String args[])throws IOException{
		int numero = 1;
		char menu1, menu2;
		double op1, op2;
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br= new BufferedReader(isr);
		String valor;
		do{
			System.out.println("Indicar numero de operadores: ");
			System.out.println("0 (salir)");
			System.out.println("1 operador");
			System.out.println("2 operadores");
			valor = br.readLine();
			menu1=valor.charAt(0);
			System.out.println("menu1="+menu1);
			switch (menu1){
				case '1':
				System.out.println("introducir operando");
				valor =br.readLine();
				op1=Double.parseDouble(valor);
				
				System.out.println("Operacion deseada: ");
				System.out.println("1. logaritmo");
				System.out.println("2. exponente");
				System.out.println("3. seno");
				System.out.println("4. coseno");
				valor=br.readLine();
				
			menu2=valor.charAt(0);
			switch(menu2){
				case '1':
				System.out.println("log("+op1+")="+Math.log(op1));
				break;
				case '2':
				System.out.println("exp("+op1+")="+Math.exp(op1));
				break;
				case '3':
				System.out.println("sen("+op1+")="+Math.sin(op1));
				break;
				case '4':
				System.out.println("raiz("+op1+")="+Math.sqrt(op1));
				}
				break;
				case '2':
				System.out.println("introducir operando1");
				valor=br.readLine();
				op1=Double.parseDouble(valor);
				System.out.println("introducir operando2");
				valor=br.readLine();
				op2=Double.parseDouble(valor);
				
				System.out.println("Operacion deseada: ");
				System.out.println("1. suma");
				System.out.println("2. resta");
				System.out.println("3. producto");
				System.out.println("4. division");
				valor=br.readLine();
				menu2=valor.charAt(0);
				switch (menu2){
					case '1':
					System.out.println(op1+"+"+op2+"="+(op1+op2));
					break;
					case '2':
					System.out.println(op1+"-"+op2+"="+(op1-op2));
					break;
					case '3':
					System.out.println(op1+"*"+op2+"="+(op1*op2));
					break;
					case '4':
					System.out.println(op1+"/"+op2+"="+(op1/op2));
					
					}
					}
		}while(menu1>'0' && menu1 <= '2');
	}
}