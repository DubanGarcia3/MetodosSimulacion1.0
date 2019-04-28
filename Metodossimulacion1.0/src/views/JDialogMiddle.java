package views;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import uptc.com.sim.entities.Register;

public class JDialogMiddle extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanelMiddleTop jPanelMiddleTop;
	private DefaultTableModel model;
	private static final String[] COLUMS = {"Xi","Potencia","Extension","Ri"}; 
	private JTable table;
	
	
	public JDialogMiddle(Controller controller) {
		getContentPane().setBackground(Color.decode("#A2DD2E"));
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_SEED_Y);
		setLocationRelativeTo(null);
		setModal(true);
		init(controller);
	}
	
	private void init(Controller controller) {
		jPanelMiddleTop = new JPanelMiddleTop(controller);
		add(jPanelMiddleTop, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		this.model.setColumnIdentifiers(COLUMS);
		table.setModel(model);
		
	}
	
	public void addRow(Register register){
		model.addRow(register.getData());
	}
	
	public void test(int i) {
		Object [] fila = new Object[1];
		fila[0] = i;
		model.addRow ( fila ); 
	}
	
	public int getSeed() {
		return jPanelMiddleTop.getSeed();
	}
}
