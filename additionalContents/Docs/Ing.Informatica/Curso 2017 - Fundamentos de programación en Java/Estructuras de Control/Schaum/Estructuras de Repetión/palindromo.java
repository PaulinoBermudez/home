import java.util.Scanner;

class palindromo{
	public boolean palindromo (String frase){

	for (int i=0; i<frase.length()/2; i++){
		if(Character.toUpperCase(frase.charAt(i)) != Character.toUpperCase(frase.charAt(frase.length()-1-i)))
		return false;
	}
	return true;
	}
	
	public static void main(String args[]){

	}
}