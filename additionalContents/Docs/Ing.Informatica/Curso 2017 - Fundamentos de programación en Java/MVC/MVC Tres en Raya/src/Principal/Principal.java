package Principal;

import vista.interfaz;
import controlador.controlador;
import modelo.juego;
/**
 * @web www.jc-mouse.net/
 * @author Mouse
 */
public class Principal {

    public static void main(String[] args) {
         //nuevas instancias de clase
        juego modelo = new juego();
        interfaz vista = new interfaz();
        controlador controlador = new controlador( vista , modelo );
        controlador.iniciar_vista();
        vista.setVisible(true);
    }

}
