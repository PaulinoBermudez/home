/**
 * BoxLayout1.java
 * 
 * Código de un BoxLayout
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/15
 */


import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import javax.swing.BoxLayout;

public class BoxLayoutExample {
  
    //Note: Typically the main method will be in a
    //separate class. As this is a simple one class
    //example it's all in the one class.
    public static void main(String[] args) {
     
         //Use the event dispatch thread for Swing components
         EventQueue.invokeLater(new Runnable(){
         	@Override
            public void run(){  
            	new BoxLayoutExample();         
            }
         });
              
    }
    
    public BoxLayoutExample()
    {
        JFrame guiFrame = new JFrame();
        
        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Ejemplo de BoxLayout");
        guiFrame.setSize(400,300);
      
        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setLayout(new BorderLayout());
        
        //creating a border to highlight the JPanel areas
        Border outline = BorderFactory.createLineBorder(Color.black);
        
        JPanel pageAxisPanel = new JPanel();
        pageAxisPanel.setBorder(outline);
        pageAxisPanel.setLayout(new BoxLayout(pageAxisPanel, BoxLayout.PAGE_AXIS));
        
        //Add some buttons
        for (int i=1;i<6;i++)
        {
            addButton(pageAxisPanel, String.valueOf(i));
        }
        
        JPanel lineAxisPanel = new JPanel();
        lineAxisPanel.setLayout(new BoxLayout(lineAxisPanel, BoxLayout.LINE_AXIS));
        lineAxisPanel.setBorder(outline);
        //Add some buttons
        for (int i=1;i<6;i++)
        {
            addButton(lineAxisPanel, String.valueOf(i));
        }
        
        guiFrame.add(pageAxisPanel,BorderLayout.NORTH);
        guiFrame.add(lineAxisPanel,BorderLayout.SOUTH);
        guiFrame.setVisible(true);
        
    }
    
    //All the buttons are following the same pattern
    //so create them all in one place.
    private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        parent.add(but);
    }
}