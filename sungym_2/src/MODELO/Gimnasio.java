package MODELO;
/**
 * Clase que define los atributos y metodos de un gimnasio.
 * @author Sol Marín
 * @version 1
 *
 */

public class Gimnasio {
	//Atributos
	private int idGym;
	private String nombre;
	private String direccion;
	
	//Constructor
	public Gimnasio(int idGym, String nombre, String direccion) {
		super();
		this.idGym = idGym;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	//Getters y Setters
	public int getIdGym() {
		return idGym;
	}

	public void setIdGym(int idGym) {
		this.idGym = idGym;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	//Metodos
	@Override
	public String toString() {
		return "Gimnasio [idGym=" + idGym + ", nombre=" + nombre + ", direccion=" + direccion + "]\n";
	}
	
	

}
