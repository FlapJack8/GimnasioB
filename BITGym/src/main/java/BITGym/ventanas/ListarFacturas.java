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

import BITGym.controladores.SistemaFacturas;

import javax.swing.JList;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;

public class ListarFacturas extends JFrame {
	private JTable tbFacturas;
	
	public ListarFacturas(SistemaFacturas facturasControlador) {

		setResizable(false);
		setTitle("Consultar Facturas");
		setBounds(450, 250, 682, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ResultSet listaFacturas = facturasControlador.listarFacturas();

		tbFacturas = new JTable();
		tbFacturas.setBounds(36, 75, 616, 295);
		tbFacturas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		tbFacturas.setModel(DbUtils.resultSetToTableModel(listaFacturas));

		getContentPane().add(tbFacturas);
		//tbSocios.getTableHeader().resizeAndRepaint();
		
		JLabel lblEmpleados = new JLabel("Facturas:");
		lblEmpleados.setFont(new Font("Tunga", Font.BOLD, 20));
		lblEmpleados.setBounds(36, 21, 128, 16);
		getContentPane().add(lblEmpleados);

		setLocationRelativeTo(null);

	}
}
