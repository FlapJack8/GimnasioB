package BITGym.ventanas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import BITGym.controladores.SistemaAbonos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class OpcionesAbonos extends JFrame{

	/*----Inicializar Interfaz de Opciones de Abonos----*/
	
	public OpcionesAbonos(SistemaAbonos abonosControlador, String rolLogeado) {
		setResizable(false);
		setTitle("Abonos");
		setBounds(450, 250, 352, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 *************************
		 * 1) ALTA ABONO
		 * 2) ELIMINAR ABONO
		 * 3) MODIFICAR ABONO
		 *************************
		 *
		 */
		
		/*--------------------------------
		 *  *    1) ALTA SOCIO      *  *
		 *--------------------------------
		 */
		
		JButton btnAltaAbono = new JButton("Nuevo Abono");
		btnAltaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					AltaAbono altaAbono = new AltaAbono(abonosControlador);
					altaAbono.setVisible(true);
				}
			}
		});
		btnAltaAbono.setBounds(90, 100, 142, 23);
		getContentPane().add(btnAltaAbono);
		
		/*------------------------------------
		 *  *    2) ELIMINAR ABONO      *  *
		 *------------------------------------
		 */
		JButton btnBajaAbono = new JButton("Eliminar Abono");
		btnBajaAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					EliminarAbono eliminarAbonos = new EliminarAbono(abonosControlador);
					eliminarAbonos.setVisible(true);
				}
			}
		});
		btnBajaAbono.setBounds(90, 134, 142, 23);
		getContentPane().add(btnBajaAbono);
		
		/*-------------------------------------
		 *  *    3) MODIFICAR ABONO      *  *
		 *-------------------------------------
		 */
		
		JButton btnModificarAbono = new JButton("Modificar Abono");
		btnModificarAbono.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					ModificarAbono modifCliente = new ModificarAbono(abonosControlador);
					modifCliente.setVisible(true);
				}
			}
		});
		btnModificarAbono.setBounds(90, 66, 142, 23);
		getContentPane().add(btnModificarAbono);
		
		JLabel lblAbonos = new JLabel("Abonos");
		lblAbonos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbonos.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAbonos.setBounds(107, 33, 111, 16);
		getContentPane().add(lblAbonos);

		setLocationRelativeTo(null);

	}
}
