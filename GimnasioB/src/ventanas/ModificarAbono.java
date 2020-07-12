package ventanas;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.SistemaAbonos;
import controladores.SistemaClases;
import controladores.SistemaUsuarios;
import modelo.Abono;
import modelo.Clase;
import modelo.Socio;
import persistencia.AbonoMapping;


public class ModificarAbono  extends JFrame{
	private JPanel contentPane;
	private JTextField textTipoAbono;
	
	public ModificarAbono(SistemaAbonos abonosControlador) {

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
		
		/*----CAMPOS A LLENAR----*/
		
				
		JLabel lblTIPOABONO = new JLabel("TIPO ABONO:");
		lblTIPOABONO.setBounds(30, 62, 86, 14);
		contentPane.add(lblTIPOABONO);
			
		JTextField textTIPOABONO = new JTextField();
		textTIPOABONO.setBounds(100, 59, 152, 20);
		contentPane.add(textTIPOABONO);
		textTIPOABONO.setColumns(10);
	
/*----BOTON MODIFICAR----*/
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					if(!textTIPOABONO.getText().equals("")) {
						Abono v = abonosControlador.buscarAbono(textTIPOABONO.getText());
						/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
						if(v!=null)
						{
							ModificarAbonoLlenarCampos modifClienteLC = new ModificarAbonoLlenarCampos(abonosControlador,v);
							modifClienteLC.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el abono","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnModificar.setBounds(157, 100, 89, 23);
		getContentPane().add(btnModificar);
	}
}
