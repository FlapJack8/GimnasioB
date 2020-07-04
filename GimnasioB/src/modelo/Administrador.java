package modelo;

import java.util.Date;

//import controladores.SistemaCines;

public class Administrador extends Empleado {


	//CONSTRUCTOR 
	public Administrador(Persona persona,String rol,Float sueldo,String diasLaborales) {
		super(persona, rol,diasLaborales,sueldo);

	}

	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Administrador(Persona persona,String rol, String estado,Float sueldo,String diasLaborales) {
		super(persona, rol,diasLaborales,sueldo);

	}


		
		
		
}
