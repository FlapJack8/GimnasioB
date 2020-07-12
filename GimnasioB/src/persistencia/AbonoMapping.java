package persistencia;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import controladores.SistemaAbonos;
import modelo.Abono;
import modelo.Actividad;
import modelo.Persona;
import modelo.Socio;

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
			PreparedStatement s = con.prepareStatement("insert into dbo.Abonos(tipoAbono,duracion,precio,estado) values (?,?,?,?)");
			/*-----CAMPOS DE LA Abono----*/
			s.setString(1, c.getTipoAbono()); //chequear orden
			s.setFloat(2, c.getPrecio());
			s.setInt(3, c.getDuracion());
			s.setString(4,c.getEstado());
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

		try
		{
			Abono abono = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL SELECT----*/
			PreparedStatement s = con.prepareStatement("select * from dbo.Abonos where tipoAbono = ?");			
			/*----CAMPOS DE CLIENTE----*/
			s.setString(1, tipoAbono);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				String tipoAbon = result.getString(1);
				int duracion = result.getInt(2);
				Float precio = result.getFloat(3);
				String estado = result.getString(4);
				
				
				abono = new Abono(tipoAbon,duracion,precio,estado);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return abono;
		}
		catch (Exception e)
		{
			System.out.println("rompio select Socio");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
		
	
	
	public ResultSet listarAbono() {
		try {
			Abono c = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Abonos where estado = 'Activo'");

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

	
	
	
	public void deleteAbono(Abono cl) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Abono c = (Abono) cl;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement(
					"UPDATE dbo.Abonos set estado ='Inactivo' where tipoAbono = ?");
			
			/*----CAMPOS DE ABONOS----*/
			s.setString(1, c.getTipoAbono());
			
			s.execute();

			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio baja abono");
		}
	}
	
	public void updateAbono(Abono cl) 
	{
/*----TRY DE LA CONECCION UPDATE----*/ //verificar lo de update
		
		try
		{
			Abono c = (Abono) cl;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Abonos " +
					" duracion =?," +
					" precio =?," +
					" estado ='Activo'," +
					" where tipoAbono = ?");
			
			/*----CAMPOS DE ABONOS----*/
			s.setString(1, c.getTipoAbono());
			s.setInt(2, c.getDuracion());
			s.setFloat(3, c.getPrecio());
			s.setString(4, c.getEstado());

			s.execute();

			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio update abono");
		}
	
}
}
