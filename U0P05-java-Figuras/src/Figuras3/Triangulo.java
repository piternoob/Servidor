package Figuras3;

public class Triangulo extends Figura{
	private double base, altura;
	
	public Triangulo(double base, double altura, String titulo, Color color) {
		super.setColor(color);
		super.setTitulo(titulo);
		this.base=base;
		this.altura=altura;
	}

	public double getBase() {
		return base;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return base+altura+Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return base*altura/2;
	}

	@Override
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + ", calcularPerimetro()=" + calcularPerimetro()
				+ ", calcularArea()=" + calcularArea() + ", toString()=" + super.toString() + "]";
	}
	
	
}
