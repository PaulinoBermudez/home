public class Fecha{
	
   private int mes;   // 1-12
   private int dia;   // 1-31 con base en el mes
   private int anio;  // cualquier anio

   // dias en cada mes 
   private static final int[] diasPorMes =  
      { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

   // constructor: llama a comprobarMes para confirmar el valor apropiado para el mes; 
   // llama a comprobarDia para confirmar el valor apropiado para el dia
   public Fecha( int elMes, int elDia, int elAnio){
   	
      mes = comprobarMes(elMes); // valida el mes
      anio = elAnio; // pudo validar el anio
      dia = comprobarDia( elDia ); // valida el dia

      System.out.printf("Constructor de objeto Fecha para la fecha %s\n", this );
   } // fin del constructor de Fecha

   // metodo utilitario para confirmar el valor apropiado del mes
   private int comprobarMes(int mesPrueba){
      if ( mesPrueba > 0 && mesPrueba <= 12 ) // valida el mes
         return mesPrueba;
      else // mes es invalido
         throw new IllegalArgumentException ( "el mes debe ser 1 a 12"); 
   } // fin del metodo comprobarMes

   // metodo utilitario para confirmar el valor apropiado del dia, con base en el mes y el anio
   private int comprobarDia(int diaPrueba){
      // comprueba si el dia esta dentro del rango para el mes
      if ( diaPrueba > 0 && diaPrueba <= diasPorMes[ mes ] )
         return diaPrueba;
   
      // comprueba si es anio bisiesto
      if ( mes == 2 && diaPrueba == 29 && ( anio % 400 == 0 || 
           ( anio % 4 == 0 && anio % 100 != 0 ) ) )
         return diaPrueba;
   
      throw new IllegalArgumentException(
         "dia fuera de rango para el mes y anio especificados" );
   } // fin del metodo comprobarDia
   
   // devuelve un objeto String de la forma mes/dia/anio
   public String toString(){ 
      return String.format("%d/%d/%d", mes, dia, anio); 
   } // fin del metodo toString
} // fin de la clase Fecha