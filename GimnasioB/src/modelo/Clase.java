package modelo;
import java.sql.Date;
import java.sql.Time;

import modelo.Actividad;
import modelo.Profesor;


public class Clase {

	private String actividad;
	private Date fecha;
	private Time horario;
	private String profeNombreUsr;
	private Float duracion;
	private int capacidadMax;
	private int capacidadMin; 
	private String publico;
	private String dificultad;
	private String estado;
	
	public Clase(String actividad, Date fecha, Time horario, String profeNombreUsr, Float duracion, int capacidadMax, int capacidadMin, String publico,String dificultad) {
		super();
		this.actividad = actividad;
		this.fecha = fecha;
		this.horario = horario;
		this.profeNombreUsr=profeNombreUsr;
		this.duracion = duracion;
		this.capacidadMax = capacidadMax;  
		this.capacidadMin= capacidadMin;
		this.publico= publico;
		this.dificultad= dificultad;

	}
	public Clase(String actividad, Date fecha, Time horario, String profeNombreUsr, Float duracion, int capacidadMax, int capacidadMin, String publico,String dificultad, String estado) {
		super();
		this.actividad = actividad;
		this.fecha = fecha;
		this.horario = horario;
		this.profeNombreUsr=profeNombreUsr;
		this.duracion = duracion;
		this.capacidadMax = capacidadMax;  
		this.capacidadMin= capacidadMin;
		this.publico= publico;
		this.dificultad= dificultad;
		this.estado = estado;	
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getProfe() {
		return profeNombreUsr;
	}

	public void setProfe(String profeNombreUsr) {
		this.profeNombreUsr = profeNombreUsr;
	}

	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	public int getCapacidadMax() {
		return capacidadMax;
	}

	public void setCapacidadMax(int capacidadMax) {
		this.capacidadMax = capacidadMax;
	}

	public int getCapacidadMin() {
		return capacidadMin;
	}

	public void setCapacidadMin(int capacidadMin) {
		this.capacidadMin = capacidadMin;
	}

	public String getPublico() {
		return publico;
	}

	public void setPublico(String publico) {
		this.publico = publico;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public Time getHorario() {
		return horario;
	}
	public void setHorario(Time horario) {
		this.horario = horario;
	}

	public String getEstado() {
		return estado;
	}

	//Metodos para BD
	
	public void bajaLogica() {
		this.estado="Inactivo";
	}
	
	public void esActivo() {
		 this.estado="Activo";
	}
}

