package controladores;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Vector;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.text.DateFormatter;

import modelo.Administrador;
import modelo.Socio;
import modelo.Empleado;
import modelo.Operador;
import modelo.Persona;
import modelo.Profesor;
import persistencia.ClasesMapper;
import persistencia.UsrMapper;


/*----CONTROLADOR DE USUARIOS----*/


public class SistemaUsuarios {
	
	/*----CREO VECTORES DE USUARIOS----*/
	
	private static Vector <Socio> vSocios;
	private static Vector <Operador> vOperadores;
	private static Vector <Administrador> vAdministradores;
	private static Vector <Profesor> vProfes;
	
	private static SistemaUsuarios instanciaSistemaUsuarios;
	
	/*----------------------------*/
	
	/*----SINGLETON----*/
	
	public static SistemaUsuarios getInstancia(){
		if(instanciaSistemaUsuarios==null){
			instanciaSistemaUsuarios=new SistemaUsuarios();
			vSocios=new Vector<Socio>();
			
			vAdministradores=new Vector<Administrador>();
			
			vOperadores=new Vector<Operador>();
			
			vProfes=new Vector<Profesor>();
			 
		}
		return instanciaSistemaUsuarios;
	}
	
	/*-----------------*/
	
	/**
	 *****************************************
	 * 1) CREO USUARIO
	 * 2) ELIMINO CLIENTE
	 * 3) MODIFICAR CLIENTE
	 //* 4) CREO EMPLEADO
	 * 5) ELIMINO EMPLEADO
	 * 6) MODIFICAR EMPLEADO
	 * 7) VERIFICAR USUARIO
	 * 8) BUSCAR CLIENTE
	 * 9) EXISTE USUARIO (EMPLEADO - CLIENTE)
	 * 10) BUSCAR EMPLEADO
	 *     a) 
	 *     b) Administrador
	 *     c) 
	 *     d) Operador
	 * 11) EXISTE USUARIO EN MEMORIA
	 * 12) GET Y SET DEL CONTROLADOR
	 *****************************************
	 */
	
	
	/*-------------------------------
	 *  *    1)  CREO USUARIO    *  *
	 *-------------------------------
	 */
	
	public void altaUsuario(String nombre, String email, String password, String nombreUsuario, String domicilio, int dni, Date fechaNac, String rol,Date fechaInicioActividades, Float sueldo, String diasLaborales,String actividades, String tipoAbono, Date fechaVen)
	{
		if(!existeUsuario(nombreUsuario)) {
	
			Persona p = new Persona(nombreUsuario, email, nombre, password, domicilio, dni, fechaNac,rol,fechaInicioActividades);
	
			switch (rol.toLowerCase()) {
				case "socio":
					Socio v1= new Socio(p, rol, fechaVen, tipoAbono);
					vSocios.add(v1);
					break;
		        case "administrador":
		        	Administrador vAdm= new Administrador(p,rol,sueldo,diasLaborales);
					vAdministradores.add(vAdm);
		            break;
		        case "operador":
		        	Operador vOp= new Operador(p,rol,sueldo,diasLaborales);
					vOperadores.add(vOp);
		            break;
		        case "profesor":
		        	Profesor vPr= new Profesor(p,rol,sueldo,diasLaborales,actividades);
					vProfes.add(vPr);
		            break;
			}
			p.isActivo();
			UsrMapper.getInstance().insert(p,sueldo,diasLaborales,actividades, tipoAbono, fechaVen);
		}
	}

	/*-----------------*/
	
	/*----------------------------------
	 *  *    2)  ELIMINO SOCIO    *  *
	 *----------------------------------
	 */
	
	 public int bajaSocio(int dni,int flag){

		if(dni != 0) {
			Socio v=buscarSocio(dni);
			if(v!=null) {
				vSocios.remove(v);
				v.bajaLogica();
				UsrMapper.getInstance().updateSocio(v);
				flag = 1;
			}
		}
		return flag;
	}
	
	/*-----------------*/
	
	/*------------------------------------
	 *  *    3)  MODIFICAR SOCIO    *  *
	 *------------------------------------
	 */

