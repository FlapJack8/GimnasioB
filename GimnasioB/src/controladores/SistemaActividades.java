package controladores;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.Actividad;
import persistencia.ActividadesMapper;

public class SistemaActividades {
	
	private  Vector<Actividad>vActividades;
	private  static SistemaActividades instanciaSistemaActividades;
	
	//Constructor
	public SistemaActividades() {
		
		vActividades=new Vector<Actividad>();
				
	}
	
	//Singleton
	
	public static SistemaActividades getInstancia(){
		if(instanciaSistemaActividades==null){
			instanciaSistemaActividades=new SistemaActividades();
		}
		
		return instanciaSistemaActividades;
	}
	
	//Nueva Actividad
	public void crearActividad(String nombreActividad,String estadoActividad)
	{
		if(!existeActividad(nombreActividad)) {
	
			Actividad a = new Actividad(nombreActividad,estadoActividad);
			vActividades.add(a);
			a.esActivo(); //Agrega una nueva actividad con estado inicial "Activo"
			ActividadesMapper.getInstance().altaActividad(a);
		}
	}
	
	//Eliminar Actividad fisicamente
	public int bajarActividad (Actividad act, int flag) {
		
		Actividad a= buscarActividad(act.getNombreActividad());
				
		if(a!=null) {
			vActividades.remove(a);
			a.bajaLogica();
			ActividadesMapper.getInstance().updateActividad(a);
			return 1;
		}
		return flag;
	}
	
	//Modificar
	public void modificarActividad(String nombreActividad, String estado){
		
		for(Actividad a: vActividades) {
			if(a.getNombreActividad().toString().equals(nombreActividad) && a.getEstado().toString().contentEquals(estado))
				a.setNombreActividad(nombreActividad);//solo actualiza el nombre de la actividad
			
			a.bajaLogica(); //Solo acutaliza el estado de la actividad
			ActividadesMapper.getInstance().updateActividad(a);
		}
	
	}
	
	
	public boolean existeActividad (String nombreActividad) {

		Actividad a = buscarActividad(nombreActividad);
		if(a!=null)
			return true;

		return false;		
	}
	
	
	public Actividad buscarActividad(String nombreActividad) {
		
		/*----Buscamos en memoria----*/
		for(Actividad a: vActividades)
		{
			if(a.getNombreActividad().equals(nombreActividad)) {
					return a;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		
		Actividad a = ActividadesMapper.getInstance().buscarActividad(nombreActividad);
		 
		/*----Agrega Actividad PARA FUTURAS BUSQUEDAS----*/
		
		if(a!=null)
			vActividades.add(a);
			
		return a;
	}
	
	public ResultSet listar() {
		ResultSet rta=null;
		rta =ActividadesMapper.getInstance().listar();
		return rta;
	}
	
	

}
