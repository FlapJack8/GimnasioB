package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controladores.SistemaActividades;
import modelo.Actividad;
import net.proteanit.sql.DbUtils;
import ventanas.ModificarActividadLlenarCampos;
public class ModificarActividad extends JFrame{
	
	private JTable tbActividades;

	
	public ModificarActividad (SistemaActividades actividadControlador) {
		
		setResizable(false);
		setLocationRelativeTo(null);
		//seteo Marco
		setTitle("Modificar Actividad");
		setBounds(450,250,682,515);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		//---------------------
	
		ResultSet listaActividades = actividadControlador.listarTodas();
		
		tbActividades = new JTable();
		tbActividades.setBounds(36, 50, 616, 295);
		tbActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbActividades.setModel(DbUtils.resultSetToTableModel(listaActividades));
		tbActividades.setDefaultEditor(Object.class, null);
		
		getContentPane().add(tbActividades);
		
		
		//BOTON
		
		JButton btnModificar =new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelo=(DefaultTableModel) tbActividades.getModel();
				
				int selectedRow = tbActividades.getSelectedRow();
				
				String actividad = modelo.getValueAt(selectedRow, 0).toString();
				String estado = modelo.getValueAt(selectedRow, 1).toString();
				
				Actividad aux=new Actividad(actividad,estado);
				ModificarActividadLlenarCampos actualizarDatosActividad =new ModificarActividadLlenarCampos(actividadControlador,aux);
				actualizarDatosActividad.setVisible(true);
				dispose();
			}
		});
		btnModificar.setBounds(268, 397, 89, 23);
		getContentPane().add(btnModificar);
		
	}
	
	

}
