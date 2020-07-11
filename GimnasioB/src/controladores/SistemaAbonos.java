package controladores;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

import modelo.Abono;
import persistencia.AbonoMapping;


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
	
	public void crearClase(String tipoAbono,String estado,Float precio,int duracion,int idAbono){
		
		if(!existeAbono(tipoAbono, estado, precio, duracion, idAbono)) {
			
			Abono cl=buscarAbono(tipoAbono, estado, precio, duracion, idAbono); 
			
			if(cl==null) {
				Abono a= new Abono(tipoAbono, estado, precio, duracion, idAbono);//SistemaActividades.getInstancia().buscarActividadAll(nombreActividad);
				
				cl=new Abono(tipoAbono, estado, precio, duracion, idAbono); 
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

	public boolean existeAbono(String tipoAbono,String estado,Float precio,int duracion,int idAbono) {
		
		Abono c = buscarAbono( tipoAbono, estado, precio, duracion, idAbono);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(c!=null)
			return true;
		return false;
	}
	
	public Abono buscarAbono(String tipoAbono,String estado,Float precio,int duracion,int idAbono) {
		
		
		/*----Si no esta, buscamos en BD----*/
		Abono c=AbonoMapping.getInstance().buscarAbono(tipoAbono);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(c!=null)
			vAbonos.add(c);
		return c;
	}
	
	public int eliminarAbono(String tipoAbono,String estado,Float precio,int duracion,int idAbono) {
		
		Abono c=buscarAbono( tipoAbono, estado, precio, duracion, idAbono);
		
		if(c!=null) {
			vAbonos.remove(c);
			c.bajaLogica();
			AbonoMapping.getInstance().updateAbono(c);
			return 1;
		}
		return 2;
		
	}
	
}
