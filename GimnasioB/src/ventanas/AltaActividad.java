package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controladores.SistemaActividades;


public class AltaActividad extends JFrame{

	private JPanel contentPane;
	private JTextField textActividad;
	private JTextField textEstado;

	
	public AltaActividad(SistemaActividades actividadesControlador) {
		setResizable(false);
		setTitle("Agregar Actividad");
		
		/*---------CREO VENTANA----*/
		
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 400, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//-----------------------------------
		
		//Datos Actividad
		
		JLabel lblIngreseActividad= new JLabel("Nombre actividad:");
		lblIngreseActividad.setBounds(12, 55, 152, 14);
		contentPane.add(lblIngreseActividad);
		
		textActividad = new JTextField();
		textActividad.setBounds(213, 52, 152, 20);
		contentPane.add(textActividad);
		textActividad.setColumns(10);
		
		//Agregar
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(105, 120, 152, 23);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
				if(textActividad.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				else {
					
					if(actividadesControlador.existeActividad(textActividad.getText())) {
							JOptionPane.showMessageDialog(null, "La actividad ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
							textActividad.selectAll();
							textActividad.requestFocus();
					}
					else {
					
					actividadesControlador.crearActividad(textActividad.getText());
					JOptionPane.showMessageDialog(null, "Actividad agregada correctamente");
					//actividadesControlador.imprimirActividad(); //Metodo aun no implementado
					dispose();
					}
				}

			}
		});
		setLocationRelativeTo(null);

		contentPane.add(btnAgregar);
		
	}
	
	
	
}
