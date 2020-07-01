package modelo;

import java.util.Date;

public class Persona {
	private String nombreUsuario; 
	private String email;
	private String nombre; 
	private String password; 
	private String domicilio;  
	private int dni; 
	private Date fechaDeNac;
	private String rol;
	private String estado;

	public Persona(String nombreUsuario, String email, String nombre, String password, String domicilio, int dni,
			Date fechaDeNac, String rol) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.domicilio = domicilio;
		this.dni = dni;
		this.fechaDeNac = fechaDeNac;
		this.rol = rol;

	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Persona(String nombreUsuario, String email, String nombre, String password, String domicilio, int dni,
			Date fechaDeNac, String rol, String estado) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		this.domicilio = domicilio;
		this.dni = dni;
		this.fechaDeNac = fechaDeNac;
		this.rol = rol;
		this.estado = estado;
	}

	public void isActivo() {
		this.estado="Activo";
	}
	
	public void bajaLogica() {
		this.estado = "Inactivo";
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFechaDeNac() {
		return fechaDeNac;
	}

	public void setFechaDeNac(Date fechaDeNac) {
		this.fechaDeNac = fechaDeNac;
	} 
	
	public boolean sosCliente(){
		return false;
		
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getEstado() {
		return estado;
	}

	
}
