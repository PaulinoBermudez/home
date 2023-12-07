package Principal;

import Controlador.ControladorPrincipal;
import Vista.VistaPrincipal;

/**
 *
 * @author Toni
 */
public class Principal {
    
    public static void main(String[] args) {

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControladorPrincipal cPrincipal = new ControladorPrincipal(vistaPrincipal);
        vistaPrincipal.setVisible(true);
        vistaPrincipal.setLocationRelativeTo(null);
    }
    
}
