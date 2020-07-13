package ventanas;

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

import controladores.SistemaActividades;
import modelo.Actividad;

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
		setBounds(400, 200, 715, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Actividad:");
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActividad.setBounds(13, 103, 152, 14);
		contentPane.add(lblActividad);
		
		JLabel lblEstadoActividad = new JLabel("Estado:");
		lblEstadoActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoActividad.setBounds(13, 163, 152, 14);
		contentPane.add(lblEstadoActividad);
		
		txtActividad = new JTextField();
		txtActividad.setBounds(214, 100, 152, 20);
		contentPane.add(txtActividad);
		txtActividad.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(214, 160, 152, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		//Actualizar
		JButton btnAceptar = new JButton("Actualizar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtActividad.getText().equals("")||txtEstado.getText().equals("")) 
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				else {

				actividadControlador.modificarActividad(txtActividad.getText(), txtEstado.getText());
				JOptionPane.showMessageDialog(null, "Actividad actualizada correctamente");
				//actividadControlador.imprimirActividad(); //Metodo aun no implementado
				dispose();
				}
			}
		});
		btnAceptar.setBounds(368, 230, 89, 23);
		getContentPane().add(btnAceptar);
	}
}
