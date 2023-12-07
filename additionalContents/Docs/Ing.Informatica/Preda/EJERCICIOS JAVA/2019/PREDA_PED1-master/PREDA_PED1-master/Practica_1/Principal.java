import java.util.*;
import java.lang.Math;
import java.math.*;

/**
 * Write a description of class Principal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Principal
{
    // instance variables - replace the example below with your own
    private EntradaConfig datosEntrada;
    private AlgoritmoDyV aDyV;
    private BigInteger resultado;

    /**
     * Constructor for objects of class Principal
     */
    public Principal(String nombrearchivoentrada, boolean trazabilidad)
    {
        datosEntrada = new EntradaConfig(nombrearchivoentrada);
        if(datosEntrada.comprobarDatos()){
            calcularMultiplicacion(trazabilidad);
        }else{
            System.out.println("Los datos del fichero de entrada no son correctos, no se puede ejecutar el algoritmo de multiplicación");
        }
        /*if(datosEntrada.getOKentrada()){
            datosEntrada.print();
            calcularMultiplicacion(trazabilidad);
            print();
        }else{
            System.out.println("ARCHIVO DE ENTRADA NO VALIDO");
        }*/
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void calcularMultiplicacion(boolean trazabilidad)
    {
        aDyV = new AlgoritmoDyV(trazabilidad);
        resultado  = aDyV.ejecutarAlgoritmoDyV(new BigInteger(datosEntrada.getOperandoA()), new BigInteger(datosEntrada.getOperandoB()));
    }
    
  public void print()
  {
    System.out.println("RESULTADO: "+this.resultado);
  }
    
}
