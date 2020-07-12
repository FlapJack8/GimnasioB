package ventanas;
import java.awt.EventQueue;
import java.awt.SystemColor;
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
import persistencia.AbonoMapping;


public class ModificarAbono  extends JFrame{
	private JTextField txtNombreUsuarioModif;

	public ModificarAbono(SistemaAbonos abonosControlador) {
		setTitle("Modificar A");
		
		setBounds(450, 250, 401, 185);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		/*----CAMPO NOMBRE DE USUARIO----*/
		
		JLabel lblNombreDeUsuario = new JLabel("Tipo de abono:");
		lblNombreDeUsuario.setBounds(45, 40, 128, 14);
		contentPane().add(lblNombreDeUsuario);
		
		txtNombreUsuarioModif = new JTextField();
		txtNombreUsuarioModif.setBounds(188, 37, 128, 20);
		getContentPane().add(txtNombreUsuarioModif);
		txtNombreUsuarioModif.setColumns(10);
		
		/*----BOTON MODIFICAR----*/
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (abonosControlador != null) {
					
					/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
					
					if(!txtNombreUsuarioModif.getText().equals("")) {
						if(SistemaAbonos.existeAbono(txtNombreUsuarioModif.getText())){
							
							/*----ENVIA CONTROLADOR DE USUARIO A LA SIGUIENTE VISTA----*/

							ModificarAbonosCompletarCampos modificarAbonoLC = new ModificarAbonosCompletarCampos(abonosControlador);
							modificarAbonoLC.setVisible(true);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro el abono","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Llene todos los campos","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnModificar.setBounds(157, 100, 89, 23);
		getContentPane().add(btnModificar);
	}
}
