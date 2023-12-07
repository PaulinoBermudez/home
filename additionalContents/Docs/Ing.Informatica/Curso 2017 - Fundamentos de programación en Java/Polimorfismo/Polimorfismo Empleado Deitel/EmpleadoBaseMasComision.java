// Fig. 10.8: EmpleadoBaseMasComision.java
// La clase EmpleadoBaseMasComision extiende a EmpleadoPorComision.

public class EmpleadoBaseMasComision extends EmpleadoPorComision 
{
   private double salarioBase; // salario base por semana

   // constructor con seis argumentos
   public EmpleadoBaseMasComision( String nombre, String apellido, 
      String nss, double ventas, double tarifa, double salario )
   {
      super( nombre, apellido, nss, ventas, tarifa );
      establecerSalarioBase( salario ); // valida y almacena el salario base
   } // fin del constructor de EmpleadoBaseMasComision con seis argumentos

   // establece el salario base
   public void establecerSalarioBase( double salario )
   {
      if (salario >= 0.0 )
         salarioBase = salario;
      else
         throw new IllegalArgumentException(
            "El salario base debe ser >= 0.0" );
   } // fin del método establecerSalarioBase

   // devuelve el salario base
   public double obtenerSalarioBase()
   {
      return salarioBase;
   } // fin del método obtenerSalarioBase

   // calcula los ingresos; sobrescribe el método ingresos en EmpleadoPorComision
   @Override
   public double ingresos()
   {
      return obtenerSalarioBase() + super.ingresos();
   } // fin del método ingresos

   // devuelve representación String de un objeto EmpleadoBaseMasComision
   @Override
   public String toString()
   {
      return String.format( "%s %s; %s: $%,.2f", 
         "con salario base", super.toString(), 
         "salario base", obtenerSalarioBase() );
   } // fin del método toString   
} // fin de la clase EmpleadoBaseMasComision


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

