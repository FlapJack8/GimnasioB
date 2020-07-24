package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaAbonos;
import controladores.SistemaFacturas;
import controladores.SistemaUsuarios;
import modelo.Socio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;

public class FacturarCuotaTarjeta extends JFrame{
	private JPanel contentPane;
	private JTextField txtDniBuscar;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtNumeroTarjeta;
	private JTextField txtFechaVencimiento;
	private JTextField txtCuotas;
	private JTextField txtCvc;

	public FacturarCuotaTarjeta(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador, Socio s, SistemaAbonos abonosControlador) {
		setTitle("Pago con Tarjeta de Credito");
		
		/*---------CREO VENTANA DE MODIFICACION DE EMPLEADO----*/
		
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 380, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 24, 153, 16);
		contentPane.add(lblNombre);
		
		JLabel lblNumTarjeta = new JLabel("Numero de Tarjeta:");
		lblNumTarjeta.setBounds(12, 124, 153, 16);
		contentPane.add(lblNumTarjeta);
		
		JLabel lblFechaDeVencimiento = new JLabel("Fecha de Vencimiento:");
		lblFechaDeVencimiento.setBounds(12, 154, 153, 16);
		contentPane.add(lblFechaDeVencimiento);
		
		JLabel lblCvc = new JLabel("CVC:");
		lblCvc.setBounds(12, 184, 153, 16);
		contentPane.add(lblCvc);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(12, 84, 153, 16);
		contentPane.add(lblDni);
		
		JLabel lblMonto = new JLabel("Monto: " + abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio());
		lblMonto.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMonto.setBounds(12, 244, 153, 16);
		contentPane.add(lblMonto);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setBounds(12, 324, 153, 16);
		contentPane.add(lblDetalle);
		
		txtNombre = new JTextField(s.getNombre());
		txtNombre.setBounds(189, 24, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField(s.getApellido());
		txtApellido.setBounds(189, 54, 116, 22);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		txtDni = new JTextField(Integer.toString(s.getDni()));
		txtDni.setBounds(189, 84, 116, 22);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		txtNumeroTarjeta = new JTextField();
		txtNumeroTarjeta.setBounds(189, 124, 116, 22);
		contentPane.add(txtNumeroTarjeta);
		txtNumeroTarjeta.setColumns(10);
		
		txtFechaVencimiento = new JTextField(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
		txtFechaVencimiento.setBounds(189, 154, 116, 22);
		contentPane.add(txtFechaVencimiento);
		txtFechaVencimiento.setColumns(10);
		
		JTextArea txtDetalle = new JTextArea("Facturacion de abono " + s.getTipoAbono() + "\nel dia " + new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date())+ "\n\nFecha de Vencimiento:\n" + s.getFechaVenAbono());
		txtDetalle.setBounds(63, 354, 242, 99);
		contentPane.add(txtDetalle);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(12, 54, 153, 16);
		contentPane.add(lblApellido);
		
		JLabel lblCuotas = new JLabel("Cuotas:");
		lblCuotas.setBounds(12, 284, 56, 16);
		contentPane.add(lblCuotas);
		
		txtCuotas = new JTextField("1");
		txtCuotas.setBounds(189, 284, 116, 22);
		contentPane.add(txtCuotas);
		txtCuotas.setColumns(10);
		
		txtCvc = new JTextField();
		txtCvc.setBounds(189, 184, 116, 22);
		contentPane.add(txtCvc);
		txtCvc.setColumns(10);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBounds(138, 465, 97, 25);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*----VALIDA QUE TODOS LOS CAMPOS NECESARIOS ESTEN LLENOS----*/

				
				if(txtNombre.getText().equals("")||txtApellido.getText().equals("")||txtDni.getText().equals("")||txtNumeroTarjeta.getText().equals("")||txtFechaVencimiento.getText().equals("")||txtCvc.getText().equals("")||txtCuotas.getText().equals("")||txtDetalle.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Llene los campos necesarios","Error",JOptionPane.ERROR_MESSAGE);

				}
				else {
					if(usuariosControlador.existeSocio(s.getDni())) {
						java.util.Date today = new java.util.Date();
						java.sql.Date hoy = new java.sql.Date(today.getTime());
						
						int respuesta=JOptionPane.showConfirmDialog(null,"\nFacturar a : "+s.getNombre()+ "\nPor: "+ abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio()+"\nFecha de Pago: "+today+"\nDetalle:\n"+txtDetalle.getText(), "Son estos los datos correctos?",JOptionPane.YES_NO_OPTION);
						if(respuesta==1) {
						
						}
						else if(respuesta==0) {
							
							/*Conexion con API*/
							
							
							
							/*Si API devuelve que pago*/
							
								facturasControlador.generarFactura(0, s.getDni(), hoy, abonosControlador.buscarAbono(s.getTipoAbono()).getPrecio(), txtDetalle.getText(), "Tarjeta");
								
								/*-----CALCULAMOS NUEVA FECHA DE VENCIMIENTO Y ACTUALIZAMOS-----*/
								
								Calendar cal = Calendar.getInstance();
						        cal.setTime(hoy);
						        cal.add(Calendar.DATE, abonosControlador.buscarAbono(s.getTipoAbono()).getDuracion());
						        java.util.Date nuevaFechaVenAux = cal.getTime();
						        java.sql.Date nuevaFechaVen = new java.sql.Date(nuevaFechaVenAux.getTime());
						        
								usuariosControlador.actualizarEstadoYFechaVenAbono(s.getDni(), nuevaFechaVen);
															
								JOptionPane.showMessageDialog(null, "Facturado");
								dispose();
							
							/*Si API devuelve algun error*/
								
								/*Mensaje*/
							
						}
						
					}
				}
			}
		});
		contentPane.add(btnPagar);
		
		
		setLocationRelativeTo(null);

	}
}
