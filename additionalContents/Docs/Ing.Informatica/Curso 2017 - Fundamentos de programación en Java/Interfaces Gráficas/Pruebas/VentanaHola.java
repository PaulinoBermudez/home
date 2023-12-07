import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaHola extends JFrame {
	
	public VentanaHola() {
		
		setTitle("Hola");
		setLocation(50,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label1 = new JLabel("Curso UNED");
        add(label1);
		setSize(250, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new VentanaHola();
	}
}