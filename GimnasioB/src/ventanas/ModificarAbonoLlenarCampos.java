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

import controladores.SistemaAbonos;
import modelo.Abono;

public class ModificarAbonoLlenarCampos extends JFrame{

	private JPanel contentPane;
	private JTextField txtPRECIO;
	private JTextField txtDURACION;
	
	public ModificarAbonoLlenarCampos(SistemaAbonos abonoContorlador, Abono a) {
		
		setForeground(SystemColor.textHighlight);
		setTitle("Modificar Abono");
		setLocationRelativeTo(null);
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 715, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblActividad = new JLabel("Precio:");
		lblActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblActividad.setBounds(85, 124, 61, 14);
		contentPane.add(lblActividad);
		
		JLabel lblEstadoActividad = new JLabel("Duracion:");
		lblEstadoActividad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstadoActividad.setBounds(85, 166, 89, 14);
		contentPane.add(lblEstadoActividad);
		
		txtPRECIO = new JTextField();
		txtPRECIO.setText(Float.toString(a.getPrecio()));
		txtPRECIO.setBounds(184, 122, 152, 20);
		contentPane.add(txtPRECIO);
		txtPRECIO.setColumns(10);
		
		txtDURACION = new JTextField();
		txtDURACION.setText(Integer.toString(a.getDuracion()));

		txtDURACION.setBounds(184, 160, 152, 20);
		contentPane.add(txtDURACION);
		txtDURACION.setColumns(10);
		
		//Actualizar
		JButton btnAceptar = new JButton("Actualizar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtPRECIO.getText().equals("") || txtDURACION.getText().equals("")) 
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				else {
					abonoContorlador.updateAbono(a.getTipoAbono(), Float.parseFloat(txtPRECIO.getText()), Integer.parseInt(txtDURACION.getText()));
				JOptionPane.showMessageDialog(null, "Actividad actualizada correctamente");
				//actividadControlador.imprimirActividad(); //Metodo aun no implementado
				dispose();
				}
			}
		});
		btnAceptar.setBounds(197, 202, 106, 23);
		getContentPane().add(btnAceptar);
	}
}
