package Modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * @(#)Aplicacion.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/4/11
 */
public class Listas {

    private java.util.List<Coche> lista;

    public Listas() {
        lista = new ArrayList<Coche>();
    }

    public void agregarCoche(Coche coche) {
        lista.add(coche);
    }

    public java.util.List<Coche> getLista() {
        return lista;
    }
}
