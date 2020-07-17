package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controladores.SistemaFacturas;
import controladores.SistemaUsuarios;
import modelo.Socio;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacturarCuota extends JFrame{
	private JTextField txtDniBuscar;

	public FacturarCuota(SistemaFacturas facturasControlador, SistemaUsuarios usuariosControlador, Socio s) {
		setTitle("Facturar Cuota");
	}

}
