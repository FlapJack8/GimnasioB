package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaUsuarios;
//import modelo.VendedorBoleteria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel cpLogin;
	private JTextField textUsuario;
	private JPasswordField passwordField;
	
	public static Login instanciaLogin;
	
	public static String rolLogin;
	
	public Login getInstancia(SistemaUsuarios usuariosControlador, String rol) {
		
		/*----INSTANCIAMOS LOGIN PARA QUE SOLO HAYA UNA SESION----*/
		
		if(instanciaLogin==null&&rolLogin==null){
			instanciaLogin=new Login();
			
			
			
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
							//JOptionPane.showMessageDialog(null, "Ingreso correcto!");
							switch (rolLogeado.toLowerCase()) {
							case "vendedor":
								rolLogin = "vendedor";
								
							break;
							case "administrador":
								
							break;
							case "agente comercial":
								
								break;
							case "operador":
								
								break;
							default:
								rolLogin = "cliente";
								System.out.println("Hola "+rol);
								break;
							}
							dispose();
						}
						else
						{
							
							/*----USUARIO NO EXISTE----*/
							
							JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectos","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
				btnIngresar.setBounds(254, 209, 110, 23);
				cpLogin.add(btnIngresar);
				
				/*----BOTON REGISTRARSE----*/
				
				JButton btnRegistrarse = new JButton("Registrarse");
				btnRegistrarse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/*----------------------------------------------------------
						 *    EJECUTA REGISTRAR CLIENTE YA QUE EL RESTO DE LAS ALTAS 
						 *    DE LOS USUARIOS LAS DARA EL ADMINISTRADOR
						 *    
						 *--------------------------------------------------------*/
						
						if (usuariosControlador != null) {
							
							/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
							/*----INICIA LA VENTANA DE REGISTRO----*/
							
							RegistrarSocio altaUsuarios = new RegistrarSocio(usuariosControlador);
							altaUsuarios.setVisible(true);
						}
				}
			});
			btnRegistrarse.setBounds(75, 209, 110, 23);
			cpLogin.add(btnRegistrarse);

		}
		
		return instanciaLogin;
	}
}
