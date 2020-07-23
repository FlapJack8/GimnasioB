package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Enumeration;
import java.util.Vector;
import net.proteanit.sql.DbUtils;

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

import controladores.SistemaClases;
import controladores.SistemaUsuarios;
import modelo.Clase;

import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;

public class ListarEmpleadosLiquidarSueldo extends JFrame {
	private JTable tbEmpleados;
	
	public ListarEmpleadosLiquidarSueldo(SistemaUsuarios usuariosControlador, String rolLogeado) {

		setResizable(false);
		setTitle("Liquidar Sueldos");
		setBounds(450, 250, 682, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ResultSet listaEmpleados = usuariosControlador.listarEmpleados();
		
		String columnas [] = {"Nombre Usuario","Nombre", "Apellido", "E-Mail","DNI","Sueldo","Inicio de Actividades","Dias Laborales","Rol"};
		tbEmpleados = new JTable();
		tbEmpleados.setBounds(36, 50, 616, 295);
		tbEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		tbEmpleados.setModel(DbUtils.resultSetToTableModel(listaEmpleados));
		for(int i=0;i<tbEmpleados.getColumnCount();i++)
		{
			tbEmpleados.getColumnModel().getColumn(i).setHeaderValue(columnas[i]);
		} 
		tbEmpleados.setDefaultEditor(Object.class, null);
		
		getContentPane().add(tbEmpleados);
		tbEmpleados.getTableHeader().resizeAndRepaint();

		/*----BOTON MODIFICAR----*/
		
		JButton btnLiquidar = new JButton("Liquidar");
		btnLiquidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tbEmpleados.getModel();
				
				int selectedRow = tbEmpleados.getSelectedRow();
				
				String nombreUsr = modelo.getValueAt(selectedRow, 0).toString();
				String nombre = modelo.getValueAt(selectedRow, 1).toString();
				String apellido = modelo.getValueAt(selectedRow, 2).toString();
				String email = modelo.getValueAt(selectedRow, 3).toString();
				int dni = Integer.parseInt(modelo.getValueAt(selectedRow, 4).toString());
				Float sueldo = Float.parseFloat(modelo.getValueAt(selectedRow, 5).toString());
				Date fechInicioActs = Date.valueOf(modelo.getValueAt(selectedRow, 6).toString());
				String diasLaborales = modelo.getValueAt(selectedRow, 7).toString();
				String rol = modelo.getValueAt(selectedRow, 8).toString();
				
				String nombreCompleto = nombre.concat(" ").concat(apellido);
				LiquidarSueldo liquidarSueldo = new LiquidarSueldo(usuariosControlador, nombreUsr, nombreCompleto, email,dni, sueldo,fechInicioActs,diasLaborales,rol);
				liquidarSueldo.setVisible(true);
				dispose();
			}
				
			//}
		});
		btnLiquidar.setBounds(268, 397, 89, 23);
		getContentPane().add(btnLiquidar);
		
		JLabel lblEmpleados = new JLabel("Empleados:");
		lblEmpleados.setFont(new Font("Tunga", Font.BOLD, 20));
		lblEmpleados.setBounds(36, 21, 128, 16);
		getContentPane().add(lblEmpleados);

		setLocationRelativeTo(null);

	}
}