	public void modificarSocio(int dni, String nombre, String email, String domicilio, Date fechaNac, Date fechaIns, String tipoAbono, Date fechaVen){
		for(Socio s: vSocios) {
			if(s.getDni() == dni) {
				s.setNombre(nombre);
				s.setEmail(email);
				s.setDomicilio(domicilio);
				s.setEmail(email);
				s.esActivo();
				s.setFechaDeNac(fechaNac);
				s.setFechaInicioActividades(fechaIns);
				s.setTipoAbono(tipoAbono);
				s.setFechaVen(fechaVen);
				UsrMapper.getInstance().updateSocio(s);
			}
				
		}
	}

	/*-----------------*/
	
	/*--------------------------------
	 *  *    4)  CREO EMPLEADO    *  *
	 *--------------------------------
	 */
	
	/*public void altaEmpleado(String nombre, String email, String password, String nombreUsuario, String domicilio, int dni, String fechaNac, String rol)
	{
		Persona p = new Persona(nombre, email, password, nombreUsuario, domicilio, dni, fechaNac, rol);
		switch (rol.toLowerCase()) {
        case "administrador":
        	Administrador vAdm= new Administrador(p,0);
			vAdministradores.add(vAdm);
            break;
        case "operador":
        	Operador vOp= new Operador(p,0);
			vOperadores.add(vOp);
            break;
        case "profesor":
        	Profesor vPro= new Profesor(p,0);
			vProfes.add(vPro);
            break;		
	
		}
	}

	}*/
	
	/*-----------------------------------
	 *  *    5)  ELIMINO EMPLEADO    *  *
	 *-----------------------------------
	 */
	
	public int bajaEmpleado(String nombreUsuario,int flag)
	{
		if(nombreUsuario !=null) {
			Administrador a=buscarAdministrador(nombreUsuario);
			if(a!=null) {
				vAdministradores.remove(a);
				a.bajaLogica();
				UsrMapper.getInstance().updateEmpleado(a);
				return 1;
			}
			Operador o=buscarOperador(nombreUsuario);
			if(o!=null) {
				vOperadores.remove(o);
				o.bajaLogica();
				UsrMapper.getInstance().updateEmpleado(o);
				return 1;
			}
			Profesor pro=buscarProfesor(nombreUsuario);
			if(pro!=null) {
				vProfes.remove(pro);
				pro.bajaLogica();
				UsrMapper.getInstance().updateEmpleado(pro);
				return 1;
			}
		}
		
		return flag;
	}
	
	/*-------------------------------------
	 *  *    6)  MODIFICAR EMPLEADO    *  *
	 *-------------------------------------
	 */
	
	public void modificarEmpleado(String nombreUsuario, String email, String password, String nombre, String domicilio, int dni, Date fechaNacimiento, String rol, Date fechaInicioActividades, Float sueldo, String diasLaborales, String actividades){
		
		/*----Dependiendo el rol modificamos el empleado----*/
		
		switch (rol.toLowerCase()) {
			case "administrador":
				for(Administrador a: vAdministradores) {
					if(a.getNombreUsuario().toString().equals(nombreUsuario)) {
						a.setNombre(nombre);
						a.setEmail(email);
						a.setPassword(password);
						a.setDomicilio(domicilio);
						a.setDni(dni);
						a.setFechaDeNac(fechaNacimiento);
						a.setRol(rol); 
						a.esActivo();
						a.setDiasLaborales(diasLaborales);
						a.setSueldo(sueldo);
						a.setFechaInicioActividades(fechaInicioActividades);
						UsrMapper.getInstance().updateEmpleado(a);
					}
				}
			break;
			case "profesor":
				for(Profesor pro: vProfes) {
					if(pro.getNombreUsuario().toString().equals(nombreUsuario)) {
						pro.setNombre(nombre);
						pro.setEmail(email);
						pro.setPassword(password);
						pro.setDomicilio(domicilio);
						pro.setDni(dni);
						pro.setFechaDeNac(fechaNacimiento);
						pro.setRol(rol); 
						pro.esActivo();
						pro.setDiasLaborales(diasLaborales);
						pro.setSueldo(sueldo);
						pro.setFechaInicioActividades(fechaInicioActividades);
						pro.setActividades(actividades);
						UsrMapper.getInstance().updateEmpleado(pro);
					}
				}
			break;
			case "operador":
				for(Operador o: vOperadores) {
					if(o.getNombreUsuario().toString().equals(nombreUsuario)) {
						o.setNombre(nombre);
						o.setEmail(email);
						o.setPassword(password);
						o.setDomicilio(domicilio);
						o.setDni(dni);
						o.setFechaDeNac(fechaNacimiento);
						o.setRol(rol);
						o.esActivo();
						o.setDiasLaborales(diasLaborales);
						o.setSueldo(sueldo);
						o.setFechaInicioActividades(fechaInicioActividades);
						UsrMapper.getInstance().updateEmpleado(o);
					}
				}
			break;		
		}
	}
	
