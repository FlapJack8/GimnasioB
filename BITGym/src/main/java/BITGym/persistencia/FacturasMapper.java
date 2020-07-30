package BITGym.persistencia;
import java.util.Vector;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import BITGym.controladores.SistemaAbonos;
import BITGym.controladores.SistemaFacturas;
import BITGym.controladores.SistemaUsuarios;
import BITGym.modelo.Factura;
import BITGym.modelo.Socio;
import BITGym.modelo.Abono;


public class FacturasMapper {
	private static FacturasMapper instancia;
	private static Vector <Factura> vFacturas;
	private FacturasMapper() {
		
	}
	
	//Singleton
	public static FacturasMapper getInstance() {
		if(instancia==null)
			instancia =new FacturasMapper();
		return instancia;
	}
	
	public void generarFactura(Factura f, String tipoPago, String idTransaccion) {
		
		try {
			Factura fac=(Factura) f;
			String tipoPag = (String) tipoPago;
			String idTransac = (String) idTransaccion;

			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s= con.prepareStatement("insert into dbo.Facturas(dniSocio,fechaFactura,monto,detalle,tipoPago,idPagoTarjeta)values (?,?,?,?,?,?)");
			s.setInt(1, fac.getDniSocio()); //posicion de la columna (?)
			s.setDate(2,(Date) fac.getFechaFactura());
			s.setFloat(3, fac.getMonto());
			s.setString(4, fac.getDetalle());
			s.setString(5, tipoPag);
			s.setString(6, idTransac);

			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
						
		}
		catch (Exception e){
			System.out.println("rompio insert factura");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}
	
	public Factura buscarFactura(int dniSocio, Date fecha) {
		try {
			Factura fac=null;
			int idSocio=dniSocio;
			Date df=fecha;
			
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement(
					"select * from dbo.Facturas where dniSocio = ? and fechaFactura = ?");

			s.setInt(1, idSocio);
			s.setDate(2,df);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				int numF = result.getInt(1);
				int dniSoc = result.getInt(2);
				Date fe = result.getDate(3);
				Float pre=result.getFloat(4);
				String det= result.getString(5);
				String tipoPag= result.getString(6);
				String idTransac= result.getString(7);

				
				Socio buscarSoc=SistemaUsuarios.getInstancia().buscarSocio(dniSoc);
				
				Abono buscarAb=SistemaAbonos.getInstancia().buscarAbono(buscarSoc.getTipoAbono());
				fac=new Factura (numF,buscarSoc.getDni(),fe,buscarAb.getPrecio(),det,tipoPag,idTransac);
				
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return fac;
		}
		catch (Exception e) {
			System.out.println("Error select Facturas\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public ResultSet listarFacturas() {
		try {
	
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Facturas order by fechaFactura DESC");

			ResultSet result = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return result;
		}
		catch (Exception e) {
			System.out.println("Error select listar Facturas\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
				
}
