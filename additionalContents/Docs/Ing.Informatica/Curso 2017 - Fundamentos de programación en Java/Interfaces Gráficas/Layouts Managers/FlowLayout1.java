/**
 * FlowLayout1.java
 * 
 * Código de un FlowLayout
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/15
 */

import java.awt.*;

public class FlowLayout1 extends Frame {
	public FlowLayout1() {
		setLayout(new FlowLayout());
		for(int i = 0; i < 20; i++)
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
		FlowLayout1 f = new FlowLayout1();
		f.setSize(300, 400);
		f.show();
	}
}