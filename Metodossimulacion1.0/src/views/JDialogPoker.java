package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDialogPoker extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel model;
	private static final String[] COLUMS = {"No","Ri","Tipo"}; 
	private JTable table;
	private JScrollPane jsp;
	
	
	public JDialogPoker() {
		getContentPane().setBackground(Color.decode("#A2DD2E"));
		setIconImage(new ImageIcon(getClass().getResource(ConstansUI.PATH_IMAGE_PERFIL)).getImage());
		setSize(ConstansUI.SIZE_WINDOW_X, ConstansUI.SIZE_WINDOW_SEED_Y);
		setTitle(ConstansUI.MESSAGE_TITTLE_DIALOG_MIDDLE);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		init();
	}


	private void init() {
		Font fontHeader = new Font("Franklin Ghotic Demi" , Font.ITALIC ,20);
		Font font = new Font("Arial" , Font.PLAIN ,17);
		table = new JTable(){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){  
				return false;  
			}
		};;
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setBackground(Color.decode("#282E33"));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(fontHeader);
		table.setFont(font);
		table.setBackground(Color.white);
		table.setBorder(null);

		model = new DefaultTableModel();
		this.model.setColumnIdentifiers(COLUMS);
		table.setModel(model);
		
		jsp = new JScrollPane(table);
		jsp.setForeground(Color.white);
		jsp.setBorder(null);
		jsp.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(jsp, BorderLayout.CENTER);
	}
}
