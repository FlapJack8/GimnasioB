package controladores;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import java.util.Collection;
import java.util.Vector;
import modelo.Abono;
import modelo.Administrador;
import modelo.Operador;
import modelo.Persona;
import modelo.Socio;
import persistencia.AbonoMapping;
import persistencia.UsrMapper;




public class SistemasAbonos {
	
	private static Vector <Abono> vAbonos;
	private static SistemasAbonos instanciaSistemasAbonos;
	/*----SINGLETON----*/
	
	public static SistemasAbonos getInstancia(){
		if(instanciaSistemasAbonos==null){
			instanciaSistemasAbonos=new SistemasAbonos();
			vAbonos=new Vector<Abono>();
					
			 
		}
		return instanciaSistemasAbonos;
	}

	/* Alta Abono*/
	
	public void altaAbono(String tipoAbono,int duracion, Float precio)
	{
		if(!existeAbono(tipoAbono)) {
	
			Abono a = new Abono(tipoAbono, precio, duracion);
			vAbonos.add(a);
			
			AbonoMapping.getInstance().insertAbono(a,precio, tipoAbono, duracion);
		}
	}

	
	public void modificarAbono(String tipoAbono, int duracion, Float precio){
		for(Abono a: vAbonos) {
			if(a.getTipoAbono().toString().equals(tipoAbono)) {
				a.setPrecio(precio);
				AbonoMapping.getInstance().updateAbono(a);
			}
		}	
		}
		
		
		public int bajaAbono(String tipoAbono,int flag)
		{
			if(tipoAbono !=null) {
				
				Abono a=buscarAbono(tipoAbono);
				if(a!=null) {
					vAbonos.remove(a);
					AbonoMapping.getInstance().updateAbono(a);
					return 1;
				}
				
			}
			
			return flag;
		}
		
		
		public boolean existeAbono (String tipoAbono) {//Hace mas o menos lo mismo que buscarX pero devuelve un boolean

			
			Abono a = buscarAbono(tipoAbono);

			if(a!=null)
				return true;

				
			
			
			return false;
			
		}
		
		public Abono buscarAbono(String tipoAbono) {
			
			/*----Buscamos en memoria----*/
			for(Abono c: vAbonos)
			{
				if(c.getTipoAbono().equals(tipoAbono)) {
						return c;	
				}
			}
			/*----Si no esta, buscamos en BD----*/
			
			Abono c=AbonoMapping.getInstance().buscarAbono(tipoAbono);
			 
			
			/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
			
			if(c!=null)
				vAbonos.addAll((Collection<? extends Abono>) c);

			return c;
			
		}
		
		
		public void imprimirAbono() {
			
			for(Abono a: vAbonos) { //For each
				String tipoAbono = new String();
				int duracion;
				Float precio;
				tipoAbono=a.getTipoAbono();
				duracion=a.getDuracion();
				precio=a.getPrecio();
				
				System.out.printf("%d -  %s  - Empleado: %s \n",tipoAbono,duracion,precio);
				
			}
			
			
			
		
		
		
		
		
		
	}
	
	
	
	
	
}
