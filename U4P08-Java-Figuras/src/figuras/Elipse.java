
package figuras;

public class Elipse extends Figura{
	public int radioX, radioY;

	public Elipse(Color color, int radioX, int radioY) {
		super.setColor(color);
		this.radioX=radioX;
		this.radioY=radioY;
	}

	public int getRadioX() {return radioX;}

	public void setRadioX(int radioX) {this.radioX = radioX;}

	public int getRadioY() {return radioY;}

	public void setRadioY(int radioY) {this.radioY = radioY;}

	@Override
	public String toString() {
		return "Elipse [radioX=" + radioX + ", radioY=" + radioY + "]";
	}
	

	
	
	
}
