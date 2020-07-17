package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

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

	public FacturarBuscarSocio(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador) {
		setTitle("Facturar Cuota");
		
		setBounds(450, 250, 401, 185);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblDniSocio = new JLabel("DNI socio:");
		lblDniSocio.setBounds(45, 40, 128, 14);
		getContentPane().add(lblDniSocio);
		
		txtDniBuscar = new JTextField();
		txtDniBuscar.setBounds(188, 37, 128, 20);
		getContentPane().add(txtDniBuscar);
		txtDniBuscar.setColumns(10);
		
		/*----BOTON MODIFICAR----*/
		
		JButton btnModificar = new JButton("Buscar Socio");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if(!txtDniBuscar.getText().equals("")) {
						Socio v = usuariosControlador.buscarSocio(Integer.parseInt(txtDniBuscar.getText()));
						/*----ENVIA CONTROLADOR DE FACTURAS Y USUARIO A LA SIGUIENTE VISTA----*/
						if(v!=null)
						{
							FacturarCuota facturarCuota = new FacturarCuota(facturasControlador, usuariosControlador, v);
							facturarCuota.setVisible(true);
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
		btnModificar.setBounds(117, 100, 140, 23);
		getContentPane().add(btnModificar);
	}

}
