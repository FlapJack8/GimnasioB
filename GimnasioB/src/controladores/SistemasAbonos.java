package controladores;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Vector;
import java.sql.Date;

import javax.swing.text.DateFormatter;

import modelo.Abono;
import modelo.Administrador;
import modelo.Operador;
import modelo.Persona;
import modelo.Profesor;
import modelo.Socio;
import persistencia.AbonoMapping;
import persistencia.UsrMapper;

public class SistemasAbonos {
/*----CREO VECTORES DE USUARIOS----*/
	
	private static Vector <Abono> vAbono;
	
	private static SistemasAbonos instanciaSistemasAbonos;
	
	/*----------------------------*/
	
	/*----SINGLETON----*/
	
	public static SistemasAbonos getInstancia(){
		if(instanciaSistemasAbonos==null){
			instanciaSistemasAbonos=new SistemasAbonos();
			vAbono=new Vector<Abono>();
			
					}
		return instanciaSistemasAbonos;
	}
	
	/*-----------------*/
	
	/**
	 *****************************************
	 * 1) CREO USUARIO
	 * 2) ELIMINO CLIENTE
	 * 3) MODIFICAR CLIENTE
	 * 4) CREO EMPLEADO
	 * 5) ELIMINO EMPLEADO
	 * 6) MODIFICAR EMPLEADO
	 * 7) VERIFICAR USUARIO
	 * 8) BUSCAR CLIENTE
	 * 9) EXISTE USUARIO (EMPLEADO - CLIENTE)
	 * 10) BUSCAR EMPLEADO
	 *     a) 
	 *     b) Administrador
	 *     c) 
	 *     d) Operador
	 * 11) EXISTE USUARIO EN MEMORIA
	 * 12) GET Y SET DEL CONTROLADOR
	 *****************************************
	 */
	
	
	/*-------------------------------
	 *  *    1)  CREO ABONO    *  *
	 *-------------------------------
	 */
	
	public void altaAbono(int IdAbono,String tipoAbono, int duracion, Float precio)
	{
		if(!ExisteAbono(tipoAbono)) {
	
			Abono p = new Abono( IdAbono,tipoAbono,duracion,precio);
			Vector<Abono> vSocios;
			vSocios.add(p);			
			p.isActivo();
			AbonoMapping.getInstance().insert(IdAbono, tipoAbono,  duracion,  precio);
		}
	}

	/*-----------------*/
	
	/*----------------------------------
	 *  *    2)  ELIMINO SOCIO    *  *
	 *----------------------------------
	 */
	
	 public int bajaAbono(int IdAbono,String tipoAbono, int duracion, Float precio,int flag){

		if(tipoAbono != null) {
			Abono v=buscarAbono(tipoAbono);
			if(v!=null) {
				vAbono.remove(v);
				v.bajaLogica();
				AbonoMapping.getInstance().updateAbono(v);
				flag = 1;
			}
		}
		return flag;
	}
	
	/*-----------------*/
	
	/*------------------------------------
	 *  *    3)  MODIFICAR ABONO    *  *
	 *------------------------------------
	 */

	public void modificarAbono(int IdAbono,String tipoAbono, int duracion, Float precio){
		for(Abono s: vAbono) {
			if(s.getTipoAbono() == tipoAbono) {
				s.setIdAbono(IdAbono);
				s.setTipoAbono(tipoAbono);
				s.setDuracion(duracion);
				s.setPrecio(precio);
				AbonoMapping.getInstance().updateAbono(s);
			}
				
		}
	}

	
	
	/*--------------------------------
	 *  *    8) BUSCAR ABONO    *  *
	 *--------------------------------
	 */
	
	/*-----BUSCAR SOCIO DENTRO DEL VECTOR vSocios------------*/

	  public Abono buscarAbono(String tipoAbono) {
		
		/*----Buscamos en memoria----*/
		for(Abono s: vAbono)
		{
			if(s.getTipoAbono() == tipoAbono) {
					return s;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		Abono s=AbonoMapping.getInstance().buscarAbono(tipoAbono);
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		if(s!=null)
			vAbono.add(s);
		return s;
	}
	
	/*-----------------*/
	
	/*----------------------------------------------------
	 *  *    9) EXISTE USUARIO (EMPLEADO - CLIENTE)   *  *
	 *----------------------------------------------------
	 */
	public boolean ExisteAbono (String tipoAbono) {//Hace mas o menos lo mismo que buscarX pero devuelve un boolean

		Abono a = buscarAbono(tipoAbono);

		if(a!=null)
			return true;
		
		return false;
		
	}
	

	/*-------------------------------------------
	 *  *    12) GET Y SET DEL CONTROLADOR    *  *
	 *-------------------------------------------
	 */
	
	public static SistemasAbonos getInstanciaSistemasAbonos() {
		return instanciaSistemasAbonos;
	}

	public static void setInstanciaSistemaUsuarios(SistemasAbonos instanciaSistemasAbonos) {
		SistemasAbonos.instanciaSistemasAbonos = instanciaSistemasAbonos;
	}
	
	/*-----------------*/
	
/*----------------------------------------------------------------------------*/
	
		public void imprimirAbono() {
		
		for(Abono a: vAbono) { //For each
			String tipoAbono = new String();
			int IdAbono;
			Float precio;
		    int duracion;
		    tipoAbono=a.getTipoAbono();
		    IdAbono=a.getIdAbono();
		    precio=a.getPrecio();
		    duracion=a.getDuracion();
			System.out.printf("%d -  %s  - Abonos: %s \n",tipoAbono,IdAbono,precio,duracion);
			
		}
		System.out.println("\n");
				
		

	}


}
