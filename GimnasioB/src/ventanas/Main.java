package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controladores.SistemaAbonos;
import controladores.SistemaActividades;
import controladores.SistemaClases;
import controladores.SistemaFacturas;
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
	private SistemaClases clasesControlador;
	private SistemaAbonos abonosControlador;
	private SistemaActividades actividadesControlador;
	private SistemaFacturas facturasControlador;




/*------Instancio Controladores-------*/
	
	public Main() {
			super();

			usuariosControlador = SistemaUsuarios.getInstancia();
			clasesControlador = SistemaClases.getInstancia();
			abonosControlador = SistemaAbonos.getInstancia();
			actividadesControlador = SistemaActividades.getInstancia();
			facturasControlador = SistemaFacturas.getInstancia();

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
			 * 1) USUARIOS
			 * 2) CLASES
			 * 3) ABONOS
			 * 4) ACTIVIDADES
			 * 5) LIQUIDAR SUELDOS
			 * 6) FACTURAR SOCIO
			 * 7) 
			 **********************************
			 */
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
			
			setTitle("Ventana Principal");
			getContentPane().setLayout(null);
			setBounds(450, 250, 460, 300);
			
			/*-------------------------------------------
			 *  *    1)        USUARIOS              *  *
			 *-------------------------------------------
			 */

			
			JButton btnSistemaUsuarios = new JButton("Usuarios");
			btnSistemaUsuarios.setBounds(250, 75, 169, 23);
			btnSistemaUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (usuariosControlador != null) {
						
						/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
						
						OpcionesUsuarios opcionesUsuarios = new OpcionesUsuarios(usuariosControlador, rolLogeado, actividadesControlador);
						opcionesUsuarios.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaUsuarios);
			
			/*-------------------------------------------
			 *  *    2)        CLASES              *  *
			 *-------------------------------------------
			 */
			
			JButton btnSistemaClases = new JButton("Clases");
			btnSistemaClases.setBounds(20, 75, 169, 23);
			btnSistemaClases.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (clasesControlador != null) {
						
						/*----ENVIA CONTROLADOR DE CLASES A LA SIGUIENTE VISTA Y USUARIOS POR PROFESOR----*/
						
						OpcionesClases opcionesClases = new OpcionesClases(clasesControlador, usuariosControlador, rolLogeado);
						opcionesClases.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaClases);
			
			/*-------------------------------------------
			 *  *    3)        ABONO              *  *
			 *-------------------------------------------
			 */
			
			JButton btnSistemaAbonos = new JButton("Abonos");
			btnSistemaAbonos.setBounds(20, 120, 169, 23);
			btnSistemaAbonos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (clasesControlador != null) {
						
						/*----ENVIA CONTROLADOR DE ABONOS A LA SIGUIENTE VISTA----*/
						
						OpcionesAbonos opcionesAbonos = new OpcionesAbonos(abonosControlador, rolLogeado);
						opcionesAbonos.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaAbonos);
			
			/*-------------------------------------------
			 *  *    4)        ACTIVIDADES              *  *
			 *-------------------------------------------
			 */
			
			JButton btnSistemaActividades = new JButton("Actividades");
			btnSistemaActividades.setBounds(250, 120, 169, 23);
			btnSistemaActividades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (actividadesControlador != null) {
						
						/*----ENVIA CONTROLADOR DE ACTIVIDADES A LA SIGUIENTE VISTA----*/
						
						OpcionesActividades opcionesActividades = new OpcionesActividades(actividadesControlador, rolLogeado);
						opcionesActividades.setVisible(true);
					}
				}
			});
			getContentPane().add(btnSistemaActividades);
			
			/*-------------------------------------------
			 *  *    5)     LIQUIDAR SUELDOS         *  *
			 *-------------------------------------------
			 */
			
			JButton btnLiquidarSueldos = new JButton("Liquidar Sueldos");
			btnLiquidarSueldos.setBounds(20, 165, 169, 23);
			btnLiquidarSueldos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (usuariosControlador != null) {
						
						/*----ENVIA CONTROLADOR DE ABONOS A LA SIGUIENTE VISTA----*/
						
						ListarEmpleadosLiquidarSueldo listarEmplLiquSueldos = new ListarEmpleadosLiquidarSueldo(usuariosControlador, rolLogeado);
						listarEmplLiquSueldos.setVisible(true);
					}
				}
			});
			getContentPane().add(btnLiquidarSueldos);

			/*-------------------------------------------
			 *  *    6)     FACTURAR SOCIO           *  *
			 *-------------------------------------------
			 */
			
			JButton btnFacturarSocio = new JButton("Facturar Cuota");
			btnFacturarSocio.setBounds(250, 165, 169, 23);
			btnFacturarSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (facturasControlador != null) {
						
						/*----ENVIA CONTROLADOR DE ABONOS A LA SIGUIENTE VISTA----*/
						
						FacturarBuscarSocio facturarBuscarSocio = new FacturarBuscarSocio(facturasControlador, usuariosControlador);
						facturarBuscarSocio.setVisible(true);
					}
				}
			});
			getContentPane().add(btnFacturarSocio);
			
			/*-------------------------------------------------------------
			 *  *      DEPENDIENDO EL ROL HABILITAMOS LOS BOTONES      *  *
			 *-------------------------------------------------------------
			 */
			
			switch (rolLogeado.toLowerCase()) {
			/*case "profesor":
				btnSistemaUsuarios.setEnabled(false);
			break;*/
			case "administrador":
				btnSistemaUsuarios.setEnabled(true);
				btnSistemaClases.setEnabled(true);
				btnSistemaAbonos.setEnabled(true);
				btnSistemaActividades.setEnabled(true);
				btnLiquidarSueldos.setEnabled(true);
			break;
			case "operador":
				btnSistemaUsuarios.setEnabled(true);
				btnSistemaUsuarios.setLabel("Socios");
				btnSistemaClases.setEnabled(true);
				btnSistemaAbonos.setEnabled(true);
				btnSistemaActividades.setEnabled(false);
				btnSistemaActividades.setVisible(false);
				btnLiquidarSueldos.setEnabled(false);
				btnLiquidarSueldos.setEnabled(false);
				break;
			/*default://Socio
				btnSistemaUsuarios.setEnabled(false);
				
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
							
							JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrectos","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
				btnIngresar.setBounds(145, 190, 110, 23);
				cpLogin.add(btnIngresar);
	}
}
