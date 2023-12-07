/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paulino
 */
public class NReinas {
    private int[][] solucion = new int[8][8];
    
    public NReinas(){
        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion.length; j++) {
                solucion[i][j] = 0;
            }
        }
    }
    
    public void imprimir(){
        System.out.println();
        for (int i = 0; i < solucion.length; i++) {
            for (int j = 0; j < solucion.length; j++) {
                System.out.print(solucion[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void vueltaAtras (int etapa){
        for (int i = 0; i < solucion.length; i++) {
            if(aceptable(i, etapa)){
                solucion[i][etapa] = 1;
                if(etapa == solucion.length -1){
                    imprimir();
                }else{
                    vueltaAtras(etapa+1);
                }
                solucion[i][etapa]= 0;
            }
        }
    }
    
    public boolean aceptable(int i, int etapa){
        // filas
        for (int j = 0; j <= i; j++) {
            if(solucion[i][etapa] == 1){
                return false;
            }
        }
        // columnas
        for (int j = 0; j <= etapa; j++) {
            if (solucion[i][j] == 1) {
                return false;
            }
        }
        // diagonal izquierda
        int h = i;
        for (int j = etapa; j >= 0 && h >= 0 ; j--) {
            if(solucion[h][j] == 1){
                return false;
            }
            h--;
        }
        // diagonal derecha
        h = i;
        for (int j = etapa; j >= 0 && h >= solucion.length ; j--) {
            if(solucion[h][j] == 1){
                return false;
            }
            h++;
        }
        return true;
    }
    
    public void resolver(){
        imprimir();
        vueltaAtras(0);
    }
    
}
