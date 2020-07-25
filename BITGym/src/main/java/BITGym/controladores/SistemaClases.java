package BITGym.controladores;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

import BITGym.modelo.Clase;
import BITGym.modelo.Actividad;
import BITGym.modelo.Profesor;
import BITGym.modelo.Socio;
import BITGym.persistencia.ClasesMapper;
import BITGym.persistencia.UsrMapper;


public class SistemaClases {


	private  Vector<Clase> vClases; 
	private  Vector<Actividad>vActividades;
	private  Vector<Profesor>vProfes;
	private  Vector<Clase> vClasesAux;
	private  static SistemaClases instanciaSistemaClases;
	
	//CONSTRUCTOR
	public SistemaClases() {
		
		vClases = new Vector<Clase>();
		vActividades=new Vector<Actividad>();
		vProfes=new Vector<Profesor>();
		
	}


	//SINGLETON
	public static SistemaClases getInstancia(){
		
		if(instanciaSistemaClases==null){	
			instanciaSistemaClases=new SistemaClases();
			
		}
		return instanciaSistemaClases;
	}
	
	public void crearClase(String actividad, Date fecha, Time horario, String profeNombreUsr, Float duracion, int capacidadMax, int capacidadMin, String publico,String dificultad){
		
		if(!existeClase(actividad, profeNombreUsr, fecha, horario)) {
			
			Clase cl=buscarClase(actividad, profeNombreUsr, fecha, horario); 
			
			if(cl==null) {
				//SistemaActividades.getInstancia().buscarActividadAll(nombreActividad);
				
				cl=new Clase(actividad,fecha, horario, profeNombreUsr, duracion, capacidadMax, capacidadMin, publico, dificultad); 
				vClases.add(cl);
				cl.esActivo();
				ClasesMapper.getInstance().altaClase(cl);
			}
		}
	}
	
	public ResultSet listarClases(){
		
		ResultSet rs = null;
		rs = ClasesMapper.getInstance().listarClases();
		
		return rs;
	}

	public ResultSet listarClasesTodas(){
		
		ResultSet rs = null;
		rs = ClasesMapper.getInstance().listarClasesTodas();
		
		return rs;
	}
	
	public boolean existeClase(String actividad, String nombreUsuario, Date fecha, Time horario) {
		
		Clase c = buscarClase(actividad, nombreUsuario, fecha, horario);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(c!=null)
			return true;
		return false;
	}
	
	public Clase buscarClase(String actividad, String nombreUsuario, Date fecha, Time horario) {
		
		/*----Buscamos en memoria----*/
		for(Clase c: vClases)
		{
			if(c.getActividad().equals(actividad)&&c.getProfe().equals(nombreUsuario)&&c.getFecha().equals(fecha)&&c.getHorario().equals(horario)) {
					return c;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		Clase c=ClasesMapper.getInstance().buscarClase(actividad, nombreUsuario, fecha, horario);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(c!=null)
			vClases.add(c);
		return c;
	}
	
	public int eliminarClase(Clase clas, int flag) {
		
		Clase c=buscarClase(clas.getActividad(), clas.getProfe(), clas.getFecha(),clas.getHorario());
		
		if(c!=null) {
			vClases.remove(c);
			c.bajaLogica();
			ClasesMapper.getInstance().updateClase(c);
			return 1;
		}
		return flag;
		
	}
	
	public void activarClase(String actividad, String profe, Date fechaClase, Time horario) {
		
		Clase c=buscarClase(actividad, profe, fechaClase, horario);
		
		if(c!=null) {
			vClases.remove(c);
			c.esActivo();
			ClasesMapper.getInstance().updateClase(c);
		}
		
	}
}
