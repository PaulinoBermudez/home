public class Tabla{
	public static void main (String arg []){
		int [][] tabla = new int [4][7];
		
		for (int i=0; i< tabla.length; i++){
			for (int j=0; j< tabla[i].length; j++){
				tabla [i][j]= i;
			}
		}
		
		for (int [] fila : tabla){
			for (int v:fila){
				System.out.print(" " +v);
			}
			System.out.println();
		}		
	}
}
