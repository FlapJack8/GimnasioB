package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/*import controladores.SistemaCines;
import controladores.SistemaDescuento;
import controladores.SistemaPeliculas;
import controladores.SistemaVentas;

import modelo.AgenteComercial;
import modelo.Cliente;
import modelo.VendedorBoleteria;
*/
import controladores.SistemaUsuarios;
import modelo.Administrador;
import modelo.Operador;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.Font;
import java.awt.event.ActionEvent;

/*---------MAIN PRINCIPAL DE SISTEMA--------------*/

public class Main extends JFrame{
	
	/*----DEFINO CONTROLADORES-------*/
	
	private static final long serialVersionUID = 1L;
	private SistemaUsuarios usuariosControlador;
	/*private SistemaVentas ventasControlador;
	private SistemaCines cinesControlador;
	private SistemaPeliculas peliculasControlador;
	private SistemaDescuento descuentosControlador;
	*/
/*------Instancio Controladores-------*/
	
	public Main() {
			super();

			usuariosControlador = SistemaUsuarios.getInstancia();
			/*ventasControlador = SistemaVentas.getInstancia();
			cinesControlador = SistemaCines.getInstancia();
			peliculasControlador =  SistemaPeliculas.getInstancia();
			descuentosControlador = SistemaDescuento.getInstancia();
			*/

			/*----------------------------------------------
			 *  *      MOSTRAMOS PANTALLA DE LOGIN      *  *
			 *----------------------------------------------
			 */
			
			initGUILogin();
	}
	
	/*----MAIN PRINCIPAL----*/
	
	public static void main(String[] args) {
		
		Main main = new Main();
		
		main.setVisible(true);
		
	}
	
	/*--------------CREO LA VENTANA PRINCIPAL--------------*/
	
