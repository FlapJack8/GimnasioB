package BITGym.ventanas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import BITGym.controladores.SistemaAbonos;
import BITGym.controladores.SistemaUsuarios;
import javax.swing.JComboBox;

public class RegistrarSocio extends JFrame {

	private JPanel contentPane;
	private JTextField textDNI;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textFechaNacimiento;
	private JTextField textFechaIns;
	private JTextField textNombre;
	private JTextField textFechaVen;
	private JTextField textField;
	private File selectedFile; 
	private FileInputStream fis; 
	private SistemaAbonos abonosControl;
	private JComboBox<String> comboBoxAbonos;
	private JTextField textApellido;

	/*---------CREO VENTANA DE REGISTRO----*/
	
	public RegistrarSocio(SistemaUsuarios usuariosControlador) {
		
		setResizable(false);
		abonosControl = new SistemaAbonos();
		setTitle("Registrar Socio");
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 774, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(11, 93, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(11, 161, 64, 14);
		contentPane.add(lblDomicilio);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(11, 128, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
		lblFechaNacimiento.setBounds(11, 190, 102, 14);
		contentPane.add(lblFechaNacimiento);

		JLabel lblFechaInscripcion = new JLabel("Fecha Inscripcion:");
		lblFechaInscripcion.setBounds(11, 221, 102, 14);
		contentPane.add(lblFechaInscripcion);
		
		JLabel lblTipoAbono = new JLabel("Tipo de Abono:");
		lblTipoAbono.setBounds(11, 253, 191, 14);
		contentPane.add(lblTipoAbono);

		textDNI = new JTextField();
		textDNI.setBounds(212, 90, 152, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);
		
		textDomicilio = new JTextField();
		textDomicilio.setBounds(212, 156, 152, 20);
		contentPane.add(textDomicilio);
		textDomicilio.setColumns(10);
		
		textMail = new JTextField();
		textMail.setBounds(212, 125, 152, 20);
		contentPane.add(textMail);
		textMail.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		textFechaNacimiento.setBounds(212, 187, 152, 20);
		contentPane.add(textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		textFechaIns = new JTextField();
		textFechaIns.setBounds(212, 218, 152, 20);
		contentPane.add(textFechaIns);
		textFechaIns.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(11, 25, 141, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(212, 22, 152, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(11, 62, 64, 14);
		contentPane.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBounds(212, 59, 152, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setEnabled(false);
		textField.setBounds(465, 90, 191, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblDatosMedicos = new JLabel("Datos Medicos:");
		lblDatosMedicos.setBounds(465, 25, 91, 14);
		contentPane.add(lblDatosMedicos);
		
		//File selectedFile = new File ("text.txt");
		JButton btnImagenApto = new JButton("Buscar Imagen");
		btnImagenApto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			final JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(btnImagenApto);
			fc.setCurrentDirectory (new File(System.getProperty("user.home")));
			//if (returnVal == JFileChooser.APPROVE_OPTION) {
				selectedFile = fc.getSelectedFile();
				textField.setEnabled(true);
				textField.setText(selectedFile.getAbsolutePath());
				try {
					fis = new FileInputStream(selectedFile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			//}
		});
		
		btnImagenApto.setBounds(475, 58, 155, 23);
		contentPane.add(btnImagenApto);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimineto Apto fisico:");
		lblFechaVencimiento.setBounds(465, 124, 165, 14);
		contentPane.add(lblFechaVencimiento);
		
		textFechaVen = new JTextField();
		textFechaVen.setBounds(508, 154, 86, 20);
		contentPane.add(textFechaVen);
		textFechaVen.setColumns(10);
		
		ResultSet listaAbonos = abonosControl.listarAbono();
		comboBoxAbonos = new JComboBox<String>();
		comboBoxAbonos.setBounds(212, 249, 152, 22);
		contentPane.add(comboBoxAbonos);
		try {
			while(listaAbonos.next()) {
				comboBoxAbonos.addItem(listaAbonos.getString("tipoAbono"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
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
				String abono = (String) comboBoxAbonos.getSelectedItem();
			//}
				if(textNombre.getText().equals("")||abono.equals("")||textFechaNacimiento.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||fechaV.equals("")||fechaI.equals("")||textMail.getText().equals("")||textDNI.getText().equals("")) {
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
						usuariosControlador.altaUsuario(textNombre.getText(), textMail.getText(), null, null, textDomicilio.getText(), Integer.parseInt(textDNI.getText()),fechaN, "Socio", fechaI, null, null, null, abono, fechaV, fis, textApellido.getText());

						JOptionPane.showMessageDialog(null, "Ingreso correcto");
						usuariosControlador.imprimir();
						dispose();
					}
				}
			}
		});
		contentPane.add(btnEnviar);		
		
		setLocationRelativeTo(null);

	}
}
