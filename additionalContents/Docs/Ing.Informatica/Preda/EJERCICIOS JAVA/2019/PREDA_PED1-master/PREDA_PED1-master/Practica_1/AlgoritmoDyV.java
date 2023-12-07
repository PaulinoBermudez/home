import java.util.*;
import java.lang.Math;
import java.math.*;

/**
 * Write a description of class AlgoritmoVoraz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlgoritmoDyV
{
    private boolean trazabilidad;

    /**
     * Constructor for objects of class AlgoritmoVoraz
     */
    public AlgoritmoDyV(boolean trazabilidad_p)
    {
        this.trazabilidad= trazabilidad_p;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public BigInteger ejecutarAlgoritmoDyV(BigInteger numeroA_p, BigInteger numeroB_p)
    {
        System.out.println("ALGORITMO DIVIDE Y VENCERÁS PARA MULTIPLICACIÓN DE NÚMEROS GRANDES");
        //Implementación de algoritmo Dividé y Venceras para la multiplicación de números grandes
        if(trazabilidad){
            System.out.println("Se va a proceder a realizar la multiplicación de los dos siguientes número enteros:");
            System.out.println("Número A: "+numeroA_p);
            System.out.println("Número B: "+numeroB_p);
            System.out.println();
        }
        //SOLUCIÓN TRIVIAL
        //Camprobamos si la multiplicación de los número a multiplicar está limitada por el tamaño de representación de los valores en long en Java
        //Si el resultado de la múltiplicación es mayor que la posible representación enJava long, utilizamos el método propuesto en el enunciado de la ped1.
        //Este sería el caso trivial del algoritmo DivideyVencerás para multiplicar número grandes.
        if(esSolucionTrivial(numeroA_p, numeroB_p)){
            System.out.println("SOLUCIÓN TRIVIAL");
            return BigInteger.valueOf(Math.multiplyExact(numeroA_p.longValueExact(), numeroB_p.longValueExact()));
        }
        //DESCOMPOSICIÓN RECURSIVA DE LOS SUBPROBLEMAS
        System.out.println("DESCOMPOSICIÓN RECURSIVA DE LOS SUBPROBLEMAS");
        //Si no es en caso trivial, implementamos el algoritmo para número grandes que no puede representar Java long
        //a*b= 10^n*p + 10^n/2 s + q
        //s = (r - p - q)
        //Donde > n el el tamaño del número más grande, p = aL *bL , q = aR * bR  y r = (aL + aR) * (bL + bR)
        //Calculamos el tamaño n del número más grande a multiplicar, para dividirlos en dos mitades de tamaño n/2
        int n = Math.max(numeroA_p.bitLength(), numeroB_p.bitLength());
        int nn = n;
        n =  (n/2) + (n%2);
        System.out.println("Lo que resulta en que dos números de tamaño máximo "+nn+" pueden multiplicarse mediante 3 multiplicaciones de tamaño "+n);
        //Calculamos los valores aL aR bL bR 
        BigInteger aR = numeroA_p.shiftRight(n);
        BigInteger aL = numeroA_p.subtract(aR.shiftLeft(n));
        BigInteger bR = numeroB_p.shiftRight(n);
        BigInteger bL = numeroB_p.subtract(bR.shiftLeft(n));
        System.out.println("Los numeros  "+numeroA_p+ " y  "+numeroB_p+" los dividimos en > aL: "+aL+" aR: "+aR+" bL: "+bL+" bR: "+bR);
        System.out.println("Y realizaremos las tres multiplicaciones p = aL *bL > p = "+aL+" * "+bL+" ; q = aR * bR > q = "+aR+" * "+bR+" ; r = (aL + aR) * (bL + bR) > r = ("+aL+" + "+aR+") * ("+bL+" + "+bR+")");
        //RESOLUCIÓN RECURSIVA DE LOS SUBPROBLEMAS
        System.out.println("RESOLUCIÓN RECURSIVA DE LOS SUBPROBLEMAS");
        System.out.println("Volvemos a invocar el algoritmo recursivamente para cada una de las tres multiplicaciones p, q y r.");
        //Calculamos los valores p, q y r, que son 3 multiplicaciones que sirven para realizar la multiplicación de los numeros grandes, como se muestra en la formula anterior
        //Como estas multiplicaciones pueden tb ser de número grandes, invocamos recursivamente el algoritmo divide y vencerás
        BigInteger p = ejecutarAlgoritmoDyV(aL, bL); //p = aL *bL
        BigInteger q = ejecutarAlgoritmoDyV(aR, bR); //q = aR * bR 
        BigInteger r = ejecutarAlgoritmoDyV(aL.add(aR), bL.add(bR)); //r = (aL + aR) * (bL + bR)
        
        //COMBINACIÓN DE LAS SOLUCIONES DE LOS SUBPROBLEMAS
        System.out.println("COMBINACIÓN DE LAS SOLUCIONES DE LOS SUBPROBLEMAS");
        System.out.println("Hemos obtenido recursivamente los valores p = "+p+" , q = "+q+" , r = "+r);
        BigInteger s = r.subtract(q).subtract(p); // s = (r - p - q) 
        System.out.println("Calculamos el valor de s = (r - p - q) > s = "+s);
        //Juntamos los resultados parciales de las multiplicaciones recursivas para obtener el resultado final
        System.out.println("Juntamos los resultados parciales de las multiplicaciones recursivas para obtener el resultado final, en este caso el resultado del subproblema es: "+q.shiftLeft(2 * n).add(s.shiftLeft(n)).add(p));
        return q.shiftLeft(2 * n).add(s.shiftLeft(n)).add(p);
    }
    
    private static boolean esSolucionTrivial(BigInteger numeroA_p, BigInteger numeroB_p){
        if (BigInteger.valueOf(Long.MAX_VALUE).compareTo(numeroA_p) < 0 || BigInteger.valueOf(Long.MAX_VALUE).compareTo(numeroB_p) < 0) {
              // alguno de los números  es mayor que el máximo long que soporta Java, no  podemos realizar la múltiplicación normal, devolvemos falso, no es caso trivial
              System.out.println("Los numeros A: "+numeroA_p+ " y B: "+numeroB_p+" no son solución trivial (demasiado grandes para su representación como long en java) con lo que debemos dividirlos en dos mitades, para poder multiplicarlos.");
              return false;
        }else{
            //Ninguno de los dos números es mayor que la máxima representación en long de Java. Ahora vamos a comprobar si se pueden multiplicar de modo normal
            //Si se pueden multiplicar, sabemos que es un caso trivial, si no, es un caso no trivial y debemos calcular por el método propuesto en la PED
            try{
                Math.multiplyExact(numeroA_p.longValueExact(), numeroB_p.longValueExact());
                System.out.println("Los numeros A: "+numeroA_p+ " y B: "+numeroB_p+" son solución trivial (no demasiado grandes para su multiplicación directa) con lo que podemos multiplicarlos directamente.");
                return true;
            }catch(Exception e){
                System.out.println("Los numeros A: "+numeroA_p+ " y B: "+numeroB_p+" no son solución trivial (demasiado grandes para su multiplicación directa como long en java) con lo que debemos dividirlos en dos mitades, para poder multiplicarlos.");
                return false;
            }    
        }
    }
    
}
