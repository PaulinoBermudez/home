// Fig. 10.7: EmpleadoPorComision.java
// La clase EmpleadoPorComision extiende a Empleado.

public class EmpleadoPorComision extends Empleado 
{
   private double ventasBrutas; // ventas totales por semana
   private double tarifaComision; // porcentaje de comisión

   // constructor con cinco argumentos
   public EmpleadoPorComision( String nombre, String apellido, String nss, 
      double ventas, double tarifa )
   {
      super( nombre, apellido, nss );
      establecerVentasBrutas( ventas );
      establecerTarifaComision( tarifa );
   } // fin del constructor de EmpleadoPorComision con cinco argumentos

   // establece la tarifa de comisión
   public void establecerTarifaComision( double tarifa )
   {
      if ( tarifa > 0.0 && tarifa < 1.0 )
         tarifaComision = tarifa;
      else
         throw new IllegalArgumentException(
            "La tarifa de comision debe ser > 0.0 y < 1.0" );
   } // fin del método establecerTarifaComision

   // devuelve la tarifa de comisión
   public double obtenerTarifaComision()
   {
      return tarifaComision;
   } // fin del método obtenerTarifaComision

   // establece el monto de ventas brutas
   public void establecerVentasBrutas( double ventas )
   {
      if (ventas >= 0.0 )
         ventasBrutas = ventas;
      else
         throw new IllegalArgumentException(
            "Las ventas brutas deben ser >= 0.0" );
   } // fin del método establecerVentasBrutas

   // devuelve el monto de ventas brutas
   public double obtenerVentasBrutas()
   {
      return ventasBrutas;
   } // fin del método obtenerVentasBrutas

   // calcula los ingresos; sobrescribe el método abstracto ingresos en Empleado
   @Override
   public double ingresos()
   {
      return obtenerTarifaComision() * obtenerVentasBrutas();
   } // fin del método ingresos

   // devuelve representación String de un objeto EmpleadoPorComision
   @Override
   public String toString()
   {
      return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f", 
         "empleado por comision", super.toString(), 
         "ventas brutas", obtenerVentasBrutas(), 
         "tarifa de comision", obtenerTarifaComision() );
   } // fin del método toString
} // fin de la clase EmpleadoPorComision


/**************************************************************************
 * (C) Copyright 1992-2012 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigación y prueba de las teorías y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garantía de      *
 * ningún tipo, expresa o implícita, en relación con estos programas o    *
 * con la documentación contenida en estos libros. Los autores y el       *
 * editor no serán responsables en ningún caso por los daños consecuentes *
 * en conexión con, o que surjan de, el suministro, desempeño o uso de    *
 * estos programas.                                                       *
 *************************************************************************/

