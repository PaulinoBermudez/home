/**
 * @(#)Curso.java
 *
 *
 * @author Antonio Rivero
 * @version 1.00 2016/1/7
 */


public class Curso {

   public static void main(String args[]){
      char departamento = 'B';

      switch(departamento)
      {
         case 'A' :
            System.out.println("Desarrollo");
            break;
         case 'B' :
    		System.out.println("Recursos Humanos");
            break;
         case 'C' :
            System.out.println("Finanzas");
            break;
         case 'D' :
            System.out.println("Mercadeo");
         default :
            System.out.println("Departamento invalido");
      }
      System.out.println("Código para el departamento es " + departamento);
   }
}