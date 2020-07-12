package ventanas;

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

import controladores.SistemaAbonos;
import persistencia.AbonoMapping;

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
		 setBounds(400, 200, 720, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
				
		JLabel lblTIPOABONO = new JLabel("TIPO ABONO:");
		lblTIPOABONO.setBounds(14, 62, 86, 14);
		contentPane.add(lblTIPOABONO);
			
		JLabel lblPRECIO = new JLabel("PRECIO:");
		lblPRECIO.setBounds(24, 124, 86, 14);
		contentPane.add(lblPRECIO);
		
		JLabel lblDURACION = new JLabel("DURACION:");
		lblDURACION.setBounds(14, 99, 76, 14);
		contentPane.add(lblDURACION);
		
			
		JTextField textTIPOABONO = new JTextField();
		textTIPOABONO.setBounds(100, 59, 152, 20);
		contentPane.add(textTIPOABONO);
		textTIPOABONO.setColumns(10);
		
		JTextField textPRECIO = new JTextField();
		textPRECIO.setBounds(100, 96, 152, 20);
		contentPane.add(textPRECIO);
		textPRECIO.setColumns(10);
		
		JTextField textDURACION = new JTextField();
		textDURACION.setBounds(100, 121, 152, 20);
		contentPane.add(textDURACION);
		textDURACION.setColumns(10);
		
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(209, 182, 152, 23);
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

}
}
