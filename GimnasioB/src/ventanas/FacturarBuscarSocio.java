package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaAbonos;
import controladores.SistemaFacturas;
import controladores.SistemaUsuarios;
import modelo.Socio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacturarBuscarSocio extends JFrame{
	private JTextField txtDniBuscar;

	public FacturarBuscarSocio(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador, SistemaAbonos abonosControlador) {
		setTitle("Facturar Cuota");
		
		setBounds(450, 250, 359, 187);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblDniSocio = new JLabel("DNI socio:");
		lblDniSocio.setBounds(45, 37, 128, 14);
		getContentPane().add(lblDniSocio);
		
		txtDniBuscar = new JTextField();
		txtDniBuscar.setBounds(134, 37, 128, 20);
		getContentPane().add(txtDniBuscar);
		txtDniBuscar.setColumns(10);
		
		/*----BOTON MODIFICAR----*/
		
		JButton btnFacturarEfectivo = new JButton("Efectivo");
		btnFacturarEfectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if(!txtDniBuscar.getText().equals("")) {
						Socio v = usuariosControlador.buscarSocio(Integer.parseInt(txtDniBuscar.getText()));
						/*----ENVIA CONTROLADOR DE FACTURAS Y USUARIO A LA SIGUIENTE VISTA----*/
						if(v!=null)
						{
							FacturarCuotaEfectivo facturarCuota = new FacturarCuotaEfectivo(facturasControlador, usuariosControlador, v, abonosControlador);
							facturarCuota.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el socio","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Llene los campos","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnFacturarEfectivo.setBounds(175, 91, 140, 23);
		getContentPane().add(btnFacturarEfectivo);
		
		JButton btnFacturarTarjeta = new JButton("Tarjeta");
		btnFacturarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if(!txtDniBuscar.getText().equals("")) {
						Socio v = usuariosControlador.buscarSocio(Integer.parseInt(txtDniBuscar.getText()));
						/*----ENVIA CONTROLADOR DE FACTURAS Y USUARIO A LA SIGUIENTE VISTA----*/
						if(v!=null)
						{
							FacturarCuotaTarjeta facturarCuotaTarjeta = new FacturarCuotaTarjeta(facturasControlador, usuariosControlador, v, abonosControlador);
							facturarCuotaTarjeta.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el socio","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Llene los campos","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnFacturarTarjeta.setBounds(25, 91, 140, 23);
		getContentPane().add(btnFacturarTarjeta);
		
		setLocationRelativeTo(null);

		
	}
}
