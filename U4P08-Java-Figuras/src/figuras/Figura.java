package figuras;

public abstract class Figura{
	
	private Color color;
	
	@Override
	public String toString() {
		return "Figura [color=" + color + "]";
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	
	
}
