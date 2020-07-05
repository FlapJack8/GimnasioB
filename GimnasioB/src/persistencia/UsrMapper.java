package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Administrador;
//import modelo.AgenteComercial;
import modelo.Socio;
import modelo.Empleado;
import modelo.Operador;
import modelo.Persona;
//import modelo.VendedorBoleteria;

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
		
		public void insert(Persona p, Float sueldo, String diasLaborales,String clases, String tipoAbono, Date fechaVen) 
		{
			/*----TRY DE LA CONECCION INSERT----*/
			
			try
			{
				Persona per = (Persona) p;
				Float sue = (Float) sueldo;
				String diasLab = (String) diasLaborales;
				String clas = (String) clases;
				String Abono = (String) tipoAbono;
				Date vencimiento = (Date) fechaVen;
				
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL INSERT----*/
				if(p.getRol().equalsIgnoreCase("socio")) {
					PreparedStatement s = con.prepareStatement("insert into dbo.Socios(nombre, dni, email, domicilio, fechaNacimiento, fechaInscipcion, estado, tipoAbono, fechaVencimientoApto) values (?,?,?,?,?,?,?,?,?)");
					/*-----CAMPOS DEL SOCIO----*/
					s.setString(1, per.getNombre());
					s.setInt(2, per.getDni());
					s.setString(3, per.getEmail());
					s.setString(4, per.getDomicilio());
					s.setDate(5, (Date) per.getFechaDeNac());
					s.setDate(6, (Date) per.getFechaInicioActividades());
					s.setString(7, per.getEstado());
					s.setString(8, tipoAbono);
					s.setDate(9, (Date) fechaVen);
					s.execute();
					PoolConnection.getPoolConnection().realeaseConnection(con);
				}
				else {
					if(p.getRol().equalsIgnoreCase("profesor")) {
						PreparedStatement s = con.prepareStatement("insert into dbo.Profesores (nombreusuario,clases) values (?,?)");
						/*----CAMPOS DE CLIENTE----*/			
						s.setString(1, per.getNombreUsuario());
						s.setString(2, per.getPassword());
						
						s.execute();
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
		
		public void updateCliente(Socio cliente) 
		{
			/*----TRY DE LA CONECCION UPDATE----*/
			
			try
			{
				Socio c =(Socio) cliente;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL UPDATE----*/
				PreparedStatement s = con.prepareStatement("update dbo.Usuarios " +
						"set contraseña =?," +
						" nombre =?," +
						" domicilio =?," +
						" email =?," +
						" dni = ?," +
						" fechaNacimiento =?," +
						" frecuente = ?," +
						" rol = ?," +
						" estado = ?" +
						" where nombreUsuario = ?");
				/*----CAMPOS DE CLIENTE----*/
				
				s.setString(1, c.getPassword());
				s.setString(2, c.getNombre());
				s.setString(3, c.getDomicilio());
				s.setString(4, c.getEmail());
				s.setInt(5, c.getDni());
				s.setDate(6, (Date) c.getFechaDeNac());
				s.setString(7, c.getNombreUsuario());
				//s.setBoolean(8, c.isClienteFrecuente());
				s.setString(9, c.getRol());
				s.setString(10, c.getEstado());
				
				s.executeUpdate();
				PoolConnection.getPoolConnection().realeaseConnection(con);
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
				System.out.println("rompio update cliente");
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
						"set contraseña =?," +
						" nombre =?," +
						" domicilio =?," +
						" email =?," +
						" dni = ?," +
						" fechaNacimiento = ?," +
						" frecuente = ?," +
						" rol = ?," +
						" estado = ?" +
						" where nombreUsuario = ?");
				/*----CAMPOS DE EMPLEADO----*/
				
				s.setString(1, e.getPassword());
				s.setString(2, e.getNombre());
				s.setString(3, e.getDomicilio());
				s.setString(4, e.getEmail());
				s.setInt(5, e.getDni());
				s.setDate(6, (Date) e.getFechaDeNac());
			
				s.setInt(7, 0);//PREGUNTAR
				s.setString(8, e.getRol());
				s.setString(9, e.getEstado());
				s.setString(10, e.getNombreUsuario());
				s.execute();
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
		
		/**
		 * public Cliente buscarCliente(String nomUsu)
		 
		{
			/*----TRY DE LA CONECCION SELECT----
			
			try
			{
				Cliente cliente = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----
				PreparedStatement s = con.prepareStatement("select * from dbo.Usuarios where nombreUsuario = ? and rol='Cliente'");			
				/*----CAMPOS DE CLIENTE----
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					String nombreUsuario = result.getString(1);
					String password = result.getString(2);
					String nombre = result.getString(3);
					String domicilio = result.getString(4);
					String mail = result.getString(5);
					int dni = result.getInt(6);
					Date fechaDeNac = result.getDate(7);
					boolean frecuente = result.getBoolean(8);
					String rol = result.getString(9);
					String estado = result.getString(10);
					Persona p = new Persona(nombreUsuario,mail,nombre,password,domicilio,dni,fechaDeNac,rol);
					cliente = new Cliente(p,rol,estado);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return cliente;
			}
			catch (Exception e)
			{
				System.out.println("rompio select cliente");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}*/
		
		public boolean existeEmpleado (String nombreUsuario) {
			return false;
		}
		
		public boolean existeCliente (String nombreUsuario) {
			return false;
		}
		
		/*public VendedorBoleteria buscarVendedorBoleteria(String nomUsu)
		{
			/*----TRY DE LA CONECCION SELECT----
			
			try
			{
				VendedorBoleteria vb = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----
				PreparedStatement s = con.prepareStatement("select * from dbo.Usuarios where nombreUsuario = ? and rol='Vendedor'");			
				/*----CAMPOS DE EMPLEADO----
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					String nombreUsuario = result.getString(1);
					String contraseña = result.getString(2);
					String nombre = result.getString(3);
					String domicilio = result.getString(4);
					String mail = result.getString(5);
					int dni = result.getInt(6);
					Date fechaDeNac = result.getDate(7);
					//boolean frecuente = result.getBoolean(8);
					String rol = result.getString(9);
					Persona p = new Persona(nombreUsuario,mail,nombre,contraseña,domicilio,dni,fechaDeNac,rol);
					vb = new VendedorBoleteria(p,rol);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return vb;
			}
			catch (Exception e)
			{
				System.out.println("rompio select vb");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}*/
		
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
		
		/*public AgenteComercial buscarAgenteComercial(String nomUsu)
		{
			/*----TRY DE LA CONECCION SELECT----
			
			try
			{
				AgenteComercial ac = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL SELECT----
				PreparedStatement s = con.prepareStatement("select * from dbo.Usuarios where nombreUsuario = ? and rol='Agente Comercial'");			
				/*----CAMPOS DE EMPLEADO----
				s.setString(1,nomUsu);
				ResultSet result = s.executeQuery();
				while (result.next()) {
					String nombreUsuario = result.getString(1);
					String contraseña = result.getString(2);
					String nombre = result.getString(3);
					String domicilio = result.getString(4);
					String mail = result.getString(5);
					int dni = result.getInt(6);
					Date fechaDeNac = result.getDate(7);
					//boolean frecuente = result.getBoolean(8);
					String rol = result.getString(9);
					Persona p = new Persona(nombreUsuario,mail,nombre,contraseña,domicilio,dni,fechaDeNac,rol);
					ac = new AgenteComercial(p,rol);
				}
				PoolConnection.getPoolConnection().realeaseConnection(con);
				return ac;
			}
			catch (Exception e)
			{
				System.out.println("rompio select ac");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}*/

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
					Date fechaInicioActividades =res.getDate(9);
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

}
