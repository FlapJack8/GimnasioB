package ventanas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaActividades;
import controladores.SistemaClases;
import controladores.SistemaUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class OpcionesClases extends JFrame{

	/*----Inicializar Interfaz de Opciones de Usuarios----*/
	
	public OpcionesClases(SistemaClases clasesControlador, SistemaUsuarios usuariosControlador, SistemaActividades actividadesControlador, String rolLogeado) {
		setResizable(false);
		setTitle("Clases");
		setBounds(450, 250, 352, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/**
		 *************************
		 * 1) DIAGRAMAR CLASE
		 * 2) ELIMINAR CLASE
		 * 3) MODIFICAR CLASE
		 *************************
		 *
		 */
		
		/*--------------------------------
		 *  *    1) DIAGRAMAR CLASE      *  *
		 *--------------------------------
		 */
		
		JButton btnAltaClase = new JButton("Diagramar Clase");
		btnAltaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clasesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					AltaClase altaClase = new AltaClase(clasesControlador, usuariosControlador, actividadesControlador);
					altaClase.setVisible(true);
				}
			}
		});
		btnAltaClase.setBounds(90, 50, 142, 23);
		getContentPane().add(btnAltaClase);
		
		/*------------------------------------
		 *  *    2) ELIMINAR CLASE      *  *
		 *------------------------------------
		 */
		JButton btnBajaClase = new JButton("Eliminar Clase");
		btnBajaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clasesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					EliminarClase eliminarClase = new EliminarClase(clasesControlador);
					eliminarClase.setVisible(true);
				}
			}
		});
		btnBajaClase.setBounds(90, 116, 142, 23);
		getContentPane().add(btnBajaClase);
		
		/*-------------------------------------
		 *  *    3) MODIFICAR CLASE      *  *
		 *-------------------------------------
		 */
		
		JButton btnModificarClase = new JButton("Modificar Clase");
		btnModificarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clasesControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					ModificarClase modifClase = new ModificarClase(clasesControlador, usuariosControlador, actividadesControlador);
					modifClase.setVisible(true);
				}
			}
		});
		btnModificarClase.setBounds(90, 84, 142, 23);
		getContentPane().add(btnModificarClase);
		setLocationRelativeTo(null);


		switch (rolLogeado.toLowerCase()) {
		case "operador":
			btnAltaClase.setEnabled(true);
			btnBajaClase.setEnabled(true);
			btnModificarClase.setEnabled(true);
			btnAltaClase.setBounds(100, 57, 142, 23);
			btnBajaClase.setBounds(100, 91, 142, 23);
			btnModificarClase.setBounds(100, 123, 142, 23);

		break;
		default://Administrador
		break;
		}
	}

}
