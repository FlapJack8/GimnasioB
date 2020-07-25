package BITGym.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Enumeration;
import java.util.Vector;
import net.proteanit.sql.DbUtils;
import BITGym.persistencia.PoolConnection;
import BITGym.persistencia.UsrMapper;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import BITGym.controladores.SistemaClases;
import BITGym.controladores.SistemaUsuarios;
import BITGym.modelo.Clase;
import BITGym.modelo.Empleado;

import javax.swing.JList;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;

public class ListarEstadoDeAbonos extends JFrame {
	private JTable tbSocios;
	
	public ListarEstadoDeAbonos(SistemaUsuarios usuariosControlador) {

		setResizable(false);
		setTitle("Estado de Abonos");
		setBounds(450, 250, 682, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ResultSet listaEstadoDeAbonos = usuariosControlador.listarEstadoDeAbonos();

		tbSocios = new JTable();
		tbSocios.setBounds(36, 75, 616, 295);
		tbSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		tbSocios.setModel(DbUtils.resultSetToTableModel(listaEstadoDeAbonos));

		getContentPane().add(tbSocios);
		//tbSocios.getTableHeader().resizeAndRepaint();
		
		JLabel lblEmpleados = new JLabel("Socios:");
		lblEmpleados.setFont(new Font("Tunga", Font.BOLD, 20));
		lblEmpleados.setBounds(36, 21, 128, 16);
		getContentPane().add(lblEmpleados);

		setLocationRelativeTo(null);

	}
}
