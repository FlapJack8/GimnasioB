package BITGym.controladores;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;
import BITGym.modelo.Factura;
import BITGym.persistencia.FacturasMapper;
import BITGym.persistencia.RestController;


	public class SistemaFacturas {
	
		private Vector<Factura> vFacturas;
		private  static SistemaFacturas instanciaSistemaFacturas;
		
		public SistemaFacturas() {
			
			vFacturas=new Vector<Factura>();
		}
			
		public static SistemaFacturas getInstancia(){
		
		if(instanciaSistemaFacturas==null){	
			instanciaSistemaFacturas=new SistemaFacturas();
			
		}
		return instanciaSistemaFacturas;
		}
	
	public void generarFactura(int nroFactura,int dniSocio,Date fecha, float monto, String detalle, String tipoPago, String idTransaccion){
		
		if(!existeFactura(dniSocio,fecha)) {
			
			Factura fc=buscarFactura(dniSocio, fecha); 
			
			if(fc==null) {
				
				fc=new Factura (nroFactura,dniSocio, fecha,monto,detalle, tipoPago, idTransaccion); 
				vFacturas.add(fc);
				
				FacturasMapper.getInstance().generarFactura(fc,tipoPago, idTransaccion);
			}
		}
	}
	
	public ResultSet listarFacturas(){
			
			ResultSet fs = null;
			fs = FacturasMapper.getInstance().listarFacturas();
			
			return fs;
		}

	public boolean existeFactura(int dniSocio,Date fecha) {
			
			Factura fc = buscarFactura(dniSocio,fecha);
			/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
			if(fc!=null)
				return true;
			return false;
	}
	
	
	public Factura buscarFactura(int dniSocio,Date fecha) {
	
		/*----Buscamos en memoria----*/
		for(Factura f: vFacturas)
		{
			if(f.getDniSocio()==dniSocio && f.getFechaFactura().equals(fecha)) {
					return f;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		Factura f= FacturasMapper.getInstance().buscarFactura(dniSocio,fecha);
		/*----AGREGAMOS CLASE PARA FUTURAS BUSQUEDAS----*/
		if(f!=null)
			vFacturas.add(f);
		return f;
	}

	public void facturarTarjeta(String nombre, String apellido, int dni, String comercio, long cuit, long numTarjeta,
			Date fechaVen, int cvc, Float monto, int cuotas) {
		
		RestController.getInstance().postFacturarTarjeta(nombre, apellido, dni, comercio, cuit, numTarjeta, fechaVen, cvc, monto, cuotas);
		
	}
	
	
	
}
