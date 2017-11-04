##### *Desarrollo Web en Entorno Servidor - Curso 2017/2018 - IES Leonardo Da Vinci - Alberto Ruiz*
## U0P05 - Figuras
#### Entrega de: *Pedro Plaza Ramos*
----

#### 1. Descripción:

Vamos a utilizar el enfoque orientado a objetos para solucionar un problema trigonométrico, repasando conceptos como clases y objetos, herencia y polimorfismo, colecciones, o JavaDoc.

#### 2. Formato de entrega:

Incluye al final de este documento el código de las clases que hayas programado, así como el resultado de ejecución.

Puedes utilizar bloques de código Markdown o capturas de Eclipse.

#### 3. Trabajo a realizar:

#### Parte 1: Clases y objetos

Crea un paquete llamado `figuras` y codifica las clases Cuadrado, Triangulo y Circunferencia. Incluye en todas un método para imprimir sus datos. Después codifica una clase *Problema* que calcule el área y el perímetro de la siguiente figura:

![](U0P05-1.png "...")

##### Código de la clase Cuadrado:

```java
public class Cuadrado {
	private double lado;

	public Cuadrado (double lado) {
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}

	public double calcularPerimetro() {
		return lado*4;
	}

	public double calcularArea() {
		return Math.pow(lado, 2);
	}
}
```

##### Código de la clase Triángulo:

```java
public class Triangulo {
	private double base, altura;

	public Triangulo(double base, double altura) {
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
	public String toString() {
		return "Triangulo [base=" + base + ", altura=" + altura + "]";
	}

	public double calcularPerimetro() {
		return base+altura+Math.sqrt(Math.pow(base, 2)+Math.pow(altura, 2));
	}

	public double calcularArea() {
		return base*altura/2;
	}

}
```

##### Código de la clase Circunferencia:

```java
public class Circunferencia {
	private double radio;

	public Circunferencia(double radio) {
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	@Override
	public String toString() {
		return "Circunferencia [radio=" + radio + "]";
	}

	public double calcularPerimetro() {
		return 2*Math.PI*radio;
	}

	public double calcularArea() {
		return Math.PI*Math.pow(radio, 2);
	}

}
```

##### Código del método main en la clase Problema:

```java
public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;

		cir1=new Circunferencia(4.8);
		cir2=new Circunferencia(1.5);
		cua1=new Cuadrado(4.2);
		tri1=new Triangulo(8, 15);

		calcularArea(cir1, cir2, cua1, tri1);
		calcularPerimetro(cir1, cir2, cua1, tri1);
	}

	public static void calcularArea(Circunferencia cir1, Circunferencia cir2, Cuadrado cua1, Triangulo tri1) {
		double aTotal, aCir1, aCir2, aCua1, aTri1;

		aCir1=cir1.calcularArea();
		aCir2=cir2.calcularArea();
		aCua1=cua1.calcularArea();
		aTri1=tri1.calcularArea();

		aTotal=aCir1/2+aCir2*0.75+aCua1+aTri1;

		System.out.println("El area de la figura es: "+aTotal+".");
	}

	public static void calcularPerimetro(Circunferencia cir1, Circunferencia cir2, Cuadrado cua1, Triangulo tri1) {
		double pTotal, pCir1, pCir2, pCua1, pTri1;

		pCir1=cir1.calcularPerimetro();
		pCir2=cir2.calcularPerimetro();
		pCua1=cua1.calcularPerimetro();
		pTri1=tri1.calcularPerimetro();

		pTotal=pCir1/2+pCir2*0.75+pCua1*0.75+pTri1-cir1.getRadio()*2-cir2.getRadio()*2-cua1.getLado();

		System.out.println("El perimetro de la figura es: "+pTotal+".");
	}

}
```

##### Ejecución del método main:

    El area de la figura es: 119.13258497228719.
    El perimetro de la figura es: 57.94822820780804.

#### Parte 2: Herencia

Queremos que todas las figuras tengan un título y un color. Para el color puedes utilizar un tipo enumerado Color con al menos cinco valores.

1. Define una clase Figura con estos nuevos atributos
- Haz que nuestras clases de figuras hereden dichos atributos
- ¿Crees que la clase Figura debería ser abstracta? ¿Y los métodos de calcular áreas y perímetros? Si es así haz las modificaciones necesarias
- Utilizando la *reescritura*, haz que de cada figura se impriman en pantalla tanto sus atributos heredados (color y título) como los propios de esa figura particular.
- Crea una clase Principal con un método main en el que instancies diferentes figuras por este procedimiento y escribas sus datos por pantalla.

##### Código de la clase Figura:

```java
public abstract class Figura {

	private String titulo;
	private Color color;

	public abstract double calcularPerimetro();
	public abstract double calcularArea();

	@Override
	public String toString() {
		return "Figura [titulo=" + titulo + ", color=" + color + "]";
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
```

##### Código de la clase Cuadrado una vez modificada:

```java
public class Cuadrado extends Figura{
	private double lado;

	public Cuadrado (double lado, String titulo, Color color) {
		super.setColor(color);
		super.setTitulo(titulo);
		this.lado=lado;
	}

	public double getLado() {
		return lado;
	}

	@Override
	public double calcularPerimetro() {
		// TODO Auto-generated method stub
		return lado*4;
	}

	@Override
	public double calcularArea() {
		// TODO Auto-generated method stub
		return Math.pow(lado, lado);
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + ", calcularPerimetro()=" + calcularPerimetro() + ", calcularArea()="
				+ calcularArea() + ", toString()=" + super.toString() + "]";
	}
}
```

