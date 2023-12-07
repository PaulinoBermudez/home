/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/9/25
 */


import java.util.Scanner;
/*
 * Java example source code to convert String input to Boolean
 */
 
public class StringToBoolean {
 
	public static void main(String[] args) {
		System.out.print("Input:");
		Scanner scanner = new Scanner(System.in);
 
		// convert the string read from the scanner into Boolean data type
		Boolean input = Boolean.parseBoolean(scanner.nextLine());
		if (input) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
 
		scanner.close();
 
	}
 
}