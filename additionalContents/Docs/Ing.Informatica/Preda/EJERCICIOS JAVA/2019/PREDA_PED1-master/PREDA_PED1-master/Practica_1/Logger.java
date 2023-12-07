import java.io.*;

class Logger extends PrintStream{    

    private PrintStream fileStream = null;
    private PrintStream originalPrintStream = null;
    private boolean consola = true;
    
    public Logger(PrintStream salida, String ruta, boolean consola) {
        super(salida);
        this.consola = consola;
        if(!consola){
                    originalPrintStream = null;
        }else{
                    originalPrintStream = salida;
        }
         try {
             FileOutputStream fout = new FileOutputStream(ruta,true);
             fileStream = new PrintStream(fout);
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        }
    }    
    public void print(final String str) {
        if(consola){
            originalPrintStream.print(str);
            fileStream.println(str);
        }else{
            originalPrintStream = null;
            fileStream.println(str);
        }
    }
    public void println(final String str) {
       if(consola){
            originalPrintStream.print(str);
            fileStream.println(str);
        }else{
            originalPrintStream = null;
            fileStream.println(str);
        }
    }        
}