package figuras;

public class Cuadrado extends Figura{
	
	private int lado;
	
	public Cuadrado (Color color, int lado) {
		super.setColor(color);
		this.lado=lado;
	}

	public int getLado() {return lado;}

	public void setLado(int lado) {this.lado = lado;}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	
	
}
