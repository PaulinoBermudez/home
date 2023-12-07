/**
 * @(#)FileVentana.java
 *
 * @author Antonio Rivero
 * @version 1.00 2015/7/14
 */

import java.awt.TextField;
import java.awt.TextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;

public class FileVentana extends JFrame implements ActionListener{
	
	TextField texto1;
	TextArea texto2;
	
	public FileVentana (){
		
		setLayout (new BorderLayout());
				
		addWindowListener (new WindowAdapter(){
			public void windowclosing(WindowEvent e){
				System.exit(3);
			}
		});

		texto1 = new TextField ("Introduzca el nombre"+
								" del directorio", 55);
		texto1.selectAll();
		add ("North", texto1);
		texto1.addActionListener(this);
		texto2 = new TextArea ();
		add ("Center", texto2) ;
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		File arch = new File (texto1.getText());
		if (arch.exists())
			if (arch.isDirectory()){
			
				texto2.append ("Contenido de " + arch + "\n");
				String arr [] = arch.list ();
				for(int j = 0; j < arr.length; j++){
					
					File otro = new File(arch+ "\\" + arr [j]);
					if (otro.isDirectory ())
						texto2.append (arr [j] + " <DIR>" + "\n");
					else
						texto2.append(arr [j] + "\n");
				}
	
			}else
				texto2.append (e.toString() + " no es un directorio");
		else
			texto2.append(e.toString () + " no existe");	
		
	}

	public static void main(String args[]){
		
		FileVentana vt = new FileVentana();
		vt.setTitle ("File Con Entorno gráfico");
		vt.setSize(400,550);
		vt.setVisible(true);		
	}
}