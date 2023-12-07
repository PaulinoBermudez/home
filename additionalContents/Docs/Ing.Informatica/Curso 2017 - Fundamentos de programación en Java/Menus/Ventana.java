import java.awt.*;

/**
 * @(#)Ventana.java
 * HACEMOS REFERENCIA A LA BIBLIOTECA 
 * QUE CONTIENE LAS CLASES GRÁFICAS
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/3/15
 */
 

//CREAMOS NUESTRA CLASE "Ventana" 
//Y LA HACEMOS QUE HEREDE LOS ATRIBUTOS
//Y METODOS DE LA CLASE "Frame"

public class Ventana extends Frame{

   //CREAMOS UN OBJETO DE DATOS "MenuBar" PARA CREAR NUESTRA BARRA 

   //QUE CONTENDRA LOS MENUS

   MenuBar barra = new MenuBar();//LA DECLARAMOS E INSTANCIAMOS.


   //CREAMOS LOS MENUS QUE ESTARAN DENTRO DE   
   //LA BARRA DE MENUS QUE ACABAMOS DE CREAR

   Menu programa = new Menu("Programa");

   Menu ayuda = new Menu("Ayuda");

   //PARA CREAR UN SUBMENU, BASTA CON INTRODUCIR EN UN MENU, OTRO MENU.
   //CREAMOS EL MENU QUE SERVIRA SE SUBMENU EN NUESTRO PROGRAMA

   Menu guardar = new Menu("Guardar");

   //CREAMOS EL CONSTRUCTOR DE NUESTRA CLASE

   public Ventana(){

      super("Ventana en JAVA"); //LE DAMOS UN NOMBRE A NUESTRA VENTANA

      this.setSize(500, 500); //ESTABLECEMOS EL TAMAÑO DE LA VENTANA


      //SELECCIONAMOS LA BARRA DE MENUS

      setMenuBar(barra);
 
      //A LA BARRA LE AGREGAMOS LOS MENUS.

      barra.add(programa);

      barra.add(ayuda);

      //AHORA A LOS MENUS LE AGREGAMOS LAS OPCIONES Y EL SUBMENU

      programa.add("Nuevo");

      programa.add("Abrir");

      //PARA AGREGAR UN SEPARADOR ENTRE VARIAS OPCIONES DEL MENU, 

      //HACEMOS LO SIGUIENTE

      programa.addSeparator();


      //SEGUIMOS AGREGANDO MAS OPCIONES Y EL SUBMENU

      programa.add(guardar);//AQUI ESTAMOS AGREGANDO EL SUBMENU


      //AHORA AL SUBMENU LE AGREGAMOS LAS OPCIONES

      guardar.add("Guardar");

      guardar.add("Guardar Como...");

      guardar.add("Guardar Todo");

 

      //AGREGAMOS OTRO SEPARADOR DE OPCIONES

      programa.addSeparator();


      //AGREGAMOS UNA ULTIMA OPCION A NUESTRO MENU programa

      programa.add("Salir");


      //AHORA VAMOS A AGREGARLE OPCIONES AL MENU DE AYUDA

      ayuda.add("Ayuda General");

      ayuda.addSeparator();//AGREGAMOS UN SEPARADOR

      ayuda.add("Acerca de...");

   }//FIN DEL CONSTRUCTOR DE LA CLASE Ventana

 
   //PROCEDIMIENTO PRINCIPAL DEL PROGRAMA

   public static void main(String g[]){

      Ventana prog = new Ventana();//Instanciamos la clase que creamos

      prog.show();//Mostramos esa ventana

   }//FIN DEL PROCEDIMIENTO PRINCIPAL


   //PARA PODER CERRAR LA VENTANA

   public boolean handleEvent(Event evt){

      if (evt.id == Event.WINDOW_DESTROY)

         System.exit(0);

         return super.handleEvent(evt);

   }
}//FIN DE LA CLASE Ventana