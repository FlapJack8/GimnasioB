package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Administrador;
import modelo.Socio;
import modelo.Empleado;
import modelo.Operador;
import modelo.Persona;
import modelo.Profesor;

public class UsrMapper {

		private static UsrMapper instancia;
		
		/*----CONSTRUCTOR 1----*/
		
		private UsrMapper()
		{
			
		}
		
		/*----SINGLETON----*/
		
		public static UsrMapper getInstance()
		{
			if (instancia == null)
				instancia = new UsrMapper();
			return instancia;
		}
		/*----DELETE FISICO (NO USAMOS)----*/
		
		public void insert(Persona p, Float sueldo, String diasLaborales,String actividades, String tipoAbono, Date fechaVen) 
		{
			/*----TRY DE LA CONECCION INSERT----*/
			
			try
			{
				Persona per = (Persona) p;
				Float sue = (Float) sueldo;
				String diasLab = (String) diasLaborales;
				String acts = (String) actividades;
				String tipoAb = (String) tipoAbono;
				Date vencimiento = (Date) fechaVen;
				
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL INSERT----*/
				if(per.getRol().equalsIgnoreCase("socio")) {
					PreparedStatement s = con.prepareStatement("insert into dbo.Socios(nombre, dni, email, domicilio, fechaNacimiento, fechaInscipcion, estado, tipoAbono, fechaVencimientoApto) values (?,?,?,?,?,?,?,?,?)");
					/*-----CAMPOS DEL SOCIO----*/
					s.setString(1, per.getNombre());
					s.setInt(2, per.getDni());
					s.setString(3, per.getEmail());
					s.setString(4, per.getDomicilio());
					s.setDate(5, (Date) per.getFechaDeNac());
					s.setDate(6, (Date) per.getFechaInicioActividades());
					s.setString(7, per.getEstado());
					s.setString(8, tipoAb);
					s.setDate(9, (Date) vencimiento);
					s.execute();
					PoolConnection.getPoolConnection().realeaseConnection(con);
				}
				else {
					if(per.getRol().equalsIgnoreCase("profesor")) {
						PreparedStatement s = con.prepareStatement("insert into dbo.Profesores (nombreusuario,actividades) values (?,?)");
						/*----CAMPOS DE PROFESORES----*/			
						s.setString(1, per.getNombreUsuario());
						s.setString(2, acts);
						
						PreparedStatement sProfes = con.prepareStatement("insert into dbo.Empleados (nombreusuario,nombre,domicilio,email,dni,fechaNacimiento,estado,sueldo,fechaInicioActividades,diasLaborales,rol) values (?,?,?,?,?,?,?,?,?,?,?)");
						/*----CAMPOS DE EMPLEADOS----*/			
						sProfes.setString(1, per.getNombreUsuario());
						sProfes.setString(2, per.getNombre());
						sProfes.setString(3, per.getDomicilio());
						sProfes.setString(4, per.getEmail());
						sProfes.setInt(5, per.getDni());
						sProfes.setDate(6, (Date) per.getFechaDeNac());
						sProfes.setString(7, per.getEstado());
						sProfes.setFloat(8, sue);
						sProfes.setDate(9, (Date) per.getFechaInicioActividades());
						sProfes.setString(10, diasLab);
						sProfes.setString(11, per.getRol());
						
						s.execute();
						sProfes.execute();
						PoolConnection.getPoolConnection().realeaseConnection(con);
					}
					else {
						PreparedStatement s = con.prepareStatement("insert into dbo.Empleados (nombreusuario,nombre,domicilio,email,dni,fechaNacimiento,estado,sueldo,fechaInicioActividades,diasLaborales,rol) values (?,?,?,?,?,?,?,?,?,?,?)");
						/*----CAMPOS DE EMPLEADOS----*/			
						s.setString(1, per.getNombreUsuario());
						s.setString(2, per.getNombre());
						s.setString(3, per.getDomicilio());
						s.setString(4, per.getEmail());
						s.setInt(5, per.getDni());
						s.setDate(6, (Date) per.getFechaDeNac());
						s.setString(7, per.getEstado());
						s.setFloat(8, sue);
						s.setDate(9, (Date) per.getFechaInicioActividades());
						s.setString(10, diasLab);
						s.setString(11, per.getRol());
						
						PreparedStatement sUsrs = con.prepareStatement("insert into dbo.Usuarios (nombreUsuario,password,rol) values (?,?,?)");
						/*----CAMPOS DE USUARIOS----*/			
						sUsrs.setString(1, per.getNombreUsuario());
						sUsrs.setString(2, per.getPassword());
						sUsrs.setString(3, per.getRol());
						
						s.execute();
						sUsrs.execute();
		
						PoolConnection.getPoolConnection().realeaseConnection(con);
					}
				}
			}
			catch (Exception e)
			{
				System.out.println("rompio insert usuario");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
		}

		public void deleteCliente(Socio cliente) 
		{
			/*----TRY DE LA CONECCION ELIMINAR----*/

			try
			{
				Socio c = (Socio) cliente;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL DELETE----*/
				PreparedStatement s = con.prepareStatement("delete from dbo.Usuarios where nombreUsuario = ? ");
				s.setString(1, c.getNombreUsuario());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
		}
		
		public void updateSocio(Socio socio) 
		{
			/*----TRY DE LA CONECCION UPDATE----*/
			
			try
			{
				Socio soc =(Socio) socio;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL UPDATE----*/
				PreparedStatement s = con.prepareStatement("update dbo.Socios " +
						" set nombre =?," +
						" email =?," +
						" domicilio =?," +
						" fechaNacimiento =?," +
						" fechaInscipcion =?," +
						" tipoAbono =?," +
						" fechaVencimientoApto=?," +
						" estado = ?" +
						" where dni = ?");
				/*----CAMPOS DE CLIENTE----*/
				
				s.setString(1, soc.getNombre());
				s.setString(2, soc.getEmail());
				s.setString(3, soc.getDomicilio());
				s.setDate(4, (Date) soc.getFechaDeNac());
				s.setDate(5, (Date) soc.getFechaInicioActividades());
				s.setString(6, soc.getTipoAbono());
				s.setDate(7, (Date) soc.getFechaVen());
				s.setString(8, soc.getEstado());
				System.out.println(soc.getEstado());
				s.setInt(9, soc.getDni());
				
				s.executeUpdate();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
				System.out.println("rompio update Socio");
			}
		}
		
		public void deleteEmpleado(Empleado emp) 
		{
			/*----TRY DE LA CONECCION ELIMINAR----*/

			try
			{
				Empleado e = (Empleado) emp;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL DELETE----*/
				PreparedStatement s = con.prepareStatement("delete from dbo.Usuarios where nombreUsuario = ? ");
				s.setString(1, e.getNombreUsuario());
				s.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
		}
		
		public void updateEmpleado(Empleado emp) 
		{
			/*----TRY DE LA CONECCION UPDATE----*/
			
			try
			{
				Empleado e = (Empleado) emp;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL UPDATE----*/
				PreparedStatement s = con.prepareStatement("update dbo.Usuarios " +
						"set password =?," +
						" rol =?" +
						" where nombreUsuario = ?");
				/*----CAMPOS DE EMPLEADO----*/
				
				s.setString(1, e.getPassword());
				s.setString(2, e.getRol());
				
				s.setString(3, e.getNombreUsuario());
				
				/*----STATEMENT QUERY DEL UPDATE----*/
				PreparedStatement s2 = con.prepareStatement("update dbo.Empleados " +
						"set nombre =?," +
						" domicilio =?," +
						" email =?," +
						" dni = ?," +
						" fechaNacimiento = ?," +
						" estado = ?," +
						" sueldo = ?," +
						" fechaInicioActividades = ?," +
						" diasLaborales = ?" +
						" where nombreUsuario = ?");
				/*----CAMPOS DE EMPLEADO----*/
				
				s2.setString(1, e.getNombre());
				s2.setString(2, e.getDomicilio());
				s2.setString(3, e.getEmail());
				s2.setInt(4, e.getDni());
				s2.setDate(5, (Date) e.getFechaDeNac());
				s2.setString(6,e.getEstado());
				s2.setFloat(7,e.getSueldo());
				s2.setDate(8, (Date) e.getFechaInicioActividades());

				s2.setString(9,e.getDiasLaborales());
				
				s2.setString(10, e.getNombreUsuario());
				
				s.execute();
				s2.execute();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
				System.out.println("rompio update empleado");
			}
		}
		
		public String verificarUsuario(String nombreUsuario, String password) {
			
			return null;
		}
		
		
		 public Socio buscarSocio(int DNIdado)
		 
		{
			/*----TRY DE LA CONECCION SELECT----*/
			
			try
			{
				Socio socio = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----*/
				PreparedStatement s = con.prepareStatement("select * from dbo.Socios where dni = ?");			
				/*----CAMPOS DE CLIENTE----*/
				s.setInt(1, DNIdado);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					String nombre = result.getString(1);
					int dni = result.getInt(2);
					String email = result.getString(3);
					String domicilio = result.getString(4);
					Date fechaDeNac = result.getDate(5);
					Date fechaDeInscripcion = result.getDate(6);
					String estado = result.getString(7);
					String tipoAbono = result.getString(8);
					Date fechaVencimineto = result.getDate(9);
					
					
					Persona p = new Persona(null, email, nombre, null, domicilio, dni, fechaDeNac, "socio", estado, fechaDeInscripcion);
					socio = new Socio(p, "socio", fechaVencimineto, tipoAbono);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return socio;
			}
			catch (Exception e)
			{
				System.out.println("rompio select Socio");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}
		
		public boolean existeEmpleado (int dni) {
			return false;
		}
		
		public boolean existeCliente (int dni) {
			return false;
		}
		
		public Administrador buscarAdministrador(String nomUsu)
		{
			/*----TRY DE LA CONECCION SELECT----*/
			
			try
			{
				Administrador adm = null;
				String nombreUsuario = new String();
				String password = new String();
				String rol = new String();
				
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----*/
				PreparedStatement s = con.prepareStatement("select * from dbo.Usuarios where nombreUsuario = ? and rol='administrador'");			
				/*----CAMPOS DE USUARIOS----*/
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					nombreUsuario = result.getString(1);
					password = result.getString(2);
					rol = result.getString(3);
				}
				
				PreparedStatement s2 = con.prepareStatement("select * from dbo.Empleados where nombreUsuario = ? and rol='administrador'");			
				/*----CAMPOS DE EMPLEADOS----*/
				s2.setString(1,nomUsu);
				ResultSet res = s2.executeQuery();
				
				while(res.next()) {
					String nombre = res.getString(2);
					String domicilio = res.getString(3);
					String mail = res.getString(4);
					int dni = res.getInt(5);
					Date fechaDeNac = res.getDate(6);
					String estado = res.getString(7);
					Float sueldo = res.getFloat(8);
					Date fechaInicioActividades =res.getDate(9);
					String diasLaborales = res.getString(10);
					Persona p = new Persona(nombreUsuario,mail,nombre,password,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades);
					adm = new Administrador(p,rol,sueldo,diasLaborales);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return adm;
			}
			catch (Exception e)
			{
				System.out.println("rompio select adm");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}

		public Operador buscarOperador(String nomUsu)
		{
			/*----TRY DE LA CONECCION SELECT----*/
			
			try
			{
				Operador o = null;
				String nombreUsuario = new String();
				String password = new String();
				String rol = new String();
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----*/
				PreparedStatement s = con.prepareStatement("select * from dbo.Usuarios where nombreUsuario = ? and rol='operador'");			
				/*----CAMPOS DE USUARIOS----*/
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
						nombreUsuario = result.getString(1);
						password = result.getString(2);
						rol = result.getString(3);
				}
				PreparedStatement s2 = con.prepareStatement("select * from dbo.Empleados where nombreUsuario = ? and rol='operador'");			
				/*----CAMPOS DE EMPLEADOS----*/
				s2.setString(1,nomUsu);
				ResultSet res = s2.executeQuery();
				while(res.next()) {
					String nombre = res.getString(2);
					String domicilio = res.getString(3);
					String mail = res.getString(4);
					int dni = res.getInt(5);
					Date fechaDeNac = res.getDate(6);
					String estado = res.getString(7);
					Float sueldo = res.getFloat(8);
					
					Date fechaInicioActividades = res.getDate(9);
					String diasLaborales = res.getString(10);
					
					Persona p = new Persona(nombreUsuario,mail,nombre,password,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades);
					o = new Operador(p,rol,sueldo,diasLaborales);
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
		
		public Profesor buscarProfesor(String nomUsu)
		{
			/*----TRY DE LA CONECCION SELECT----*/
			
			try
			{
				Profesor o = null;
				String nombreUsuario = new String();
				String actividades = new String();
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----*/
				PreparedStatement s = con.prepareStatement("select * from dbo.Profesores where nombreUsuario = ?");			
				/*----CAMPOS DE USUARIOS----*/
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					nombreUsuario = result.getString(1);
					actividades = result.getString(2);
				}
				
				PreparedStatement s2 = con.prepareStatement("select * from dbo.Empleados where nombreUsuario = ? and rol='profesor'");			
				/*----CAMPOS DE EMPLEADOS----*/
				s2.setString(1,nomUsu);
				ResultSet res = s2.executeQuery();
				while(res.next()) {
					//nombreUsuario = res.getString(1);
					String nombre = res.getString(2);
					String domicilio = res.getString(3);
					String mail = res.getString(4);
					int dni = res.getInt(5);
					Date fechaDeNac = res.getDate(6);
					String estado = res.getString(7);
					Float sueldo = res.getFloat(8);
					Date fechaInicioActividades = res.getDate(9);
					String diasLaborales = res.getString(10);
					String rol= res.getString(11);

					Persona p = new Persona(nombreUsuario,mail,nombre,null,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades);
					o = new Profesor(p,rol,sueldo,diasLaborales,actividades);

				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return o;

			}
			catch (Exception e)
			{
				System.out.println("rompio select profes");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}

}
