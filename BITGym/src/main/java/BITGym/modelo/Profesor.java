package BITGym.modelo;

public class Profesor extends Empleado {
	private String actividades;

	public Profesor(Persona persona,String rol,Float sueldo,String diasLaborales, String actividades) {
		super(persona, rol,diasLaborales,sueldo);
		this.actividades = actividades;
	}
	
	/*----CONSTRUCTOR BAJA LOGICA----*/
	
	public Profesor(Persona persona,String rol, String estado,Float sueldo,String diasLaborales,String actividades) {
		super(persona, rol,diasLaborales,sueldo);
		this.actividades = actividades;

	}

	public boolean soyProfesor(Persona p){
		if(p.getNombre()==this.getNombre() && p.getDni()==this.getDni()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getActividades() {
		return actividades;
	}
	
	public void setActividades(String actividades) {
		this.actividades = actividades;
	}
}
