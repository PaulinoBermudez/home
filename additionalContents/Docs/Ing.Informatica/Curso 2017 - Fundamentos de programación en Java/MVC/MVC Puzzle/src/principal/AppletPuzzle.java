package principal;

import controlador.Ordenador;
import java.awt.Image;
import java.awt.Graphics;
import modelo.Puzzle;
import vista.GuiTableroBotones;

public class AppletPuzzle extends javax.swing.JApplet {
        
    /** Called by the browser or applet viewer to inform
     * this applet that it has been loaded into the system. It is always
     * called before the first time that the <code>start</code> method is
     * called.
     * <p>
     * A subclass of <code>Applet</code> should override this method if
     * it has initialization to perform. For example, an applet with
     * threads would use the <code>init</code> method to create the
     * threads and the <code>destroy</code> method to kill them.
     * <p>
     * The implementation of this method provided by the
     * <code>Applet</code> class does nothing.
     *
     * @see     java.applet.Applet#destroy()
     * @see     java.applet.Applet#start()
     * @see     java.applet.Applet#stop()
     *
     */
    public void init() {
        int i;
        
        Puzzle puzzle = new Puzzle (3,3);
        Ordenador ordenador = new Ordenador(puzzle);
        
        Image [] imagenes = new Image[ficheros.length];
        
        for (i=0; i<ficheros.length; i++)
            imagenes[i] = this.getImage(
                this.getDocumentBase(), ficheros[i]);
        
        GuiTableroBotones guiPuzzle = new GuiTableroBotones(
            ordenador, imagenes, puzzle);
        
        this.getContentPane().add (guiPuzzle);
    }
    
    /** Called by the browser or applet viewer to inform
     * this applet that it should start its execution. It is called after
     * the <code>init</code> method and each time the applet is revisited
     * in a Web page.
     * <p>
     * A subclass of <code>Applet</code> should override this method if
     * it has any operation that it wants to perform each time the Web
     * page containing it is visited. For example, an applet with
     * animation might want to use the <code>start</code> method to
     * resume animation, and the <code>stop</code> method to suspend the
     * animation.
     * <p>
     * The implementation of this method provided by the
     * <code>Applet</code> class does nothing.
     *
     * @see     java.applet.Applet#destroy()
     * @see     java.applet.Applet#init()
     * @see     java.applet.Applet#stop()
     *
     */
/*    public void start() {
    }*/
    
    
    private String [] ficheros = {"hueco.gif", "uno.gif", "dos.gif", "tres.gif",
        "cuatro.gif", "cinco.gif", "seis.gif", "siete.gif", "ocho.gif" };
}