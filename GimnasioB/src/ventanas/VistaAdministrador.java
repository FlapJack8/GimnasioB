package ventanas;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import controladores.SistemaCines;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaAdministrador extends JFrame {
	
	/*AltaCine ac;
	ModificarCine mc;
	BajaCine bc;
	AltaSala as;
	ModificarSala ms;
	EliminarSala es;
	*/
	
	private JPanel contentPane;

	public VistaAdministrador(SistemaCines cinesControlador) {
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCines = new JLabel("Cines:");
		lblCines.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCines.setBounds(79, 47, 46, 14);
		contentPane.add(lblCines);
		
		JLabel lblSalas = new JLabel("Salas:");
		lblSalas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSalas.setBounds(280, 47, 46, 14);
		contentPane.add(lblSalas);
		
		/**
		 *********************
		 * 1) Alta Cine
		 * 2) Modificar Cine
		 * 3) Baja Cine
		 * 
		 * 
		 * 4) Alta Sala
		 * 5) Modificar Sala
		 * 6) Baja Sala
		 *********************
		 */
		
		/*------------------------------
		 *  *    1)  ALTA CINE      *  *
		 *------------------------------
		 */
		
		JButton btnAltacine = new JButton("Alta Cine");
		btnAltacine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnAltacine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ac = new AltaCine(cinesControlador);
				ac.setVisible(true);
			}
		});
		btnAltacine.setBounds(35, 72, 133, 23);
		contentPane.add(btnAltacine);
		
		/*-----------------------------------
		 *  *    2)  MODIFICAR CINE      *  *
		 *-----------------------------------
		 */
		
		JButton btnModificarCine = new JButton("Modificar Cine");
		btnModificarCine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnModificarCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc = new ModificarCine(cinesControlador);
				mc.setVisible(true);
			}
		});
		btnModificarCine.setBounds(35, 106, 133, 23);
		contentPane.add(btnModificarCine);
		
		/*------------------------------
		 *  *    3)  BAJA CINE      *  *
		 *------------------------------
		 */
		
		JButton btnBajaCine = new JButton("Baja Cine");
		btnBajaCine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnBajaCine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bc = new BajaCine(cinesControlador);
				bc.setVisible(true);
			}
		});
		btnBajaCine.setBounds(35, 140, 133, 23);
		contentPane.add(btnBajaCine);
		
		/*------------------------------
		 *  *    4)  ALTA SALA      *  *
		 *------------------------------
		 */
		
		JButton btnAltaSala = new JButton("Alta Sala");
		btnAltaSala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnAltaSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				as = new AltaSala(cinesControlador);
				as.setVisible(true);
			}
		});
		btnAltaSala.setBounds(237, 72, 133, 23);
		contentPane.add(btnAltaSala);
		
		/*-----------------------------------
		 *  *    5)  MODIFICAR SALA      *  *
		 *-----------------------------------
		 */
		
		JButton btnModificarSala = new JButton("Modificar Sala");
		btnModificarSala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnModificarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ms = new ModificarSala(cinesControlador);
				ms.setVisible(true);
			}
		});
		btnModificarSala.setBounds(237, 106, 133, 23);
		contentPane.add(btnModificarSala);
		
		/*----------------------------------
		 *  *    6)  ELIMINAR SALA      *  *
		 *----------------------------------
		 */
		
		JButton btnEliminarSala = new JButton("Eliminar Sala");
		btnEliminarSala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnEliminarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				es = new EliminarSala(cinesControlador);
				es.setVisible(true);
			}
		});
		btnEliminarSala.setBounds(237, 140, 133, 23);
		contentPane.add(btnEliminarSala);
		
		/*----BOTON CANCELAR----*/
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Cursor manito = new Cursor(HAND_CURSOR);
				setCursor(manito);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Cursor cursor = new Cursor(NORMAL);
				setCursor(cursor);
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
	}
}
