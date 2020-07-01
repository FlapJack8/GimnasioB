package modelo;

import java.util.Date;

public class Empleado extends Rol {

	public Empleado(Persona persona,String rol) {
		super(persona, rol);	
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Empleado(Persona persona,String rol, String estado) {
		super(persona, rol);
	}
	
	/*----Metodos BD----*/
	public void bajaLogica() {
		persona.bajaLogica();
	}
	
	public void esActivo() {
		persona.isActivo();
	}
	/*------------------*/
	
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