	/*------------------------------------------------
	 *  *    7) VERIFICAR USUARIO (Para Login)    *  *
	 *------------------------------------------------
	 */
	
	public String verificarUsuario(String nombreUsuario, String password)
	{

		/*----VERIFICO EMPLEADOS PRIMERO PORQUE EL VECTOR ES MAS CORTO----*/
		
		/*----Primero buscamos en memoria, luego en BD----*/
		
		
		Administrador a = buscarAdministrador(nombreUsuario);
		
		if(a!=null)
			if(a.getPassword().equals(password)&&a.getEstado().equals("Activo"))
				return "Administrador";
		
		/*----Lo mismo con los demas roles----*/
		
		Operador o = buscarOperador(nombreUsuario);
		
		if(o!=null)
			if(o.getPassword().equals(password)&&o.getEstado().equals("Activo"))
				return "Operador";
	/*----------------------------------------------------------*/	

		/*Profesor pro = buscarAgenteComercial(nombreUsuario);

		if(pro!=null)
			if(pro.getPassword().equals(password))
				return "profesor";
		*/
		
		/**----(Implementar si socios necesitan password) VERIFICO VECTOR CLIENTES----

		Socio c = buscarCliente(nombreUsuario);

		if(c!=null) {
			if(c.getPassword().equals(password))
				return "socio";
		}*/
		return null;
		
	}
	
	/*-----------------*/
	
	/*--------------------------------
	 *  *    8) BUSCAR SOCIO    *  *
	 *--------------------------------
	 */
	
	/*-----BUSCAR SOCIO DENTRO DEL VECTOR vSocios------------*/

