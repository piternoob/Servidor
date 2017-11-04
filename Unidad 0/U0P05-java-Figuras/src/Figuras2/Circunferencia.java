package Figuras2;

public class Circunferencia extends Figura{
	private double radio;

	public Circunferencia(double radio, String titulo, Color color) {
		super.setColor(color);
		super.setTitulo(titulo);
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public double calcularPerimetro() {
		return 2*Math.PI*radio;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(radio, 2);
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + ", calcularPerimetro()=" + calcularPerimetro() + ", calcularArea()="
				+ calcularArea() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
