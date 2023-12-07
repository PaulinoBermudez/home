
package Principal;

import Controlador.ControladorCB;
import Modelo.ComunidadAutonomaDAO;
import Vista.ComboComunidades;

/**
 *
 * @author Toni
 */
public class Principal {
    
    public static void main(String[] args) {
    
    ComboComunidades vistaCombo = new ComboComunidades();
    ComunidadAutonomaDAO ccaadao = new ComunidadAutonomaDAO();
    ControladorCB controladorCombo = new ControladorCB(vistaCombo, ccaadao);
    vistaCombo.setLocationRelativeTo(null);
    vistaCombo.setVisible(true);
    
    }
    
}
