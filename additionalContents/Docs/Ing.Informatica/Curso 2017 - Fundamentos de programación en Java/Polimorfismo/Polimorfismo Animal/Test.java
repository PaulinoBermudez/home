
/**
 * @(#)Test.java
 *
 * @author Antonio Rivero
 * @version 1.00 2017/6/9
 */
public class Test {

    public static void main(String[] arg) {

        /**
         * Creamos anim, un objeto Perro de tipo Animal
         */
        Animal animal = new Perro("goliath");
        animal.tipoAnimal();
        animal.comunicarse();
        System.out.println();

        /**
         * Creamos perro, un objeto Perro de tipo Perro
         */
        Perro perro = new Perro("hercules");
        perro.tipoAnimal();
        System.out.println();

        /**
         * Creamos animalPolimorfico, un objeto perro de tipo Animal asignamos
         * una referencia ya existente
         */
        Animal animalPolimorfico = perro;
        animalPolimorfico.tipoAnimal();
        System.out.println();

        /**
         * reasignamos la referencia del objeto animal a el objeto 
         * perro esto es valido ya que ambos son de tipo Perro
         */
        perro = (Perro) animal;
        perro.tipoAnimal();
        System.out.println();

        /**
         * Creamos gato, un objeto Gato de tipo Animal
         */
        Animal gato = new Gato("pichi");
        gato.tipoAnimal();
        gato.comunicarse();
        System.out.println();

        /**
         * Creamos cat, un objeto Gato de tipo IAnimal Para esto aplicamos
         * polimorfismo usando la Interface
         */
        IAnimal cat = new Gato("pitufa");
        cat.comunicarse();

        System.out.println("\nConstante en la interfaz Animal : " + IAnimal.valor);
    }
}
