package controladores;

import java.sql.ResultSet;
import java.util.Vector;
import modelo.Actividad;
import persistencia.ActividadesMapper;

public class SistemaActividades {
	
	private  static Vector<Actividad>vActividades;
	private  static SistemaActividades instanciaSistemaActividades;
	
	//Singleton
	
	public static SistemaActividades getInstancia(){
		if(instanciaSistemaActividades==null){
			instanciaSistemaActividades=new SistemaActividades();
			
			vActividades=new Vector<Actividad>();
		}
		
		return instanciaSistemaActividades;
	}
	
	//Nueva Actividad
	public void crearActividad(String nombreActividad)
	{
		if(!existeActividad(nombreActividad)) {
	
			Actividad a = new Actividad(nombreActividad);
			vActividades.add(a);
			a.esActivo(); //Agrega una nueva actividad con estado inicial "Activo"
			ActividadesMapper.getInstance().altaActividad(a);
		}
	}
	
	//Eliminar Actividad Logicamente
	public int bajarActividad (Actividad act, int flag) {
		
		Actividad a= buscarActividad(act.getNombreActividad());
				
		if(a!=null) {
			vActividades.remove(a);
			a.bajaLogica();
			ActividadesMapper.getInstance().updateActividad(a.getNombreActividad(), a);
			return 1;
		}
		return flag;
	}
	
	//Modificar
	public void modificarActividad(String nombreActividadAux, String nombreActividad){
		
		for(Actividad a: vActividades) {
			if(a.getNombreActividad().toString().equals(nombreActividadAux)) {
				a.setNombreActividad(nombreActividad);//solo actualiza el nombre de la actividad
				a.esActivo(); //Solo actualiza el estado de la actividad
				System.out.println(a.getNombreActividad());

			}
		}
		Actividad a = new Actividad(nombreActividad,"Activo");
		ActividadesMapper.getInstance().updateActividad(nombreActividadAux,a);
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
	
	
	public ResultSet listarTodas() {
		ResultSet rta=null;
		rta =ActividadesMapper.getInstance().listarTodas();
		return rta;
	}
	

}
