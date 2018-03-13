package modelo;

public class Usuario {
	
	private String password;
	private String nombre;
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	
	public Usuario(String nombre, String password) {
		super();
		this.password = password;
		this.nombre = nombre;
	}
	
}
