/**
 * BoxLayout1.java
 * 
 * Código de un BorderLayout
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/15
 */

import java.awt.*;

public class BorderLayout1 extends Frame {
	public BorderLayout1() {
		int i = 0;
		setLayout(new BorderLayout());
		add("North", new Button("Button " + i++));
		add("South", new Button("Button " + i++));
		add("East", new Button("Button " + i++));
		add("West", new Button("Button " + i++));
		add("Center", new Button("Button " + i++));
	}
	
	
	public boolean handleEvent(Event e) {
		if (e.id == Event.WINDOW_DESTROY &&
		e.target == this) {
		System.out.println("Frame eliminado.");
		System.exit(0);
		}
	return super.handleEvent(e);
	}
	
	public static void main(String[] args) {
		BorderLayout1 f = new BorderLayout1();
		f.setSize(300, 200);
		f.show();
	}
}