
/**
 * Clase Concreta Violin, hija de Instrumento
 */

class Violin extends Instrumento {

    public Violin() {

        tipo = "Violin";
    }

    @Override
    public void tocar() {

        System.out.println("Tocar El violin");
    }
}
