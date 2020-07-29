package BITGym.ventanas;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BITGym.controladores.SistemaAbonos;
import BITGym.persistencia.AbonoMapping;

public class AltaAbono extends JFrame {
	private JPanel contentPane;
	private JTextField textTipoAbono;
	private JTextField textPRECIO;
	private JTextField textDURACION;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public AltaAbono(SistemaAbonos abonosControlador) {
		
		setForeground(SystemColor.textHighlight);
		 setTitle ("Alta Abono");
		 setResizable(false);
		 toFront();
		 setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		 setBounds(400, 200, 417, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
				
		JLabel lblTIPOABONO = new JLabel("Tipo de Abono:");
		lblTIPOABONO.setBounds(24, 62, 121, 14);
		contentPane.add(lblTIPOABONO);
			
		JLabel lblPRECIO = new JLabel("Precio:");
		lblPRECIO.setBounds(24, 121, 86, 14);
		contentPane.add(lblPRECIO);
		
		JLabel lblDURACION = new JLabel("Duracion:");
		lblDURACION.setBounds(24, 90, 76, 14);
		contentPane.add(lblDURACION);
		
			
		JTextField textTIPOABONO = new JTextField();
		textTIPOABONO.setBounds(164, 59, 152, 20);
		contentPane.add(textTIPOABONO);
		textTIPOABONO.setColumns(10);
		
		JTextField textPRECIO = new JTextField();
		textPRECIO.setBounds(164, 90, 152, 20);
		contentPane.add(textPRECIO);
		textPRECIO.setColumns(10);
		
		JTextField textDURACION = new JTextField();
		textDURACION.setBounds(164, 121, 152, 20);
		contentPane.add(textDURACION);
		textDURACION.setColumns(10);
		
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(128, 173, 152, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
			
				if(textDURACION.getText().equals("")||textTIPOABONO.getText().equals("")||textPRECIO.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					if(abonosControlador.existeAbono(textTIPOABONO.getText())) {
						JOptionPane.showMessageDialog(null, "El abono ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
						textTIPOABONO.selectAll();
						textTIPOABONO.requestFocus();
					}
					else
					{
						abonosControlador.altaAbono(textTIPOABONO.getText(),Float.parseFloat(textPRECIO.getText()), Integer.parseInt(textDURACION.getText()));
						JOptionPane.showMessageDialog(null, "Ingreso correcto");
					}
				}

			}
		});
		contentPane.add(btnEnviar);
		setLocationRelativeTo(null);
}
}
