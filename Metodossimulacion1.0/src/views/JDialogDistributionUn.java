package views;


import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class JDialogDistributionUn extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanelTopDistribution jPanelTopDistribution;
	private DefaultTableModel model;
	private static final String[] COLUMS = {"No","Ri","Ni"}; 
	private JTable table;
	
	public JDialogDistributionUn(Controller controller) {
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_SEED_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_DISTRIBUTION);
		setLocationRelativeTo(null);
		setModal(true);
		init(controller);
	}
	
	private void init(Controller controller) {
		jPanelTopDistribution = new JPanelTopDistribution(controller);
		add(jPanelTopDistribution, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		this.model.setColumnIdentifiers(COLUMS);
		table.setModel(model);
	}
}
