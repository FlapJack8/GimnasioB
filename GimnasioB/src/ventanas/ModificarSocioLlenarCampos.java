package ventanas;

import javax.swing.JFrame;

import controladores.SistemaAbonos;
import controladores.SistemaUsuarios;
import modelo.Socio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class ModificarSocioLlenarCampos extends JFrame{
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtDomicilio;
	private JTextField txtEmail;
	private JTextField txtFechaNacimiento;
	private JTextField txtFechaIns;
	private JTextField txtFechaVenci;
	private SistemaAbonos abonosControl;
	private JComboBox<String> comboBoxAbonos;
	private JTextField textField;
	private File selectedFile; 
	private FileInputStream fis; 
	private JTextField textBonoActual;
	private JTextField textEstadoAbono;
	private JTextField textVenciAbono;

	/*----LLENAR CAMPOS PARA MODIFICAR----*/
	
	public ModificarSocioLlenarCampos(SistemaUsuarios usuariosControlador, Socio v) {
		
		abonosControl = new SistemaAbonos();
		setResizable(false);
		
		setTitle("Modificar Socio");
		setBounds(400, 200, 845, 303);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPOS A MODIFICAR LLENOS CON EL VALOR DEL VECTOR----*/
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(64, 53, 96, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(64, 25, 123, 14);
		getContentPane().add(lblDNI);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento");
		lblFechaNacimiento.setBounds(64, 134, 96, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(64, 109, 108, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(64, 84, 78, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaInscripcion = new JLabel("Fecha Inscripcion:");
		lblFechaInscripcion.setBounds(64, 159, 123, 14);
		getContentPane().add(lblFechaInscripcion);
		
		JLabel lblTipoAbono = new JLabel("Tipo de Abono:");
		lblTipoAbono.setBounds(64, 188, 108, 14);
		getContentPane().add(lblTipoAbono);
		
		JLabel lblFechaVencimiento = new JLabel("Fecha Vencimiento del Apto:");
		lblFechaVencimiento.setBounds(64, 213, 143, 14);
		getContentPane().add(lblFechaVencimiento);
		
		txtNombre = new JTextField();
		txtNombre.setText(v.getNombre());
		txtNombre.setBounds(221, 50, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setEnabled(false);
		txtDni.setBounds(221, 22, 86, 20);
		txtDni.setText(Integer.toString(v.getDni()));
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setText(v.getDomicilio());
		txtDomicilio.setBounds(221, 106, 86, 20);
		getContentPane().add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(v.getEmail());
		txtEmail.setBounds(221, 81, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		String fechaNaci =v.getFechaDeNac().toString();
		txtFechaNacimiento.setText(fechaNaci);
		txtFechaNacimiento.setBounds(221, 131, 86, 20);
		getContentPane().add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		txtFechaIns = new JTextField();
		String fechaInscrip=v.getFechaInicioActividades().toString();
		txtFechaIns.setText(fechaInscrip);
		txtFechaIns.setBounds(221, 156, 86, 20);
		getContentPane().add(txtFechaIns);
		txtFechaIns.setColumns(10);
		
		txtFechaVenci = new JTextField();
		String fechaVencimiento = v.getFechaVen().toString();
		txtFechaVenci.setText(fechaVencimiento);
		txtFechaVenci.setBounds(221, 210, 86, 20);
		getContentPane().add(txtFechaVenci);
		txtFechaVenci.setColumns(10);
		
		JLabel lblDatosMedicos = new JLabel("Datos Medicos:");
		lblDatosMedicos.setBounds(452, 36, 102, 14);
		getContentPane().add(lblDatosMedicos);
		
		JButton btnBuscarImagen = new JButton("Buscar Imagen");
		btnBuscarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			final JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(btnBuscarImagen);
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
		btnBuscarImagen.setBounds(557, 155, 108, 23);
		getContentPane().add(btnBuscarImagen);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(557, 185, 108, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		ResultSet listaAbonos = abonosControl.listarAbono();
		comboBoxAbonos = new JComboBox<String>();
		comboBoxAbonos.setBounds(221, 184, 86, 22);
		getContentPane().add(comboBoxAbonos);
		comboBoxAbonos.addItem("");
		try {
			while(listaAbonos.next()) {
				comboBoxAbonos.addItem(listaAbonos.getString("tipoAbono"));
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		textBonoActual = new JTextField();
		textBonoActual.setText(v.getTipoAbono());
		textBonoActual.setEditable(false);
		textBonoActual.setBounds(317, 185, 86, 20);
		getContentPane().add(textBonoActual);
		textBonoActual.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Bono Actual:");
		lblNewLabel.setBounds(317, 162, 75, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel labelImage = new JLabel("");
		ImageIcon img = usuariosControlador.enviarImagen(v.getDni());
		labelImage.setIcon(img);
		labelImage.setBounds(532, 25, 165, 123);
		getContentPane().add(labelImage);
		
		
		JLabel lblEstadoAbono = new JLabel("Estado abono:");
		lblEstadoAbono.setBounds(317, 25, 86, 14);
		getContentPane().add(lblEstadoAbono);
		
		textEstadoAbono = new JTextField();
		if(v.getEstadoAbono() != null) {
			textEstadoAbono.setText(v.getEstadoAbono());
		}
		textEstadoAbono.setEditable(false);
		textEstadoAbono.setBounds(317, 47, 86, 20);
		getContentPane().add(textEstadoAbono);
		textEstadoAbono.setColumns(10);
		
		JLabel lblVencimientoAbono = new JLabel("Vencimiento del Abono:");
		lblVencimientoAbono.setBounds(317, 97, 123, 14);
		getContentPane().add(lblVencimientoAbono);
		
		textVenciAbono = new JTextField();
		if(v.getFechaVenAbono() != null) {
			String fechaVenciAbono = v.getFechaVenAbono().toString();
			textVenciAbono.setText(fechaVenciAbono);
		}
		textVenciAbono.setEditable(false);
		textVenciAbono.setBounds(317, 115, 86, 20);
		getContentPane().add(textVenciAbono);
		textVenciAbono.setColumns(10);
		
		/*----BOTON ACEPTAR----*/
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaN=Date.valueOf(txtFechaNacimiento.getText());
				Date fechaIns=Date.valueOf(txtFechaIns.getText());
				Date fechaVen=Date.valueOf(txtFechaVenci.getText());
				String abono = (String) comboBoxAbonos.getSelectedItem();
				Date fechaVenAbono = Date.valueOf(textVenciAbono.getText());
				if(txtNombre.getText().equals("")||abono.equals("")||txtFechaNacimiento.getText().equals("")||txtDomicilio.getText().equals("")||fechaN.equals("")||fechaVen.equals("")||fechaIns.equals("")||txtEmail.getText().equals("")||txtDni.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//System.out.println(v.getEstado());
					usuariosControlador.modificarSocio(Integer.parseInt(txtDni.getText()), txtNombre.getText(), txtEmail.getText(), txtDomicilio.getText(), fechaN, fechaIns, abono, fechaVen, fis, textEstadoAbono.getText(), fechaVenAbono);
					JOptionPane.showMessageDialog(null, "Modificado!");
					usuariosControlador.imprimir();
					dispose();
				}
				
			}
		});
		btnAceptar.setBounds(368, 230, 89, 23);
		getContentPane().add(btnAceptar);
		
		setLocationRelativeTo(null);

	}
}
