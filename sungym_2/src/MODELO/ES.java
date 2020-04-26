package MODELO;


/**
 * Clase que define los atributos y metodos de E/S.
 * @author Sol M. Marín
 * @version 1
 *
 */
public class ES {
	//Atributos
	private int idES;
	private int idGym;
	private String idCliente;
	private String fechaHora;
	private boolean eS;
	
	//Constructor
	public ES(int idGym, String idCliente, String fechaHora, boolean eS) {
		super();
		this.idGym = idGym;
		this.idCliente = idCliente;
		this.fechaHora = fechaHora;
		this.eS = eS;
	}

	//Getters y setters
	public int getIdES() {
		return idES;
	}

	public void setIdES(int idES) {
		this.idES = idES;
	}

	public int getIdGym() {
		return idGym;
	}

	public void setIdGym(int idGym) {
		this.idGym = idGym;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	public boolean iseS() {
		return eS;
	}

	public void seteS(boolean eS) {
		this.eS = eS;
	}
	
	//Metodos
	
	@Override
	public String toString() {
		return "ES [idES=" + idES + ", idGym=" + idGym + ", idCliente=" + idCliente + ", fechaHora=" + fechaHora
				+ ", eS=" + eS + "]\n";
	}
	

}
