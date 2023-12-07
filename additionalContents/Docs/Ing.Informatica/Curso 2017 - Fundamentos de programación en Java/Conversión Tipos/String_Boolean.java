/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/9/25
 */


import java.util.Scanner;
 
public class String_Boolean {
	
	Scanner scan;
	String num;
	
	void getVal() {
		
		scan = new Scanner(System.in);
		System.out.println("String to Boolean");
		
		System.out.println("\nEnter the String :");
		num = scan.nextLine();
	}
	
	void convert() {
		
		boolean val = Boolean.parseBoolean(num);
		
		if(val == true)
			System.out.println("The Positive Boolean Value is : " + val);
		else
			System.out.println("The Negative Boolean Value is : " + val);
	}
}
 
class MainClass {
	
	public static void main(String args[]) {
		
		String_Boolean obj = new String_Boolean();
		
		obj.getVal();
		obj.convert();
	}
}