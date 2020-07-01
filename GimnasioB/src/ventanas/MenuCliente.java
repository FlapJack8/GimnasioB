package ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import controladores.SistemaCines;
import controladores.SistemaUsuarios;
//import controladores.SistemaVentas;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuCliente extends JFrame {

	private JPanel contentPane;
	//private SistemaVentas v;
	//private SistemaCines cin;
	private SistemaUsuarios u;


	/**
	 * Create the frame.
	 */
	public MenuCliente(String usuario,String nombre) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*JButton btnComprarEntrada = new JButton("Comprar Entrada");
		btnComprarEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraEntradaOnline en=new CompraEntradaOnline(v,u,cin,usuario,nombre);
				en.setVisible(true);
				dispose();
			}
		});
		btnComprarEntrada.setBounds(124, 98, 187, 29);
		contentPane.add(btnComprarEntrada);
		*/
		JButton btnNewButton = new JButton("Funciones disponibles");
		btnNewButton.setBounds(135, 157, 176, 29);
		contentPane.add(btnNewButton);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
