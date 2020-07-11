package modelo;

public class Actividad {
	private String nombreActividad;
	private String estado;

	// CONSTRUCTOR
	public Actividad(String nombreActividad) {
		super();
		this.nombreActividad = nombreActividad;
	}
	
	public Actividad(String nombreActividad, String estado) {
		super();
		this.nombreActividad = nombreActividad;
		this.estado = estado;
	}

	public String getNombreActividad() {
		return nombreActividad;
	}

	public void setNombreActividad(String nombreActividad) {
		this.nombreActividad = nombreActividad;
	}

	public String getEstado() {
		return estado;
	}
	//Metodos que utilizo en la base de datos
	public void bajaLogica() {
		this.estado = "Inactivo";	
	}
	
	public void esActivo() {
		this.estado="Activo";
	}
}
