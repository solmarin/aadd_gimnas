package MODELO;


/**
 * Clase que define los atributos y metodos de un usuario.
 * 
 * @author Sol M. Marín
 * @version 1
 *
 */
public class Usuario {
	//Atributos
	private String DNI;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String direccion;
	private String contrasena;
	private String datos;
	private boolean rol;
	private boolean deudor;
	
	//Constructor
	public Usuario(String DNI, String nombre, String apellidos, String fechaNacimiento, String direccion,
			String contrasena, String datos, boolean rol, boolean deudor) {
		super();
		this.DNI = DNI;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.contrasena = contrasena;
		this.datos = datos;
		this.rol = rol;
		this.deudor = deudor;
	}

	//Getters y Setters
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getcontrasena() {
		return contrasena;
	}

	public void setcontrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public boolean isRol() {
		return rol;
	}

	public void setRol(boolean rol) {
		this.rol = rol;
	}

	public boolean isDeudor() {
		return deudor;
	}

	public void setDeudor(boolean deudor) {
		this.deudor = deudor;
	}

	//metodos
	@Override
	public String toString() {
		return "Usuario [DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + ", contrasena=" + contrasena + ", datos=" + datos
				+ ", rol=" + rol + ", deudor=" + deudor + "]\n";
	}
	
	

}
