import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;

/**
 * @(#)JPanelEjemplo.java
 *
 *
 * @author Antonio Rivero Cuesta
 * @version 1.00 2017/7/2
 */

public class JPanelEjemplo implements ActionListener{
 
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton botonP1;
    private JButton botonP2;
    private JButton botonP3;   
 
    public JPanelEjemplo(){
 
        JFrame frame = new JFrame("JPanel En Java");  
        frame.setLayout(null);
 
        gridJP();
        bordJP();
        flowJP();
 
        botonP1 = new JButton("Panel 1"); 
        botonP2 = new JButton("Panel 2"); 
        botonP3 = new JButton("Panel 3");
        
        //xxxx.setBounds(x, y, width, height);
        panel1.setBounds(10, 10, 200, 200);
        panel2.setBounds(240, 10, 400, 250);
        panel3.setBounds(10, 270, 400, 150);
 
        botonP1.setBounds(10, 430, 90, 20);
        botonP2.setBounds(110, 430, 90, 20);
        botonP3.setBounds(210, 430, 90, 20);
 
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        
        frame.add(botonP1);
        frame.add(botonP2);
        frame.add(botonP3);
 
        botonP1.addActionListener(this);
        botonP2.addActionListener(this);
        botonP3.addActionListener(this);
 
        frame.setLocation(100, 50);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public void gridJP(){
 
        panel1 = new JPanel(new GridLayout(3, 1, 5, 7));
 
        boton1= new JButton("Botón 1G");
        boton2= new JButton("Botón 2G");
        boton3= new JButton("Botón 3G");
 
        panel1.add(boton1); 
        panel1.add(boton2);
        panel1.add(boton3);
 
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);
 
        panel1.setVisible(true);
        
        //la siguiente linea es para dar margen interior y color al jpanel 
        panel1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.black),BorderFactory.createEmptyBorder(10, 15, 5, 15)));
    }
 
    public void bordJP(){
    	
        panel2 = new JPanel(new BorderLayout(2,3));
 
        boton1= new JButton("Botón 1B");
        boton2= new JButton("Botón 2B");
        boton3= new JButton("Botón 3B");
 
        panel2.add(boton1, BorderLayout.NORTH);
        panel2.add(boton2, BorderLayout.WEST);
        panel2.add(boton3, BorderLayout.CENTER);
 
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        panel2.setVisible(true);
    }
 
    public void flowJP(){
    	
        panel3 = new JPanel(new FlowLayout());
 
        boton1= new JButton("Botón 1F");
        boton2= new JButton("Botón 2F");
        boton3= new JButton("Botón 3F");
 
        panel3.add(boton1);
        panel3.add(boton2); 
        panel3.add(boton3);
 
        boton1.addActionListener(this); 
        boton2.addActionListener(this);
        boton3.addActionListener(this);
 
        panel3.setVisible(true);
    }
 
    public static void main(String[] args) {        
        JPanelEjemplo panel = new JPanelEjemplo();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
 
        if(e.getSource() == botonP1){
            if(panel1.isVisible()){
                panel1.setVisible(false);
            }else
                panel1.setVisible(true);
        }else if(e.getSource() == botonP2){
            if(panel2.isVisible()){
                panel2.setVisible(false);
            }else
                panel2.setVisible(true);
 
        }else if(e.getSource() == botonP3){
            if(panel3.isVisible()){
                panel3.setVisible(false);
            }else
                panel3.setVisible(true);
 
        }else{
            JOptionPane.showMessageDialog(
            	null, 
            	e.getActionCommand());
        }
    }
}