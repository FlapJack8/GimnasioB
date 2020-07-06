package modelo;


public class Abono {
	
	private String TipoAbono; 
	private Float Precio;
	private int Duracion; 

	
	public Abono(String TipoAbono, Float Precio, int Duracion) {
		super();
		this.TipoAbono = TipoAbono;
		this.Precio = Precio;
		this.Duracion = Duracion;

	}
	
	
	
	public String getTipoAbono() {
		return TipoAbono;
	}

	public void setTipoAbono(String TipoAbono) {
		this.TipoAbono = TipoAbono;
	}

	public Float getPrecio() {
		return Precio;
	}

	public void setPrecio(Float Precio) {
		this.Precio = Precio;
	}

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int Duracion) {
		this.Duracion = Duracion;
	}

	
	
}
