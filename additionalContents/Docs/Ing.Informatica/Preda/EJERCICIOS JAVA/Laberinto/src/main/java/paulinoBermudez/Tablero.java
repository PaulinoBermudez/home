/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paulinoBermudez;

import java.util.ArrayList;

/**
 *
 * @author paulino
 */
public class Tablero {
    private Casilla[][] tablero;
    private ArrayList<ArrayList<Casilla>> caminos;
    
    public Tablero(Casilla[][] tablero){
        this.tablero = tablero;
        caminos = new ArrayList<>();
    }
    /**
     * Indica si se puede mover hacia arriba
     * @param casillaActual
     * @param casillaDestino
     * @return
     */
    public boolean arribaDisponible(Casilla casillaActual, Casilla casillaDestino){
        if (casillaDestino != null && !casillaDestino.isVisitado()){
            return casillaActual.arribaDisponible();
        }
        return false;
    }
    /**
     * Indica si se puede mover hacia la derecha
     * @param casillaActual
     * @param casillaDestino
     * @return
     */
    public boolean derechaDisponible(Casilla casillaActual, Casilla casillaDestino){
        if (casillaDestino != null && !casillaDestino.isVisitado()){
            return casillaActual.derechaDisponible();
        }
        return false;
    }
    /**
     * Indica si se puede mover hacia abajo
     * @param casillaActual
     * @param casillaDestino
     * @return
     */
    public boolean abajoDisponible(Casilla casillaActual, Casilla casillaDestino){
        if (casillaDestino != null && !casillaDestino.isVisitado()){
            return casillaActual.abajoDisponible();
        }
        return false;
    }
    /**
     * Indica si se puede mover hacia la izquierda
     * @param casillaActual
     * @param casillaDestino
     * @return
     */
    public boolean izquierdaDisponible(Casilla casillaActual, Casilla casillaDestino){
        if (casillaDestino != null && !casillaDestino.isVisitado()){
            return casillaActual.izquierdaDisponible();
        }
        return false;
    }
    /**
     * Coge la casilla indicada
     * @param x
     * @param y
     * @return
     */
    public Casilla getCasilla(int x, int y){
        if(dentroDelLimite(x,y)){
            return tablero[x][y];
        }
        return null;
    }
    /**
     * Indica si esta dentro del limite
     * @param x
     * @param y
     * @return
     */
    public boolean dentroDelLimite(int x, int y){
        return (x >= 0 && x < tablero.length) && (y >= 0 && y<tablero[0].length);
    }
    /**
     * Añade un camino a la solución
     * @param camino
     */
    public void añadirCamino(ArrayList<Casilla> camino){
        if(camino != null && !camino.isEmpty()){
            caminos.add(camino);
        }
    }
    
    /**
     * Muestra los caminos
     */
    public void mostrarCaminos(){
        int i = 1;
        for (ArrayList<Casilla> camino : caminos){
            System.out.println("Camino:" + i );
        }
        i++;
    }
    
}