##### Código del método main en la clase Principal:

```java
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;

		cir1=new Circunferencia(4.8,"Círculo 1", Color.Azul);
		cir2=new Circunferencia(1.5,"Círculo 2", Color.Amarillo);
		cua1=new Cuadrado(4.2,"Cuadrado 1", Color.Naranja);
		tri1=new Triangulo(8, 15,"Triángulo 1", Color.Rojo);

		System.out.println(cir1.toString()+"\n"+
				cir2.toString()+"\n"+
				cua1.toString()+"\n"+
				tri1.toString());
	}
```

##### Ejecución del método main:

    Circunferencia [radio=4.8, calcularPerimetro()=30.159289474462014, calcularArea()=72.38229473870884, toString()=Figura [titulo=Círculo 1, color=Azul]]
    Circunferencia [radio=1.5, calcularPerimetro()=9.42477796076938, calcularArea()=7.0685834705770345, toString()=Figura [titulo=Círculo 2, color=Amarillo]]
    Cuadrado [lado=4.2, calcularPerimetro()=16.8, calcularArea()=414.6169186012969, toString()=Figura [titulo=Cuadrado 1, color=Naranja]]
    Triangulo [base=8.0, altura=15.0, calcularPerimetro()=40.0, calcularArea()=60.0, toString()=Figura [titulo=Triángulo 1, color=Rojo]]


#### Parte 3: Colecciones

1. Codifica una clase GestorFiguras con un único atributo (un ArrayList de figuras) y los siguientes métodos, teniendo cuidado de documentar con código JavaDoc:
  - **constructor**: no recibirá ningún valor pero inicializará el ArrayList
  - **añadirFigura**: recibirá un objeto de la clase Figura y lo añadirá a la lista siempre que no tenga el mismo título
  - **eliminarFigura**: eliminará una figura a partir de su título
  - **mostrarFiguras**: escribirá por pantalla de forma ordenada los datos de todas las figuras del gestor
  - **calcularSumatorioAreas**: escribirá la suma de las áreas de todas las figuras

2. Modifica el método main de la clase Principal para crear un gestor de figuras y hacer pruebas con él: añadir alguna, eliminarla, imprimirlas...

##### Código de la clase GestorFiguras:

```java
import java.util.ArrayList;

/**
 * Clase GestorFiguras con un ArrayList que gestionará nuestras figuras
 * @author Pedro Plaza
 */

public class GestorFiguras {

	private ArrayList<Figura> array;

	/**
	 * Constructor de la clase, inicializa el ArrayList
	 */
	public GestorFiguras() {
		array=new ArrayList<Figura>();
	}

	/**
	 * Método añadirFigura que nos añade una figura a nuestro ArrayList
	 * @param f1 es el objeto que vamos a añadir al ArrayList
	 */
	public void añadirFigura(Figura f1) {
		System.out.println("Añadiendo figura...");
		array.add(f1);
	}

	/**
	 * Método eliminarFigura que nos elimina una figura de nuestro ArrayList en caso de que este guardada
	 * @param f1 es el objeto que vamos a intentar eliminar del ArrayList
	 */
	public void eliminarFigura(Figura f1) {

		if (array.contains(f1)) {
			System.out.println("Eliminando figura...");
			array.remove(f1);
		}
		else
			System.out.println("No se ha encontrado la figura");

	}

	/**
	 * Método mostrarFiguras que visualizará el método toString de cada figura de nuestro ArrayList
	 */
	public void mostrarFiguras() {
		System.out.println("Mostrando todas las figuras...");
		for(Figura f : array)
			System.out.println(f.toString());
	}

	/**
	 * Método calcularSumatorioAreas que nos va sumando las areas de cada figura del ArrayList
	 * @return suma devuelve el sumatorio de todas las areas de Arraylist
	 */
	public double calcularSumatorioAreas() {
		double suma=0;
		for(Figura f : array)
			suma+=f.calcularArea();
		return suma;
	}
}
```

##### Código del método main en la clase Principal:

```java
public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorFiguras gestor=new GestorFiguras();
		Circunferencia cir1, cir2;
		Cuadrado cua1;
		Triangulo tri1;

		cir1=new Circunferencia(4.8,"Círculo 1", Color.Azul);
		cir2=new Circunferencia(1.5,"Círculo 2", Color.Amarillo);
		cua1=new Cuadrado(4.2,"Cuadrado 1", Color.Naranja);
		tri1=new Triangulo(8, 15,"Triángulo 1", Color.Rojo);

		gestor.añadirFigura(cir1);
		gestor.añadirFigura(cir2);
		gestor.añadirFigura(cua1);
		//gestor.añadirFigura(tri1);

		gestor.eliminarFigura(tri1);
		gestor.eliminarFigura(cir2);

		gestor.mostrarFiguras();

		System.out.println("La suma de todas las areas es: "+gestor.calcularSumatorioAreas());
	}
```

##### Ejecución del método main:

    Añadiendo figura...
    Añadiendo figura...
    Añadiendo figura...
    No se ha encontrado la figura
    Eliminando figura...
    Mostrando todas las figuras...
    Circunferencia [radio=4.8, calcularPerimetro()=30.159289474462014, calcularArea()=72.38229473870884, toString()=Figura [titulo=Círculo 1, color=Azul]]
    Cuadrado [lado=4.2, calcularPerimetro()=16.8, calcularArea()=414.6169186012969, toString()=Figura [titulo=Cuadrado 1, color=Naranja]]
    La suma de todas las areas es: 486.9992133400057
