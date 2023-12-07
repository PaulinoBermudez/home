import java.util.*;

public class Vocales{
   public static void main(String[] args){
      
    int numA,numE,numI,numO,numU;
        numA=numE=numI=numO=numU=0;
      
      Scanner teclado=new Scanner(System.in);
      System.out.print("Introduzca texto: ");
      String texto=teclado.nextLine();
      for(int i=0;i<texto.length();i++){
         switch(Character.toUpperCase(texto.charAt(i))){
            case 'A':
               numA++;
              break;
            case'E':
               numE++;
               break;
            case 'I':
               numI++;
               break;
            case 'O':
               numO++;
            case 'U':
               numU++;
               break;
            default:
               break;
              
         }
      }
      
      
      System.out.print("a: "+numA+" e: "+numE+" i: "+numI+" o: "+numO+" u: "+numU );
   }
}