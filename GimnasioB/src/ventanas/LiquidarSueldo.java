package ventanas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaActividades;
import controladores.SistemaUsuarios;
import modelo.Administrador;
import modelo.Clase;
//import modelo.AgenteComercial;
import modelo.Operador;
//import modelo.VendedorBoleteria;
import modelo.Profesor;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class LiquidarSueldo extends JFrame{

	private JPanel contentPane;
	private JTextField txtFechaPago;
	private JTextField txtExtras;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblFechaInicioActs;
	private JLabel lblSueldo;
	private JLabel lblDiasLaborales;
	private JLabel lblDiasLaboralesDynamic;
	private JLabel lblExtras;
	private JLabel lblFechaDePago;
	private JTextArea txtDescripcion;

	public LiquidarSueldo(SistemaUsuarios usuariosControlador, String nombreUsuario, String nombre, String email, int dni, Float sueldo, Date fechaInicioActs, String diasLaborales, String rol) {
		setTitle("Modificar Empleado");

		/*---------CREO VENTANA DE MODIFICACION DE EMPLEADO----*/
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 472, 538);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			/*----CAMPOS Y LABELS A LLENAR----*/

			txtExtras = new JTextField();
			txtExtras.setBounds(166, 271, 116, 22);
			contentPane.add(txtExtras);
			txtExtras.setColumns(10);
			
			txtFechaPago = new JTextField(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()),15);
			txtFechaPago.setBounds(166, 306, 116, 22);
			contentPane.add(txtFechaPago);
			txtFechaPago.setColumns(10);
			
			JLabel lblLiquidarSueldo = new JLabel("Liquidar sueldo del/la " +rol+"/a: ");
			lblLiquidarSueldo.setFont(new Font("Tunga", Font.BOLD, 20));
			lblLiquidarSueldo.setBounds(12, 24, 303, 29);
			contentPane.add(lblLiquidarSueldo);
			
			lblNombre = new JLabel("("+nombreUsuario+") "+nombre);
			lblNombre.setFont(new Font("Tunga", Font.BOLD, 20));
			lblNombre.setBounds(83, 66, 296, 16);
			contentPane.add(lblNombre);
			
			lblDni = new JLabel("DNI: "+dni);
			lblDni.setBounds(22, 126, 128, 16);
			contentPane.add(lblDni);
			
			lblFechaInicioActs = new JLabel("Inicio Actividades: "+ fechaInicioActs);
			lblFechaInicioActs.setBounds(22, 163, 260, 16);
			contentPane.add(lblFechaInicioActs);
			
			lblSueldo = new JLabel("Importe de sueldo: "+sueldo);
			lblSueldo.setBounds(22, 198, 260, 16);
			contentPane.add(lblSueldo);
			
			lblDiasLaborales = new JLabel("Dias Laborales: ");
			lblDiasLaborales.setBounds(22, 234, 180, 16);
			contentPane.add(lblDiasLaborales);
			
			lblDiasLaboralesDynamic = new JLabel(diasLaborales);
			lblDiasLaboralesDynamic.setBounds(131, 234, 359, 16);
			contentPane.add(lblDiasLaboralesDynamic);
			
			lblExtras = new JLabel("Extras: ");
			lblExtras.setBounds(22, 270, 121, 16);
			contentPane.add(lblExtras);
			
			lblFechaDePago = new JLabel("Fecha de Pago: ");
			lblFechaDePago.setBounds(22, 309, 128, 16);
			contentPane.add(lblFechaDePago);
			
			JButton btnLiquidar = new JButton("Liquidar");
			btnLiquidar.setBounds(185, 460, 97, 25);
			btnLiquidar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					/*----VALIDA QUE TODOS LOS CAMPOS NECESARIOS ESTEN LLENOS----*/

					Date fechaPago=Date.valueOf(txtFechaPago.getText());
					Float total = sueldo;
					Float extras = 0.0f;
					
					if(!txtExtras.getText().equals(""))
					{
						extras = Float.parseFloat(txtExtras.getText());
						total = total+extras;
					}
					if(txtFechaPago.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Llene los campos necesarios","Error",JOptionPane.ERROR_MESSAGE);

					}
					else {
						if(usuariosControlador.existeEmpleado(nombreUsuario)) {
							java.util.Date today = Calendar.getInstance().getTime();
							int respuesta=JOptionPane.showConfirmDialog(null,"\nLiquidar sueldo del empleado: "+nombre+ "\nPor: "+total+"\n(Sueldo: "+sueldo+" + Extras: "+extras+")\nFecha de Pago: "+fechaPago+"\nDetalle: "+txtDescripcion.getText()+"\nFecha de Liquidacion: "+today, "Son estos los datos correctos?",JOptionPane.YES_NO_OPTION);
							if(respuesta==1) {
							
							}
							else if(respuesta==0) {

								usuariosControlador.liquidarSueldoEmpleado(nombreUsuario, nombre, dni, sueldo, extras, fechaPago, txtDescripcion.getText());
								JOptionPane.showMessageDialog(null, "Sueldo liquidado");
								dispose();
								
							}
							
						}
					}
				}
			});
			contentPane.add(btnLiquidar);
			
			JLabel lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(22, 348, 85, 16);
			contentPane.add(lblDescripcion);
			

			Calendar cal = Calendar.getInstance();
			int mesHoy = cal.get(Calendar.MONTH);
			int yearHoy = cal.get(Calendar.YEAR);
			
			txtDescripcion = new JTextArea("Liquidacion de sueldo del mes " + mesHoy+ "-" + yearHoy);
			txtDescripcion.setBounds(98, 366, 260, 73);
			contentPane.add(txtDescripcion);

			
			
			
	}
}
