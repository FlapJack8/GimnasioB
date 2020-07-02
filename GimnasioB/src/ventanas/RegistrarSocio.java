package ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.SistemaUsuarios;

public class RegistrarSocio extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textDNI;
	private JTextField textFechaNac;
	private JTextField textContra1;
	private JTextField textContra2;
	private JTextField txtNombre;

	/*---------CREO VENTANA DE REGISTRO----*/
	
	public RegistrarSocio(SistemaUsuarios usuariosControlador) {
		setTitle("Registrar Socio");
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 470, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
		JLabel lblIngreseSuNombre = new JLabel("Nombre de usuario:");
		lblIngreseSuNombre.setBounds(11, 62, 152, 14);
		contentPane.add(lblIngreseSuNombre);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(11, 93, 152, 14);
		contentPane.add(lblDomicilio);
			
		JLabel label = new JLabel("");
		label.setBounds(191, 75, 86, 14);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(11, 124, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(11, 157, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
		lblFechaNacimiento.setBounds(11, 188, 102, 14);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a:");
		lblIngreseSuContrasea.setBounds(10, 221, 142, 14);
		contentPane.add(lblIngreseSuContrasea);
		
		JLabel lblIngresaNuevamente = new JLabel("Ingresa nuevamente:");
		lblIngresaNuevamente.setBounds(11, 251, 191, 14);
		contentPane.add(lblIngresaNuevamente);

		textUsuario = new JTextField();
		textUsuario.setBounds(212, 59, 152, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(212, 90, 152, 20);
		contentPane.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(212, 121, 152, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textDNI = new JTextField();
		textDNI.setBounds(212, 154, 152, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textFechaNac = new JTextField();
		textFechaNac.setBounds(212, 185, 152, 20);
		contentPane.add(textFechaNac);
		textFechaNac.setColumns(10);
		
		textContra1 = new JTextField();
		textContra1.setBounds(212, 218, 152, 20);
		contentPane.add(textContra1);
		textContra1.setColumns(10);
		
		textContra2 = new JTextField();
		textContra2.setBounds(212, 248, 152, 20);
		contentPane.add(textContra2);
		textContra2.setColumns(10);
		
		JLabel lblIngreseSuNombre_1 = new JLabel("Nombre:");
		lblIngreseSuNombre_1.setBounds(11, 25, 141, 14);
		contentPane.add(lblIngreseSuNombre_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(212, 22, 152, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(157, 293, 152, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
				Date fechaN=Date.valueOf( textFechaNac.getText());
				if(txtNombre.getText().equals("")||textContra1.getText().equals("")||textContra2.getText().equals("")||textDNI.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||textMail.getText().equals("")||textUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

				}
				else {
					if(usuariosControlador.existeUsuario(textUsuario.getText())) {
						JOptionPane.showMessageDialog(null, "Usuario ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
						textUsuario.selectAll();
						textUsuario.requestFocus();
					}
					else
					{
						usuariosControlador.altaUsuario(txtNombre.getText(), textMail.getText(), textContra1.getText(), textUsuario.getText(), textDomicilio.getText(), Integer.parseInt(textDNI.getText()),fechaN, "Cliente",false);

						JOptionPane.showMessageDialog(null, "Ingreso correcto");
						usuariosControlador.imprimir();
						dispose();
					}
				}

			}
		});
		contentPane.add(btnEnviar);
		
	}
}
