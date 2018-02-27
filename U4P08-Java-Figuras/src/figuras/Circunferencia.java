package figuras;

public class Circunferencia extends Figura{
	
	private int radio;

	public Circunferencia(Color color, int radio) {
		super.setColor(color);
		this.radio=radio;
	}

	public int getRadio() {return radio;}

	public void setRadio(int radio) {this.radio = radio;}

	@Override
	public String toString() {
		return super.toString()+"Circunferencia [radio=" + radio + "]";
	}
	
	
	
}
