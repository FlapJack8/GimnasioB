package ventanas;
import java.awt.EventQueue;
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
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class AltaAbono extends JFrame{

	private JPanel contentPane;
	private JTextField textTipoAbono;
	private JTextField textPrecio;
	private JTextField textDuracion;
	public AltaAbono(SistemaAbonos AbonosControlador) {
		setTitle("Nuevo Abono");

		/*---------CREO VENTANA DE REGISTRO----*/
		
			setResizable(false);
			toFront();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 200, 593, 608);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
	
			JLabel lblTipoAbono = new JLabel("Tipo de Abono:");
			lblTipoAbono.setBounds(13, 33, 75, 14);
			contentPane.add(lblTipoAbono);
			
			JLabel lblDuracion = new JLabel("Duracion:");
			lblDuracion.setBounds(13, 103, 152, 14);
			contentPane.add(lblDuracion);
			
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(13, 163, 152, 14);
			contentPane.add(lblPrecio);
			 
		
			 textTipoAbono = new JTextField();
			 textTipoAbono.setBounds(214, 100, 152, 20);
			contentPane.add(textTipoAbono);
			textTipoAbono.setColumns(10);
			
			textPrecio = new JTextField();
			textPrecio.setBounds(214, 160, 152, 20);
			contentPane.add(textPrecio);
			textPrecio.setColumns(10);
			
			textDuracion = new JTextField();
			textDuracion.setBounds(214, 191, 152, 20);
			contentPane.add(textDuracion);
			textDuracion.setColumns(10);
			
			
			
			
			/*----BOTON ENVIAR----*/
			
			JButton btnEnviar = new JButton("Enviar");
			btnEnviar.setBounds(214, 537, 152, 23);
			btnEnviar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					AbonosControlador.altaAbono(textTipoAbono.getText(), Integer.parseInt(textDuracion.getText()),Float.parseFloat(textPrecio.getText()));
							JOptionPane.showMessageDialog(null, "Ingreso correcto");
							AbonosControlador.imprimirAbono();
							dispose();
						}
					;
				;
			});
			contentPane.add(btnEnviar);
			
			
			
			
		}
}
	
	
	

