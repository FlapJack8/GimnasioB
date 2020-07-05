package ventanas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.SistemaPeliculas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AltaPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField txtPeli;
	private JTextField txtDirector;
	private JTextField txtGenero;
	private JTextField txtDuracion;
	private JTextField txtObservaciones;
	private JTextField txtCalificacion;
	private JTextField txtOtro;
	private JTextField txtOtroSubs;
	private String idioma;
	private String subtitulos;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private SistemaPeliculas peliControl;
	
	/**
	 * Create the frame.
	 */
	public AltaPelicula(SistemaPeliculas pelicula) {
		
		peliControl = pelicula;
		
		setType(Type.POPUP);
		setTitle("Nueva Pelicula");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 401);
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
		btnCancelar.setBounds(432, 245, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblPelicula = new JLabel("Pelicula:");
		lblPelicula.setBounds(27, 11, 72, 14);
		contentPane.add(lblPelicula);
		
		JLabel lblDirector = new JLabel("Director:");
		lblDirector.setBounds(27, 37, 72, 14);
		contentPane.add(lblDirector);
		
		JLabel lblNewLabel = new JLabel("Genero:");
		lblNewLabel.setBounds(27, 74, 72, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(27, 99, 72, 14);
		contentPane.add(lblDuracion);
		
		JLabel lblIdiomas = new JLabel("Idiomas:");
		lblIdiomas.setBounds(27, 129, 65, 14);
		contentPane.add(lblIdiomas);
		
		JLabel lblSubtitulos = new JLabel("Subtitulos:");
		lblSubtitulos.setBounds(308, 129, 63, 14);
		contentPane.add(lblSubtitulos);
		
		JLabel lblCalificacion = new JLabel("Calificacion:");
		lblCalificacion.setBounds(220, 14, 65, 14);
		contentPane.add(lblCalificacion);
		
		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(27, 204, 89, 14);
		contentPane.add(lblObservaciones);
		
		txtPeli = new JTextField();
		txtPeli.setBounds(109, 11, 86, 20);
		contentPane.add(txtPeli);
		txtPeli.setColumns(10);
		
		txtDirector = new JTextField();
		txtDirector.setText("");
		txtDirector.setBounds(109, 37, 86, 20);
		contentPane.add(txtDirector);
		txtDirector.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setText("");
		txtGenero.setBounds(109, 74, 86, 20);
		contentPane.add(txtGenero);
		txtGenero.setColumns(10);
		
		txtDuracion = new JTextField();
		txtDuracion.setText("");
		txtDuracion.setBounds(109, 99, 86, 20);
		contentPane.add(txtDuracion);
		txtDuracion.setColumns(10);
		
		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(109, 222, 176, 46);
		contentPane.add(txtObservaciones);
		txtObservaciones.setColumns(10);
		
		txtCalificacion = new JTextField();
		txtCalificacion.setBounds(290, 11, 86, 20);
		contentPane.add(txtCalificacion);
		txtCalificacion.setColumns(10);
		
		txtOtro = new JTextField();
		txtOtro.setBounds(270, 175, 86, 20);
		contentPane.add(txtOtro);
		txtOtro.setColumns(10);
		txtOtro.setEnabled(false);
		
		JCheckBox boxIngles = new JCheckBox("Ingles");
		boxIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(boxIngles);
		boxIngles.addMouseListener(new MouseAdapter() {
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
		
		boxIngles.setBounds(98, 125, 63, 23);
		contentPane.add(boxIngles);
		
		JCheckBox boxEspanol = new JCheckBox("Espa\u00F1ol");
		boxEspanol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonGroup.add(boxEspanol);
		boxEspanol.addMouseListener(new MouseAdapter() {
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
		boxEspanol.setBounds(98, 148, 63, 23);
		contentPane.add(boxEspanol);
		
		JCheckBox boxAleman = new JCheckBox("Aleman");
		boxAleman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(boxAleman);
		boxAleman.addMouseListener(new MouseAdapter() {
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
		boxAleman.setBounds(98, 174, 63, 23);
		contentPane.add(boxAleman);
		
		JCheckBox boxJapones = new JCheckBox("Japones");
		boxJapones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(boxJapones);
		boxJapones.addMouseListener(new MouseAdapter() {
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
		boxJapones.setBounds(188, 125, 79, 23);
		contentPane.add(boxJapones);
		
		JCheckBox boxFrances = new JCheckBox("Frances");
		boxFrances.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(boxFrances);
		boxFrances.addMouseListener(new MouseAdapter() {
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
		boxFrances.setBounds(188, 148, 63, 23);
		contentPane.add(boxFrances);
		
		JCheckBox boxOtro = new JCheckBox("Otro:");
		buttonGroup.add(boxOtro);
		boxOtro.addMouseListener(new MouseAdapter() {
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
		boxOtro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxOtro.isSelected()){
					txtOtro.setEnabled(true);
				}
				else
					txtOtro.setEnabled(false);
			}
		});
		boxOtro.setBounds(188, 174, 76, 23);
		contentPane.add(boxOtro);
		
		JCheckBox subsEspanol = new JCheckBox("Espa\u00F1ol");
		subsEspanol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(subsEspanol.isSelected()){
					subtitulos = "Español";
				}
			}
		});
		buttonGroup_1.add(subsEspanol);
		subsEspanol.addMouseListener(new MouseAdapter() {
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
		subsEspanol.setBounds(373, 125, 97, 23);
		contentPane.add(subsEspanol);
		
		JCheckBox subsIngles = new JCheckBox("Ingles");
		subsIngles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup_1.add(subsIngles);
		subsIngles.addMouseListener(new MouseAdapter() {
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
		subsIngles.setBounds(373, 150, 97, 23);
		contentPane.add(subsIngles);
		
		JCheckBox subsOtros = new JCheckBox("Otro:");
		buttonGroup_1.add(subsOtros);
		subsOtros.addMouseListener(new MouseAdapter() {
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
		subsOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(subsOtros.isSelected())
					txtOtroSubs.setEnabled(true);
					else
						txtOtroSubs.setEnabled(false);
			}
		});
		subsOtros.setBounds(373, 174, 86, 23);
		contentPane.add(subsOtros);
		
		txtOtroSubs = new JTextField();
		txtOtroSubs.setBounds(465, 175, 86, 20);
		contentPane.add(txtOtroSubs);
		txtOtroSubs.setColumns(10);
		txtOtroSubs.setEnabled(false);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(boxEspanol.isSelected()){
					idioma = "Español";
				}
				if(boxIngles.isSelected()){
					idioma = "Ingles";
				}
				if(boxFrances.isSelected()){
					idioma = "Frances";
				}
				if(boxAleman.isSelected()){
					idioma = "Aleman";
				}
				if(boxOtro.isSelected()){
					idioma = txtOtro.getText();
				}
				if(subsIngles.isSelected()){
					subtitulos = "Ingles";
				}
				if(boxJapones.isSelected()){
					idioma = "Japones";
				}
				if(subsOtros.isSelected()){
					subtitulos = txtOtroSubs.getText();
				}
				peliControl.altaPelicula(txtPeli.getText(), txtDirector.getText(), txtGenero.getText(), txtDuracion.getText(), idioma, subtitulos, Float.parseFloat(txtCalificacion.getText()), txtObservaciones.getText());
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
		btnAceptar.setBounds(333, 245, 89, 23);
		contentPane.add(btnAceptar);
	}
	
}
