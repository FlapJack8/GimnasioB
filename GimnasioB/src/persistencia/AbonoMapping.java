package persistencia;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Abono;
import modelo.Administrador;
import modelo.Empleado;
import modelo.Operador;
import modelo.Persona;
import modelo.Socio;

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
	
	

	public void insertAbono(Abono A, Float precio, String tipoAbono,int duracion) 
	{
		/*----TRY DE LA CONECCION INSERT----*/
		
		try
		{
			Abono abo = (Abono) A;
			Float pre = (Float) precio;
			String tipoAb = (String) tipoAbono;
			int dur = (int) duracion;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL INSERT----*/
				PreparedStatement s = con.prepareStatement("insert into dbo.Abonos(precio, tipoAbono, duracion) values (?,?,?)");
				/*-----CAMPOS DEL SOCIO----*/
				s.setFloat(1, abo.getPrecio());
				s.setString(2, abo.getTipoAbono());
				s.setInt(3, abo.getDuracion());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			
				PoolConnection.getPoolConnection().realeaseConnection(con);
				
			
		}
		catch (Exception e)
		{
			System.out.println("rompio insert abono");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

	public void deleteAbono(Abono A) 
	{
		/*----TRY DE LA CONECCION ELIMINAR----*/

		try
		{
			Abono AB = (Abono) A;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL DELETE----*/
			PreparedStatement s = con.prepareStatement("delete from dbo.abonos where tipoAbono = ? ");
			s.setString(1, AB.getTipoAbono());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace());
		}
	}
	
	public void updateAbono(Abono A) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Abono c =(Abono) A;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Abonos " +
					"set precio =?," +
					" where tipoAbono = ?");
			/*----CAMPOS DE CLIENTE----*/
			
			s.setFloat(1, c.getPrecio());
			
			s.executeUpdate();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio update cliente");
		}
	}
	
	
	
	
	
	
	
	
	public Abono buscarAbono(String tipoAbono)
	{
		/*----TRY DE LA CONECCION SELECT----*/
		
		try
		{
			String tipoAb = new String();
			Abono adm = null;
			String nombreUsuario = new String();
			String password = new String();
			String rol = new String();
			
			Connection con = PoolConnection.getPoolConnection().getConnection(); //busca la coneccion
			/*----STATEMENT QUERY DEL SELECT----*/
			PreparedStatement s = con.prepareStatement("select * from dbo.Abonos where tipoAbono = ?");			
			/*----CAMPOS DE USUARIOS----*/
			s.setString(1,tipoAb);
			ResultSet result = s.executeQuery();
			while (result.next()) {
				tipoAb = result.getString(1);
			}
			
			PreparedStatement s2 = con.prepareStatement("select * from dbo.Abonos where tipoAbono = ?");			
			/*----CAMPOS DE EMPLEADOS----*/
			s2.setString(1,tipoAb);
			ResultSet res = s2.executeQuery();
			
			while(res.next()) {
				String tipoAbon2 = res.getString(2);
				int duracion = res.getInt(3);
				Float precio = res.getFloat(4);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return adm;
		}
		catch (Exception e)
		{
			System.out.println("rompio select abono");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	

	

}
