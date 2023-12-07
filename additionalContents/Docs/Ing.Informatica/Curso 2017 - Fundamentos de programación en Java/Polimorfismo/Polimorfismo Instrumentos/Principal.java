
public class Principal {

    public static void main(String arg[]) {

        /**
         * Objeto miGuitarra de tipo Instrumento
         */
        Instrumento miGuitarra = new Guitarra();
        System.out.println("Instrumento : " + miGuitarra.tipo);
        miGuitarra.tocar();
        System.out.println();

        /**
         * Objeto miSaxofon de tipo Instrumento
         */
        Instrumento miSaxofon = new Saxofon();
        System.out.println("Instrumento : " + miSaxofon.tipo);
        miSaxofon.tocar();
        System.out.println();

        /**
         * Objeto miViolin de tipo Instrumento
         */
        Instrumento miViolin = new Violin();
        System.out.println("Instrumento : " + miViolin.tipo);
        miViolin.tocar();
    }
}
