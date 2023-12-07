
/**
 * Clase Concreta Guitarra, hija de Instrumento
 */

class Guitarra extends Instrumento {

    public Guitarra() {

        tipo = "Guitarra";
    }

    @Override
    public void tocar() {

        System.out.println("Tocar La Guitarra");
    }
}
