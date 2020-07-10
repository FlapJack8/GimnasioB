package ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controladores.SistemaAbonos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class EliminarAbono extends JFrame{
private JTextField txtAbonoEliminar;
	
	public EliminarAbono(SistemaAbonos abonosControlador) {

		setTitle("Eliminar Abono");
		setBounds(450, 250, 368, 204);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblNombreDeUsuario = new JLabel("Tipo de abono:");
		lblNombreDeUsuario.setBounds(25, 47, 128, 14);
		getContentPane().add(lblNombreDeUsuario);
		
		txtAbonoEliminar = new JTextField();
		txtAbonoEliminar.setBounds(144, 44, 153, 20);
		getContentPane().add(txtAbonoEliminar);
		txtAbonoEliminar.setColumns(10);
		
		/*----BOTON ELIMINAR----*/
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
				
				if(!txtAbonoEliminar.getText().equals("")) {
					
					/*----CONFIRMA ELIMINACION----*/
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro que desea eliminar a este abono?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						int flag = 0;
						flag = abonosControlador.bajaAbono(txtAbonoEliminar.getText(),flag);
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
			
					}
				}
				
			}
		});
		btnEliminar.setBounds(208, 113, 89, 23);
		getContentPane().add(btnEliminar);
}}
