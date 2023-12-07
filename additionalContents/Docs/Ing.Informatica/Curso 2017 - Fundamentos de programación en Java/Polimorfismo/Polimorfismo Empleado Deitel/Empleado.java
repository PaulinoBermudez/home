// Fig. 10.4: Empleado.java
// La superclase abstracta Empleado.

public abstract class Empleado 
{
   private String primerNombre;
   private String apellidoPaterno;
   private String numeroSeguroSocial;

   // constructor con tres argumentos
   public Empleado( String nombre, String apellido, String nss )
   {
      primerNombre = nombre;
      apellidoPaterno = apellido;
      numeroSeguroSocial = nss;
   } // fin del constructor de Empleado con tres argumentos

   // establece el primer nombre
   public void establecerPrimerNombre( String nombre )
   {
      primerNombre = nombre;  // deber�a validar
   } // fin del m�todo establecerPrimerNombre

   // devuelve el primer nombre
   public String obtenerPrimerNombre()
   {
      return primerNombre;
   } // fin del m�todo obtenerPrimerNombre

   // establece el apellido paterno
   public void establecerApellidoPaterno( String apellido )
   {
      apellidoPaterno = apellido;  // deber�a validar
   } // fin del m�todo establecerApellidoPaterno

   // devuelve el apellido paterno
   public String obtenerApellidoPaterno()
   {
      return apellidoPaterno;
   } // fin del m�todo obtenerApellidoPaterno

   // establece el n�mero de seguro social
   public void establecerNumeroSeguroSocial( String nss )
   {
      numeroSeguroSocial = nss; // deber�a validar
   } // fin del m�todo establecerNumeroSeguroSocial

   // devuelve el n�mero de seguro social
   public String obtenerNumeroSeguroSocial()
   {
      return numeroSeguroSocial;
   } // fin del m�todo obtenerNumeroSeguroSocial

   // devuelve representaci�n String de un objeto Empleado
   @Override
   public String toString()
   {
      return String.format( "%s %s\nnumero de seguro social: %s", 
         obtenerPrimerNombre(), obtenerApellidoPaterno(), obtenerNumeroSeguroSocial() );
   } // fin del m�todo toString

   // m�todo abstracto sobrescrito por las subclases concretas
   public abstract double ingresos(); // aqu� no hay implementaci�n
} // fin de la clase abstracta Empleado