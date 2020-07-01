package ventanas;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaCines;
import controladores.SistemaPeliculas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VistaOperador extends JFrame {

	private static final long serialVersionUID = 1L;
	AltaPelicula ap;
	ModificarPelicula mp;
	EliminarPelicula ep;
	CrearFuncion cf;
	EliminarFuncion ef;
	
	private JPanel contentPane;

	public VistaOperador(SistemaPeliculas peliculasControlador, SistemaCines cinesControlador) {
		setTitle("Operador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 264);
		toFront();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFunciones = new JLabel("Funciones:");
		lblFunciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFunciones.setBounds(42, 22, 96, 14);
		contentPane.add(lblFunciones);
		
		JLabel lblPeliculas = new JLabel("Peliculas:");
		lblPeliculas.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeliculas.setBounds(249, 22, 81, 14);
		contentPane.add(lblPeliculas);
		
		/**
		 *************************
		 * 1) CREAR FUNCION
		 * 2) MODIFICAR FUNCION
		 * 3) ELIMINAR FUNCION
		 * 
		 * 4) ALTA PELICULA
		 * 5) MODIFICAR PELICULA
		 * 6) ELIMINAR PELICULA
		 *************************
		 */
		
		/*----------------------------------
		 *  *    1)  CREAR FUNCION      *  *
		 *----------------------------------
		 */
		
		JButton btnCrearFuncion = new JButton("Crear Funcion");
		btnCrearFuncion.addMouseListener(new MouseAdapter() {
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
		btnCrearFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearFuncion cf = new CrearFuncion(cinesControlador);
				cf.setVisible(true);
			}
		});
		btnCrearFuncion.setBounds(21, 47, 130, 23);
		contentPane.add(btnCrearFuncion);
		
		/*-------------------------------------
		 *  *    3)  ELIMINAR FUNCION      *  *
		 *-------------------------------------
		 */
		
		JButton btnEliminarFuncion = new JButton("Eliminar Funcion");
		btnEliminarFuncion.addMouseListener(new MouseAdapter() {
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
		btnEliminarFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarFuncion ef = new EliminarFuncion(cinesControlador);
				ef.setVisible(true);
			}
		});
		btnEliminarFuncion.setBounds(21, 81, 130, 23);
		contentPane.add(btnEliminarFuncion);
		
		/*----------------------------------
		 *  *    5)  ALTA PELICULA      *  *
		 *----------------------------------
		 */
		
		JButton btnAltaPelicula = new JButton("Alta Pelicula");
		btnAltaPelicula.addMouseListener(new MouseAdapter() {
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
		btnAltaPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaPelicula ap = new AltaPelicula(peliculasControlador);
				ap.setVisible(true);
			}
		});
		btnAltaPelicula.setBounds(218, 47, 146, 23);
		contentPane.add(btnAltaPelicula);
		
		/*---------------------------------------
		 *  *    5)  MODIFICAR PELICULA      *  *
		 *---------------------------------------
		 */
		
		JButton btnModificarPelicula = new JButton("Modificar Pelicula");
		btnModificarPelicula.addMouseListener(new MouseAdapter() {
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
		btnModificarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarPelicula mp = new ModificarPelicula(peliculasControlador);
				mp.setVisible(true);
			}
		});
		btnModificarPelicula.setBounds(218, 81, 146, 23);
		contentPane.add(btnModificarPelicula);
		
		/*--------------------------------------
		 *  *    6)  ELIMINAR PELICULA      *  *
		 *--------------------------------------
		 */
		
		JButton btnEliminarPelicula = new JButton("Eliminar Pelicula");
		btnEliminarPelicula.addMouseListener(new MouseAdapter() {
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
		btnEliminarPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarPelicula ep = new EliminarPelicula(peliculasControlador);
				ep.setVisible(true);
			}
		});
		btnEliminarPelicula.setBounds(218, 115, 146, 23);
		contentPane.add(btnEliminarPelicula);
		
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
		btnCancelar.setBounds(310, 180, 89, 23);
		contentPane.add(btnCancelar);
	}
}
