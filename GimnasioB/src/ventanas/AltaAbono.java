package ventanas;
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
import controladores.SistemasAbonos;

public class AltaAbono {
	private JPanel contentPane;
	private JTextField textDNI;
	private JTextField textDomicilio;
	private JTextField textMail;
	private JTextField textFechaNacimiento;
	private JTextField textFechaIns;
	private JTextField textTipoAbono;
	private JTextField textNombre;
	private JTextField textFechaVen;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public AltaAbono(SistemasAbonos SistemasAbonos) {
		setTitle("Alta Abono");
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 720, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*----CAMPOS A LLENAR----*/
		
		JLabel lblIDABONO = new JLabel("ID ABONO:");
		lblIDABONO.setBounds(11, 62, 46, 14);
		contentPane.add(lblIDABONO);
		
		JLabel lblTIPOABONO = new JLabel("TIPO ABONO:");
		lblTIPOABONO.setBounds(11, 124, 64, 14);
		contentPane.add(lblTIPOABONO);
			
		JLabel lblPRECIO = new JLabel("PRECIO");
		lblPRECIO.setBounds(191, 75, 86, 14);
		contentPane.add(lblPRECIO);
		
		JLabel lblDURACION = new JLabel("DURACION:");
		lblDURACION.setBounds(11, 93, 46, 14);
		contentPane.add(lblDURACION);
		
		JTextField textIDABONO = new JTextField();
		textIDABONO.setBounds(212, 121, 152, 20);
		contentPane.add(textIDABONO);
		textIDABONO.setColumns(10); 
		
		JTextField textTIPOABONO = new JTextField();
		textTIPOABONO.setBounds(212, 121, 152, 20);
		contentPane.add(textTIPOABONO);
		textTIPOABONO.setColumns(10);
		
		JTextField textPRECIO = new JTextField();
		textPRECIO.setBounds(212, 121, 152, 20);
		contentPane.add(textPRECIO);
		textPRECIO.setColumns(10);
		
		JTextField textDURACION = new JTextField();
		textDURACION.setBounds(212, 121, 152, 20);
		contentPane.add(textDURACION);
		textDURACION.setColumns(10);
		
		/*----BOTON ENVIAR----*/
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(311, 293, 152, 23);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
			//if(!Date.valueOf( textFechaNacimiento.getText()).equals("")|| !Date.valueOf( textFechaIns.getText()).equals("")|| !Date.valueOf( textFechaVen.getText()).equals("")) {
				Date fechaN=Date.valueOf( textFechaNacimiento.getText());
				Date fechaI=Date.valueOf( textFechaIns.getText());
				Date fechaV=Date.valueOf( textFechaVen.getText());
			//}
				if(textNombre.getText().equals("")||textTipoAbono.getText().equals("")||textFechaNacimiento.getText().equals("")||textDomicilio.getText().equals("")||fechaN.equals("")||fechaV.equals("")||fechaI.equals("")||textMail.getText().equals("")||textDNI.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}
				else {
					
					if(SistemasAbonos.ExisteAbono(textTIPOABONO.getText())) {
						JOptionPane.showMessageDialog(null, "El abono ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
						textTIPOABONO.selectAll();
						textTIPOABONO.requestFocus();
					}
					else
					{
						SistemasAbonos.altaAbono(Integer.parseInt(textIDABONO.getText()), textTIPOABONO.getText(),Integer.parseInt(textDURACION.getText())   , Float.parseFloat(textPRECIO.getText()));
						JOptionPane.showMessageDialog(null, "Ingreso correcto");
						SistemasAbonos.imprimirAbono();
					}
				}

			}
		});
		contentPane.add(btnEnviar);

}
}
