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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class RegistrarEmpleado extends JFrame{

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textDNI;
	private JTextField textFechaNac;
	private JTextField textContra1;
	private JTextField textContra2;
	private JTextField txtNombre;
	private final ButtonGroup roles = new ButtonGroup();
	private JTextField txtInicioActs;
	private JTextField txtSueldo;
	
	public RegistrarEmpleado(SistemaUsuarios usuariosControlador) {
		setTitle("Registrar Empleado");

		/*---------CREO VENTANA DE REGISTRO----*/
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 593, 608);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			

			JCheckBox chBxOperador = new JCheckBox("Operador");
			chBxOperador.setBounds(343, 33, 97, 23);
			roles.add(chBxOperador);
			contentPane.add(chBxOperador);
			chBxOperador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textContra1.setEnabled(true);
					textContra2.setEnabled(true);
				}
			});
			
			JCheckBox chBxAdministrador = new JCheckBox("Administrador");
			chBxAdministrador.setBounds(214, 33, 110, 23);
			roles.add(chBxAdministrador);
			contentPane.add(chBxAdministrador);
			chBxAdministrador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textContra1.setEnabled(true);
					textContra2.setEnabled(true);
				}
			});
			
			JCheckBox chBxProfe = new JCheckBox("Profesor");
			chBxProfe.setBounds(214, 61, 117, 23);
			roles.add(chBxProfe);
			contentPane.add(chBxProfe);
			chBxProfe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textContra1.setText(null);
					textContra2.setText(null);
					textContra1.setEnabled(false);
					textContra2.setEnabled(false);
				}
			});
			
			JLabel lblRol = new JLabel("Empleo:");
			lblRol.setBounds(13, 33, 75, 14);
			contentPane.add(lblRol);
			
			JLabel lblIngreseSuNombre = new JLabel("Nombre de usuario:");
			lblIngreseSuNombre.setBounds(13, 103, 152, 14);
			contentPane.add(lblIngreseSuNombre);
			
			JLabel lblDomicilio = new JLabel("Domicilio:");
			lblDomicilio.setBounds(13, 163, 152, 14);
			contentPane.add(lblDomicilio);
				
			JLabel label = new JLabel("");
			label.setBounds(191, 75, 86, 14);
			contentPane.add(label);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(13, 194, 46, 14);
			contentPane.add(lblEmail);
			
			JLabel lblNewLabel = new JLabel("DNI:");
			lblNewLabel.setBounds(13, 227, 46, 14);
			contentPane.add(lblNewLabel);

			JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento:");
			lblFechaNacimiento.setBounds(13, 258, 152, 14);
			contentPane.add(lblFechaNacimiento);
			
			JLabel lblIngreseSuContrasea = new JLabel("Ingrese su contrase\u00F1a:");
			lblIngreseSuContrasea.setBounds(12, 291, 142, 17);
			contentPane.add(lblIngreseSuContrasea);
			
			JLabel lblIngresaNuevamente = new JLabel("Ingresa nuevamente:");
			lblIngresaNuevamente.setBounds(13, 321, 191, 17);
			contentPane.add(lblIngresaNuevamente);

			textUsuario = new JTextField();
			textUsuario.setBounds(214, 100, 152, 20);
			contentPane.add(textUsuario);
			textUsuario.setColumns(10);
			
			textDomicilio = new JTextField();
			textDomicilio.setBounds(214, 160, 152, 20);
			contentPane.add(textDomicilio);
			textDomicilio.setColumns(10);
			
			textMail = new JTextField();
			textMail.setBounds(214, 191, 152, 20);
			contentPane.add(textMail);
			textMail.setColumns(10);
			
			textDNI = new JTextField();
			textDNI.setBounds(214, 224, 152, 20);
			contentPane.add(textDNI);
			textDNI.setColumns(10);
			
			textFechaNac = new JTextField();
			textFechaNac.setBounds(214, 255, 152, 20);
			contentPane.add(textFechaNac);
			textFechaNac.setColumns(10);
			
			textContra1 = new JTextField();
			textContra1.setBounds(214, 288, 152, 20);
			contentPane.add(textContra1);
			textContra1.setColumns(10);
			
			textContra2 = new JTextField();
			textContra2.setBounds(214, 318, 152, 20);
			contentPane.add(textContra2);
			textContra2.setColumns(10);
			
			JLabel lblIngreseSuNombre_1 = new JLabel("Nombre:");
			lblIngreseSuNombre_1.setBounds(13, 133, 141, 14);
			contentPane.add(lblIngreseSuNombre_1);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(214, 130, 152, 20);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
			JCheckBox chckbxLunes = new JCheckBox("Lunes");
			chckbxLunes.setBounds(52, 461, 113, 25);
			contentPane.add(chckbxLunes);
			
			JCheckBox chckbxMartes = new JCheckBox("Martes");
			chckbxMartes.setBounds(52, 491, 113, 25);
			contentPane.add(chckbxMartes);
			
			JCheckBox chckbxMiercoles = new JCheckBox("Miercoles");
			chckbxMiercoles.setBounds(208, 461, 113, 25);
			contentPane.add(chckbxMiercoles);
			
			JCheckBox chckbxJueves = new JCheckBox("Jueves");
			chckbxJueves.setBounds(208, 491, 113, 25);
			contentPane.add(chckbxJueves);
			
			JCheckBox chckbxViernes = new JCheckBox("Viernes");
			chckbxViernes.setBounds(345, 461, 113, 25);
			contentPane.add(chckbxViernes);
			
			JCheckBox chckbxSabado = new JCheckBox("Sabado");
			chckbxSabado.setBounds(345, 491, 113, 25);
			contentPane.add(chckbxSabado);
			
			JCheckBox chckbxDomingo = new JCheckBox("Domingo");
			chckbxDomingo.setBounds(472, 461, 113, 25);
			contentPane.add(chckbxDomingo);

			/*----BOTON ENVIAR----*/
			
			JButton btnEnviar = new JButton("Enviar");
			btnEnviar.setBounds(214, 537, 152, 23);
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					int flagDiasSelected=0;
					
					String rol = new String();
					rol = null;
					
					/**Llenamos diasLaborales seleccionando los checkbox y concatenando los dias seleccionados dentro del
					 * String como => [lunes,martes,jueves,sabado,]
					 */
					
					String diasLaborales = new String();
					diasLaborales = "-";
					String actividades = new String();
					actividades = "zumba-yoga-";
					
					if(chBxAdministrador.isSelected()) {		
						rol = "Administrador";
					}
					else {
						if(chBxOperador.isSelected()) {
							rol = "Operador";
						}
						else {
							if(chBxProfe.isSelected()) {
							rol = "Profesor";
							}
						}
					}
					
					/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
					if(chckbxLunes.isSelected()==false&&chckbxMartes.isSelected()==false&&chckbxMiercoles.isSelected()==false&&chckbxJueves.isSelected()==false&&chckbxViernes.isSelected()==false&&chckbxSabado.isSelected()==false&&chckbxDomingo.isSelected()==false){
						flagDiasSelected=0;
					}
					else{
						flagDiasSelected=1;
					}
					
					Date fechaN=Date.valueOf(textFechaNac.getText());
					Date fechaInicioActs=Date.valueOf(txtInicioActs.getText());
					if(rol.equals("Profesor")) {
						if(txtNombre.getText().equals("")||textDNI.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||textMail.getText().equals("")||textUsuario.getText().equals("")||rol==null||txtInicioActs.getText().equals("")||txtSueldo.getText().equals("")||flagDiasSelected==0) {
							JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

						}
						else {
							if(usuariosControlador.existeUsuario(textUsuario.getText())) {
								JOptionPane.showMessageDialog(null, "Usuario ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
								textUsuario.selectAll();
								textUsuario.requestFocus();
							}
							else {
								
								/**Concatenamos el String de diasLaborales
								 **/
								
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
									diasLaborales.concat("domingo-");
								}
								
								
								usuariosControlador.altaUsuario(txtNombre.getText(), textMail.getText(), null, textUsuario.getText(), textDomicilio.getText(), Integer.parseInt(textDNI.getText()), fechaN, rol,fechaInicioActs,Float.parseFloat(txtSueldo.getText()),diasLaborales,actividades, null, null);
								JOptionPane.showMessageDialog(null, "Ingreso correcto");
								usuariosControlador.imprimirEmpleados();
								dispose();
							}
						}
					}
					else {
						if(txtNombre.getText().equals("")||textContra1.getText().equals("")||textContra2.getText().equals("")||textDNI.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||textMail.getText().equals("")||textUsuario.getText().equals("")||rol==null||txtInicioActs.getText().equals("")||txtSueldo.getText().equals("")||flagDiasSelected==0) {
								JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
	
						}
						else {
							if(usuariosControlador.existeUsuario(textUsuario.getText())) {
								JOptionPane.showMessageDialog(null, "Usuario ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
								textUsuario.selectAll();
								textUsuario.requestFocus();
							}
							else {
								if(textContra1.getText().equals(textContra2.getText())) {
	
									/**Concatenamos el String de diasLaborales
									 **/
									
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
										diasLaborales.concat("domingo-");
									}
										
									usuariosControlador.altaUsuario(txtNombre.getText(), textMail.getText(), textContra1.getText(), textUsuario.getText(), textDomicilio.getText(), Integer.parseInt(textDNI.getText()), fechaN, rol,fechaInicioActs,Float.parseFloat(txtSueldo.getText()),diasLaborales,null, null, null);
									JOptionPane.showMessageDialog(null, "Ingreso correcto");
									usuariosControlador.imprimirEmpleados();
									dispose();
								}
								else{
									JOptionPane.showMessageDialog(null, "Los campos de claves no coinciden","Error",JOptionPane.ERROR_MESSAGE);
								}
							}
						}
					}
				}
			});
			contentPane.add(btnEnviar);
			
			txtInicioActs = new JTextField();
			txtInicioActs.setBounds(214, 351, 152, 20);
			contentPane.add(txtInicioActs);
			txtInicioActs.setColumns(10);
			
			JLabel lblInicioActs = new JLabel("Inicio de Actividades:");
			lblInicioActs.setBounds(13, 354, 152, 16);
			contentPane.add(lblInicioActs);
			
			JLabel lblDias = new JLabel("Dias Laborales:");
			lblDias.setBounds(13, 436, 110, 16);
			contentPane.add(lblDias);
			
			JLabel lblSueldo = new JLabel("Sueldo:");
			lblSueldo.setBounds(13, 386, 56, 16);
			contentPane.add(lblSueldo);
			
			txtSueldo = new JTextField();
			txtSueldo.setBounds(214, 384, 152, 20);
			contentPane.add(txtSueldo);
			txtSueldo.setColumns(10);
			
			
		}
}
