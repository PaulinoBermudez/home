/**
 * CardLayout1.java
 * 
 * Código de un CardLayout
 * 
 * @author Antonio Rivero Cuesta
 * @version 1.00 2014/4/15
 */

import java.awt.*;
import java.applet.Applet;
class ButtonPanel extends Panel {
ButtonPanel(String id) {
setLayout(new BorderLayout());
add("Center", new Button(id));
}
}
public class CardLayout1 extends Frame {
Button
first = new Button("First"),
second = new Button("Second"),
third = new Button("Third");
Panel cards = new Panel();
CardLayout cl = new CardLayout();
public CardLayout1() {
setLayout(new BorderLayout());
Panel p = new Panel();
p.setLayout(new FlowLayout());
p.add(first);
p.add(second);
p.add(third);
add("North", p);
cards.setLayout(cl);
cards.add("First card",
new ButtonPanel("The first one"));
cards.add("Second card",
new ButtonPanel("The second one"));
cards.add("Third card",
new ButtonPanel("The third one"));
add("Center", cards);
}
public boolean handleEvent(Event e) {
	if (e.id == Event.WINDOW_DESTROY && e.target == this) {
System.out.println("Frame eliminado.");
System.exit(0);
}
return super.handleEvent(e);
}
public boolean action(Event evt, Object arg) {
if (evt.target.equals(first)) {
cl.first(cards);
}
else if (evt.target.equals(second)) {
cl.first(cards);
cl.next(cards);
}
else if (evt.target.equals(third)) {
cl.last(cards);
}
else
return super.action(evt, arg);
return true;
}
public static void main(String[] args) {
CardLayout1 f = new CardLayout1();
f.setSize(300, 200);
f.show();
}
}