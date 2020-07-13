package ventanas;

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

import controladores.SistemaAbonos;
import modelo.Abono;
import modelo.Actividad;
import modelo.Clase;
import persistencia.AbonoMapping;

import javax.swing.JList;
import javax.swing.JTable;




public class ModificarAbono  extends JFrame{
	private JTable tbClases;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public ModificarAbono(SistemaAbonos abonosControlador) {

		setTitle("Modificar Abono");
		setBounds(450, 250, 682, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//DefaultTableModel modeloTabla = (DefaultTableModel) tbClases.getModel();
		ResultSet listaClases = abonosControlador.listarAbono();
	/*Object data[] = new Object[listaClases.size()];
		for(int j=0;j<listaClases.size();j++) {
			data[j] = listaClases.elementAt(j).getActividad();
			System.out.println(listaClases.elementAt(j).getActividad());
			data[j] = listaClases.elementAt(j).getFecha();
			data[j] = listaClases.elementAt(j).getHorario();
			data[j] = listaClases.elementAt(j).getProfe();
			data[j] = listaClases.elementAt(j).getDuracion();
			data[j] = listaClases.elementAt(j).getCapacidadMax();
			data[j] = listaClases.elementAt(j).getCapacidadMin();
			data[j] = listaClases.elementAt(j).getPublico();
			data[j] = listaClases.elementAt(j).getDificultad();
			modeloTabla.addRow(data);
			}*/
		tbClases = new JTable();
		tbClases.setBounds(36, 50, 616, 295);
		tbClases.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbClases.setModel(DbUtils.resultSetToTableModel(listaClases));
		tbClases.setDefaultEditor(Object.class, null);
		getContentPane().add(tbClases);

		/*----BOTON ELIMINAR----*/

		//BOTON
		
		JButton btnModificar =new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo=(DefaultTableModel) tbClases.getModel();
				
				int selectedRow = tbClases.getSelectedRow();
				
				String tipoAbon = modelo.getValueAt(selectedRow, 0).toString();
				int duracio = Integer.parseInt(modelo.getValueAt(selectedRow, 1).toString());
				Float preci = Float.parseFloat(modelo.getValueAt(selectedRow, 2).toString());
				String estad = modelo.getValueAt(selectedRow, 3).toString();
				
				Abono aux=new Abono(tipoAbon, duracio, preci, estad);
				ModificarAbonoLlenarCampos actualizarDatosActividad =new ModificarAbonoLlenarCampos(abonosControlador, aux);
				actualizarDatosActividad.setVisible(true);
				dispose();
			}
		});
		btnModificar.setBounds(268, 397, 89, 23);
		getContentPane().add(btnModificar);
		
	}
	
	

}