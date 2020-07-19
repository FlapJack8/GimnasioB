package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import controladores.SistemaActividades;
import modelo.Actividad;

public class EliminarActividad extends JFrame {
	
	private JTable tbActividades;
	
	public EliminarActividad (SistemaActividades actividadControlador) {
		//seteo Marco
		setResizable(false);
		setTitle("Eliminar Actividad");
		setBounds(450,250,682,515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//---------------------
	
		ResultSet listaActividades = actividadControlador.listar();
		
		tbActividades = new JTable();
		tbActividades.setBounds(36, 50, 616, 295);
		tbActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbActividades.setModel(DbUtils.resultSetToTableModel(listaActividades));
		tbActividades.setDefaultEditor(Object.class, null);
		
		getContentPane().add(tbActividades);
		
		//BOTON
		
		JButton btnEliminar =new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo=(DefaultTableModel) tbActividades.getModel();
				
				int selectedRow = tbActividades.getSelectedRow();
				
				String actividad = modelo.getValueAt(selectedRow, 0).toString();
				Actividad aux=new Actividad(actividad,null);
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "¿Esta seguro que desea eliminar esta actividad?","Atencion",JOptionPane.WARNING_MESSAGE, dialogButton);
				
				if(dialogResult == JOptionPane.YES_OPTION){
					int flag = 0;
					flag = actividadControlador.bajarActividad(aux, flag);
					if(flag==1)
					{
						JOptionPane.showMessageDialog(null, "Eliminada!");
						flag=0;
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "No se econtro la actividad","Error",JOptionPane.ERROR_MESSAGE);
						flag=0;
					}
				}
				
				
			}
		
		});
		btnEliminar.setBounds(268, 397, 89, 23);
		getContentPane().add(btnEliminar);
		
	}
}
