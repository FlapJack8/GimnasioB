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
import modelo.Persona;
import modelo.Profesor;


public class ClasesMapper {
	
	private static ClasesMapper instancia;
	
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



}
