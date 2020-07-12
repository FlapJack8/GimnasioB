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
	
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Eliminar");
		btnEnviar.setBounds(209, 182, 152, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
			
				if(textTIPOABONO.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					
					if(abonosControlador.existeAbono(textTIPOABONO.getText())) {// aca poner para eliminar el abono
						abonosControlador.eliminarAbono(textTIPOABONO.getText());
						JOptionPane.showMessageDialog(null, "El abono se elimino","Atencion",JOptionPane.WARNING_MESSAGE);
						textTIPOABONO.selectAll();
						textTIPOABONO.requestFocus();
					}
					else					{
						JOptionPane.showMessageDialog(null, "No exite el abono que desea eliminar");
					}
				}

			}
		});
		contentPane.add(btnEnviar);

}
	
	
}