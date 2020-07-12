package ventanas;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;

import controladores.SistemaAbonos;
import modelo.Abono;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
public class ModificarAbonoLlenarCampos  extends JFrame {
	private JPanel contentPane;
	private JTextField textTipoAbono;
	private JTextField textPRECIO;
	private JTextField textDURACION;
	private JTextField textESTADO;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public ModificarAbonoLlenarCampos(SistemaAbonos abonosControlador, Abono v) {
		 setForeground(SystemColor.textHighlight);
		 setTitle ("Modificar Abono");
		 setResizable(false);
		 toFront();
		 setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		 setBounds(400, 200, 720, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane (contentPane);
		contentPane.setLayout(null);
			
		JLabel lblPRECIO = new JLabel("PRECIO:");
		lblPRECIO.setBounds(14, 159, 86, 14);
		contentPane.add(lblPRECIO);
		
		JLabel lblDURACION = new JLabel("DURACION:");
		lblDURACION.setBounds(14, 134, 76, 14);
		contentPane.add(lblDURACION);
		
		JLabel lblESTADO = new JLabel("ESTADO:");
		lblESTADO.setBounds(14, 94, 76, 14);
		contentPane.add(lblESTADO);
		
		JTextField textPRECIO = new JTextField();
		textPRECIO.setBounds(100, 156, 152, 20);
		contentPane.add(textPRECIO);
		textPRECIO.setColumns(10);
		
		JTextField textDURACION = new JTextField();
		textDURACION.setBounds(100, 131, 152, 20);
		contentPane.add(textDURACION);
		textDURACION.setColumns(10);
		
		JTextField textESTADO = new JTextField();
		textESTADO.setBounds(100, 91, 152, 20);
		contentPane.add(textESTADO);
		textESTADO.setColumns(10);
		
		/*----BOTON ACEPTAR----*/
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float preci = Float.parseFloat(textPRECIO.getText());
				int duracio = Integer.parseInt(textDURACION.getText());
				String estad= textESTADO.getText();
				if(textPRECIO.getText().equals("")||textDURACION.getText().equals("")||textESTADO.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					//System.out.println(v.getEstado());
					abonosControlador.updateAbono(textESTADO.getText(), Float.parseFloat(textPRECIO.getText()), Integer.parseInt(textDURACION.getText()));
					JOptionPane.showMessageDialog(null, "Modificado!");
					dispose();
				}
				
			}
		});
		btnAceptar.setBounds(368, 230, 89, 23);
		getContentPane().add(btnAceptar);
}
}