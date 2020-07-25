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
	
	public void generarFactura(Factura f, String tipoPago) {
		
		try {
			Factura fac=(Factura) f;
			String tipoPag = (String) tipoPago;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s= con.prepareStatement("insert into dbo.Facturas(dniSocio,fechaFactura,monto,detalle,tipoPago)values (?,?,?,?,?)");
			s.setInt(1, fac.getDniSocio()); //posicion de la columna (?)
			s.setDate(2,(Date) fac.getFechaFactura());
			s.setFloat(3, fac.getMonto());
			s.setString(4, fac.getDetalle());
			s.setString(5, tipoPag);
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
				int num=result.getInt(1);
				int soc = result.getInt(2);
				Date fe = result.getDate(3);
				Float pre=result.getFloat(4);
				String d= result.getString(4);
				
				Socio buscarSoc=SistemaUsuarios.getInstancia().buscarSocio(soc);
				
				Abono buscarAb=SistemaAbonos.getInstancia().buscarAbono(buscarSoc.getTipoAbono());
				fac=new Factura (num,buscarSoc.getDni(),fe,buscarAb.getPrecio(),d);
				
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
			PreparedStatement s = con.prepareStatement("select * from dbo.Facturas");

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
