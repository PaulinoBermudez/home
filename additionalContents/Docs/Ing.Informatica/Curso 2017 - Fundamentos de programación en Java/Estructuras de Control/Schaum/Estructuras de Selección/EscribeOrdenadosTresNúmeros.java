/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2014/7/1
 */


public class EscribeOrdenadosTresNúmeros{
	static void EscribeOrdenadosTresNúmeros(double a, double b, double c){
		double temp;
		if (a > b) {
		temp = a;
		a = b;
		b = temp;
		}
		if(a>c){
		temp = a;
		a = c;
		c = temp;
		}
		if(b>c){
		temp = b;
		b = c;
		c = temp;
		}
		System.out.printf("%f %f %f\n", a, b, c);

	}
    public static void main(String args[]){
    	EscribeOrdenadosTresNúmeros (55.9, 6.8, 9.7);
	}
}