// Fig. 7.24: ColeccionArrayList.java
// Demostración de la colección de genéricos ArrayList.

import java.util.ArrayList;

public class ColeccionArrayList{
	
   public static void main( String[] args ){
      // crea un nuevo objeto ArrayList de objetos String.
      ArrayList< String > elementos = new ArrayList< String >();

      elementos.add("rojo"); // adjunta un elemento a la lista          
      elementos.add(0, "amarillo"); // inserta el valor en el subíndice 0

      // encabezado
      System.out.print(
         "Mostrar contenido de lista con ciclo controlado por contador:" ); 

      // muestra los colores en la lista
      for ( int i = 0; i < elementos.size(); i++ )
         System.out.printf(" %s", elementos.get( i ));

      // muestra los colores usando foreach en el método mostrar
      mostrar( elementos,
         "\nMostrar contenido de lista con instruccion for mejorada:" );

      elementos.add( "verde" ); // agrega "verde" al final de la lista
      elementos.add( "amarillo" ); // agrega "amarillo" al final de la lista 
      mostrar( elementos, "Lista con dos nuevos elementos:" ); 

      elementos.remove( "amarillo" ); // elimina el primer "amarillo"
      mostrar( elementos, "Eliminar primera instancia de amarillo:" ); 

      elementos.remove( 1 ); // elimina elemento en subíndice 1
      mostrar( elementos, "Eliminar segundo elemento de la lista (verde):" ); 

      // verifica si hay un valor en la lista
      System.out.printf( "\"rojo\" %sexta en la lista\n",
         elementos.contains( "rojo" ) ? "": "no " );

      // muestra el número de elementos en la lista
      System.out.printf( "Tamanio: %s\n", elementos.size() );
   } // fin de main

   // muestra los elementos de ArrayList en la consola
   public static void mostrar( ArrayList< String > elementos, String encabezado ){
      System.out.print(encabezado); // mostrar encabezado

      // muestra cada elemento en elementos
      for ( String elemento : elementos )
         System.out.printf( " %s", elemento );

      System.out.println(); // muestra fin de línea
   } // fin del método mostrar
} // fin de la clase ColeccionArrayList
