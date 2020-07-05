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
	private JTextField textDNI;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textFechaNacimiento;
	private JTextField textFechaIns;
	private JTextField textTipoAbono;
	private JTextField textNombre;
	private JTextField textFechaVen;

	/*---------CREO VENTANA DE REGISTRO----*/
	
	public RegistrarSocio(SistemaUsuarios usuariosControlador) {
		setTitle("Registrar Socio");
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 720, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(11, 62, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(11, 124, 64, 14);
		contentPane.add(lblDomicilio);
			
		JLabel label = new JLabel("");
		label.setBounds(191, 75, 86, 14);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(11, 93, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(11, 157, 102, 14);
		contentPane.add(lblFechaNacimiento);

		JLabel lblFechaInscripcion = new JLabel("Fecha Inscripcion:");
		lblFechaInscripcion.setBounds(11, 188, 102, 14);
		contentPane.add(lblFechaInscripcion);
		
		JLabel lblTipoAbono = new JLabel("Tipo de Abono:");
		lblTipoAbono.setBounds(11, 216, 191, 14);
		contentPane.add(lblTipoAbono);

		textDNI = new JTextField();
		textDNI.setBounds(212, 59, 152, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(212, 121, 152, 20);
		contentPane.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(212, 90, 152, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(212, 154, 152, 20);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		textFechaIns = new JTextField();
		textFechaIns.setBounds(212, 185, 152, 20);
		contentPane.add(textFechaIns);
		textFechaIns.setColumns(10);
		
		textTipoAbono = new JTextField();
		textTipoAbono.setBounds(212, 213, 152, 20);
		contentPane.add(textTipoAbono);
		textTipoAbono.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(11, 25, 141, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(212, 22, 152, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		

		JLabel lblDatosMedicos = new JLabel("Datos Medicos:");
		lblDatosMedicos.setBounds(465, 25, 91, 14);
		contentPane.add(lblDatosMedicos);
		
		JButton btnImagenApto = new JButton("Buscar Imagen");
		btnImagenApto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnImagenApto.setBounds(513, 58, 117, 23);
		contentPane.add(btnImagenApto);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimineto Apto fisico:");
		lblFechaVencimiento.setBounds(465, 124, 165, 14);
		contentPane.add(lblFechaVencimiento);
		
		textFechaVen = new JTextField();
		textFechaVen.setBounds(508, 154, 86, 20);
		contentPane.add(textFechaVen);
		textFechaVen.setColumns(10);
		
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(311, 293, 152, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
			//if(!Date.valueOf( textFechaNacimiento.getText()).equals("")|| !Date.valueOf( textFechaIns.getText()).equals("")|| !Date.valueOf( textFechaVen.getText()).equals("")) {
				Date fechaN=Date.valueOf( textFechaNacimiento.getText());
				Date fechaI=Date.valueOf( textFechaIns.getText());
				Date fechaV=Date.valueOf( textFechaVen.getText());
			//}
				if(textNombre.getText().equals("")||textTipoAbono.getText().equals("")||textFechaNacimiento.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||fechaV.equals("")||fechaI.equals("")||textMail.getText().equals("")||textDNI.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

				}
				else {
					if(usuariosControlador.existeUsuario(textDNI.getText())) {
						JOptionPane.showMessageDialog(null, "El Socio ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
						textDNI.selectAll();
						textDNI.requestFocus();
					}
					else
					{
						usuariosControlador.altaUsuario(textNombre.getText(), textMail.getText(), null, null, textDomicilio.getText(), Integer.parseInt(textDNI.getText()),fechaN, "Socio", fechaI, null, null, null, textTipoAbono.getText(), fechaV);

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
