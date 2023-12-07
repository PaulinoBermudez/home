
/**
 * @(#)Animal.java
 *
 * @author Antonio Rivero
 * @version 1.00 2017/6/9
 */
public abstract class Animal implements IAnimal {

    private String nombre;

    /**
     * Constructor de la clase Animal
     *
     * @param nombre
     */
    public Animal(String nombre) {
        this.nombre = nombre;
        System.out.println("Constructor Animal, "
                + "nombre del animal : " + this.nombre);
    }

    /**
     * Retorna el valor de nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo Abstracto tipoAnimal, la implementaci�n depende de las clases
     * concretas que extiendan la clase Animal
     */
    public abstract void tipoAnimal();
}
