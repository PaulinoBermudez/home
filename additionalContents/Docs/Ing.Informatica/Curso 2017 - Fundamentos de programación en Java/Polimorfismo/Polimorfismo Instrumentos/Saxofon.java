
/**
 * Clase Concreta Saxofon, hija de Instrumento
 */

class Saxofon extends Instrumento {

    public Saxofon() {

        tipo = "Saxof�n";
    }

    @Override
    public void tocar() {

        System.out.println("Tocar el Saxofon");
    }
}
