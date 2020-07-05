package modelo;

import java.sql.Date;

public class Operador extends Empleado {
		
	
	
	public Operador(Persona persona,String rol,Float sueldo,String diasLaborales) {
		super(persona, rol,diasLaborales,sueldo);
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Operador(Persona persona,String rol, String estado,Float sueldo,String diasLaborales) {
		super(persona, rol,diasLaborales,sueldo);
	}

	public boolean soyOperador(Persona p){
		if(p.getNombre()==this.getNombre() && p.getDni()==this.getDni()){
			return true;
		}
		else{
			return false;
		}
		
	}
} 

