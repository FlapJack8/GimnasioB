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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificarPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField textObservaciones;
	private JTextField txtCalificacion;
	private JTextField txtDirector;
	private JTextField txtGenero;
	private JTextField txtDuracion;
	private JTextField txtIdiomaOtro;
	private JTextField txtOtroSubs;
	private JTextField txtPelicula;
	private String idioma;
	private String subtitulos;
	private SistemaPeliculas peliControl;
	/**
	 * Create the frame.
	 */
	public ModificarPelicula(SistemaPeliculas pelicula) {
		
		peliControl = pelicula;
		
		setType(Type.POPUP);
		setTitle("Modificar Pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 376);
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
		btnCancelar.setBounds(446, 288, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		lblPelicula.setBounds(10, 11, 46, 14);
		contentPane.add(lblPelicula);
		
	/*	JComboBox cbPelicula = new JComboBox(peliControl.peliculas);
		cbPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreAModificar = (String) cbPelicula.getSelectedItem();
				Pelicula peli = peliControl.buscarPelicula(nombreAModificar);
				txtDirector.setText(peli.getDirector());
			}
		});*/
		//cbPelicula.setBounds(66, 8, 105, 20);
		//contentPane.add(cbPelicula);
		
		JLabel lblNewLabel = new JLabel("Director:");
		lblNewLabel.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 61, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(10, 86, 46, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblIdiomas = new JLabel("Idiomas:");
		lblIdiomas.setBounds(10, 111, 46, 14);
		contentPane.add(lblIdiomas);
		
		JLabel lblSubtitulos = new JLabel("Subtitulos:");
		lblSubtitulos.setBounds(293, 111, 67, 14);
		contentPane.add(lblSubtitulos);
		
		JLabel lblCalificacion = new JLabel("Calificacion:");
		lblCalificacion.setBounds(181, 11, 67, 14);
		contentPane.add(lblCalificacion);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(10, 216, 84, 14);
		contentPane.add(lblObservaciones);
		
		textObservaciones = new JTextField();
		textObservaciones.setBounds(41, 241, 186, 70);
		contentPane.add(textObservaciones);
		textObservaciones.setColumns(10);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(258, 8, 86, 20);
		contentPane.add(txtCalificacion);
		txtCalificacion.setColumns(10);
		
		txtDirector = new JTextField();
		txtDirector.setBounds(66, 33, 86, 20);
		contentPane.add(txtDirector);
		txtDirector.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setText("");
		txtGenero.setBounds(66, 58, 86, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtDuracion = new JTextField();
		txtDuracion.setText("");
		txtDuracion.setBounds(66, 83, 86, 20);
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		JCheckBox chckbxIngles = new JCheckBox("Ingles");
		chckbxIngles.addMouseListener(new MouseAdapter() {
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
		chckbxIngles.setBounds(41, 127, 67, 23);
		contentPane.add(chckbxIngles);
		
		JCheckBox chckbxEspaol = new JCheckBox("Espa\u00F1ol");
		chckbxEspaol.addMouseListener(new MouseAdapter() {
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
		chckbxEspaol.setBounds(41, 153, 67, 23);
		contentPane.add(chckbxEspaol);
		
		JCheckBox chckbxAleman = new JCheckBox("Aleman");
		chckbxAleman.addMouseListener(new MouseAdapter() {
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
		chckbxAleman.setBounds(41, 183, 67, 23);
		contentPane.add(chckbxAleman);
		
		JCheckBox chckbxJapones = new JCheckBox("Japones");
		chckbxJapones.addMouseListener(new MouseAdapter() {
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
		chckbxJapones.setBounds(140, 127, 97, 23);
		contentPane.add(chckbxJapones);
		
		JCheckBox chckbxFrances = new JCheckBox("Frances");
		chckbxFrances.addMouseListener(new MouseAdapter() {
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
		chckbxFrances.setBounds(140, 153, 97, 23);
		contentPane.add(chckbxFrances);
		
		JCheckBox chckbxOtro = new JCheckBox("Otro:");
		chckbxOtro.addMouseListener(new MouseAdapter() {
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
		chckbxOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxOtro.isSelected())
					txtIdiomaOtro.setEnabled(true);
					else
						txtIdiomaOtro.setEnabled(false);
			}
		});
		chckbxOtro.setBounds(140, 183, 87, 23);
		contentPane.add(chckbxOtro);
		
		txtIdiomaOtro = new JTextField();
		txtIdiomaOtro.setBounds(232, 184, 86, 20);
		contentPane.add(txtIdiomaOtro);
		txtIdiomaOtro.setColumns(10);
		txtIdiomaOtro.setEnabled(false);
		
		JCheckBox chckbxSubsEspaol = new JCheckBox("Espa\u00F1ol");
		chckbxSubsEspaol.addMouseListener(new MouseAdapter() {
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
		chckbxSubsEspaol.setBounds(340, 132, 97, 23);
		contentPane.add(chckbxSubsEspaol);
		
		JCheckBox chckbxSubsIngles = new JCheckBox("Ingles");
		chckbxSubsIngles.addMouseListener(new MouseAdapter() {
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
		chckbxSubsIngles.setBounds(340, 158, 97, 23);
		contentPane.add(chckbxSubsIngles);
		
		JCheckBox chckbxOtroSubs = new JCheckBox("Otro:");
		chckbxOtroSubs.addMouseListener(new MouseAdapter() {
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
		chckbxOtroSubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxOtroSubs.isSelected())
					txtOtroSubs.setEnabled(true);
					else
						txtOtroSubs.setEnabled(false);
			}
		});
		chckbxOtroSubs.setBounds(340, 183, 84, 23);
		contentPane.add(chckbxOtroSubs);
		
		txtOtroSubs = new JTextField();
		txtOtroSubs.setBounds(430, 184, 86, 20);
		contentPane.add(txtOtroSubs);
		txtOtroSubs.setColumns(10);
		txtOtroSubs.setEnabled(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxEspaol.isSelected()){
					idioma = "Español";
				}
				if(chckbxIngles.isSelected()){
					idioma = "Ingles";
				}
				if(chckbxAleman.isSelected()){
					idioma = "Aleman";
				}
				if(chckbxFrances.isSelected()){
					idioma = "Frances";
				}
				if(chckbxJapones.isSelected()){
					idioma = "Japones";
				}
				if(chckbxOtro.isSelected()){
					idioma = txtIdiomaOtro.getText();
				}
				
				if(chckbxSubsEspaol.isSelected()){
					subtitulos = "Español";
				}
				if(chckbxSubsIngles.isSelected()){
					subtitulos = "Ingles";
				}
				if(chckbxOtroSubs.isSelected()){
					subtitulos = txtOtroSubs.getText();
				}
				peliControl.modificarPelicula((txtPelicula.getText()), txtDirector.getText(), txtGenero.getText(), txtDuracion.getText(), idioma, subtitulos, Float.parseFloat(txtCalificacion.getText()), textObservaciones.getText());
				peliControl.imprimirPelicula();
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
		btnAceptar.setBounds(347, 288, 89, 23);
		contentPane.add(btnAceptar);
		
		txtPelicula = new JTextField();
		txtPelicula.setBounds(66, 8, 86, 20);
		contentPane.add(txtPelicula);
		txtPelicula.setColumns(10);
	}
}
