import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

class DibujaEnVentana extends JFrame{
	
	public static void main(String[] args) {
		
		new DibujaEnVentana("Dibujos");
	}
	
	public DibujaEnVentana(String título) {
		super(título);
		setContentPane(new PanelDibujos());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
	
	public class PanelDibujos extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawRect(60, 60, 90, 90);
			g.drawRoundRect(210, 60, 90, 90, 20, 20);
			g.setColor(Color.red);
			g.drawString("Un texto", 30, 170);
			g.setColor(new Color(0,255,0));
			g.drawRect(100, 100, 120, 120);
			g.setColor(new Color(255,255,0));
			g.fillOval(200,200,50,50);
		}
	}
} // fin clase DibujaEnVentana