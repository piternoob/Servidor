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
	public String toString() {
		return "Circunferencia [radio=" + radio + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double calcularPerimetro() {
		return 0;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
