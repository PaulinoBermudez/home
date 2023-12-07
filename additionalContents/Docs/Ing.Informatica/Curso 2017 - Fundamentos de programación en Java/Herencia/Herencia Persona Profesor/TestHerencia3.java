/**
 * @(#)TestHerencia3.java
 *
 *
 * @author 
 * @version 1.00 2015/12/30
 */

import java.util.Calendar;

public class TestHerencia3 {

    public static void main (String [ ] Args) {

        Profesor profesor1 = new Profesor ("Juan", "Hernández García", 33);

        Calendar fecha1 = Calendar.getInstance();

        fecha1.set(2019,10,22); //Los meses van de 0 a 11, luego 10 representa noviembre

        ProfesorInterino interino1 = new ProfesorInterino("José Luis", "Morales Pérez", 54, fecha1);

        Profesor profesor73 = interino1; //Ahora el supertipo contiene un subtipo, en principio con pérdida de información

        if (profesor73 instanceof ProfesorInterino) {

            System.out.println ("***profesor73 es un objeto de tipo ProfesorInterino" );
        }

        if (profesor73 instanceof Profesor) {
        	System.out.println ("profesor73 es un objeto de tipo Profesor ¡ES POLIMÓRFICO!" );
        }

        if (interino1 instanceof Profesor) {
        	System.out.println ("interino1 es un objeto de tipo Profesor ¡ES POLIMÓRFICO TAMBIÉN!" );

        } else {
        	 System.out.println ("interino1 no apunta a un objeto de tipo Profesor" );
        }

        if (profesor1 instanceof ProfesorInterino) {

            System.out.println ("profesor1 es un objeto de tipo ProfesorInterino" );

        } else {
        	System.out.println ("profesor1 no es un objeto de tipo ProfesorInterino. Nunca ha sido un interino." );
        }
    }
}