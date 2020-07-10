package persistencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Abono;

public class AbonoMapping {
	
	private static AbonoMapping instancia;
	
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
	/*----DELETE FISICO (NO USAMOS)----*/
	
	public void insert(Abono p, String tipoAbono,String estado,Float precio,int duracion,int idAbono) 
	{
		/*----TRY DE LA CONECCION INSERT----*/
		
		try
		{
			Abono per = (Abono) p;
			Float pre = (Float) precio;
			String tipoA = (String) tipoAbono;
			int dura = (int) duracion;
			int id = (int) idAbono;

			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL INSERT----*/
				PreparedStatement s = con.prepareStatement("insert into dbo.Abono(idAbono, tipoAbono,duracion,precio) values (?,?,?,?)");
				/*-----CAMPOS DEL SOCIO----*/
				s.setInt(1, per.getIdAbono());
				s.setString(2, per.getTipoAbono());
				s.setInt(3, per.getDuracion());
				s.setFloat(4, per.getPrecio());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			
							
		}
		catch (Exception e)
		{
			System.out.println("rompio insert abono");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

	public void deleteAbono(Abono abono) 
	{
		/*----TRY DE LA CONECCION ELIMINAR----*/

		try
		{
			Abono c = (Abono) abono;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL DELETE----*/
			PreparedStatement s = con.prepareStatement("delete from dbo.Abono where tipoAbono = ? ");
			s.setString(1, c.getTipoAbono());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}
	
	public void updateAbono(Abono abono) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Abono soc =(Abono) abono;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Socios " +
					" set precio =?," +
					" where tipoAbono = ?");
			/*----CAMPOS DE CLIENTE----*/
			
			s.setFloat(1, soc.getPrecio());
			
			
			s.executeUpdate();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio update abono");
		}
	}
	
		public Abono buscarAbono(String tipoAbono)
	{
		/*----TRY DE LA CONECCION SELECT----*/
		
		try
		{
			Abono o = null;
			String tipoAbono1 = new String();
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL SELECT----*/
			PreparedStatement s = con.prepareStatement("select * from dbo.Abono where tipoAbono = ? ");			
			/*----CAMPOS DE USUARIOS----*/
			s.setString(1,tipoAbono1);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				tipoAbono1 = result.getString(1);
			}
			
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return o;

		}
		catch (Exception e)
		{
			System.out.println("rompio select o");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	
}
