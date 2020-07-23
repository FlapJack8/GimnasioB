package persistencia;


import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.ImageIcon;
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
		
		public void insert(Persona p, Float sueldo, String diasLaborales,String actividades, String tipoAbono, Date fechaVen, FileInputStream fis) 
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
				FileInputStream fileIS = (FileInputStream) fis;
				
				Connection con = PoolConnection.getPoolConnection().getConnection();
				/*----STATEMENT QUERY DEL INSERT----*/
				if(per.getRol().equalsIgnoreCase("socio")) {
					PreparedStatement s = con.prepareStatement("insert into dbo.Socios(nombre, dni, email, domicilio, fechaNacimiento, fechaInscipcion, estado, tipoAbono, fechaVencimientoApto, datosMedicos) values (?,?,?,?,?,?,?,?,?,?)");
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
					s.setBinaryStream(10, (InputStream) fileIS);
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

		public ImageIcon getImage (int dni) {
			ImageIcon newImage = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			try {
				PreparedStatement s = con.prepareStatement("select datosMedicos from dbo.Socios where dni = ?");
				s.setInt(1, dni);
				ResultSet rs = s.executeQuery();
				if(rs.next()) {
					byte[] img = rs.getBytes("datosMedicos");
					ImageIcon image = new ImageIcon(img);
					Image im = image.getImage();
					Image myImg = im.getScaledInstance(165, 123, Image.SCALE_SMOOTH);
					newImage = new ImageIcon (myImg);	
				}
			}
			catch (Exception e)
			{
				System.out.println("Stack Trace: " + e.getStackTrace());
			}
			return newImage; 
		}
		
		public void deleteSocio(Socio socio) 
		{
			/*----TRY DE LA CONECCION ELIMINAR----*/

			try
			{
				Socio c = (Socio) socio;
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
						" estado = ?," +
						" datosMedicos = ?" +
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
				s.setBinaryStream(9, (InputStream) soc.getDatosMedicos());
				s.setInt(10, soc.getDni());
				
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
					Date fechaVencimiento = result.getDate(9);
					Blob blob = (Blob) result.getBlob(11);
					String estadoAbono = result.getString(12);
					Date fechaVencimientoAbono = result.getDate(13);
					String apellido = result.getString(14);
					
					
					Persona p = new Persona(null, email, nombre, null, domicilio, dni, fechaDeNac, "socio", estado, fechaDeInscripcion, apellido);
					socio = new Socio(p, "socio", fechaVencimiento, tipoAbono, null, blob, estadoAbono, fechaVencimientoAbono);
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
		
		public boolean existeSocio (int dni) {
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
					String apellido = res.getString(13);
					Persona p = new Persona(nombreUsuario,mail,nombre,password,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades, apellido);
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
					String apellido = res.getString(13);
					
					Date fechaInicioActividades = res.getDate(9);
					String diasLaborales = res.getString(10);
					
					Persona p = new Persona(nombreUsuario,mail,nombre,password,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades, apellido);
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
					String apellido = res.getString(13);

					Persona p = new Persona(nombreUsuario,mail,nombre,null,domicilio,dni,fechaDeNac,rol,estado,fechaInicioActividades, apellido);
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

		public ResultSet listarProfesores() {
			try {
				Profesor p = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				PreparedStatement s = con.prepareStatement("select * from dbo.Profesores");

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
				System.out.println("Error select listar profesores\n");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}
		
		public ResultSet listarEmpleadosLiquidacion() {
			try {
				Empleado emp = null;
				Connection con = PoolConnection.getPoolConnection().getConnection();
				PreparedStatement s = con.prepareStatement("select nombreUsuario, nombre, email, dni, sueldo, fechaInicioActividades, diasLaborales, rol from dbo.Empleados where estado = 'Activo'");

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
				System.out.println("Error select listar empleados\n");
				System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			}
			return null;
		}

		public void liquidarSueldoEmpleado(String nombreUsuario, String nombreCompleto, int dni, Float importeTotal, 
				Float sueldo, Float extras, Float porJub, Float porObra, Float porImpGen, Date fechaPago, String descripcion) {
			
		try {
			String nombreComp = (String) nombreCompleto;
			int numDni = (int) dni;
			Float importeTot = (Float) importeTotal; 
			Float sue = (Float) sueldo;
			Float ext = (Float) extras;
			Float pJub = (Float) porJub;
			Float pObra = (Float) porObra;
			Float pImpGen = (Float) porImpGen;
			Date fPago = (Date) fechaPago;
			String descr = (String) descripcion;

			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("insert into dbo.LiquidacionDeSueldos (nombreCompleto, dni, importeTotal, sueldo, extras, fechaPago, descripcion, fechaLiquidacion, porAporteJub, porObraSoc, porImpGral) values (?,?,?,?,?,?,?,?,?,?,?)");
			//agregar campos
			
			s.setString(1,nombreComp);
			s.setInt(2,numDni);
			s.setFloat(3,importeTot);
			s.setFloat(4,sue);
			s.setFloat(5,ext);
			s.setDate(6,fPago);
			s.setString(7,descr);
			java.util.Date today = Calendar.getInstance().getTime();
			java.sql.Date fechaHoy = new java.sql.Date(today.getTime());
			s.setDate(8,fechaHoy); // LOCAL DATE
			s.setFloat(9,pJub);
			s.setFloat(10,pObra);
			s.setFloat(11,pImpGen);

			s.execute();

			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch(Exception e)
		{
			System.out.println("Error insert liquidacion");
			System.out.println("Stack trace: "+e.getStackTrace());
			
		}
	}
		
	public ResultSet listarEstadoDeAbonos() {
		try {
			Empleado emp = null;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			PreparedStatement s = con.prepareStatement("select dni, nombre, email, estadoAbono, fechaVencimientoAbono from dbo.Socios where estado = 'Activo' order by estadoAbono DESC");

			ResultSet result = s.executeQuery();
			
			PoolConnection.getPoolConnection().realeaseConnection(con);

			return result;
		} 
		catch (Exception e) {
			System.out.println("Error select listar estado de abonos\n");
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
		}
		return null;
	}
	
	public void actualizarEstadoDeAbonos() {
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Socios " +
					"set estadoAbono =?" +
					" where fechaVencimientoAbono < ?");
			/*----CAMPOS DEL SOCIO----*/
			
			s.setString(1, "Vencido");
			java.util.Date today = Calendar.getInstance().getTime();
			java.sql.Date fechaHoy = new java.sql.Date(today.getTime());
			s.setDate(2, fechaHoy);
			
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s2 = con.prepareStatement("update dbo.Socios " +
					"set estadoAbono = ? " +
					" where ? between DateAdd(DD,-7,fechaVencimientoAbono) and fechaVencimientoAbono ");
			
			/*----CAMPOS DE SOCIO----*/
			
			s2.setString(1, "PorVencer");
			s2.setDate(2, fechaHoy);

			s.execute();
			s2.execute();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio update abonos estado");
		}
	}
	
	public void actualizarEstadoYFechaAbono(Socio socio, Date fechaNueva) 
	{
		/*----TRY DE LA CONECCION UPDATE----*/
		
		try
		{
			Socio soc =(Socio) socio;
			Connection con = PoolConnection.getPoolConnection().getConnection();
			/*----STATEMENT QUERY DEL UPDATE----*/
			PreparedStatement s = con.prepareStatement("update dbo.Socios " +
					" set estadoAbono =?," +
					" fechaVencimientoAbono =?" +
					" where dni = ?");
			/*----CAMPOS DE CLIENTE----*/
			
			s.setString(1, "Pago");
			s.setDate(2, fechaNueva);
			s.setInt(3, soc.getDni());
			
			s.executeUpdate();
			PoolConnection.getPoolConnection().realeaseConnection(con);
		}
		catch (Exception e)
		{
			System.out.println("Stack Trace: " + e.getStackTrace() + e.getMessage());
			System.out.println("rompio actualizar estado y fecha abono");
		}
	}
}
