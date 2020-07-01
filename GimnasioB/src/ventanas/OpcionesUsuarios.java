package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaUsuarios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class OpcionesUsuarios extends JFrame{

	/*----Inicializar Interfaz de Opciones de Usuarios----*/
	
	public OpcionesUsuarios(SistemaUsuarios usuariosControlador) {
		
		setTitle("Usuarios");
		setBounds(450, 250, 352, 225);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClientes.setBounds(48, 25, 79, 23);
		getContentPane().add(lblClientes);
		
		JLabel lblEmpleados = new JLabel("Empleados:");
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmpleados.setBounds(200, 23, 109, 23);
		getContentPane().add(lblEmpleados);
		
		/**
		 *************************
		 * 1) ALTA CLIENTE
		 * 2) ELIMINAR CLIENTE
		 * 3) MODIFICAR CLIENTE
		 * 4) ALTA EMPLEADO
		 * 5) BAJA EMPLEADO
		 * 6) MODIFICAR EMPLEADO
		 *************************
		 *
		 */
		
		/*--------------------------------
		 *  *    1) ALTA CLIENTE      *  *
		 *--------------------------------
		 */
		
		JButton btnAltaCliente = new JButton("Alta Cliente");
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					RegistrarCliente altaUsuarios = new RegistrarCliente(usuariosControlador);
					altaUsuarios.setVisible(true);
				}
			}
		});
		btnAltaCliente.setBounds(10, 57, 142, 23);
		getContentPane().add(btnAltaCliente);
		
		/*------------------------------------
		 *  *    2) ELIMINAR CLIENTE      *  *
		 *------------------------------------
		 */
		JButton btnBajaCliente = new JButton("Baja Cliente");
		btnBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					EliminarCliente eliminarUsuarios = new EliminarCliente(usuariosControlador);
					eliminarUsuarios.setVisible(true);
				}
			}
		});
		btnBajaCliente.setBounds(10, 91, 142, 23);
		getContentPane().add(btnBajaCliente);
		
		/*-------------------------------------
		 *  *    3) MODIFICAR CLIENTE      *  *
		 *-------------------------------------
		 */
		
		JButton btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					
					/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/
					
					ModificarCliente modifCliente = new ModificarCliente(usuariosControlador);
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
		
		JButton btnAltaEmpleado = new JButton("Alta Empleado");
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuariosControlador != null) {
					RegistrarEmpleado altaEmpleado = new RegistrarEmpleado(usuariosControlador);
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
		
		JButton btnBajaEmpleado = new JButton("Baja Empleado");
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
					
					ModificarEmpleado modifEmpleado = new ModificarEmpleado(usuariosControlador);
					modifEmpleado.setVisible(true);
				}
			}
		});
		btnModificarEmpleado.setBounds(181, 123, 142, 23);
		getContentPane().add(btnModificarEmpleado);
		
	}
}
