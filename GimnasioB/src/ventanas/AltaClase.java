package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaClases;
import controladores.SistemaUsuarios;
import modelo.Persona;
import modelo.Profesor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.Color;

public class AltaClase extends JFrame{
	private JPanel contentPane;
	private JTextField txtActividad;
	private JTextField txtFechaClase;
	private JTextField txtHorario;
	private JTextField txtProfesor;
	private JTextField txtDuracion;
	private JTextField txtCapacidadMax;
	private JTextField txtCapacidadMin;
	private final ButtonGroup btnGrPublico = new ButtonGroup();
	private final ButtonGroup btnGrDif = new ButtonGroup();

	public AltaClase(SistemaClases clasesControlador, SistemaUsuarios usuariocontrolador) {
		setForeground(SystemColor.textHighlight);
		setTitle("Diagramar Clase");

		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 389, 672);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActividad.setBounds(22, 42, 149, 16);
		contentPane.add(lblActividad);
		
		JLabel lblFechaClase = new JLabel("Fecha:");
		lblFechaClase.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaClase.setBounds(22, 85, 149, 16);
		contentPane.add(lblFechaClase);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorario.setBounds(22, 130, 149, 16);
		contentPane.add(lblHorario);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProfesor.setBounds(22, 174, 149, 16);
		contentPane.add(lblProfesor);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuracion.setBounds(22, 219, 149, 16);
		contentPane.add(lblDuracion);
		
		JLabel lblCapacidadMax = new JLabel("Capacidad Maxima:");
		lblCapacidadMax.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidadMax.setBounds(22, 267, 149, 16);
		contentPane.add(lblCapacidadMax);
		
		txtActividad = new JTextField();
		txtActividad.setBounds(199, 39, 116, 22);
		contentPane.add(txtActividad);
		txtActividad.setColumns(10);
		
		txtFechaClase = new JTextField();
		txtFechaClase.setBounds(199, 82, 116, 22);
		contentPane.add(txtFechaClase);
		txtFechaClase.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(199, 127, 116, 22);
		contentPane.add(txtHorario);
		txtHorario.setColumns(10);
		
		txtProfesor = new JTextField();
		txtProfesor.setBounds(199, 171, 116, 22);
		contentPane.add(txtProfesor);
		txtProfesor.setColumns(10);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(199, 216, 116, 22);
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		txtCapacidadMax = new JTextField();
		txtCapacidadMax.setBounds(199, 264, 116, 22);
		contentPane.add(txtCapacidadMax);
		txtCapacidadMax.setColumns(10);
		
		JLabel lblCapacidadMin = new JLabel("Capacidad Minima:");
		lblCapacidadMin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidadMin.setBounds(22, 311, 149, 16);
		contentPane.add(lblCapacidadMin);
		
		JLabel lblPublico = new JLabel("Publico:");
		lblPublico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPublico.setBounds(158, 367, 56, 16);
		contentPane.add(lblPublico);
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDificultad.setBounds(138, 479, 101, 16);
		contentPane.add(lblDificultad);
		
		txtCapacidadMin = new JTextField();
		txtCapacidadMin.setBounds(199, 308, 116, 22);
		contentPane.add(txtCapacidadMin);
		txtCapacidadMin.setColumns(10);
		
		JCheckBox chckbxHombres = new JCheckBox("Hombres");
		chckbxHombres.setBounds(73, 398, 113, 25);
		contentPane.add(chckbxHombres);
		btnGrPublico.add(chckbxHombres);

		JCheckBox chckbxMujeres = new JCheckBox("Mujeres");
		chckbxMujeres.setBounds(202, 398, 113, 25);
		contentPane.add(chckbxMujeres);
		btnGrPublico.add(chckbxMujeres);

		JCheckBox chckbxMixto = new JCheckBox("Mixto");
		chckbxMixto.setBounds(73, 434, 113, 25);
		contentPane.add(chckbxMixto);
		btnGrPublico.add(chckbxMixto);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(138, 595, 97, 25);
		contentPane.add(btnAceptar);
		
