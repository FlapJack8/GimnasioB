package ventanas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

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

/*------Instancio Controladores-------*/
	
	public Main() {
			super();

			usuariosControlador = SistemaUsuarios.getInstancia();

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
			 * 2) 
			 * 3) 
			 * 4) 
			 * 5) 
			 * 6) 
			 * 7) 
			 **********************************
			 */
			
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
			
			setTitle("Ventana Principal");
			getContentPane().setLayout(null);
			setBounds(450, 250, 460, 220);
			
			/*-------------------------------------------
			 *  *    1)        USUARIOS              *  *
			 *-------------------------------------------
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
			break;
			case "operador":
				btnSistemaUsuarios.setEnabled(true);
				btnSistemaUsuarios.setLabel("Socios");
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
