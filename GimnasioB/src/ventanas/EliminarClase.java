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

import controladores.SistemaClases;
import controladores.SistemaUsuarios;
import modelo.Clase;

import javax.swing.JList;
import javax.swing.JTable;

public class EliminarClase extends JFrame {
	private JTable tbClases;
	
	public EliminarClase(SistemaClases clasesControlador) {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Eliminar Clase");
		setBounds(450, 250, 682, 515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//DefaultTableModel modeloTabla = (DefaultTableModel) tbClases.getModel();
		ResultSet listaClases = clasesControlador.listarClases();
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
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
				//String estado = modelo.getValueAt(selectedRow, 9).toString();

				Clase cAux = new Clase(act, fech, hor, profe, dur, capMax, capMin, pub, dif, null);
				
				//clasesControlador.eliminarClase(cAux);
				
				/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
				
				/*if(selectedRow==null) {
					
					/*----CONFIRMA ELIMINACION----*/
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro que desea eliminar esta Clase?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						int flag = 0;
						flag = clasesControlador.eliminarClase(cAux,flag);
						if(flag==1)
						{
							JOptionPane.showMessageDialog(null, "Eliminada!");
							flag=0;
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "No se econtro la Clase","Error",JOptionPane.ERROR_MESSAGE);
							flag=0;
						}
					}
				}
				
			//}
		});
		btnEliminar.setBounds(268, 397, 89, 23);
		getContentPane().add(btnEliminar);
		setLocationRelativeTo(null);

	}
}
