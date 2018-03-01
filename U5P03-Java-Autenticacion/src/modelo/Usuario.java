package modelo;

public class Usuario {
	private String login;
	private String password;
	private String nombre;
	private boolean admin;
	private String descripcion;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		if(admin) {
			return "<p><ul><li>login:" + login + "</li><li> password: " + password + "</li><li> nombre: " + nombre + "</li><li> descripcion: "
					+ descripcion + "</li><li> administrador: si </li></p></ul>";
		}else {
			return "<p><ul><li>login:" + login + "</li><li> password: " + password + "</li><li> nombre: " + nombre + "</li><li> descripcion: "
					+ descripcion + "</li><li> administrador: no </li></p></ul>";
		}
	}
	
	public Usuario(String login, String password, String nombre, boolean admin, String descripcion) {
		super();
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.admin = admin;
		this.descripcion = descripcion;
	}
	
}
