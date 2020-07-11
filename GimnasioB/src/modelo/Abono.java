package modelo;


public class Abono {
	private String tipoAbono; 
	private String estado;
	private Float precio;
	private int duracion;
	private int idAbono;
	

	public Abono(String tipoAbono,String estado,Float precio,int duracion,int idAbono) {
		super();
		this.tipoAbono = tipoAbono;
		this.estado = estado;
		this.precio = precio;
		this.duracion = duracion;
		this.idAbono = idAbono;

	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	

	public Abono(int idAbono2, String tipoAbono2, int duracion2, Float precio2) {
		// TODO Auto-generated constructor stub
	}

	public void isActivo() {
		this.estado="Activo";
	}
	
	public void bajaLogica() {
		this.estado = "Inactivo";
	}
	
	public String getTipoAbono() {
		return tipoAbono;
	}

	public void setTipoAbono(String tipoAbono) {
		this.tipoAbono = tipoAbono;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getIdAbono() {
		return idAbono;
	}

	public void setIdAbono(int idAbono) {
		this.idAbono = idAbono;
	}
	public String estado() {
		return estado;
	}

	public void estado(String estado) {
		this.estado = estado;
	}

	
}
