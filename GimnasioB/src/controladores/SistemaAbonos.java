package controladores;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

import modelo.Abono;
import modelo.Actividad;
import modelo.Administrador;
import modelo.Operador;
import modelo.Profesor;
import modelo.Socio;
import persistencia.AbonoMapping;
import persistencia.ActividadesMapper;
import persistencia.UsrMapper;


public class SistemaAbonos {
	
	private  Vector<Abono> vAbonos; 
	private  static SistemaAbonos instanciaAbonos;
	
	//CONSTRUCTOR
	public SistemaAbonos() {
		
		vAbonos = new Vector<Abono>();
		
	}


	//SINGLETON
	public static SistemaAbonos getInstancia(){
		
		if(instanciaAbonos==null){	
			instanciaAbonos=new SistemaAbonos();
			
		}
		return instanciaAbonos;
	}
	
	public void altaAbono(String tipoAbono,Float precio,int duracion){
		
		if(!existeAbono(tipoAbono)) {
			
			Abono cl=buscarAbono(tipoAbono); 
			
			if(cl==null) {
				Abono a= new Abono(tipoAbono,  precio, duracion);//SistemaActividades.getInstancia().buscarActividadAll(nombreActividad);
				
				cl=new Abono(tipoAbono,  precio, duracion); 
				vAbonos.add(cl);
				cl.isActivo();
				AbonoMapping.getInstance().altaAbono(cl);
			}
		}
	}
	
	public ResultSet listarClases(){
		
		ResultSet rs = null;
		rs = AbonoMapping.getInstance().listarAbono();
		
		return rs;
	}

	public boolean existeAbono(String tipoAbono) {
		
		Abono c = buscarAbono( tipoAbono);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(c!=null) {
			return true;
		} else {
			return false;

		}
		
		
	}
	
	public Abono buscarAbono(String tipoAbono) {
		
		for(Abono a: vAbonos)
		{
			if(a.getTipoAbono().equals(tipoAbono)) {
					return a;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		
		Abono a = AbonoMapping.getInstance().buscarAbono(tipoAbono);
		 
		/*----Agrega Actividad PARA FUTURAS BUSQUEDAS----*/
		
		if(a!=null)
			vAbonos.add(a);
			
		return a;
	
	}
		
	


	public int deleteAbono(String tipoAbono, int flag) {

			if(tipoAbono !=null) {
				Abono a=buscarAbono(tipoAbono);
				if(a!=null) {
					vAbonos.remove(a);
					a.bajaLogica();
					AbonoMapping.getInstance().deleteAbono(a);
					return 1;
				}
			
		}
			return flag;

	}
	
	


public void updateAbono(String tipoAbono,Float precio,int duracion){
	for(Abono s: vAbonos) {
		if(s.getTipoAbono() == tipoAbono) {
			s.setDuracion(duracion);
			s.isActivo();
			s.setPrecio(precio);
			AbonoMapping.getInstance().updateAbono(s);
		}
			
	}
}

	
	
	
}
