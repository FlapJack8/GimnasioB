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

public class EliminarAbono extends JFrame{
	
	private JPanel contentPane;
	private JTextField textTipoAbono;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public EliminarAbono(SistemaAbonos abonosControlador) {
		 setForeground(SystemColor.textHighlight);
		 setTitle ("Eliminar Abono");
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
		lblTIPOABONO.setBounds(30, 62, 86, 14);
		contentPane.add(lblTIPOABONO);
			
		JTextField textTIPOABONO = new JTextField();
		textTIPOABONO.setBounds(100, 59, 152, 20);
		contentPane.add(textTIPOABONO);
		textTIPOABONO.setColumns(10);
	
	
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
				
				if(!textTIPOABONO.getText().equals("")) {
					
					/*----CONFIRMA ELIMINACION----*/
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro que desea eliminar  este Abono?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						int flag = 0;
						flag = abonosControlador.deleteAbono(textTIPOABONO.getText(),flag);
						if(flag==1)
						{
							JOptionPane.showMessageDialog(null, "Eliminado!");
							flag=0;
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el abono","Error",JOptionPane.ERROR_MESSAGE);
							flag=0;
						}
			
					}
				}
				
			}
		});
		btnEliminar.setBounds(208, 113, 89, 23);
		getContentPane().add(btnEliminar);
	}
	}