	private void initGUI(String rolLogeado,String usuario) {
		try {
			
			/*----------------------------------------------
			 *  *      MOSTRAMOS PANTALLA MENU      *  *
			 *----------------------------------------------
			 */
			
			/**
			 **********************************
			 * 1) COMPRA ENTRADA CLIENTE
			 * 2) COMPRA ENTRADA VENDEDOR
			 * 3) USUARIOS
			 * 4) DESCUENTOS (AGENTE COMERCIAL)
			 * 5) PELICULAS
			 * 6) CINES
			 * 7) IMPRIMIR ENTRADAS
			 **********************************
			 */
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
			
			setTitle("Ventana Principal");
			getContentPane().setLayout(null);
			setBounds(450, 250, 460, 220);
			
			/*-------------------------------------------
			 *  *    1)  COMPRA ENTRADA CLIENTE      *  *
			 *-------------------------------------------
			 */
			/*
			JButton btnCompraEntradaCliente = new JButton("Compra Entrada Cliente");
			btnCompraEntradaCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (ventasControlador != null) {
						
						/*----ENVIA CONTROLADOR DE VENTAS A LA SIGUIENTE VISTA----
						Cliente usu=usuariosControlador.buscarCliente(usuario);
						String nombre=usu.getNombre();
						CompraEntradaOnline compraOnline = new CompraEntradaOnline(ventasControlador,usuariosControlador,cinesControlador,usuario,nombre);
						compraOnline.setVisible(true);
					}
				}
			});
			btnCompraEntradaCliente.setBounds(40, 48, 164, 23);
			getContentPane().add(btnCompraEntradaCliente);
			
			/*--------------------------------------------
			 *  *    2)  COMPRA ENTRADA VENDEDOR      *  *
			 *--------------------------------------------
			 
			
			JButton btnCompraEntradaVendedor = new JButton("Compra Entrada Vendedor");
			btnCompraEntradaVendedor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (ventasControlador != null) {
						
						/*----ENVIA CONTROLADOR DE VENTAS A LA SIGUIENTE VISTA----
						VendedorBoleteria usu = usuariosControlador.buscarVendedorBoleteria(usuario);
						String nombre=usu.getNombre();	
						int dni=usu.getDni();
						RealizarCompraVendedor compraOnline = new RealizarCompraVendedor(cinesControlador,ventasControlador,usuariosControlador,nombre,dni);
						compraOnline.setVisible(true);
					}
				}
			});
			btnCompraEntradaVendedor.setBounds(130, 15, 190, 23);
			getContentPane().add(btnCompraEntradaVendedor);	
			*/
			/*-----------------------------
			 *  *    3)  USUARIOS      *  *
			 *-----------------------------
			 */
			
			JButton btnSistemaUsuarios = new JButton("Usuarios");
			btnSistemaUsuarios.setBounds(135, 75, 169, 23);
			btnSistemaUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (usuariosControlador != null) {
						
						/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
						
						OpcionesUsuarios opcionesUsuarios = new OpcionesUsuarios(usuariosControlador, rolLogeado);
						opcionesUsuarios.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaUsuarios);
			
			/*--------------------------------------------------
			 *  *   4)   DESCUENTOS (AGENTE COMERCIAL)      *  *
			 *--------------------------------------------------
			 */
			/*
			JButton btnSistemaDescuentos = new JButton("Descuentos");
			btnSistemaDescuentos.setBounds(40, 90, 164, 23);
			btnSistemaDescuentos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (descuentosControlador != null) {
					/*----ENVIA CONTROLADOR DE DESCUENTOS A LA SIGUIENTE VISTA----
					
					MenuDescuentos vistaDescuentos = new MenuDescuentos(descuentosControlador);
					vistaDescuentos.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaDescuentos);
			
			/*------------------------------
			 *  *    5)  PELICULAS      *  *
			 *------------------------------
			 
			
			JButton btnSistemaPeliculas = new JButton("Peliculas y Funciones");
			btnSistemaPeliculas.setBounds(233, 90, 169, 23);
			btnSistemaPeliculas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (peliculasControlador != null) {
						
						/*----ENVIA CONTROLADOR DE PELICULAS A LA SIGUIENTE VISTA----
						
						VistaOperador vistaOperador = new VistaOperador(peliculasControlador, cinesControlador);
						vistaOperador.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaPeliculas);
			
			/*--------------------------
			 *  *    6)  CINES      *  *
			 *--------------------------
			 
			
			JButton btnSistemaCines = new JButton("Cines y Salas");
			btnSistemaCines.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cinesControlador!=null) {
						
						/*----ENVIA CONTROLADOR DE CINES A LA SIGUIENTE VISTA----

						VistaAdministrador vistaAdministrador = new VistaAdministrador(cinesControlador);
						vistaAdministrador.setVisible(true);
					}
					
				}
			});
			btnSistemaCines.setBounds(233, 133, 169, 23);
			getContentPane().add(btnSistemaCines);
			
			/*--------------------------------------
			 *  *    7)  IMPRIMIR ENTRADAS      *  *
			 *--------------------------------------
			 
			
			JButton btnImprimirEntradas = new JButton("Imprimir Entradas");
			btnImprimirEntradas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(ventasControlador!=null) {
						
						/*----ENVIA CONTROLADOR DE CINES A LA SIGUIENTE VISTA----

						RetiroEntradas vImprimirEntradas = new RetiroEntradas(ventasControlador);
						vImprimirEntradas.setVisible(true);
					}
					
				}
			});
			btnImprimirEntradas.setBounds(40, 133, 169, 23);
			getContentPane().add(btnImprimirEntradas);
			*/
			/*-------------------------------------------------------------
			 *  *      DEPENDIENDO EL ROL HABILITAMOS LOS BOTONES      *  *
			 *-------------------------------------------------------------
			 */
			
			switch (rolLogeado.toLowerCase()) {
			/*case "vendedor":
				btnSistemaDescuentos.setEnabled(false);
				btnSistemaCines.setEnabled(false);
				btnSistemaPeliculas.setEnabled(false);
				btnSistemaUsuarios.setEnabled(false);
				btnCompraEntradaCliente.setEnabled(false);
				btnCompraEntradaVendedor.setEnabled(true);
				btnImprimirEntradas.setEnabled(false);
			break;*/
			case "administrador":
				//btnSistemaDescuentos.setEnabled(false);
				//btnSistemaCines.setEnabled(true);
				//btnSistemaPeliculas.setEnabled(false);
				btnSistemaUsuarios.setEnabled(true);
				//btnCompraEntradaCliente.setEnabled(false);
				//btnCompraEntradaVendedor.setEnabled(false);
				//btnImprimirEntradas.setEnabled(false);
			break;
			/*case "agente comercial":
				btnSistemaDescuentos.setEnabled(true);
				btnSistemaCines.setEnabled(false);
				btnSistemaPeliculas.setEnabled(false);
				btnSistemaUsuarios.setEnabled(false);
				btnCompraEntradaCliente.setEnabled(false);
				btnCompraEntradaVendedor.setEnabled(false);
				btnImprimirEntradas.setEnabled(false);

				break;
			*/
			case "operador":
				//btnSistemaDescuentos.setEnabled(false);
				//btnSistemaCines.setEnabled(false);
				//btnSistemaPeliculas.setEnabled(true);
				btnSistemaUsuarios.setEnabled(true);
				btnSistemaUsuarios.setLabel("Socios");
				//btnCompraEntradaCliente.setEnabled(false);
				//btnCompraEntradaVendedor.setEnabled(false);
				//btnImprimirEntradas.setEnabled(false);
				break;
			/*default://Cliente
				btnSistemaDescuentos.setEnabled(false);
				btnSistemaCines.setEnabled(false);
				btnSistemaPeliculas.setEnabled(false);
				btnSistemaUsuarios.setEnabled(false);
				btnCompraEntradaCliente.setEnabled(true);
				btnCompraEntradaVendedor.setEnabled(false);
				btnImprimirEntradas.setEnabled(true);
				
				break;*/
			}

		}
			catch (Exception e) {
			
			e.printStackTrace();//Muestra el log del error
		}
		
	}
	
