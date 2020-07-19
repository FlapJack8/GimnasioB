package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controladores.SistemaUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminarSocio extends JFrame {

	private JTextField txtDNI;
	
	public EliminarSocio(SistemaUsuarios usuariosControlador) {

		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Eliminar Socio");
		setBounds(450, 250, 368, 204);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblDni = new JLabel("Dni del socio:");
		lblDni.setBounds(25, 47, 128, 14);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(144, 44, 153, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		/*----BOTON ELIMINAR----*/
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
				
				if(!txtDNI.getText().equals("")) {
					
					/*----CONFIRMA ELIMINACION----*/
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro que desea eliminar a este usuario?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						int flag = 0;
						flag = usuariosControlador.bajaSocio(Integer.parseInt(txtDNI.getText()),flag);
						if(flag==1)
						{
							JOptionPane.showMessageDialog(null, "Eliminado!");
							flag=0;
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el usuario","Error",JOptionPane.ERROR_MESSAGE);
							flag=0;
						}
			
						usuariosControlador.imprimir();
					}
				}
			}
		});
		btnEliminar.setBounds(208, 113, 89, 23);
		getContentPane().add(btnEliminar);
		setLocationRelativeTo(null);

	}
}
