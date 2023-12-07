/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paulinoBermudez;

/**
 *
 * @author paulino
 */
public class Casilla {
    private int posX, posY;
    private boolean visitado;
    private boolean fin;
    private boolean paso[]; // Datos. 0- arriba 1- derecha 2- abajo 3- izquierda
    
    public Casilla (int posX, int posY, boolean paso[], boolean fin){
        this.posX = posX;
        this.posY = posY;
        this.visitado = false;
        this.paso = paso;
        this.fin = fin;
    }
    
    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }
    
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    
    public boolean arribaDisponible(){
        return paso[0];
    }
    
    public boolean derechaDisponible(){
        return paso[1];
    }
    
    public boolean abajoDisponible(){
        return paso[2];
    }
    
    public boolean izquierdaDisponible(){
        return paso[3];
    }

    @Override
    public String toString() {
        return "Casilla{" + "pos.X=" + posX + ", pos.Y=" + posY + '}';
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj){ return true; }
        if (obj == null){ return false; }
        if (getClass() != obj.getClass()){ return false; }
        
        final Casilla other = (Casilla) obj;
        
        if (this.posX != other.posX){ return false; }
        if (this.posY != other.posY){ return false; }
        
        return true;
    }
    
    
}
