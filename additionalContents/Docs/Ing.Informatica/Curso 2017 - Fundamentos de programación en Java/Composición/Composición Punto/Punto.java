public class Punto{
	
    private int x;
    private int y;
    
	public Punto(int x, int y){
        this.x = x;
	    this.y = y;
	}
   
	public Punto(){
		x=0;
		y=0;
	}
	
	void desplazar(int dx, int dy){
		x+=dx;
		y+=dy;
	}
} 