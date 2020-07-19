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


import javax.swing.JList;
import javax.swing.JTable;

import controladores.SistemaAbonos;
import modelo.Abono;
import modelo.Clase;
import persistencia.AbonoMapping;

public class EliminarAbono extends JFrame{
	
	private JTable tbClases;

	/*---------CREO VENTANA DE ALTA ABONO----*/
	
	public EliminarAbono(SistemaAbonos abonosControlador) {

		setResizable(false);
		setTitle("Eliminar Abono");
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
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel modelo = (DefaultTableModel) tbClases.getModel();
				
				int selectedRow = tbClases.getSelectedRow();
				String tipoAbon = modelo.getValueAt(selectedRow, 0).toString();
				int duracio = Integer.parseInt(modelo.getValueAt(selectedRow, 1).toString());
				Float preci = Float.parseFloat(modelo.getValueAt(selectedRow, 2).toString());
				String estad = modelo.getValueAt(selectedRow, 3).toString();

				Abono cAux = new Abono(tipoAbon, duracio, preci, estad);
				
				//clasesControlador.eliminarClase(cAux);
				
				/*----CONFIRMA QUE NO ESTE VACIO EL CAMPO----*/
				
				/*if(selectedRow==null) {
					
					/*----CONFIRMA ELIMINACION----*/
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Esta seguro que desea eliminar esta Clase?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						int flag = 0;
						flag = abonosControlador.deleteAbono(cAux.getTipoAbono(), flag);
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

	}
}