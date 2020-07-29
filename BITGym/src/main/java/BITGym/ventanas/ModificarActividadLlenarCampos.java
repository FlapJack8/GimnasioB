package BITGym.ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BITGym.controladores.SistemaActividades;
import BITGym.modelo.Actividad;

public class ModificarActividadLlenarCampos extends JFrame{

	private JPanel contentPane;
	private JTextField txtActividad;
	private JTextField txtEstado;
	
	public ModificarActividadLlenarCampos(SistemaActividades actividadControlador, Actividad a) {
		
		setForeground(SystemColor.textHighlight);
		setTitle("Modificar Actividad");
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 325, 185);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Nombre de actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblActividad.setBounds(12, 47, 128, 14);
		contentPane.add(lblActividad);
		String actividadAux = a.getNombreActividad();
		txtActividad = new JTextField();
		txtActividad.setBounds(145, 44, 152, 20);
		contentPane.add(txtActividad);
		txtActividad.setText(actividadAux);
		txtActividad.setColumns(10);
		
		//Actualizar
		JButton btnAceptar = new JButton("Actualizar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtActividad.getText().equals("")) 
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				else {
			//	System.out.println("Hola");
				actividadControlador.modificarActividad(actividadAux,txtActividad.getText());
				JOptionPane.showMessageDialog(null, "Actividad actualizada correctamente");
				//actividadControlador.imprimirActividad(); //Metodo aun no implementado
				dispose();
				}
			}
		});
		btnAceptar.setBounds(107, 93, 89, 23);
		getContentPane().add(btnAceptar);
		setLocationRelativeTo(null);

	}
}
