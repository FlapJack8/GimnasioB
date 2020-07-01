package modelo;

import java.sql.Date;

public class Operador extends Empleado {
		
	
	
	public Operador(Persona persona,String rol) {
		super(persona, rol);
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Operador(Persona persona,String rol, String estado) {
		super(persona, rol);
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

