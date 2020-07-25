package BITGym.ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;

import BITGym.controladores.SistemaAbonos;
import BITGym.controladores.SistemaFacturas;
import BITGym.controladores.SistemaUsuarios;
import BITGym.modelo.Socio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

import BITGym.controladores.SistemaUsuarios;
import BITGym.modelo.Administrador;
import BITGym.modelo.Operador;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import java.awt.Font;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class FacturarCuotaEfectivo extends JFrame{

	private JPanel contentPane;
	private JLabel lblNombre;
	private JLabel lblDni;
	private JLabel lblTipoDeAbono;
	private JLabel lblMontoDeFacturacion;
	private JLabel lblFechaDeFacturacion;
	private JLabel lblFechaDeVencimiento;
	private JLabel lblLiquidarSueldo;
	private JTextArea txtDescripcion;

	public FacturarCuotaEfectivo(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador, Socio s, SistemaAbonos abonosControlador) {
		setTitle("Facturar Cuota");
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 380, 452);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			/*----CAMPOS Y LABELS A LLENAR----*/
			
			lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento de Abono: " + s.getFechaVenAbono());
			lblFechaDeVencimiento.setBounds(22, 180, 293, 22);
			contentPane.add(lblFechaDeVencimiento);
			
			lblFechaDeFacturacion = new JLabel("Fecha de Facturacion: " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
			lblFechaDeFacturacion.setBounds(22, 210, 293, 22);
			contentPane.add(lblFechaDeFacturacion);
	
			lblLiquidarSueldo = new JLabel("Datos de Factura:");
			lblLiquidarSueldo.setFont(new Font("Tunga", Font.BOLD, 20));
			lblLiquidarSueldo.setBounds(12, 24, 303, 29);
			contentPane.add(lblLiquidarSueldo);
			
			lblNombre = new JLabel("Socio: "+s.getNombre());
			lblNombre.setFont(new Font("Tunga", Font.BOLD, 20));
			lblNombre.setBounds(12, 66, 296, 16);
			contentPane.add(lblNombre);
			
			lblDni = new JLabel("DNI: "+s.getDni());
			lblDni.setBounds(22, 90, 286, 16);
			contentPane.add(lblDni);
			
			lblTipoDeAbono = new JLabel("Tipo de Abono: "+s.getTipoAbono());
			lblTipoDeAbono.setBounds(22, 120, 293, 16);
			contentPane.add(lblTipoDeAbono);
			
			lblMontoDeFacturacion = new JLabel("Monto a Facturar: "+abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio());
			lblMontoDeFacturacion.setBounds(22, 150, 293, 16);
			contentPane.add(lblMontoDeFacturacion);
			
			JButton btnFacturar = new JButton("Facturar");
			btnFacturar.setBounds(136, 360, 97, 25);
			btnFacturar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					/*----VALIDA QUE TODOS LOS CAMPOS NECESARIOS ESTEN LLENOS----*/

					
					if(txtDescripcion.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Llene los campos necesarios","Error",JOptionPane.ERROR_MESSAGE);

					}
					else {
						if(usuariosControlador.existeSocio(s.getDni())) {
							java.util.Date today = new java.util.Date();
							java.sql.Date hoy = new java.sql.Date(today.getTime());
							
							int respuesta=JOptionPane.showConfirmDialog(null,"\nFacturar a : "+s.getNombre()+ "\nPor: "+ abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio()+"\nFecha de Pago: "+today+"\nDetalle: "+txtDescripcion.getText(), "Son estos los datos correctos?",JOptionPane.YES_NO_OPTION);
							if(respuesta==1) {
							
							}
							else if(respuesta==0) {

								facturasControlador.generarFactura(0, s.getDni(), hoy, abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio(), txtDescripcion.getText(), "Efectivo");
								
								/*-----CALCULAMOS NUEVA FECHA DE VENCIMIENTO Y ACTUALIZAMOS-----*/
								
								Calendar cal = Calendar.getInstance();
						        cal.setTime(hoy);
						        cal.add(Calendar.DATE, abonosControlador.buscarAbono(s.getTipoAbono()).getDuracion());
						        java.util.Date nuevaFechaVenAux = cal.getTime();
						        java.sql.Date nuevaFechaVen = new java.sql.Date(nuevaFechaVenAux.getTime());
						        
								usuariosControlador.actualizarEstadoYFechaVenAbono(s.getDni(), nuevaFechaVen);
								JOptionPane.showMessageDialog(null, "Facturado");
								dispose();
								
							}
							
						}
					}
				}
			});
			contentPane.add(btnFacturar);
			
			JLabel lblDescripcion = new JLabel("Descripcion:");
			lblDescripcion.setBounds(22, 240, 85, 16);
			contentPane.add(lblDescripcion);
			
			txtDescripcion = new JTextArea("Facturacion de abono " + s.getTipoAbono() + "\nel dia " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
			txtDescripcion.setBounds(55, 270, 260, 73);
			contentPane.add(txtDescripcion);
		
			setLocationRelativeTo(null);

	}

}
