package ventanas;

import java.awt.EventQueue;
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
import modelo.Administrador;
//import modelo.AgenteComercial;
import modelo.Operador;
//import modelo.VendedorBoleteria;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class ModificarEmpleadoLlenarCampos extends JFrame{

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textDNI;
	private JTextField textFechaNac;
	private JTextField textContra1;
	private JTextField textContra2;
	private JTextField textNombre;
	private final ButtonGroup roles = new ButtonGroup();
	
	public ModificarEmpleadoLlenarCampos(SistemaUsuarios usuariosControlador, String nombreUsuario) {
		setTitle("Modificar Empleado");

		/*---------CREO VENTANA DE MODIFICACION DE EMPLEADO----*/
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 470, 404);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			/*----CAMPOS A LLENAR----*/
			
			JLabel lblIngreseSuNombre = new JLabel("Nombre de usuario:");
			lblIngreseSuNombre.setBounds(11, 28, 152, 14);
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
			textUsuario.setEditable(false);
			textUsuario.setEnabled(false);
			textUsuario.setBounds(212, 25, 152, 20);
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
			lblIngreseSuNombre_1.setBounds(11, 65, 141, 14);
			contentPane.add(lblIngreseSuNombre_1);
			
			textNombre = new JTextField();
			textNombre.setBounds(212, 62, 152, 20);
			contentPane.add(textNombre);
			textNombre.setColumns(10);
			
			JLabel lblRol = new JLabel("Rol:");
			lblRol.setBounds(11, 283, 46, 14);
			contentPane.add(lblRol);
			
			JCheckBox chBxAdministrador = new JCheckBox("Administrador");
			chBxAdministrador.setEnabled(false);
			roles.add(chBxAdministrador);
			chBxAdministrador.setBounds(133, 282, 97, 23);
			contentPane.add(chBxAdministrador);
			
			JCheckBox chBxAgenteComercial = new JCheckBox("Agente Comercial");
			chBxAgenteComercial.setEnabled(false);
			roles.add(chBxAgenteComercial);
			chBxAgenteComercial.setBounds(133, 308, 117, 23);
			contentPane.add(chBxAgenteComercial);
			
			JCheckBox chBxOperador = new JCheckBox("Operador");
			chBxOperador.setEnabled(false);
			roles.add(chBxOperador);
			chBxOperador.setBounds(262, 282, 97, 23);
			contentPane.add(chBxOperador);
			
			JCheckBox chckbxVendedor = new JCheckBox("Vendedor");
			chckbxVendedor.setEnabled(false);
			roles.add(chckbxVendedor);
			chckbxVendedor.setBounds(262, 308, 97, 23);
			contentPane.add(chckbxVendedor);
			
			textUsuario.setText(nombreUsuario);
								
			/*----BUSCAR EL USUARIO Y LLENA LOS CAMPOS----*/
			java.util.Date fechaN;
			/*VendedorBoleteria vb = usuariosControlador.buscarVendedorBoleteria(textUsuario.getText());
			if(vb!=null) {
				textNombre.setText(vb.getNombre());
				textDNI.setText(Integer.toString(vb.getDni()));
				textDomicilio.setText(vb.getDomicilio());
				fechaN=vb.getFechaDeNac();
				textFechaNac.setText(fechaN.toString());
				textMail.setText(vb.getEmail());
				chckbxVendedor.setSelected(true);
				textContra1.setText("****");
			}*/
			Administrador a = usuariosControlador.buscarAdministrador(textUsuario.getText());
			if(a!=null) {
				textNombre.setText(a.getNombre());
				textDNI.setText(Integer.toString(a.getDni()));
				textDomicilio.setText(a.getDomicilio());
				
				String fecha=a.getFechaDeNac().toString();
				
				textFechaNac.setText(fecha);
				textMail.setText(a.getEmail());
				chBxAdministrador.setSelected(true);
				textContra1.setText("****");
			}
			else
			{
				Operador o = usuariosControlador.buscarOperador(textUsuario.getText());
				if(o!=null) {
					textNombre.setText(o.getNombre());
					textDNI.setText(Integer.toString(o.getDni()));
					textDomicilio.setText(o.getDomicilio());
					String fecha=o.getFechaDeNac().toString();
					textFechaNac.setText(fecha);
					textMail.setText(o.getEmail());
					chBxOperador.setSelected(true);
					textContra1.setText("****");
				}
			}
			
			/*----BOTON MODIFICAR----*/
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(156, 338, 152, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					/*----OBTIENE EL ROL----*/
					
					String rol = new String();
					rol = null;
					
					if(chckbxVendedor.isSelected()) {
						rol = "Vendedor";
					}
					else {
						if(chBxAdministrador.isSelected()) {		
							rol = "Administrador";
						}
						else {
							if(chBxOperador.isSelected()) {
								rol = "Operador";
							}
							else {
								if(chBxAgenteComercial.isSelected()) {
									rol = "Agente Comercial";
								}
							}
						}		
					}
					
					/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
					Date fechaN=Date.valueOf(textFechaNac.getText());
					if(textNombre.getText().equals("")||textContra1.getText().equals("")||textContra2.getText().equals("")||textDNI.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||textMail.getText().equals("")||textUsuario.getText().equals("")||rol==null) {
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

					}
					else {
						usuariosControlador.modificarEmpleado(textUsuario.getText(), textMail.getText(), textContra1.getText(), textNombre.getText(), textDomicilio.getText(), Integer.parseInt(textDNI.getText()), fechaN, rol);
						JOptionPane.showMessageDialog(null, "Modificado!");
						usuariosControlador.imprimirEmpleados();
						dispose();
					}
					
				}
			});
			contentPane.add(btnModificar);

		}
}
