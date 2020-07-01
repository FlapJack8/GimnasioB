package modelo;

import java.util.Date;

public class Cliente extends Rol {
	
	private boolean clienteFrecuente;

	public Cliente(Persona persona, boolean clienteFrecuente,String rol) {
		super(persona, rol);
		this.clienteFrecuente = clienteFrecuente;
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Cliente(Persona persona, boolean clienteFrecuente,String rol, String estado) {
		super(persona, rol);
		this.clienteFrecuente = clienteFrecuente;
	}

	public void bajaLogica() {
		persona.bajaLogica();
	}
	
	public void esActivo() {
		persona.isActivo();
	}
	
	public boolean isClienteFrecuente() {
		return clienteFrecuente;
	}

	public void setClienteFrecuente(boolean clienteFrecuente) {
		this.clienteFrecuente = clienteFrecuente;
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
	
	public String getEstado() {
		return persona.getEstado();
	}



}
