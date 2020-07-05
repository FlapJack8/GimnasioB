package modelo;

import java.sql.Blob;
import java.util.Date;

public class Socio extends Rol {
	
	Date fechaVen;
	String tipoAbono;
	Blob datosMedicos;

	public Socio(Persona persona,String rol, Date fechaVen) {
		super(persona, rol);
		//this.fechaIns = fechaIns;
		//this.fechaVen = fechaVen;
		//this.tipoAbono = tipoAbono;
		//this.datosMedicos = datosMedicos;
		//this.clienteFrecuente = clienteFrecuente;
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Socio(Persona persona,String rol, String estado) {
		super(persona, rol);
		//this.fechaIns = fechaIns;
		//this.fechaVen = fechaVen;
		//this.tipoAbono = tipoAbono;
		//this.datosMedicos = datosMedicos;
		//this.clienteFrecuente = clienteFrecuente;
	}

	public void bajaLogica() {
		persona.bajaLogica();
	}
	
	public void esActivo() {
		persona.isActivo();
	}
	
	/*public boolean isClienteFrecuente() {
		return clienteFrecuente;
	}*/

	/*public void setClienteFrecuente(boolean clienteFrecuente) {
		this.clienteFrecuente = clienteFrecuente;
	} */
	
	public String getNombreUsuario() {
		return persona.getNombreUsuario();
	}

	public void setNombreUsuario(String nombreUsuario) {
		persona.setNombreUsuario(nombreUsuario);
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

	public String getPassword() {
		return persona.getPassword();
	}

	public void setPassword(String password) {
		persona.setPassword(password);
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
	
	public Date getInicioActividades() {
		return persona.getFechaInicioActividades();
	}

	public void setFechaInicioActividades(Date fechaInicioActividades) {
		persona.setFechaInicioActividades(fechaInicioActividades);
	}

	public void setFechaDeNac(Date fechaDeNac) {
		persona.setFechaDeNac(fechaDeNac);
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


}
