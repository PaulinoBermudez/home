/*
 * Para conocer el número de días de un mes dado.
 * Un switch resulta ser la mejor opción para seleccionar
 * cómo calcular cuántos días le corresponden a cada mes.
 */
 
public class DiasDelMes{
	enum Mes {Enero, Febrero, Marzo, Abril, Mayo, Junio, Julio,
			  Agosto, Septiembre, Octubre, Noviembre, Diciembre}
			  
	public static void main (String[] args) {
		int dias;
		Mes mes = Mes.Enero;

		switch(mes){
			case Abril:
			case Junio:
			case Septiembre:
			case Noviembre:
				dias = 30;
				break;
				
			case Febrero:
				dias = 28;
				break;
				
			default:
				dias = 31;
				break;
		}
		
		System.out.println("El mes "+mes+" tiene " +dias+" dias.");
}
}