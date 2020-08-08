package BITGym.modelo;


public class Abono {
	private String tipoAbono; 
	private String estado;
	private Float precio;
	private int duracion;
	

	public Abono(String tipoAbono, Float precio,int duracion) {
		super();
		this.tipoAbono = tipoAbono;
		this.precio = precio;
		this.duracion = duracion;

	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	

	public Abono( String tipoAbono, int duracion, Float precio,String estado) {
		super();
		this.tipoAbono = tipoAbono;
		this.precio = precio;
		this.duracion = duracion;
		this.estado = estado;

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

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
