package modelo;

public class Producto {

	private String familia, nombre, marca, imagen;
	private int stock, id;
	private double precio;

	public Producto(String familia, String nombre, String marca, String imagen, int stock, int id, double precio) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.imagen = imagen;
		this.familia = familia;
		this.stock=stock;
		this.id=id;
		this.precio=precio;
	}

	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public double getPrecio() {return precio;}
	public void setPrecio(double precio) {this.precio = precio;}

	public String getFamilia() {return familia;}
	public void setFamilia(String familia) {this.familia = familia;}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}

	public String getMarca() {return marca;}
	public void setMarca(String marca) {this.marca = marca;}

	public String getImagen() {return imagen;}
	public void setImagen(String imagen) {this.imagen = imagen;}
	
	
}
