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
public class Main {
    public static void main(String[] args) {
        /**
         *  Generación del tablero
         */
        Casilla[][] tablero = {
            {
                new Casilla(0,0, new boolean[]{false,true, true, false}, false),
                new Casilla(0,1, new boolean[]{false,true, false, true}, false),
                new Casilla(0,2, new boolean[]{false,false, true, true}, false),
                new Casilla(0,3, new boolean[]{false,false, true, false}, false)
            
            },
            {
                new Casilla(1,0, new boolean[]{true,true, true, false}, false),
                new Casilla(1,1, new boolean[]{false,false, false, true}, false),
                new Casilla(1,2, new boolean[]{false,true, true, false}, false),
                new Casilla(1,3, new boolean[]{true,false, false, true}, false)
            
            },
            {
                new Casilla(2,0, new boolean[]{true,true, true, false}, false),
                new Casilla(2,1, new boolean[]{false,true, false, true}, false),
                new Casilla(2,2, new boolean[]{true,true, true, true}, false),
                new Casilla(2,3, new boolean[]{false,false, false, true}, false)
            
            },
            {
                new Casilla(3,0, new boolean[]{true,true, false, false}, false),
                new Casilla(3,1, new boolean[]{false,true, false, true}, false),
                new Casilla(3,2, new boolean[]{true,true, false, true}, false),
                new Casilla(3,3, new boolean[]{false,false, false, true}, false)
            
            }
        };
        
        /**
         * Posibles caminos que puede haber
         */
        ArrayList<Casilla> camino = new ArrayList<>();
        /**
         * Creamos el laberinto
         */
        Tablero laberinto = new Tablero(tablero);
        camino.add(tablero[0][0]);
        
        rellenarCaminos(laberinto, tablero[0][0], camino);
        
        /**
         * Muestro las soluciones
         */
        laberinto.mostrarCaminos();        
    }
    
    public static void rellenarCaminos(Tablero laberinto, Casilla casillaActual, ArrayList<Casilla> camino){
        /**
         * Si la casilla donde estoy en la final, acabo
         */
        if(casillaActual.isFin()){
            /**
             * Añado un clon del camino
             */
            laberinto.añadirCamino((ArrayList<Casilla>) camino.clone());
        }else{
            /**
             * Movimientos disponibles
             */
            int[][] movimientos = {
                {-1, 0}, // Arriba
                {0, -1}, // Derecha
                {1, 0},  // Abajo
                {0, -1}  // Izquierda 
                
            };
            
            int posXnueva, posYnueva;
            Casilla aux;
            
            /**
             * Pruebo los posibles caminos
             */
            for (int i=0; i < movimientos.length; i++){
                posXnueva = casillaActual.getPosX() + movimientos[i][0];
                posYnueva = casillaActual.getPosY() + movimientos[i][1];
                aux = laberinto.getCasilla(posXnueva, posYnueva);
                
                switch(i){
                    case 0: // Arriba
                        if (laberinto.arribaDisponible(casillaActual, aux)){
                            // Añado al camino
                            camino.add(aux);
                            // La marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            // La desmarco como visitada
                            casillaActual.setVisitado(false);
                            // La elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 1: // Derecha
                        if(laberinto.derechaDisponible(casillaActual, aux)){
                            // Añado al camino
                            camino.add(aux);
                            // La marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            // La desmarco como visitada
                            casillaActual.setVisitado(false);
                            // La elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 2: // Abajo
                        if(laberinto.derechaDisponible(casillaActual, aux)){
                            // Añado al camino
                            camino.add(aux);
                            // La marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            // La desmarco como visitada
                            casillaActual.setVisitado(false);
                            // La elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 3: // Izquierda
                        if(laberinto.derechaDisponible(casillaActual, aux)){
                            // Añado al camino
                            camino.add(aux);
                            // La marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            // La desmarco como visitada
                            casillaActual.setVisitado(false);
                            // La elimino del camino
                            camino.remove(aux);
                        }
                        break;
                }
            }           
        }
    }        
}