	  public Socio buscarSocio(int dni) {
		
		/*----Buscamos en memoria----*/
		for(Socio s: vSocios)
		{
			if(s.getDni() == dni) {
					return s;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		Socio s=UsrMapper.getInstance().buscarSocio(dni);
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		if(s!=null)
			vSocios.add(s);
		return s;
	}
	
	/*-----------------*/
	
	/*----------------------------------------------------
	 *  *    9) EXISTE USUARIO (EMPLEADO - CLIENTE)   *  *
	 *----------------------------------------------------
	 */
	public boolean existeEmpleado (String nombreUsuario) {//Hace mas o menos lo mismo que buscarX pero devuelve un boolean

		Administrador a = buscarAdministrador(nombreUsuario);

		if(a!=null)
			return true;

		Profesor pro = buscarProfesor(nombreUsuario);

		if(pro!=null)
			return true;
		
		Operador o = buscarOperador(nombreUsuario);
		
		if(o!=null)
			return true;
		
		return false;
		
	}
	
	public boolean existeSocio (int dni) {//Hace mas o menos lo mismo que buscarSocio pero devuelve un boolean

		Socio s = buscarSocio(dni);
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		if(s!=null)
			return true;
		return false;
	}
	
	/**---------------------------------
	 *  *    10) BUSCAR EMPLEADO    *  *
	 *---------------------------------
	 */
	
	/**-----BUSCAR USUARIO DENTRO DE LOS ROLES DE EMPLEADOS------------**/

		/*----a)----*/

	public Administrador buscarAdministrador(String nombreUsuario) {
		
		/*----Buscamos en memoria----*/
		for(Administrador c: vAdministradores)
		{
			if(c.getNombreUsuario().equals(nombreUsuario)) {
					return c;	
			}
		}
		/*----Si no esta, buscamos en BD----*/
		
		Administrador c=UsrMapper.getInstance().buscarAdministrador(nombreUsuario);
		 
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		
		if(c!=null)
			vAdministradores.add(c);

		return c;
		
	}
		/*----b)----*/
	
	public Profesor buscarProfesor(String nombreUsuario) {
		
		/*----Buscamos en memoria----*/

		for(Profesor c: vProfes)
		{
			if(c.getNombreUsuario().equals(nombreUsuario)) {
					return c;	
			}
		}
		
		/*----Si no esta, buscamos en BD----*/
		
		Profesor c=UsrMapper.getInstance().buscarProfesor(nombreUsuario);
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		
		if(c!=null)
			vProfes.add(c);
		return c;
		
	}

		/*----c)----*/
	
	public Operador buscarOperador(String nombreUsuario) {
		
		/*----Buscamos en memoria----*/

		for(Operador c: vOperadores)
		{
			if(c.getNombreUsuario().equals(nombreUsuario)) {
					return c;	
			}
		}
		
		/*----Si no esta, buscamos en BD----*/
		

		Operador c=UsrMapper.getInstance().buscarOperador(nombreUsuario);
		 
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----*/
		
		if(c!=null)
			vOperadores.add(c);

		return c;
		
	}
	
	/*---------------------------------
	 *  *    11) EXISTE USUARIO    *  *
	 *---------------------------------
	 */
	
	public boolean existeUsuario(String nombreUsuario) {
		if(existeEmpleado(nombreUsuario))
			return true;
		return false;
		/**else Si se implementa login de usuarios
			return existeCliente(nombreUsuario);*/
	}

	/*-------------------------------------------
	 *  *    12) GET Y SET DEL CONTROLADOR    *  *
	 *-------------------------------------------
	 */
	
	public static SistemaUsuarios getInstanciaSistemaUsuarios() {
		return instanciaSistemaUsuarios;
	}

	public static void setInstanciaSistemaUsuarios(SistemaUsuarios instanciaSistemaUsuarios) {
		SistemaUsuarios.instanciaSistemaUsuarios = instanciaSistemaUsuarios;
	}
	
	/*-----------------*/
	
/*----------------------------------------------------------------------------*/
	
	public void imprimir() {
		
		for(Socio s: vSocios) { //For each
			String nombre = new String();
			int dni;
			nombre=s.getNombre();
			dni=s.getDni();
			
			System.out.printf("%d %s\n",dni,nombre);
			
		}
		System.out.println("\n");
	}

	public void imprimirEmpleados() {
		
		for(Administrador a: vAdministradores) { //For each
			String nombre = new String();
			int dni;
			String r = new String();
			nombre=a.getNombreUsuario();
			dni=a.getDni();
			r=a.getRol();
			
			System.out.printf("%d -  %s  - Empleado: %s \n",dni,nombre,r);
			
		}
		System.out.println("\n");
		
		/*for(Profesor pro: vProfes) { //For each
			String nombre = new String();
			int dni;
			String r = new String();
			nombre=pro.getNombreUsuario();
			dni=pro.getDni();
			r=agCom.getRol();
			
			System.out.printf("%d -  %s  - Empleado: %s \n",dni,nombre,r);
			
		}*/
		
		for(Operador op: vOperadores) { //For each
			String nombre = new String();
			int dni;
			String r = new String();
			nombre=op.getNombreUsuario();
			dni=op.getDni();
			r=op.getRol();
			
			System.out.printf("%d -  %s  - Empleado: %s \n",dni,nombre,r);
			
		}

	}
	
	public ResultSet listarProfesores(){
		
		ResultSet rs = null;
		rs = UsrMapper.getInstance().listarProfesores();
		
		return rs;
	}

}
