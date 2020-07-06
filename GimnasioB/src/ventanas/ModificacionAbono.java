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
import controladores.SistemasAbonos;
import modelo.Abono;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class ModificacionAbono extends JFrame{
	
	private JTextField textTipoAbono;
	private JTextField txtPrecio;
	private JPanel contentPane;
	private JTextField textPrecio;
	private JTextField textDuracion;
public ModificacionAbono(SistemasAbonos SistemasAbonos, String tipoAbono) {
	
	setTitle("Modificar Abono");
	/*---------CREO VENTANA DE MODIFICACION DE EMPLEADO----*/
	
	setResizable(false);
	toFront();
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(400, 200, 622, 590);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	
	
	/*----CAMPOS A LLENAR----*/
	
	JLabel lblTipoAbono = new JLabel("Tipo de abono:");
	lblTipoAbono.setBounds(11, 28, 152, 14);
	contentPane.add(lblTipoAbono);
	
	JLabel lblPrecio = new JLabel("Precio:");
	lblPrecio.setBounds(11, 93, 152, 14);
	contentPane.add(lblPrecio);
		
	

	JTextField textAbono = new JTextField();
	textAbono.setEditable(false);
	textAbono.setEnabled(false);
	textAbono.setBounds(212, 25, 152, 20);
	contentPane.add(textAbono);
	textAbono.setColumns(10);
	
	textPrecio = new JTextField();
	textPrecio.setBounds(212, 90, 152, 20);
	contentPane.add(textPrecio);
	textPrecio.setColumns(10);
	
	
	/*----BUSCAR EL USUARIO Y LLENA LOS CAMPOS----*/
	java.util.Date fechaN;
	
	Abono a = SistemasAbonos.buscarAbono(textAbono.getText());
	if(a!=null) {
		textAbono.setText(a.getTipoAbono());
		textPrecio.setText(a.getPrecio());

		
	
	/*----BOTON MODIFICAR----*/
	
	JButton btnModificar = new JButton("Modificar");
	btnModificar.setBounds(160, 508, 152, 23);
	btnModificar.addActionListener(new ActionListener() {
		private Float lblPrecio;

		public void actionPerformed(ActionEvent arg0) {
			
			/*----OBTIENE EL ROL----*/
			
			Float precio = new Float(precio);
			precio = null;
			
			
				precio = this.lblPrecio;
			
			
			
		}
	});
	contentPane.add(btnModificar);
	
	JLabel lblSueldo = new JLabel("Sueldo:");
	lblSueldo.setBounds(11, 215, 56, 16);
	contentPane.add(lblSueldo);
	
	JLabel lblFechaInicioActs = new JLabel("Fecha Inicio de Actividades:");
	lblFechaInicioActs.setBounds(11, 244, 168, 16);
	contentPane.add(lblFechaInicioActs);


}

	
}
}
