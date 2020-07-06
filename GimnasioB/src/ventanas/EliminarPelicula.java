package ventanas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaPeliculas;
import modelo.Pelicula;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class EliminarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField peliAEliminar;
	private SistemaPeliculas peliControl;

	/**
	 * Create the frame.
	 */
	public EliminarPelicula(SistemaPeliculas pelicula) {
		
		peliControl = pelicula;
		
		setType(Type.POPUP);
		setTitle("Eliminar Pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblPelicula = new JLabel("Nombre Pelicula que quiere eliminar:");
		lblPelicula.setBounds(39, 21, 177, 14);
		contentPane.add(lblPelicula);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				peliControl.eliminarPelicula(peliAEliminar.getText());
				dispose();
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
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
		btnAceptar.setBounds(236, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		peliAEliminar = new JTextField();
		peliAEliminar.setBounds(122, 92, 188, 20);
		contentPane.add(peliAEliminar);
		peliAEliminar.setColumns(10);
	}
}