		JCheckBox chckbxPrincipiante = new JCheckBox("Principiante");
		chckbxPrincipiante.setBounds(22, 513, 113, 25);
		contentPane.add(chckbxPrincipiante);
		btnGrDif.add(chckbxPrincipiante);

		JCheckBox chckbxIntermedio = new JCheckBox("Intermedio");
		chckbxIntermedio.setBounds(138, 513, 101, 25);
		contentPane.add(chckbxIntermedio);
		btnGrDif.add(chckbxIntermedio);

		JCheckBox chckbxAvanzado = new JCheckBox("Avanzado");
		chckbxAvanzado.setBounds(248, 513, 113, 25);
		contentPane.add(chckbxAvanzado);
		btnGrDif.add(chckbxAvanzado);

		JCheckBox chckbxGeneral = new JCheckBox("General");
		chckbxGeneral.setBounds(138, 547, 113, 25);
		contentPane.add(chckbxGeneral);
		btnGrDif.add(chckbxGeneral);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 386, 340, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 499, 340, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 472, 340, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(23, 361, 340, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(23, 580, 340, 2);
		contentPane.add(separator_4);

		/*----BOTON ACEPTAR----*/
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int flagPublicoSelected = 0;
				int flagDificultadSelected = 0;
				
				String publico = new String();
				publico = null;

				String dificultad = new String();
				publico = null;
				
				if(chckbxHombres.isSelected()) {		
					publico = "Hombres";
				}
				else {
					if(chckbxMujeres.isSelected()) {
						publico = "Mujeres";
					}
					else {
						if(chckbxMixto.isSelected()) {
						publico = "Mixto";
						}
					}
				}
				
				if(chckbxPrincipiante.isSelected()) {		
					dificultad = "Principiante";
				}
				else {
					if(chckbxIntermedio.isSelected()) {
						dificultad = "Intermedio";
					}
					else {
						if(chckbxAvanzado.isSelected()) {
							dificultad = "Avanzado";
						}else {
							if(chckbxGeneral.isSelected()) {
								dificultad = "General";
							}
						}
					}
				}
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
				if(chckbxHombres.isSelected()==false&&chckbxMujeres.isSelected()==false&&chckbxMixto.isSelected()==false){
					flagPublicoSelected=0;
				}
				else{
					flagPublicoSelected=1;
				}
				
				if(chckbxPrincipiante.isSelected()==false&&chckbxIntermedio.isSelected()==false&&chckbxAvanzado.isSelected()==false&&chckbxGeneral.isSelected()==false){
					flagDificultadSelected=0;
				}
				else{
					flagDificultadSelected=1;
				}
				
				Profesor p = usuariocontrolador.buscarProfesor(txtProfesor.getText());
				Date fechaClase=Date.valueOf(txtFechaClase.getText());
				Time horario=Time.valueOf(txtHorario.getText());

				if(txtActividad.getText().equals("")||txtCapacidadMax.getText().equals("")||txtCapacidadMin.getText().equals("")||flagDificultadSelected==0||txtFechaClase.getText().equals("")||txtHorario.getText().equals("")||p==null||flagPublicoSelected==0) {
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);

				}
				else {
					if(clasesControlador.existeClase(txtActividad.getText(),p.getNombreUsuario(),fechaClase,horario)) {
						JOptionPane.showMessageDialog(null, "Clase ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
					}
					else {
						
						/*VALIDA QUE EL PROFESOR PUEDA DAR LA CLASE*/

						if(p.getActividades().contains(txtActividad.getText())) {
							clasesControlador.crearClase(txtActividad.getText(), fechaClase,horario,p.getNombreUsuario(), Float.parseFloat(txtDuracion.getText()), Integer.parseInt(txtCapacidadMax.getText()), Integer.parseInt(txtCapacidadMin.getText()), publico, dificultad);
							JOptionPane.showMessageDialog(null, "Ingreso correcto");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "El Profesor seleccionado no puede dar esa clase","Atencion",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
	}
}
