package ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;

import controladores.SistemaClases;
import controladores.SistemaUsuarios;
import modelo.Clase;
import modelo.Profesor;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.awt.event.ActionEvent;

public class ModificarClaseLlenarCampos extends JFrame{
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
	private JTable tbProfesores;

	
	/*----LLENAR CAMPOS PARA MODIFICAR----*/
	
	public ModificarClaseLlenarCampos(SistemaClases clasesControlador, Clase c, SistemaUsuarios usuariosControlador) {
		setForeground(SystemColor.textHighlight);
		setTitle("Modificar Clase");

		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 715, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActividad.setBounds(361, 41, 149, 16);
		contentPane.add(lblActividad);
		
		JLabel lblFechaClase = new JLabel("Fecha:");
		lblFechaClase.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaClase.setBounds(22, 44, 149, 16);
		contentPane.add(lblFechaClase);
		
		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorario.setBounds(22, 89, 149, 16);
		contentPane.add(lblHorario);
		
		JLabel lblProfesor = new JLabel("Profesor:");
		lblProfesor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProfesor.setBounds(361, 178, 149, 16);
		contentPane.add(lblProfesor);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDuracion.setBounds(22, 138, 149, 16);
		contentPane.add(lblDuracion);
		
		JLabel lblCapacidadMax = new JLabel("Capacidad Maxima:");
		lblCapacidadMax.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidadMax.setBounds(22, 186, 149, 16);
		contentPane.add(lblCapacidadMax);
		
		txtActividad = new JTextField();
		txtActividad.setEnabled(false);
		txtActividad.setBounds(538, 38, 116, 22);
		txtActividad.setText(c.getActividad());
		contentPane.add(txtActividad);
		txtActividad.setColumns(10);
		
		txtFechaClase = new JTextField();
		txtFechaClase.setBounds(199, 41, 116, 22);
		txtFechaClase.setText(c.getFecha().toString());
		contentPane.add(txtFechaClase);
		txtFechaClase.setColumns(10);
		
		txtHorario = new JTextField();
		txtHorario.setBounds(199, 86, 116, 22);
		txtHorario.setText(c.getHorario().toString());
		contentPane.add(txtHorario);
		txtHorario.setColumns(10);
		
		txtProfesor = new JTextField();
		txtProfesor.setEnabled(false);
		txtProfesor.setBounds(538, 175, 116, 22);
		txtProfesor.setText(c.getProfe());
		contentPane.add(txtProfesor);
		txtProfesor.setColumns(10);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(199, 135, 116, 22);
		txtDuracion.setText(Float.toString(c.getDuracion()));
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		txtCapacidadMax = new JTextField();
		txtCapacidadMax.setBounds(199, 183, 116, 22);
		txtCapacidadMax.setText(Integer.toString(c.getCapacidadMax()));
		contentPane.add(txtCapacidadMax);
		txtCapacidadMax.setColumns(10);
		
		JLabel lblCapacidadMin = new JLabel("Capacidad Minima:");
		lblCapacidadMin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacidadMin.setBounds(22, 230, 149, 16);
		contentPane.add(lblCapacidadMin);
		
		JLabel lblPublico = new JLabel("Publico:");
		lblPublico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPublico.setBounds(158, 268, 56, 16);
		contentPane.add(lblPublico);
		
		JLabel lblDificultad = new JLabel("Dificultad:");
		lblDificultad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDificultad.setHorizontalAlignment(SwingConstants.CENTER);
		lblDificultad.setBounds(310, 380, 101, 16);
		contentPane.add(lblDificultad);
		
		txtCapacidadMin = new JTextField();
		txtCapacidadMin.setBounds(199, 227, 116, 22);
		txtCapacidadMin.setText(Integer.toString(c.getCapacidadMin()));
		contentPane.add(txtCapacidadMin);
		txtCapacidadMin.setColumns(10);
		
		JCheckBox chckbxHombres = new JCheckBox("Hombres");
		chckbxHombres.setBounds(73, 299, 113, 25);
		contentPane.add(chckbxHombres);
		btnGrPublico.add(chckbxHombres);

		JCheckBox chckbxMujeres = new JCheckBox("Mujeres");
		chckbxMujeres.setBounds(230, 299, 113, 25);
		contentPane.add(chckbxMujeres);
		btnGrPublico.add(chckbxMujeres);

		JCheckBox chckbxMixto = new JCheckBox("Mixto");
		chckbxMixto.setBounds(158, 335, 113, 25);
		contentPane.add(chckbxMixto);
		btnGrPublico.add(chckbxMixto);

		if(c.getPublico().equals("Mixto")) {
			chckbxMixto.setSelected(true);
		}
		else {
			if(c.getPublico().equals("Mujeres")) {
				chckbxMujeres.setSelected(true);
			}
			else {
				if(c.getPublico().equals("Hombres")) {
					chckbxHombres.setSelected(true);
				}
			}
		}
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(310, 504, 97, 25);
		contentPane.add(btnAceptar);
		
		JCheckBox chckbxPrincipiante = new JCheckBox("Principiante");
		chckbxPrincipiante.setBounds(199, 413, 113, 25);
		contentPane.add(chckbxPrincipiante);
		btnGrDif.add(chckbxPrincipiante);

		JCheckBox chckbxIntermedio = new JCheckBox("Intermedio");
		chckbxIntermedio.setBounds(315, 413, 101, 25);
		contentPane.add(chckbxIntermedio);
		btnGrDif.add(chckbxIntermedio);

		JCheckBox chckbxAvanzado = new JCheckBox("Avanzado");
		chckbxAvanzado.setBounds(425, 413, 113, 25);
		contentPane.add(chckbxAvanzado);
		btnGrDif.add(chckbxAvanzado);

		JCheckBox chckbxGeneral = new JCheckBox("General");
		chckbxGeneral.setBounds(315, 447, 113, 25);
		contentPane.add(chckbxGeneral);
		btnGrDif.add(chckbxGeneral);
		
		if(c.getDificultad().equals("Principiante")) {
			chckbxPrincipiante.setSelected(true);
		}
		else {
			if(c.getDificultad().equals("General")) {
				chckbxGeneral.setSelected(true);
			}
			else {
				if(c.getDificultad().equals("Intermedio")) {
					chckbxIntermedio.setSelected(true);
				}
				else {
					if(c.getDificultad().equals("Avanzando")) {
						chckbxAvanzado.setSelected(true);
					}
				}
			}
		}
		
		JSeparator separator = new JSeparator();
		separator.setBounds(23, 287, 323, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 400, 660, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 373, 660, 2);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(23, 262, 323, 2);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(23, 481, 660, 2);
		contentPane.add(separator_4);
		
		JList listActividades = new JList();
		listActividades.setBounds(361, 73, 323, 77);
		contentPane.add(listActividades);
		
		ResultSet listaProfesores = usuariosControlador.listarProfesores();

		tbProfesores = new JTable();
		tbProfesores.setBounds(361, 210, 323, 117);
		tbProfesores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbProfesores.setModel(DbUtils.resultSetToTableModel(listaProfesores));
		tbProfesores.setDefaultEditor(Object.class, null);
		contentPane.add(tbProfesores);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(23, 550, 660, 2);
		contentPane.add(separator_5);

		DefaultTableModel modelo = (DefaultTableModel) tbProfesores.getModel();
		
		tbProfesores.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	int selectedRow = tbProfesores.getSelectedRow();
        		
        		String nombreProfe = modelo.getValueAt(selectedRow, 0).toString();
        		//String acts = modelo.getValueAt(selectedRow, 1).toString();
        		txtProfesor.setText(nombreProfe);
            }
        });

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
				
				Profesor p = usuariosControlador.buscarProfesor(txtProfesor.getText());
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
							clasesControlador.eliminarClase(c, 0);
							clasesControlador.crearClase(txtActividad.getText(), fechaClase,horario,p.getNombreUsuario(), Float.parseFloat(txtDuracion.getText()), Integer.parseInt(txtCapacidadMax.getText()), Integer.parseInt(txtCapacidadMin.getText()), publico, dificultad);
							JOptionPane.showMessageDialog(null, "Modificacion correcta");
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "El Profesor seleccionado no puede dar esa clase","Atencion",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		
		/*----BOTON ACEPTAR----
		
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
		getContentPane().add(btnAceptar);*/
		
		
		
	}

}
