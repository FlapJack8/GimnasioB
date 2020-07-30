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
import java.awt.Font;
import javax.swing.JSeparator;

public class FacturarBuscarSocio extends JFrame {
	private JTextField txtDniBuscar;

	public FacturarBuscarSocio(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador,
			SistemaAbonos abonosControlador) {
		setTitle("Facturas");

		setBounds(450, 250, 369, 311);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		/*----CAMPO NOMBRE DE USUARIO----*/

		JLabel lblDniSocio = new JLabel("DNI socio:");
		lblDniSocio.setBounds(25, 176, 68, 14);
		getContentPane().add(lblDniSocio);

		txtDniBuscar = new JTextField();
		txtDniBuscar.setBounds(110, 176, 128, 20);
		getContentPane().add(txtDniBuscar);
		txtDniBuscar.setColumns(10);

		/*----BOTON MODIFICAR----*/

		JButton btnFacturarEfectivo = new JButton("Efectivo");
		btnFacturarEfectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if (!txtDniBuscar.getText().equals("")) {
						Socio v = usuariosControlador.buscarSocio(Integer.parseInt(txtDniBuscar.getText()));
						/*----ENVIA CONTROLADOR DE FACTURAS Y USUARIO A LA SIGUIENTE VISTA----*/
						if (v != null) {
							FacturarCuotaEfectivo facturarCuota = new FacturarCuotaEfectivo(facturasControlador,
									usuariosControlador, v, abonosControlador);
							facturarCuota.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "No se econtro el socio", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Llene los campos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnFacturarEfectivo.setBounds(180, 216, 140, 23);
		getContentPane().add(btnFacturarEfectivo);

		JButton btnFacturarTarjeta = new JButton("Tarjeta");
		btnFacturarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if (!txtDniBuscar.getText().equals("")) {
						Socio v = usuariosControlador.buscarSocio(Integer.parseInt(txtDniBuscar.getText()));
						/*----ENVIA CONTROLADOR DE FACTURAS Y USUARIO A LA SIGUIENTE VISTA----*/
						if (v != null) {
							FacturarCuotaTarjeta facturarCuotaTarjeta = new FacturarCuotaTarjeta(facturasControlador,
									usuariosControlador, v, abonosControlador);
							facturarCuotaTarjeta.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "No se econtro el socio", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Llene los campos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnFacturarTarjeta.setBounds(30, 216, 140, 23);
		getContentPane().add(btnFacturarTarjeta);

		JLabel lblFacturar = new JLabel("Facturar:");
		lblFacturar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFacturar.setBounds(12, 133, 105, 16);
		getContentPane().add(lblFacturar);

		JLabel lblConsultarFacturas = new JLabel("Consultar Facturas:");
		lblConsultarFacturas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConsultarFacturas.setBounds(12, 13, 205, 16);
		getContentPane().add(lblConsultarFacturas);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (facturasControlador != null) {
					ListarFacturas listarFacturas = new ListarFacturas(facturasControlador);
					listarFacturas.setVisible(true);
					dispose();
				}
			}
		});
		btnConsultar.setBounds(125, 60, 97, 25);
		getContentPane().add(btnConsultar);

		JSeparator separator = new JSeparator();
		separator.setBounds(16, 114, 317, 3);
		getContentPane().add(separator);

		setLocationRelativeTo(null);

	}
}
