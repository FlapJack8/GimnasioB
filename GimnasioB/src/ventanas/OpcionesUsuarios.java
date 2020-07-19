package ventanas;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaActividades;
import controladores.SistemaUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class OpcionesUsuarios extends JFrame{

	/*----Inicializar Interfaz de Opciones de Usuarios----*/
	
	public OpcionesUsuarios(SistemaUsuarios usuariosControlador, String rolLogeado, SistemaActividades actividadesControlador) {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Usuarios");
		setBounds(450, 250, 352, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblSocios = new JLabel("Socios:");
		lblSocios.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSocios.setBounds(48, 25, 79, 23);
		getContentPane().add(lblSocios);
		
		JLabel lblEmpleados = new JLabel("Empleados:");
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpleados.setBounds(200, 23, 109, 23);
		getContentPane().add(lblEmpleados);
		
		/**
		 *************************
		 * 1) ALTA SOCIO
		 * 2) ELIMINAR SOCIO
		 * 3) MODIFICAR SOCIO
		 * 4) ALTA EMPLEADO
		 * 5) BAJA EMPLEADO
		 * 6) MODIFICAR EMPLEADO
		 *************************
		 *
		 */
		
		/*--------------------------------
		 *  *    1) ALTA SOCIO      *  *
		 *--------------------------------
		 */
		
		JButton btnAltaCliente = new JButton("Registrar Socio");
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					RegistrarSocio altaUsuarios = new RegistrarSocio(usuariosControlador);
					altaUsuarios.setVisible(true);
				}
			}
		});
		btnAltaCliente.setBounds(10, 57, 142, 23);
		getContentPane().add(btnAltaCliente);
		
		/*------------------------------------
		 *  *    2) ELIMINAR SOCIO      *  *
		 *------------------------------------
		 */
		JButton btnBajaCliente = new JButton("Eliminar Socio");
		btnBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					EliminarSocio eliminarUsuarios = new EliminarSocio(usuariosControlador);
					eliminarUsuarios.setVisible(true);
				}
			}
		});
		btnBajaCliente.setBounds(10, 91, 142, 23);
		getContentPane().add(btnBajaCliente);
		
		/*-------------------------------------
		 *  *    3) MODIFICAR SOCIO      *  *
		 *-------------------------------------
		 */
		
		JButton btnModificarCliente = new JButton("Modificar Socio");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					ModificarSocio modifCliente = new ModificarSocio(usuariosControlador);
					modifCliente.setVisible(true);
				}
			}
		});
		btnModificarCliente.setBounds(10, 123, 142, 23);
		getContentPane().add(btnModificarCliente);
		
		/*---------------------------------
		 *  *    4) ALTA EMPLEADO      *  *
		 *---------------------------------
		 */
		
		JButton btnAltaEmpleado = new JButton("Registrar Empleado");
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					RegistrarEmpleado altaEmpleado = new RegistrarEmpleado(usuariosControlador, actividadesControlador);
					altaEmpleado.setVisible(true);
				}
			}
		});
		btnAltaEmpleado.setBounds(181, 57, 142, 23);
		getContentPane().add(btnAltaEmpleado);
		
		/*---------------------------------
		 *  *    5) BAJA EMPLEADO      *  *
		 *---------------------------------
		 */
		
		JButton btnBajaEmpleado = new JButton("Eliminar Empleado");
		btnBajaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					EliminarEmpleado eliminarEmpleado = new EliminarEmpleado(usuariosControlador);
					eliminarEmpleado.setVisible(true);
				}
			}
		});
		btnBajaEmpleado.setBounds(181, 91, 142, 23);
		getContentPane().add(btnBajaEmpleado);
		
		/*--------------------------------------
		 *  *    6) MODIFICAR EMPLEADO      *  *
		 *--------------------------------------
		 */
		
		JButton btnModificarEmpleado = new JButton("Modificar Empleado");
		btnModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					ModificarEmpleado modifEmpleado = new ModificarEmpleado(usuariosControlador, actividadesControlador);
					modifEmpleado.setVisible(true);
				}
			}
		});
		btnModificarEmpleado.setBounds(181, 123, 142, 23);
		getContentPane().add(btnModificarEmpleado);
		
		switch (rolLogeado.toLowerCase()) {
		case "operador":
			btnAltaCliente.setEnabled(true);
			btnBajaCliente.setEnabled(true);
			btnModificarCliente.setEnabled(true);
			btnAltaCliente.setBounds(100, 57, 142, 23);
			btnBajaCliente.setBounds(100, 91, 142, 23);
			btnModificarCliente.setBounds(100, 123, 142, 23);
			btnAltaCliente.setLabel("Registrar Socio");
			btnBajaCliente.setLabel("Eliminar Socio");
			btnModificarCliente.setLabel("Modificar Socio");

			
			btnAltaEmpleado.setEnabled(false);
			btnBajaEmpleado.setEnabled(false);
			btnModificarEmpleado.setEnabled(false);
			btnAltaEmpleado.setVisible(false);
			btnBajaEmpleado.setVisible(false);
			btnModificarEmpleado.setVisible(false);
			lblEmpleados.setVisible(false);
		break;
		default://Administrador
		break;
		}
	}
}
