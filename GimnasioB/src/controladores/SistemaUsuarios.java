package controladores;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Vector;
import java.sql.Date;

import javax.swing.text.DateFormatter;

import modelo.Administrador;
//import modelo.AgenteComercial;
import modelo.Socio;
//import modelo.ContadoVentanilla;
import modelo.Empleado;
import modelo.Operador;
import modelo.Persona;
//import modelo.VendedorBoleteria;
import persistencia.UsrMapper;


/*----CONTROLADOR DE USUARIOS----*/

//TODO LEGAJO EMPLEADOS HACERLO AUTOINCREMENTAL

public class SistemaUsuarios {
	
	/*----CREO VECTORES DE USUARIOS----*/
	
	private static Vector <Socio> vSocios;
	private static Vector <Operador> vOperadores;
	private static Vector <Administrador> vAdministradores;
	//private static Vector <VendedorBoleteria> vVendedorBoleteria;
	//private static Vector <AgenteComercial> vAgenteComercial;
	
	private static SistemaUsuarios instanciaSistemaUsuarios;
	
	/*----------------------------*/
	
	/*----SINGLETON----*/
	
	public static SistemaUsuarios getInstancia(){
		if(instanciaSistemaUsuarios==null){
			instanciaSistemaUsuarios=new SistemaUsuarios();
			vSocios=new Vector<Socio>();
			
			vAdministradores=new Vector<Administrador>();
			
			//vAgenteComercial=new Vector<AgenteComercial>();
			vOperadores=new Vector<Operador>();
			//vVendedorBoleteria=new Vector<VendedorBoleteria>();
			 
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
	 *     a) Vendedor Boleteria
	 *     b) Administrador
	 *     c) Agente Comercial
	 *     d) Operador
	 * 11) EXISTE USUARIO EN MEMORIA
	 * 12) GET Y SET DEL CONTROLADOR
	 *****************************************
	 */
	
	
	/*-------------------------------
	 *  *    1)  CREO USUARIO    *  *
	 *-------------------------------
	 */
	
	public void altaUsuario(String nombre, String email, String password, String nombreUsuario, String domicilio, int dni, Date fechaNac, String rol,Date fechaInicioActividades, Float sueldo, String diasLaborales,String clases, String tipoAbono, Date fechaVen)
	{
		if(!existeUsuario(nombreUsuario)) {
	
			Persona p = new Persona(nombreUsuario, email, nombre, password, domicilio, dni, fechaNac,rol,fechaInicioActividades);
	
			switch (rol.toLowerCase()) {
			case "socio":
				Socio v1= new Socio(p, tipoAbono, fechaVen);
				vSocios.add(v1);
				break;
	        case "administrador":
	        	Administrador vAdm= new Administrador(p,rol,sueldo,diasLaborales);
				vAdministradores.add(vAdm);
	            break;
	        /*case "agente comercial":
	        	AgenteComercial vAgCom= new AgenteComercial(p,rol);
				vAgenteComercial.add(vAgCom);
	            break;
	        */
	          case "operador":
	        	Operador vOp= new Operador(p,rol,sueldo,diasLaborales);
				vOperadores.add(vOp);
	            break;
	        /*case "vendedor":
	        	VendedorBoleteria vVen= new VendedorBoleteria(p,rol);
				vVendedorBoleteria.add(vVen);
	            break;
	        */
			}
			p.isActivo();
			UsrMapper.getInstance().insert(p,sueldo,diasLaborales,clases, tipoAbono, fechaVen);
		}
	}

	/*-----------------*/
	
	/*----------------------------------
	 *  *    2)  ELIMINO CLIENTE    *  *
	 *----------------------------------
	 */
	
	/**
	 * public int bajaCliente(String nombreUsuario,int flag){

		if(nombreUsuario !=null) {
			Cliente v=buscarCliente(nombreUsuario);
			if(v!=null) {
				vClientes.remove(v);
				v.bajaLogica();
				UsrMapper.getInstance().updateCliente(v);
				flag = 1;
			}
		}
		return flag;
	}*/
	
	/*-----------------*/
	
	/*------------------------------------
	 *  *    3)  MODIFICAR CLIENTE    *  *
	 *------------------------------------
	 */

	public void modificarCliente(String nombreUsuario, String email, String password, String nombre, String domicilio, int dni, Date fechaNacimiento){
		for(Socio c: vSocios) {
			if(c.getNombreUsuario().toString().equals(nombreUsuario)) {
				c.setNombre(nombre);
				c.setEmail(email);
				c.setPassword(password);
				c.setDomicilio(domicilio);
				c.setDni(dni);
				c.setFechaDeNac(fechaNacimiento);
				UsrMapper.getInstance().updateCliente(c);
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
        case "agente comercial":
        	AgenteComercial vAgCom= new AgenteComercial(p,0);
			vAgenteComercial.add(vAgCom);
            break;
        case "operador":
        	Operador vOp= new Operador(p,0);
			vOperadores.add(vOp);
            break;
        case "vendedor":
        	VendedorBoleteria vVen= new VendedorBoleteria(p,0);
			vVendedorBoleteria.add(vVen);
            break;		
			
		}
		/*if(rol.equals("Vendedor")){
			VendedorBoleteria vVen= new VendedorBoleteria(p,0);
			vVendedorBoleteria.add(vVen);
		}
		else {
			if(rol.equals("Administrador")) {
				Administrador vAdm= new Administrador(p,0);
				vAdministradores.add(vAdm);
			}
			else {
				if(rol.equals("Agente Comercial")) {
					AgenteComercial vAgCom= new AgenteComercial(p,0);
					vAgenteComercial.add(vAgCom);
				}
				else {
					if(rol.equals("Operador")){
						Operador vOp= new Operador(p,0);
						vOperadores.add(vOp);
					}
				}
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
			/*VendedorBoleteria v=buscarVendedorBoleteria(nombreUsuario);
			if(v!=null) {
				vVendedorBoleteria.remove(v);
				v.bajaLogica();
				UsrMapper.getInstance().updateEmpleado(v);
				return 1;
			}*/
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
			}/*
			AgenteComercial ag=buscarAgenteComercial(nombreUsuario);
			if(ag!=null) {
				vAgenteComercial.remove(ag);
				ag.bajaLogica();
				UsrMapper.getInstance().updateEmpleado(ag);
				return 1;
			}*/
		}
		
		return flag;
	}
	
	/*-------------------------------------
	 *  *    6)  MODIFICAR EMPLEADO    *  *
	 *-------------------------------------
	 */
	
	public void modificarEmpleado(String nombreUsuario, String email, String password, String nombre, String domicilio, int dni, Date fechaNacimiento, String rol){
		
		/*----Dependiendo el rol modificamos el empleado----*/
		
		switch (rol.toLowerCase()) {
			/*case "vendedor":
				for(VendedorBoleteria v: vVendedorBoleteria) {
					if(v.getNombreUsuario().toString().equals(nombreUsuario)) {
						v.setNombre(nombre);
						v.setEmail(email);
						v.setPassword(password);
						v.setDomicilio(domicilio);
						v.setDni(dni);
						v.setFechaDeNac(fechaNacimiento);	
						v.setRol(rol); 
						v.esActivo();
						UsrMapper.getInstance().updateEmpleado(v);
					}
				}
			break;*/
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
						UsrMapper.getInstance().updateEmpleado(a);
					}
				}
			break;
			/*case "agente comercial":
				for(AgenteComercial ag: vAgenteComercial) {
					if(ag.getNombreUsuario().toString().equals(nombreUsuario)) {
						ag.setNombre(nombre);
						ag.setEmail(email);
						ag.setPassword(password);
						ag.setDomicilio(domicilio);
						ag.setDni(dni);
						ag.setFechaDeNac(fechaNacimiento);
						ag.setRol(rol); 
						ag.esActivo();
						UsrMapper.getInstance().updateEmpleado(ag);
					}
				}
			break;*/
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
		
		/*VendedorBoleteria v = buscarVendedorBoleteria(nombreUsuario);
			
		if(v!=null)
			if(v.getPassword().equals(password))
				return "Vendedor";
		*/
		
		/*----Lo mismo con los demas roles----*/
		
		Administrador a = buscarAdministrador(nombreUsuario);
		
		if(a!=null)
			if(a.getPassword().equals(password))
				return "Administrador";
	/*----------------------------------------------------------*/	
		
		Operador o = buscarOperador(nombreUsuario);
		
		if(o!=null)
			if(o.getPassword().equals(password))
				return "Operador";
	/*----------------------------------------------------------*/	

		/*AgenteComercial ag = buscarAgenteComercial(nombreUsuario);

		if(ag!=null)
			if(ag.getPassword().equals(password))
				return "Agente Comercial";
		*/
		
		/**----VERIFICO VECTOR CLIENTES----

		Cliente c = buscarCliente(nombreUsuario);

		if(c!=null) {
			if(c.getPassword().equals(password))
				return "Cliente";
		}*/
		return null;
		
	}
	
	/*-----------------*/
	
	/*--------------------------------
	 *  *    8) BUSCAR CLIENTE    *  *
	 *--------------------------------
	 */
	
	/*-----BUSCAR USUARIO DENTRO DEL VECTOR vClientes------------*/

	/**
	 * public Cliente buscarCliente(String nombreUsuario) {
	 */
		
		/*----Buscamos en memoria----
		for(Cliente c: vClientes)
		{
			if(c.getNombreUsuario().equals(nombreUsuario)) {
					return c;	
			}
		}
		/*----Si no esta, buscamos en BD----

		Cliente c=UsrMapper.getInstance().buscarCliente(nombreUsuario);

		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----
		
		if(c!=null)
			vClientes.add(c);

		return c;
		

	}*/
	
	/*-----------------*/
	
	/*----------------------------------------------------
	 *  *    9) EXISTE USUARIO (EMPLEADO - CLIENTE)   *  *
	 *----------------------------------------------------
	 */
	public boolean existeEmpleado (String nombreUsuario) {//Hace mas o menos lo mismo que buscarX pero devuelve un boolean

		/*VendedorBoleteria v = buscarVendedorBoleteria(nombreUsuario);
		
		if(v!=null)
			return true;
		*/
		Administrador a = buscarAdministrador(nombreUsuario);

		if(a!=null)
			return true;

		/*AgenteComercial ag = buscarAgenteComercial(nombreUsuario);

		if(ag!=null)
			return true;
		*/
		
		Operador o = buscarOperador(nombreUsuario);
		
		if(o!=null)
			return true;
		
		return false;
		
	}
	
	/**public boolean existeCliente (String nombreUsuario) {//Hace mas o menos lo mismo que buscarCliente pero devuelve un boolean

		Cliente c= buscarCliente(nombreUsuario);
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----
		
		if(c!=null)
			return true;

		return false;
	}*/
	
	/**---------------------------------
	 *  *    10) BUSCAR EMPLEADO    *  *
	 *---------------------------------
	 */
	
	/**-----BUSCAR USUARIO DENTRO DE LOS ROLES DE EMPLEADOS------------**/

		/*----a)----*/
	/*public VendedorBoleteria buscarVendedorBoleteria(String nombre) {
		
		/*----Buscamos en memoria----
		for(VendedorBoleteria c: vVendedorBoleteria)
		{
			if(c.getNombreUsuario().equals(nombre)) {
					return c;	
			}
		}
		
		/*----Si no esta, buscamos en BD----
		
		VendedorBoleteria c=UsrMapper.getInstance().buscarVendedorBoleteria(nombre);
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----
		
		if(c!=null)
			vVendedorBoleteria.add(c);
		return c;
		
	}*/
		/*----b)----*/
	public Administrador buscarAdministrador(String nombreUsuario) {
		
		/*----Buscamos en memoria----*/
		Persona p = new Persona("Ivan", "hola123", "Ivan", "123", "domicilio", 12345, Date.valueOf("2009-10-10"), "administrador",Date.valueOf("2012-10-10"));
        Administrador vAdm= new Administrador(p,"administrador",1900.00f,"lunes,martes");
		vAdministradores.add(vAdm);
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
		/*----c)----*/
	/*public AgenteComercial buscarAgenteComercial(String nombreUsuario) {
		
		/*----Buscamos en memoria----

		for(AgenteComercial c: vAgenteComercial)
		{
			if(c.getNombreUsuario().equals(nombreUsuario)) {
					return c;	
			}
		}
		
		/*----Si no esta, buscamos en BD----
		
		AgenteComercial c=UsrMapper.getInstance().buscarAgenteComercial(nombreUsuario);
		
		/*----AGREGAMOS USUARIO PARA FUTURAS BUSQUEDAS----
		
		if(c!=null)
			vAgenteComercial.add(c);
		return c;
		
	}*/
		/*----d)----*/
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
		/**else
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
		
		/*for(AgenteComercial agCom: vAgenteComercial) { //For each
			String nombre = new String();
			int dni;
			String r = new String();
			nombre=agCom.getNombreUsuario();
			dni=agCom.getDni();
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
		/*for(VendedorBoleteria vvb: vVendedorBoleteria) { //For each
			String nombre = new String();
			int dni;
			String r = new String();
			nombre=vvb.getNombreUsuario();
			dni=vvb.getDni();
			r=vvb.getRol();
			
			System.out.printf("%d -  %s  - Empleado: %s \n",dni,nombre,r);
			
		}*/
	}

}
