import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @(#)PruebaGridLayout.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/17
 */

public class PruebaGridLayout {
   private static final int COLUMNAS = 8;
   private static final int FILAS = 8;

   public static void main(String [] args)
   {
      JFrame v = new JFrame();
      v.getContentPane().setLayout(new GridLayout(FILAS,COLUMNAS));
		
      JTextField [][] textField = new JTextField [FILAS][COLUMNAS];
      for (int i=0;i<FILAS;i++)
         for (int j=0;j<COLUMNAS;j++)
         {
            textField[i][j] = new JTextField(1);
            v.getContentPane().add(textField[i][j]);
         }
      v.pack();
      v.setVisible(true);
      v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
}