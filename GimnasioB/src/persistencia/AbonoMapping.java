package persistencia;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Vector;

import controladores.SistemaUsuarios;
import controladores.SistemasAbonos;
import modelo.Abono;

public class AbonoMapping {
	
	private static AbonoMapping instancia;
	private static Vector <Abono> vAbonos;

	/*----CONSTRUCTOR 1----*/
	
	private AbonoMapping()
	{
		
	}
	
	/*----SINGLETON----*/
	
	public static AbonoMapping getInstance()
	{
		if (instancia == null)
			instancia = new AbonoMapping();
		return instancia;
	}

	public void altaAbono(Abono cl)
	{
		/*----TRY DE LA CONECCION INSERT----*/
		
		try
		{
			Abono c = (Abono) cl;
			
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL INSERT----*/
			PreparedStatement s = con.prepareStatement("insert into dbo.Abono() values (?,?,?,?)");
			/*-----CAMPOS DE LA Abono----*/
			s.setString(1, c.getTipoAbono()); //chequear orden
			s.setFloat(2, c.getPrecio());
			s.setInt(3, c.getDuracion());
			s.setInt(4, c.getIdAbono());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("rompio insert abono");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}
	
	public Abono buscarAbono(String tipoAbono) {
		try {
			Abono c = null;
			String tipAbono = tipoAbono;
			int id=idAbono;
			Float Prec = Precio;
			int durac= duracion;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Abono where tipoAbono = ?");
			s.setString(1, tipAbono);
			s.setInt(2, idAbono);
			s.setFloat(3, Precio);
			s.setInt(4, duracion);

			ResultSet result = s.executeQuery();
			while (result.next()) {
				String tipAbo = result.getString(1);
				int idA=result.getInt(2);
				Float Preci = result.getFloat(3);
				int duracio= result.getInt(4);
				
				//SistemaActividades.getInstancia().buscarActividad(a);

			}
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return c;
		} catch (Exception e) {
			System.out.println("Error select Abono\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public ResultSet listarAbono() {
		try {
			Abono c = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Abono where estado = 'Activo'");

			ResultSet result = s.executeQuery();
			
			/*while (result.next()) {
				String actividad = result.getString(1);
				Date fecha = result.getDate(2);
				Time horario = result.getTime(3);
				String profeNombre = result.getString(4);
				float duracion = result.getFloat(5);
				int capacidadMax = result.getInt(6);
				int capacidadMin = result.getInt(7);
				String publico = result.getString(8);
				String dificultad = result.getString(9);
				String estado = result.getString(10);

				c = new Abono(actividad, fecha, horario, profeNombre, duracion, capacidadMax, capacidadMin, publico, dificultad, estado);

				vAbonos.add(c);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			/*for(int i=0; i<=vAbonos.size()+1; i++){
				System.out.println(vAbonos.elementAt(i).getActividad());
			}*/
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return result;
		} 
		catch (Exception e) {
			System.out.println("Error select listar Abonos\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}

	public void updateAbono(Abono cl) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Abono c = (Abono) cl;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Abono" +
					"set actividad =?," +
					" estado =?" +
					" where tipoAbono = ?");
			
			/*----CAMPOS DE ABONOS----*/
			s.setString(1, c.getTipoAbono());
			s.setInt(2, c.getIdAbono());
			s.setFloat(3, c.getPrecio());
			s.setInt(4, c.getDuracion());
			
			
			
			s.execute();

			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio update empleado");
		}
	}
	
}
