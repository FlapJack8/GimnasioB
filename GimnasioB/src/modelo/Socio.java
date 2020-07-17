package modelo;

import java.io.FileInputStream;
import java.sql.Blob;
import java.util.Date;

public class Socio extends Rol {
	
	private Date fechaVen;
	private String tipoAbono;
	private FileInputStream datosMedicos;

	public Socio(Persona persona,String rol, Date fechaVen, String tipoAbono, FileInputStream datosMedicos) {
		super(persona, rol);
		//this.fechaIns = fechaIns;
		this.fechaVen = fechaVen;
		this.tipoAbono = tipoAbono;
		this.datosMedicos = datosMedicos;
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Socio(Persona persona,String rol, String estado, Date fechaVen, String tipoAbono, FileInputStream datosMedicos) {
		super(persona, rol);
		//this.fechaIns = fechaIns;
		this.fechaVen = fechaVen;
		this.tipoAbono = tipoAbono;
		this.datosMedicos = datosMedicos;
	}

	public void bajaLogica() {
		persona.bajaLogica();
	}
	
	public void esActivo() {
		persona.isActivo();
	}

	public String getEmail() {
		return persona.getEmail();
	}

	public void setEmail(String email) {
		persona.setEmail(email);
	}

	public String getNombre() {
		return persona.getNombre();
	}

	public void setNombre(String nombre) {
		persona.setNombre(nombre);
	}

	public String getDomicilio() {
		return persona.getDomicilio();
	}

	public void setDomicilio(String domicilio) {
		persona.setDomicilio(domicilio);
	}

	public int getDni() {
		return persona.getDni();
	}

	public void setDni(int dni) {
		persona.setDni(dni);
	}

	public Date getFechaDeNac() {
		return persona.getFechaDeNac();
	}
	
	public void setFechaDeNac(Date fechaDeNac) {
		persona.setFechaDeNac(fechaDeNac);
	}
	
	public Date getInicioActividades() {
		return persona.getFechaInicioActividades();
	}

	public void setFechaInicioActividades(Date fechaInicioActividades) {
		persona.setFechaInicioActividades(fechaInicioActividades);
	}
	
	public String getEstado() {
		return persona.getEstado();
	}

	public Date getFechaVen() {
		return fechaVen;
	}

	public void setFechaVen(Date fechaVen) {
		this.fechaVen = fechaVen;
	}
	public String getTipoAbono() {
		return tipoAbono;
	}
	public void setTipoAbono(String tipoAbono) {
		this.tipoAbono = tipoAbono;
	}
	
	public FileInputStream getDatosMedicos() {
		return datosMedicos;
	}
	public void setDatosMedicos(FileInputStream datosMedicos) {
		this.datosMedicos = datosMedicos;
	}
}
