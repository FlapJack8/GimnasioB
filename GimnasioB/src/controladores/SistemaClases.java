package controladores;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

import modelo.Clase;
import modelo.Actividad;
import modelo.Profesor;
import modelo.Socio;
import persistencia.ClasesMapper;
import persistencia.UsrMapper;


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
				Actividad a= new Actividad("zumba");//SistemaActividades.getInstancia().buscarActividadAll(nombreActividad);
				
				cl=new Clase(actividad,fecha, horario, profeNombreUsr, duracion, capacidadMax, capacidadMin, publico, dificultad); 
				vClases.add(cl);
				cl.esActivo();
				ClasesMapper.getInstance().altaClase(cl);
			}
		}
	}
	
	public ResultSet getDatosClases(){
		

	}
	
	public Actividad buscarActividadAll(String actividad, Profesor p) {
		Actividad a= buscarActividad(actividad); 
		if(a==null) {
			a=ActividadesMapper.getInstance().buscarPeliculaBD(actividad); 
			vActividades.add(a);//Agrego a memoria para que futuros cambios. 
		}
		return a;
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
}
