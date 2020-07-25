package BITGym.persistencia;
import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BITGym.modelo.Actividad;


public class ActividadesMapper {
	private static ActividadesMapper instancia;
	private static Vector <Actividad> vActividades;
	/*----CONSTRUCTOR 1----*/
	
	private ActividadesMapper()
	{
		
	}
	
	/*----SINGLETON----*/
	
	public static ActividadesMapper getInstance()
	{
		if (instancia == null)
			instancia = new ActividadesMapper();
		return instancia;
	}
	
	//Alta Actividad
	public void altaActividad(Actividad a)
	{	/*----TRY DE LA CONECCION INSERT----*/
		try
		{
			Actividad act = (Actividad) a;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL INSERT----*/
				PreparedStatement s = con.prepareStatement("insert into dbo.Actividades(actividad, estadoActividad) values (?,?)");
				/*-----CAMPOS DEL Actividad----*/
				s.setString(1, act.getNombreActividad());
				s.setString(2, act.getEstado());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("rompio insert actividad");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}

	public Actividad buscarActividad (String actividad) {
		try {
			Actividad act= null;
			String nombreAct =actividad;
			
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Actividades where actividad = ?");
			s.setString(1, nombreAct);
			ResultSet result = s.executeQuery();
			while(result.next()) {
				String nombre = result.getString(1);
				String estado = result.getString(2);

				act = new Actividad(nombre,estado);
				System.out.println(act.getNombreActividad());
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return act;
		}
		catch (Exception e) {
			System.out.println("rompio select Act");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
		return null;
	}
	
	public ResultSet listar() {
		try {
			Actividad a =null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select actividad from dbo.Actividades where estadoActividad = 'Activo'");
			ResultSet result = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return result;
		}
		catch (Exception e) {
			System.out.println("Error select listar Actividades\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public ResultSet listarTodas() {
		try {
			Actividad a =null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Actividades");
			ResultSet result = s.executeQuery();
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return result;
		}
		catch (Exception e) {
			System.out.println("Error select listar Actividades\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public Vector<String> jlistar() {
		try {
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Actividades");
			ResultSet result = s.executeQuery();
			Vector<String> la = new Vector<String>();
			while(result.next()) {	 
				 la.add(result.getString(1));
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			return la;
		}
		catch (Exception e) {
			System.out.println("Error select jlistar Actividades\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public void updateActividad (String nombreActividadAux, Actividad actividad) {
		try {
			Actividad a = (Actividad) actividad;
			Connection con = PoolConnection.getPoolConnection().getConnection();


			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Actividades " +
					"set actividad = ?," +
					" estadoActividad = ?" + " where actividad = ?");
			
			s.setString(1, a.getNombreActividad());
			s.setString(2, a.getEstado());
			
			//filtro del Where
			s.setString(3, nombreActividadAux);
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("rompio update actividad");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}
	
	
}
