/**
 * GridLayout1.java
 * 
 * Código de un GridLayout
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/15
 */

import java.awt.*;

public class GridLayout1 extends Frame {
	
	public GridLayout1() {
		setLayout(new GridLayout(7, 3));
		for(int i = 0; i < 21; i++)
		add(new Button("Botón " + i));
	}
	
	public boolean handleEvent(Event e) {
		if (e.id == Event.WINDOW_DESTROY && e.target == this) {
		System.out.println("Frame eliminado.");
		System.exit(0);
	}
		
	return super.handleEvent(e);
	
	}
	
	public static void main(String[] ars) {
		GridLayout1 f = new GridLayout1();
		f.setSize(300, 400);
		f.show();
	}
}