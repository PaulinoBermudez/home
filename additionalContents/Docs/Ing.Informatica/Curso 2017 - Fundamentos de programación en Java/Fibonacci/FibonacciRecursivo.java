/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/8/25
 */


public class FibonacciRecursivo{
 public static long FiboRecursivo(long pos){
  long retornado=0;
  if(pos==0 || pos==1){
   retornado=pos;
  }else{
   retornado=FiboRecursivo(pos-2)+FiboRecursivo(pos-1);
  }
  return retornado;
 }
 public static void main(String args[]){
  System.out.println(FiboRecursivo(0));
 }
}