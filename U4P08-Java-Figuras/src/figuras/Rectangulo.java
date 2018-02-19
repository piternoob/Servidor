package figuras;

public class Rectangulo extends Figura{
	public int ladoX, ladoY;
	
	public Rectangulo (Color color, int ladoX,int ladoY) {
		super.setColor(color);
		this.ladoX=ladoX;
		this.ladoY=ladoY;
	}

	public int getLadoX() {return ladoX;}

	public void setLadoX(int ladoX) {this.ladoX = ladoX;}

	public int getLadoY() {return ladoY;}

	public void setLadoY(int ladoY) {this.ladoY = ladoY;}

	@Override
	public String toString() {
		return super.toString()+"Rectangulo [ladoX=" + ladoX + ", ladoY=" + ladoY + "]";
	}
}
