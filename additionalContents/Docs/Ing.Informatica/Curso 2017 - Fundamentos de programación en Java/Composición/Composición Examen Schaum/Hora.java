/**
 * @(#)Hora.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/5/30
 */

public class Hora{

	private int hora;
	private int minuto;
	
	public Hora(int hora, int minuto) {
		if (hora < 0 || hora > 23 || minuto < 0 || minuto> 59){
			throw new IllegalArgumentException();
		}else{
			this.hora = hora;
			this.minuto = minuto;
		}
	}
	
	public int getHora(){
		return hora;
	}
	
	public int getMinuto(){
		return minuto;
	}
	
	public String toString(){
		return hora + ":" + (minuto < 10 ? "0" :"") + minuto;
	}
}