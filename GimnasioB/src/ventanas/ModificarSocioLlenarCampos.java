package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaUsuarios;
import modelo.Socio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ModificarSocioLlenarCampos extends JFrame{
	private JTextField txtNombre;
	private JTextField txtDni;
	private JTextField txtDomicilio;
	private JTextField txtEmail;
	private JTextField txtFechaNacimiento;
	private JTextField txtFechaIns;
	private JTextField txtTipoAbono;
	private JTextField txtFechaVenci;

	/*----LLENAR CAMPOS PARA MODIFICAR----*/
	
	public ModificarSocioLlenarCampos(SistemaUsuarios usuariosControlador, Socio v) {
		setTitle("Modificar Usuario");
		
		setBounds(400, 200, 499, 303);
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
		lblFechaVencimiento.setBounds(64, 213, 188, 14);
		getContentPane().add(lblFechaVencimiento);
		
		txtNombre = new JTextField();
		txtNombre.setText(v.getNombre());
		txtNombre.setBounds(255, 50, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setEnabled(false);
		txtDni.setBounds(255, 22, 86, 20);
		txtDni.setText(Integer.toString(v.getDni()));
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		txtDomicilio = new JTextField();
		txtDomicilio.setText(v.getDomicilio());
		txtDomicilio.setBounds(255, 106, 86, 20);
		getContentPane().add(txtDomicilio);
		txtDomicilio.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText(v.getEmail());
		txtEmail.setBounds(255, 81, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFechaNacimiento = new JTextField();
		String fechaNaci =v.getFechaDeNac().toString();
		txtFechaNacimiento.setText(fechaNaci);
		txtFechaNacimiento.setBounds(255, 131, 86, 20);
		getContentPane().add(txtFechaNacimiento);
		txtFechaNacimiento.setColumns(10);
		
		txtFechaIns = new JTextField();
		String fechaInscrip=v.getFechaInicioActividades().toString();
		txtFechaIns.setText(fechaInscrip);
		txtFechaIns.setBounds(255, 156, 86, 20);
		getContentPane().add(txtFechaIns);
		txtFechaIns.setColumns(10);
		
		txtTipoAbono = new JTextField();
		txtTipoAbono.setBounds(255, 185, 86, 20);
		txtTipoAbono.setText(v.getTipoAbono());
		getContentPane().add(txtTipoAbono);
		txtTipoAbono.setColumns(10);
		
		txtFechaVenci = new JTextField();
		String fechaVencimiento = v.getFechaVen().toString();
		txtFechaVenci.setText(fechaVencimiento);
		txtFechaVenci.setBounds(255, 210, 86, 20);
		getContentPane().add(txtFechaVenci);
		txtFechaVenci.setColumns(10);
		
		
		
		/*----BOTON ACEPTAR----*/
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date fechaN=Date.valueOf(txtFechaNacimiento.getText());
				Date fechaIns=Date.valueOf(txtFechaIns.getText());
				Date fechaVen=Date.valueOf(txtFechaVenci.getText());
				if(txtNombre.getText().equals("")||txtTipoAbono.getText().equals("")||txtFechaNacimiento.getText().equals("")||txtDomicilio.getText().equals("")||fechaN.equals("")||fechaVen.equals("")||fechaIns.equals("")||txtEmail.getText().equals("")||txtDni.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//System.out.println(v.getEstado());
					usuariosControlador.modificarSocio(Integer.parseInt(txtDni.getText()), txtNombre.getText(), txtEmail.getText(), txtDomicilio.getText(), fechaN, fechaIns, txtTipoAbono.getText(), fechaVen);
					JOptionPane.showMessageDialog(null, "Modificado!");
					usuariosControlador.imprimir();
					dispose();
				}
				
			}
		});
		btnAceptar.setBounds(368, 230, 89, 23);
		getContentPane().add(btnAceptar);
		
		
		
	}

}
