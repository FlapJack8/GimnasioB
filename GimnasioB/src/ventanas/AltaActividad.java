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
		setTitle("Agregar Actividad");
		
		/*---------CREO VENTANA----*/
		
		setResizable(false);
		toFront();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(400, 200, 754, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//-----------------------------------
		
		//Datos Actividad
		
		JLabel lblIngreseActividad= new JLabel("Nombre actividad:");
		lblIngreseActividad.setBounds(13, 103, 152, 14);
		contentPane.add(lblIngreseActividad);
		
		JLabel lblEstadoActividad = new JLabel("Estado de la actividad:");
		lblEstadoActividad.setBounds(13, 163, 152, 14);
		contentPane.add(lblEstadoActividad);
		
		textActividad = new JTextField();
		textActividad.setBounds(214, 100, 152, 20);
		contentPane.add(textActividad);
		textActividad.setColumns(10);
		
		textEstado = new JTextField();
		textEstado.setBounds(214, 160, 152, 20);
		contentPane.add(textEstado);
		textEstado.setColumns(10);
		
		//Agregar
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(214, 537, 152, 23);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				/*----VALIDA QUE TODOS LOS CAMPOS ESTEN LLENOS----*/
				if(textActividad.getText().equals("")||textEstado.getText().equals("")) 
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				else {
					
					if(actividadesControlador.existeActividad(textActividad.getText())) {
							JOptionPane.showMessageDialog(null, "La actividad ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
							textActividad.selectAll();
							textActividad.requestFocus();
					}
					
					actividadesControlador.crearActividad(textActividad.getText(), textEstado.getText());
					JOptionPane.showMessageDialog(null, "Actividad agregada correctamente");
					//actividadesControlador.imprimirActividad(); //Metodo aun no implementado
					dispose();
				}

			}
		});
		
		contentPane.add(btnAgregar);
		
	}
	
	
	
}
