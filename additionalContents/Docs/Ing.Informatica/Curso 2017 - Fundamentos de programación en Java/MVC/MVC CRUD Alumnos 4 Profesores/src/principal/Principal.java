package principal;

import controlador.ControladorPrincipal;
import vista.VistaPrincipal;

/**
 *
 * @author Antonio Rivero Cuesta
 */
public class Principal {

    public static void main(String[] args) {

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControladorPrincipal cPrincipal = new ControladorPrincipal(vistaPrincipal);
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }
}
