package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JTextField txtSueldo;
	private JTextField txtFechaInicioActs;
	
	public ModificarEmpleadoLlenarCampos(SistemaUsuarios usuariosControlador, String nombreUsuario) {
		setTitle("Modificar Empleado");

		/*---------CREO VENTANA DE MODIFICACION DE EMPLEADO----*/
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 622, 590);
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
			lblIngreseSuContrasea.setBounds(11, 389, 142, 14);
			contentPane.add(lblIngreseSuContrasea);
			
			JLabel lblIngresaNuevamente = new JLabel("Ingresa nuevamente:");
			lblIngresaNuevamente.setBounds(12, 419, 191, 14);
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
			textContra1.setBounds(213, 386, 152, 20);
			contentPane.add(textContra1);
			textContra1.setColumns(10);
			textContra1.addMouseListener(new MouseAdapter(){
		            @Override
		            public void mouseClicked(MouseEvent e){
		            	if(textContra1.getText().equals("***********")) {
			            	textContra1.setText("");
			                textContra2.setText("");
		                }
		            }
		        });
			
			textContra2 = new JTextField();
			textContra2.setBounds(213, 416, 152, 20);
			contentPane.add(textContra2);
			textContra2.setColumns(10);
			textContra2.addMouseListener(new MouseAdapter(){
	            @Override
	            public void mouseClicked(MouseEvent e){
	                if(textContra2.getText().equals("***********")) {
		            	textContra1.setText("");
		                textContra2.setText("");
	                }
	            }
	        });
			
			JLabel lblIngreseSuNombre_1 = new JLabel("Nombre:");
			lblIngreseSuNombre_1.setBounds(11, 65, 141, 14);
			contentPane.add(lblIngreseSuNombre_1);
			
			textNombre = new JTextField();
			textNombre.setBounds(212, 62, 152, 20);
			contentPane.add(textNombre);
			textNombre.setColumns(10);
			
			JLabel lblRol = new JLabel("Rol:");
			lblRol.setBounds(11, 449, 46, 14);
			contentPane.add(lblRol);
			
			JCheckBox chBxAdministrador = new JCheckBox("Administrador");
			chBxAdministrador.setEnabled(false);
			roles.add(chBxAdministrador);
			chBxAdministrador.setBounds(133, 448, 125, 23);
			contentPane.add(chBxAdministrador);
			
			JCheckBox chBxOperador = new JCheckBox("Operador");
			chBxOperador.setEnabled(false);
			roles.add(chBxOperador);
			chBxOperador.setBounds(262, 448, 97, 23);
			contentPane.add(chBxOperador);
			
			JCheckBox chckbxProfe = new JCheckBox("Profesor");
			chckbxProfe.setEnabled(false);
			roles.add(chckbxProfe);
			chckbxProfe.setBounds(133, 476, 97, 23);
			contentPane.add(chckbxProfe);
			
			textUsuario.setText(nombreUsuario);
			
			txtSueldo = new JTextField();
			txtSueldo.setBounds(212, 212, 152, 20);
			contentPane.add(txtSueldo);
			txtSueldo.setColumns(10);
			
			txtFechaInicioActs = new JTextField();
			txtFechaInicioActs.setBounds(212, 241, 152, 20);
			contentPane.add(txtFechaInicioActs);
			txtFechaInicioActs.setColumns(10);
			
			JCheckBox chckbxLunes = new JCheckBox("Lunes");
			chckbxLunes.setBounds(128, 298, 113, 25);
			contentPane.add(chckbxLunes);
			
			JCheckBox chckbxMiercoles = new JCheckBox("Miercoles");
			chckbxMiercoles.setBounds(245, 298, 113, 25);
			contentPane.add(chckbxMiercoles);
			
			JCheckBox chckbxMartes = new JCheckBox("Martes");
			chckbxMartes.setBounds(128, 338, 113, 25);
			contentPane.add(chckbxMartes);
			
			JCheckBox chckbxJueves = new JCheckBox("Jueves");
			chckbxJueves.setBounds(245, 338, 113, 25);
			contentPane.add(chckbxJueves);
			
			JCheckBox chckbxViernes = new JCheckBox("Viernes");
			chckbxViernes.setBounds(377, 298, 113, 25);
			contentPane.add(chckbxViernes);
			
			JCheckBox chckbxSabado = new JCheckBox("Sabado");
			chckbxSabado.setBounds(377, 338, 113, 25);
			contentPane.add(chckbxSabado);
			
			JCheckBox chckbxDomingo = new JCheckBox("Domingo");
			chckbxDomingo.setBounds(494, 298, 113, 25);
			contentPane.add(chckbxDomingo);
			
			/*----BUSCAR EL USUARIO Y LLENA LOS CAMPOS----*/
			java.util.Date fechaN;
			
			Administrador a = usuariosControlador.buscarAdministrador(textUsuario.getText());
			if(a!=null) {
				textNombre.setText(a.getNombre());
				textDNI.setText(Integer.toString(a.getDni()));
				textDomicilio.setText(a.getDomicilio());
				
				String fecha=a.getFechaDeNac().toString();
				
				textFechaNac.setText(fecha);
				textMail.setText(a.getEmail());
				chBxAdministrador.setSelected(true);
				textContra1.setText("***********");
				textContra2.setText("***********");
				
				String fechaInicioActs=a.getInicioActividades().toString();
				
				txtFechaInicioActs.setText(fechaInicioActs);
				txtSueldo.setText(Float.toString(a.getSueldo()));
				
				String diasLab = new String();
				diasLab = a.getDiasLaborales();

				if(diasLab.contains("lunes")) {
					chckbxLunes.setSelected(true);
				}
				if(diasLab.contains("martes")) {
					chckbxMartes.setSelected(true);
				}
				if(diasLab.contains("miercoles")) {
					chckbxMiercoles.setSelected(true);
				}
				if(diasLab.contains("jueves")) {
					chckbxJueves.setSelected(true);
				}
				if(diasLab.contains("viernes")) {
					chckbxViernes.setSelected(true);
				}
				if(diasLab.contains("sabado")) {
					chckbxSabado.setSelected(true);
				}
				if(diasLab.contains("domingo")) {
					chckbxDomingo.setSelected(true);
				}
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
					textContra1.setText("***********");
					textContra2.setText("***********");
					
					String fechaInicioActs=o.getFechaInicioActividades().toString();
					txtFechaInicioActs.setText(fechaInicioActs);
					txtSueldo.setText(Float.toString(o.getSueldo()));
					
					String diasLab = new String();
					diasLab = o.getDiasLaborales();

					if(diasLab.contains("lunes")) {
						chckbxLunes.setSelected(true);
					}
					if(diasLab.contains("martes")) {
						chckbxMartes.setSelected(true);
					}
					if(diasLab.contains("miercoles")) {
						chckbxMiercoles.setSelected(true);
					}
					if(diasLab.contains("jueves")) {
						chckbxJueves.setSelected(true);
					}
					if(diasLab.contains("viernes")) {
						chckbxViernes.setSelected(true);
					}
					if(diasLab.contains("sabado")) {
						chckbxSabado.setSelected(true);
					}
					if(diasLab.contains("domingo")) {
						chckbxDomingo.setSelected(true);
					}
				}
				/*else{
					Profesor pro = usuariosControlador.buscarProfesor(textUsuario.getText());
					if(pro!=null){
						textNombre.setText(pro.getNombre());
						textDNI.setText(Integer.toString(pro.getDni()));
						textDomicilio.setText(pro.getDomicilio());
						String fecha=pro.getFechaDeNac().toString();
						textFechaNac.setText(fecha);
						textMail.setText(pro.getEmail());
						chBxProfe.setSelected(true);
						textContra1.setText("***********");
						textContra2.setText("***********");
						
						String fechaInicioActs=pro.getInicioActividades().toString();
						
						txtFechaInicioActs.setText(fechaInicioActs);
						txtSueldo.setText(Float.toString(pr.getSueldo()));
					}
				}*/
			}
			
			/*----BOTON MODIFICAR----*/
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.setBounds(160, 508, 152, 23);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					/*----OBTIENE EL ROL----*/
					
					String rol = new String();
					rol = null;
					String diasLaborales = new String();
					diasLaborales = "-";
					
					if(chckbxProfe.isSelected()) {
						rol = "Profesor";
					}
					else {
						if(chBxAdministrador.isSelected()) {		
							rol = "Administrador";
						}
						else {
							if(chBxOperador.isSelected()) {
								rol = "Operador";
							}
						}		
					}
					
					/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
					Date fechaN=Date.valueOf(textFechaNac.getText());
					Date fechaInicioActs=Date.valueOf(txtFechaInicioActs.getText());
					if(textNombre.getText().equals("")||textContra1.getText().equals("")||textContra2.getText().equals("")||textDNI.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||textMail.getText().equals("")||textUsuario.getText().equals("")||rol==null) {
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

					}
					else {
						if(textContra1.getText().equals(textContra2.getText())) {
							if(chckbxLunes.isSelected()){
								diasLaborales = diasLaborales.concat("lunes-");
							}
							if(chckbxMartes.isSelected()){
								diasLaborales = diasLaborales.concat("martes-");
							}
							if(chckbxMiercoles.isSelected()){
								diasLaborales = diasLaborales.concat("miercoles-");
							}
							if(chckbxJueves.isSelected()) {
								diasLaborales = diasLaborales.concat("jueves-");
							}
							if(chckbxViernes.isSelected()){
								diasLaborales = diasLaborales.concat("viernes-");
							}
							if(chckbxSabado.isSelected()) {
								diasLaborales = diasLaborales.concat("sabado-");
							}
							if(chckbxDomingo.isSelected()) {
								diasLaborales = diasLaborales.concat("domingo-");
							}
							String contraNueva = new String();
							
							usuariosControlador.modificarEmpleado(textUsuario.getText(), textMail.getText(), textContra1.getText(), textNombre.getText(), textDomicilio.getText(), Integer.parseInt(textDNI.getText()), fechaN, rol,fechaInicioActs,Float.parseFloat(txtSueldo.getText()),diasLaborales);
							JOptionPane.showMessageDialog(null, "Modificado!");
							usuariosControlador.imprimirEmpleados();
							dispose();
					
						}
						else{
							JOptionPane.showMessageDialog(null, "Los campos de claves no coinciden","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
						
					
				}
			});
			contentPane.add(btnModificar);
			
			JLabel lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setBounds(11, 215, 56, 16);
			contentPane.add(lblSueldo);
			
			JLabel lblFechaInicioActs = new JLabel("Fecha Inicio de Actividades:");
			lblFechaInicioActs.setBounds(11, 244, 168, 16);
			contentPane.add(lblFechaInicioActs);
			
			JLabel lblDiasLaborales = new JLabel("Dias Laborales:");
			lblDiasLaborales.setBounds(11, 273, 152, 16);
			contentPane.add(lblDiasLaborales);

		}
}