	private JPanel cpLogin;
	private JTextField textUsuario;
	private JPasswordField passwordField;
		
	
	/*----CREA INTERFAZ DEL LOGIN----*/
	
	private void initGUILogin() {	
			
			/*----CAMPOS A LLENAR----*/
			
			setTitle("Login");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(450, 250, 450, 300);
			cpLogin = new JPanel();
			cpLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(cpLogin);
			cpLogin.setLayout(null);
			
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblUsuario.setBounds(175, 37, 124, 23);
			cpLogin.add(lblUsuario);
			
			textUsuario = new JTextField();
			textUsuario.setBounds(140, 71, 124, 20);
			cpLogin.add(textUsuario);
			textUsuario.setColumns(10);
			
			JLabel lblContra = new JLabel("Contrase\u00F1a");
			lblContra.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblContra.setBounds(165, 105, 163, 23);
			cpLogin.add(lblContra);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(140, 139, 124, 20);
			cpLogin.add(passwordField);
			
			/*----BOTON INGRESAR----*/
			
			JButton btnIngresar = new JButton("Ingresar");
			btnIngresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textUsuario.getText().equals("")||passwordField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Por favor llene los campos vacios","Atencion",JOptionPane.WARNING_MESSAGE);
					}
					else {
						
						/*-------------------------------------------------------------------
						 *    EJECUTA LA VERIFICACION Y DEVUELVE EL ROL DEL USUARIO EN STRING
						 *	  SI EL USUARIO EXISTE
						 *
						 *-----------------------------------------------------------------*/
						
						String rolLogeado;
						rolLogeado = usuariosControlador.verificarUsuario(textUsuario.getText(), passwordField.getText());
						
						if(rolLogeado!=null) {
							getContentPane().removeAll();
							//JOptionPane.showMessageDialog(null, "Ingreso correcto!");
							switch (rolLogeado.toLowerCase()) {
							case "vendedor":
								initGUI(rolLogeado,textUsuario.getText());
							break;
							case "administrador":
								initGUI(rolLogeado,textUsuario.getText());
							break;
							case "agente comercial":
								initGUI(rolLogeado,textUsuario.getText());
								break;
							case "operador":
								initGUI(rolLogeado,textUsuario.getText());
								break;
							default:
								initGUI(rolLogeado,textUsuario.getText());
								break;
							}
						}
						else
						{
							
							/*----USUARIO NO EXISTE----*/
							
							JOptionPane.showMessageDialog(null, "Usuario y/o contrase�a incorrectos","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
				btnIngresar.setBounds(145, 190, 110, 23);
				cpLogin.add(btnIngresar);
				
				/*----BOTON REGISTRARSE----*/
				/*
				JButton btnRegistrarse = new JButton("Registrarse");
				btnRegistrarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/*----------------------------------------------------------
						 *    EJECUTA REGISTRAR CLIENTE YA QUE EL RESTO DE LAS ALTAS 
						 *    DE LOS USUARIOS LAS DARA EL ADMINISTRADOR
						 *    
						 *--------------------------------------------------------
						
						if (usuariosControlador != null) {
							
							/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----
							/*----INICIA LA VENTANA DE REGISTRO----
							
							RegistrarCliente altaUsuarios = new RegistrarCliente(usuariosControlador);
							altaUsuarios.setVisible(true);
						}
				}
			});
			btnRegistrarse.setBounds(75, 209, 110, 23);
			cpLogin.add(btnRegistrarse);*/

	}
}
