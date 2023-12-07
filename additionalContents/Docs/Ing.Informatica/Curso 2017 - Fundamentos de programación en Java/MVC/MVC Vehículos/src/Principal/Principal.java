package Principal;

import Controlador.ControladorGUI;
import Modelo.Coche;
import Modelo.Listas;
import Modelo.TipoDeCoche;
import Modelo.TipoDeSeguro;
import Vista.InterfazGrafica;

/**
 * @(#)Principal.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */
public class Principal {

    public static void main(String args[]) {

        Listas listas = new Listas();

        InterfazGrafica ventana = new InterfazGrafica();

        ControladorGUI controlaGUI = new ControladorGUI(listas, ventana);

        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        
        Coche coche1 = new Coche ("Ibiza", "Gris", true, "1234ABC",TipoDeCoche.MINI,2010, TipoDeSeguro.A_TODO_RIESGO);
        Coche coche2 = new Coche ("Toledo", "Rojo", false, "4567FRG",TipoDeCoche.UTILITARIO,2011, TipoDeSeguro.A_TERCEROS);
        Coche coche3 = new Coche ("Meriva", "Azul", false, "9874UHT",TipoDeCoche.FAMILIAR,2012, TipoDeSeguro.A_TODO_RIESGO);
        Coche coche4 = new Coche ("Golf", "Negro", true, "7845GTY",TipoDeCoche.DEPORTIVO,2013, TipoDeSeguro.A_TERCEROS);
        listas.agregarCoche(coche1);
        listas.agregarCoche(coche2);
        listas.agregarCoche(coche3);
        listas.agregarCoche(coche4);
                
    }
}
