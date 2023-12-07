/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/6/30
 */


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;

public class MessageDialogInFrame extends JFrame{

    public MessageDialogInFrame() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Message Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        getContentPane().setLayout(null);
    }

    public static void main(String[] args){
        ImageIcon icon = new ImageIcon("src/images/turtle64.png");
        JOptionPane.showMessageDialog(
        	new MessageDialogInFrame(),
                "I appear as part of the frame!!",
                "Customized Dialog",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

}