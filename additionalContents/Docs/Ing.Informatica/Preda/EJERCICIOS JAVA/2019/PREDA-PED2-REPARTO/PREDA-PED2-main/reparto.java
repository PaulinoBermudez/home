import java.util.ArrayList;
import java.util.Collections;

public class reparto{

    public String traza = "";
    public String res = "";
    ArrayList<String> aux = new ArrayList<String>();
    public int sol = 0;

    public reparto() {
    }
   
    
    public void dividirSociedad(Integer[] x, int suma1, int suma2, int sumaTotal, int k, Integer[] v){
        if(k == (x.length - 1)) {
            if(suma1 == suma2) {
                traza += "HEMOS LLEGADO A UNA SOLUCIÓN, LA GUARDAMOS\n\n\n\n";
                procesar(v, x);
            }
        } else {
            
            if(completable(x, suma1, sumaTotal, k+1)) {
                v[k+1] = 1;
                traza += "Como es completable en para el socio 1, guardamos que su posición le corresponde.\n";
                dividirSociedad(x, suma1 + x[k+1], suma2, sumaTotal, k+1 ,v);
            }

            if(completable(x, suma2, sumaTotal, k+1)) {
                v[k+1] = 2;
                traza += "Como es completable en para el socio 1, guardamos que su posición le corresponde.\n";
                dividirSociedad(x, suma1, suma2 + x[k+1], sumaTotal, k+1, v);
            }
        }
    }
    
    public boolean completable(Integer[] x, int sumaParcial, int sumaTotal, int k){
        if((sumaParcial + x[k]) <= (sumaTotal/2)) {
            traza += "sumaParcial + x[k] = " + (sumaParcial + x[k]) + ", es menor o igual que sumaTotal/2\n";
            traza += "ES COMPLETABLE\n";
            return true;
        } else {
            traza += "sumaParcial + x[k] = " + (sumaParcial + x[k]) + ", es mayor que sumaTotal/2\n";
            traza += "NO ES COMPLETABLE\n";
            return false;
        }
    }
    
    
    public void resolverSeparacionSocios(Integer[] x){
        int sumaTotal = 0; 
        int suma1 = 0; 
        int suma2 = 0;
        Integer[] v = new Integer[x.length];

        for(int i = 0; i < x.length; i++) {
            sumaTotal = sumaTotal + x[i];
        }
        if (sumaTotal%2 == 0) {
            traza += "Como la suma de los activos es par, el problema se puede resolver\n";
            dividirSociedad(x, suma1, suma2, sumaTotal, -1, v);
        }
    }
    
    public void procesar(Integer[] v, Integer[] x) {    
        ArrayList<Integer> socio1 = new ArrayList<Integer>();
        ArrayList<Integer> socio2 = new ArrayList<Integer>();
        
        for(int i = 0; i < v.length; i++){
            if(v[i] == 1) {
                socio1.add(x[i]);
            } else {
                socio2.add(x[i]);
            }
        }
        
        Collections.sort(socio1);
        Collections.sort(socio2);
        
        String num1 = "";
        String num2 = "";
        
        for(int i = 0; i < socio1.size(); i++) {
            num1 += socio1.get(i) + " ";
        }
        
        for(int i = 0; i < socio2.size(); i++) {
            num2 += socio2.get(i) + " ";
        }
        
        if(!aux.contains(num1)){
            aux.add(num1);
            sol++;
            res += sol + "\n" + num1 + "\n" + num2 + "\n";
        }
    }
 
}
    

