package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Vector;

import controladores.SistemaUsuarios;
import modelo.Actividad;
import modelo.Clase;
import modelo.Empleado;
import modelo.Persona;
import modelo.Profesor;
import modelo.Socio;


public class ClasesMapper {
	
	private static ClasesMapper instancia;
	private static Vector <Clase> vClases;

	/*----CONSTRUCTOR 1----*/
	
	private ClasesMapper()
	{
		
	}
	
	/*----SINGLETON----*/
	
	public static ClasesMapper getInstance()
	{
		if (instancia == null)
			instancia = new ClasesMapper();
		return instancia;
	}
	/*----DELETE FISICO (NO USAMOS)----*/

	public void altaClase(Clase cl)
	{
		/*----TRY DE LA CONECCION INSERT----*/
		
		try
		{
			Clase c = (Clase) cl;
			
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL INSERT----*/
			PreparedStatement s = con.prepareStatement("insert into dbo.Clases(actividad, fecha, horario, profeNombre, duracion, capacidadMax, capacidadMin, publico, dificultad, estado) values (?,?,?,?,?,?,?,?,?,?)");
			/*-----CAMPOS DE LA CLASE----*/
			s.setString(1, c.getActividad());
			s.setDate(2, (Date) c.getFecha());
			s.setTime(3, (Time) c.getHorario());
			s.setString(4, c.getProfe());
			s.setFloat(5, c.getDuracion());
			s.setInt(6, c.getCapacidadMax());
			s.setInt(7, c.getCapacidadMin());
			s.setString(8, c.getPublico());
			s.setString(9, c.getDificultad());
			s.setString(10, c.getEstado());
			s.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("rompio insert clases");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
	}
	
	public Clase buscarClase(String actividad, String profeNombreUsr, Date fecha, Time horario) {
		try {
			Clase c = null;
			String act = actividad;
			String profe = profeNombreUsr;
			Date fech = fecha;
			Time hor = horario;
			
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement(
					"select * from dbo.Clases where actividad = ? and profeNombre = ? and fecha = ? and horario = ?");

			s.setString(1, act);
			s.setString(2, profe);
			s.setDate(3, fech);
			s.setTime(4, hor);

			ResultSet result = s.executeQuery();
			while (result.next()) {
				String a = result.getString(1);
				Date fe = result.getDate(2);
				Time h = result.getTime(3);
				String pro = result.getString(4);
				Float dur = result.getFloat(5);
				int capMax = result.getInt(6);
				int capMin = result.getInt(7);
				String pub = result.getString(8);
				String dif = result.getString(9);
				String es = result.getString(10);
				
				Profesor p = SistemaUsuarios.getInstancia().buscarProfesor(pro);
				//SistemaActividades.getInstancia().buscarActividad(a);

				c = new Clase(a, fe, h, p.getNombreUsuario(), dur, capMax, capMin,pub,dif,es);

			}
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return c;
		} catch (Exception e) {
			System.out.println("Error select clase\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public ResultSet listarClases() {
		try {
			Clase c = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Clases where estado = 'Activo'");

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

				c = new Clase(actividad, fecha, horario, profeNombre, duracion, capacidadMax, capacidadMin, publico, dificultad, estado);

				vClases.add(c);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			/*for(int i=0; i<=vClases.size()+1; i++){
				System.out.println(vClases.elementAt(i).getActividad());
			}*/
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return result;
		} 
		catch (Exception e) {
			System.out.println("Error select listar clases\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public ResultSet listarClasesTodas() {
		try {
			Clase c = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select * from dbo.Clases");

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

				c = new Clase(actividad, fecha, horario, profeNombre, duracion, capacidadMax, capacidadMin, publico, dificultad, estado);

				vClases.add(c);
			}
			PoolConnection.getPoolConnection().realeaseConnection(con);
			
			/*for(int i=0; i<=vClases.size()+1; i++){
				System.out.println(vClases.elementAt(i).getActividad());
			}*/
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return result;
		} 
		catch (Exception e) {
			System.out.println("Error select listar clases\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}

	public void updateClase(Clase cl) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Clase c = (Clase) cl;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Clases " +
					"set actividad =?," +
					" fecha =?," +
					" horario =?," +
					" profeNombre =?," +
					" duracion =?," +
					" capacidadMax =?," +
					" capacidadMin =?," +
					" publico =?," +
					" dificultad =?," +
					" estado =?" +
					" where actividad = ? and profeNombre = ? and fecha = ? and horario = ?");
			
			/*----CAMPOS DE CLASES----*/
			
			s.setString(1, c.getActividad());
			s.setDate(2, c.getFecha());
			s.setTime(3, c.getHorario());
			s.setString(4, c.getProfe());
			s.setFloat(5, c.getDuracion());
			s.setInt(6, c.getCapacidadMax());
			s.setInt(7, c.getCapacidadMin());
			s.setString(8, c.getPublico());
			s.setString(9, c.getDificultad());
			s.setString(10, c.getEstado());
			
			/*----CAMPOS DE WHERE----*/
			
			s.setString(11, c.getActividad());
			s.setString(12, c.getProfe());
			s.setDate(13, c.getFecha());
			s.setTime(14, c.getHorario());
			
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
