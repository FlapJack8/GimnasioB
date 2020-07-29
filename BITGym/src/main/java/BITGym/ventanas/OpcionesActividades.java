package BITGym.ventanas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import BITGym.controladores.SistemaAbonos;
import BITGym.controladores.SistemaActividades;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class OpcionesActividades extends JFrame{

	/*----Inicializar Interfaz de Opciones de Abonos----*/
	
	public OpcionesActividades(SistemaActividades actividadesControlador, String rolLogeado) {
		setResizable(false);
		setTitle("Actividades");
		setBounds(450, 250, 352, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 *************************
		 * 1) ALTA ACTIVIDAD
		 * 2) ELIMINAR ACTIVIDAD
		 * 3) MODIFICAR ACTIVIDAD
		 *************************
		 *
		 */
		
		/*--------------------------------
		 *  *    1) ALTA ACTIVIDAD      *  *
		 *--------------------------------
		 */
		
		JButton btnAltaActividad = new JButton("Nueva Actividad");
		btnAltaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actividadesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE ACTIVIDADES A LA SIGUIENTE VISTA----*/
					
					AltaActividad altaActividad = new AltaActividad(actividadesControlador);
					altaActividad.setVisible(true);
				}
			}
		});
		btnAltaActividad.setBounds(90, 74, 142, 23);
		getContentPane().add(btnAltaActividad);
		
		/*------------------------------------
		 *  *    2) ELIMINAR ACTIVIDAD      *  *
		 *------------------------------------
		 */
		JButton btnBajaActividad = new JButton("Eliminar Actividad");
		btnBajaActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actividadesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE ACTIVIDADES A LA SIGUIENTE VISTA----*/
					
					EliminarActividad eliminarActividad = new EliminarActividad(actividadesControlador);
					eliminarActividad.setVisible(true);
				}
			}
		});
		btnBajaActividad.setBounds(90, 134, 142, 23);
		getContentPane().add(btnBajaActividad);
		
		/*-------------------------------------
		 *  *    3) MODIFICAR ACTIVIDAD    *  *
		 *-------------------------------------
		 */
		
		JButton btnModificarActividad = new JButton("Modificar Actividad");
		btnModificarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (actividadesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE ACTIVIDADES A LA SIGUIENTE VISTA----*/
					
					ModificarActividad modificarActividad = new ModificarActividad(actividadesControlador);
					modificarActividad.setVisible(true);
				}
			}
		});
		btnModificarActividad.setBounds(90, 104, 142, 23);
		getContentPane().add(btnModificarActividad);

		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividades.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblActividades.setBounds(107, 40, 111, 16);
		getContentPane().add(lblActividades);
		
		setLocationRelativeTo(null);

	}
}
