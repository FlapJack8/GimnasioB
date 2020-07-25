package BITGym.modelo;

import java.util.Date;

public class Rol {
	protected Persona persona;
	protected String rol;
	
	 
	
	public Rol(Persona persona, String rol) {
		super();
		this.persona = persona;
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

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

	public void setFechaDeNac(Date fechaDeNac) {
		persona.setFechaDeNac(fechaDeNac);
	}
	
	public Date getFechaInicioActividades() {
		return persona.getFechaInicioActividades();
	}
	
	public void setFechaInicioActividades(Date fechaInicioActividades) {
		persona.setFechaInicioActividades(fechaInicioActividades);
	}
	
	
	
}
