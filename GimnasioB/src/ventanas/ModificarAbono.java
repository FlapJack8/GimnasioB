package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemasAbonos;
import modelo.Administrador;
import modelo.Socio;
import modelo.Operador;
//import modelo.VendedorBoleteria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarAbono {
	private JTextField txtNombreUsuarioModif;

	public ModificarEmpleado(SistemaUsuarios usuariosControlador) {
		setTitle("Modificar Empleado");
		
		setBounds(450, 250, 401, 185);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblNombreDeUsuario = new JLabel("Tipo de abono:");
		lblNombreDeUsuario.setBounds(45, 40, 128, 14);
		contentPane().add(lblNombreDeUsuario);
		
		txtNombreUsuarioModif = new JTextField();
		txtNombreUsuarioModif.setBounds(188, 37, 128, 20);
		getContentPane().add(txtNombreUsuarioModif);
		txtNombreUsuarioModif.setColumns(10);
		
		/*----BOTON MODIFICAR----*/
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					
					if(!txtNombreUsuarioModif.getText().equals("")) {
						if(sistemaAbono.existeAbono(txtNombreUsuarioModif.getText())){
							
							/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/

							ModificarEmpleadoLlenarCampos modifEmpleadoLC = new ModificarEmpleadoLlenarCampos(abonosControlador,txtNombreUsuarioModif.getText());
							modifEmpleadoLC.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el abono","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnModificar.setBounds(157, 100, 89, 23);
		getContentPane().add(btnModificar);
	}
}
