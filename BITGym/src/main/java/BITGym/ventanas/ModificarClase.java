package BITGym.ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Vector;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BITGym.controladores.SistemaActividades;
import BITGym.controladores.SistemaClases;
import BITGym.controladores.SistemaUsuarios;
import BITGym.modelo.Clase;

import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;

public class ModificarClase extends JFrame {
	private JTable tbClases;
	
	public ModificarClase(SistemaClases clasesControlador, SistemaUsuarios usuariosControlador, SistemaActividades actividadesControlador) {

		setResizable(false);
		setTitle("Modificar Clase");
		setBounds(450, 250, 1010, 540);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		ResultSet listaClases = clasesControlador.listarClasesTodas();
		
		tbClases = new JTable();
		tbClases.setBounds(36, 50, 932, 376);
		tbClases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbClases.setModel(DbUtils.resultSetToTableModel(listaClases));
		tbClases.setDefaultEditor(Object.class, null);
		getContentPane().add(tbClases);

		/*----BOTON MODIFICAR----*/
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tbClases.getModel();
				
				int selectedRow = tbClases.getSelectedRow();
				
				String act = modelo.getValueAt(selectedRow, 0).toString();
				Date fech = Date.valueOf(modelo.getValueAt(selectedRow, 1).toString());
				Time hor=Time.valueOf(modelo.getValueAt(selectedRow, 2).toString());
				String profe = modelo.getValueAt(selectedRow, 3).toString();
				Float dur = Float.parseFloat(modelo.getValueAt(selectedRow, 4).toString());
				int capMax = Integer.parseInt(modelo.getValueAt(selectedRow, 5).toString());
				int capMin = Integer.parseInt(modelo.getValueAt(selectedRow, 6).toString());
				String pub = modelo.getValueAt(selectedRow, 7).toString();
				String dif = modelo.getValueAt(selectedRow, 8).toString();
				String estado = modelo.getValueAt(selectedRow, 9).toString();

				Clase cAux = new Clase(act, fech, hor, profe, dur, capMax, capMin, pub, dif, estado);
				
				ModificarClaseLlenarCampos modifClLlenarCampos = new ModificarClaseLlenarCampos(clasesControlador, cAux, usuariosControlador, actividadesControlador);
				modifClLlenarCampos.setVisible(true);
				dispose();
			}
				
			//}
		});
		btnModificar.setBounds(458, 451, 89, 23);
		getContentPane().add(btnModificar);
		
		JLabel lblClases = new JLabel("Clases:");
		lblClases.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClases.setBounds(36, 21, 90, 20);
		getContentPane().add(lblClases);
		setLocationRelativeTo(null);

	}
}